import { Product } from './Product';
import { Observable } from 'rxjs';

export abstract class ProductPort {
  abstract list(): Observable<Product[]>;

  abstract byId(id: string | null): Observable<Product>;

  abstract byIds(ids: readonly string[]): Observable<Product[]>;
}


