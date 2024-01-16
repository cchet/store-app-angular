import { Product } from './Product';
import { Observable } from 'rxjs';

export abstract class ProductPort {
  abstract list(): Observable<Product[]>;

  abstract byIds(ids: string[]): Observable<Product[]>;
}


