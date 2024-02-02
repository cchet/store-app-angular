import { Observable } from 'rxjs';

export abstract class OrderPort {

  abstract order(): Observable<string>;

  abstract cancel(): Observable<string>;
}