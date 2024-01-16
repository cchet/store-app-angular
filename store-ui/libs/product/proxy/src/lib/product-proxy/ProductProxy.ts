import { Product, ProductPort, ProductType } from '@store-ui/product-domain';
import { Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductProxy extends ProductPort {
  byIds(ids: string[]): Observable<Product[]> {
    return of([{
      id: "00000001",
      name: "MAC Book Pro 16",
      type: ProductType.LAPTOP,
      count: 10,
      price: 5000.00,
      taxPercent: 20.00
    }]);
  }

  list(): Observable<Product[]> {
    return of([{
      id: "00000001",
      name: "MAC Book Pro 16",
      type: ProductType.LAPTOP,
      count: 10,
      price: 5000.00,
      taxPercent: 20.00
    }]);
  }
}