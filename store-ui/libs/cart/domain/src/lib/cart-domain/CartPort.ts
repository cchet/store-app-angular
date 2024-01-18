import { CartItem } from './CartItem';

export abstract class CartPort {

  abstract add(item: CartItem): void;

  abstract remove(item: CartItem): void;

  abstract removeAll(): void;

  abstract list(): readonly CartItem[];
}
