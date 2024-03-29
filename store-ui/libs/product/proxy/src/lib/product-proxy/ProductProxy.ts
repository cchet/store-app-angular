import { Product, ProductPort, ProductType } from '@store-ui/product-domain';
import { catchError, map, Observable, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { StoreConfigPort } from '@store-ui/shared-model';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';

interface ProductRest {
  id: string,
  name: string,
  count: number,
  price: number,
  taxPercent: number
}

@Injectable({
  providedIn: 'root'
})
export class ProductProxy extends ProductPort {

  constructor(private storeConfig: StoreConfigPort,
              private httpClient: HttpClient) {
    super();
  }

  byId(id: string): Observable<Product> {
    return this.httpClient.get<ProductRest>(`${this.storeConfig.catalogBaseUrl()}/product/${id}`)
      .pipe(map(p => new Product(p.id, p.name, p.count, ProductType.DESKTOP, p.price, p.taxPercent)))
      .pipe(catchError(errorResponse => {
        throw this.handleHttpError(errorResponse);
      }));
  }

  byIds(ids: readonly string[]): Observable<Product[]> {
    const params = new HttpParams({ fromObject: { id: ids } })
    console.log(params);

    return this.httpClient.get<Array<ProductRest>>(`${this.storeConfig.catalogBaseUrl()}/product`, { params: params })
      .pipe(map(products => products.map(p => new Product(p.id, p.name, p.count, ProductType.DESKTOP, p.price, p.taxPercent))))
      .pipe(catchError(errorResponse => {
        throw this.handleHttpError(errorResponse);
      }));
  }

  list(): Observable<Product[]> {
    return this.httpClient.get<Array<ProductRest>>(`${this.storeConfig.catalogBaseUrl()}/product`)
      .pipe(map(products => products.map(p => new Product(p.id, p.name, p.count, ProductType.DESKTOP, p.price, p.taxPercent))))
      .pipe(catchError(errorResponse => {
        throw this.handleHttpError(errorResponse);
      }));
  }

  private handleHttpError(errorResponse: HttpErrorResponse): Observable<Error> {
    return throwError(() => new Error(`http-status: ${errorResponse.status}`));
  }
}