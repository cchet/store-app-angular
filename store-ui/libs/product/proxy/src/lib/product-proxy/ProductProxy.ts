import { Product, ProductPort, ProductType } from '@store-ui/product-domain';
import { delay, Observable, of } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductProxy extends ProductPort {

  readonly testData: Product[] = [
    new Product(
      '00000001',
      'MAC Book Pro 16',
      10,
      ProductType.LAPTOP,
      5000.00,
      20.00),
    new Product(
      '00000002',
      'MAC Book Pro 14',
      10,
      ProductType.LAPTOP,
      4000.00,
      20.00),
    new Product(
      '00000003',
      'Lenovo',
      10,
      ProductType.LAPTOP,
      2000.00,
      20.00)
  ];


  byId(id: string): Observable<Product> {
    const products = this.testData.filter(product => id === product.id);
    if(products.length === 1) {
      return of(products[0]).pipe(delay(2000));
    }
    console.log("data not found for id: " + id);
    return of();
  }

  byIds(ids: string[]): Observable<Product[]> {
    return of(this.testData.filter(product => ids.includes(product.id)));
  }

  list(): Observable<Product[]> {
    return of(this.testData);
  }
}