export class CartItem {

  constructor(public id: string,
              public count: number) {
  }

  increase(): void {
    this.count++;
  }

  decrease(): void {
    if(this.count === 1) {
      throw Error("Cannot decrease to 0");
    }
    this.count--;
  }
}