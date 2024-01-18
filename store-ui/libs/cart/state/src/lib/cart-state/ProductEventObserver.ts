import { Injectable } from '@angular/core';
import { MetaData, NgEventBus } from 'ng-event-bus';
import { ProductEvent, ProductEventType } from '@store-ui/product-domain';
import { CartItem, CartPort } from '@store-ui/cart-domain';

@Injectable({
  providedIn: 'root',
})
export class ProductEventObserver {
  constructor(private eventBus: NgEventBus, private cartPort: CartPort) {
    console.log('ProductEventObserver initialized');
    eventBus
      .on(ProductEventType.PRODUCT_ADDED)
      .subscribe((meta) => this.onProductAddedEvent(meta, cartPort));
  }

  onProductAddedEvent(meta: MetaData, cartPort: CartPort): void {
    console.log(meta);
    const data = meta.data as ProductEvent;
    cartPort.add(new CartItem(data.id, data.count));
  }
}
