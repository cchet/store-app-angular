import { Product } from '@store-ui/product-domain';

export class CartProduct {

  constructor(public product: Product,
              public count: number) {
  }

  fullPrice(): number {
    return this.product.calculatePriceWithTax() * this.count;
  }
  fullPriceNoTax(): number {
    return this.product.price * this.count;
  }

  fullTax(): number {
    return this.product.calculateTax() * this.count;
  }
}