export enum ProductType {
  LAPTOP,
  DESKTOP,
  HID,
}

export class Product {

  constructor(readonly id: string,
              readonly name: string,
              readonly count: number,
              readonly type: ProductType,
              readonly price: number,
              readonly taxPercent: number) {
    this.taxPercent = taxPercent / 100;
  }

  calculatePriceWithTax(): number {
    return this.price + this.calculateTax();
  }

  calculateTax(): number {
    return this.price * this.taxPercent;
  }
}
