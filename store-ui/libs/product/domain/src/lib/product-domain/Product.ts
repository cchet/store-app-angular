export enum ProductType {
  LAPTOP,
  DESKTOP,
  HID,
}

export interface Product {
  id: string,
  name: string,
  count: number,
  type: ProductType,
  price: number,
  taxPercent: number,
}