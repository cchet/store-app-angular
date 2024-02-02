import { Injectable } from '@angular/core';
import { CartItem, CartPort } from '@store-ui/cart-domain';

@Injectable({
  providedIn: 'root'
})
export class CartState extends CartPort {
  private items: CartItem[] = [];

  constructor() {
    super();
  }

  override add(item: CartItem): void {
    const foundItem = this.findItem(item.id);
    if (foundItem) {
      foundItem.increase();
    } else {
      this.items.push(item);
    }
  }

  override remove(item: CartItem): void {
    const foundItem = this.findItem(item.id);
    if (foundItem && foundItem.count > 1) {
      foundItem.decrease();
    } else {
      this.items = this.items.filter(
        (existingItem) => existingItem.id !== item.id
      );
    }
  }

  override removeAll(): void {
    this.items = [];
  }

  override list(): readonly CartItem[] {
    return this.items;
  }

  forId(id: string): CartItem {
    const item = this.findItem(id);
    if (item == null) {
      throw Error(`No item for id: '${id}' found`);
    }
    return item;
  }


  listProductIds(): readonly string[] {
    return this.items.map(item => item.id);
  }

  override isEmpty(): boolean {
    return this.items.length == 0;
  }

  private findItem(id: string): CartItem | null {
    const foundItems: CartItem[] = this.items.filter((item) => item.id === id);
    if (foundItems.length === 1) {
      return foundItems[0];
    }
    return null;
  }
}
