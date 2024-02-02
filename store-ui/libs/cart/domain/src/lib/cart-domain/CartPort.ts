import { CartItem } from './CartItem';

export abstract class CartPort {

  abstract add(item: CartItem): void;

  abstract remove(item: CartItem): void;

  abstract removeAll(): void;

  abstract forId(id:string): CartItem;

  abstract list(): readonly CartItem[];

  abstract listProductIds():readonly string[];

  abstract isEmpty():boolean;
}
