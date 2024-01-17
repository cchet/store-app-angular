export const ProductEventType = {
  PRODUCT_ADDED: 'PRODUCT_ADDED'
}

export interface ProductEvent {
  id: string,
  count: number
}