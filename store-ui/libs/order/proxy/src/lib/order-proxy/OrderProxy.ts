import { OrderPort } from '@store-ui/domain';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderProxy extends OrderPort {

    override order(): Observable<string> {
        throw new Error('Method not implemented.');
    }
    override cancel(): Observable<string> {
        throw new Error('Method not implemented.');
    }
}