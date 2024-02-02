import { Component, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbAlert } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule } from '@angular/forms';
import { globalConfiguration } from '@store-ui/shared-model';
import { TranslateService } from '@ngx-translate/core';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { map, Observable, of, Subscription } from 'rxjs';
import { CartProduct } from '@store-ui/cart-domain';
import { ProductPort } from '@store-ui/product-domain';
import { CartState } from '@store-ui/cart-state';

export class TableResult {

  public totalCount: number;
  public totalSinglePriceNoTax: number;
  public totalSinglePrice: number;
  public totalSingleTax: number;
  public totalFullTax: number;
  public totalFullPriceNoTax: number;
  public totalFullPrice: number;

  constructor(private cartProducts: readonly CartProduct[]) {
    this.totalCount = this.cartProducts.map(cartProduct => cartProduct.count).reduce((sum, current) => sum + current, 0);
    this.totalSinglePriceNoTax = this.cartProducts.map(cartProduct => cartProduct.product.price).reduce((sum, current) => sum + current, 0);
    this.totalSinglePrice = this.cartProducts.map(cartProduct => cartProduct.product.calculatePriceWithTax()).reduce((sum, current) => sum + current, 0);
    this.totalSingleTax = this.cartProducts.map(cartProduct => cartProduct.product.calculateTax()).reduce((sum, current) => sum + current, 0);
    this.totalFullTax = this.cartProducts.map(cartProduct => cartProduct.fullTax()).reduce((sum, current) => sum + current, 0);
    this.totalFullPriceNoTax = this.cartProducts.map(cartProduct => cartProduct.fullPriceNoTax()).reduce((sum, current) => sum + current, 0);
    this.totalFullPrice = this.cartProducts.map(cartProduct => cartProduct.fullPrice()).reduce((sum, current) => sum + current, 0);
  }
};

@Component({
  selector: 'store-ui-feature-cart-overview',
  standalone: true,
  imports: [CommonModule, NgbAlert, ReactiveFormsModule, FaIconComponent],
  templateUrl: './feature-cart-overview.component.html',
  styleUrl: './feature-cart-overview.component.css'
})
export class FeatureCartOverviewComponent implements OnDestroy {


  protected readonly globalConfiguration = globalConfiguration;
  protected cartProducts$: Observable<CartProduct[]>;
  protected subscription: Subscription | null = null;
  protected tableResult: TableResult = new TableResult([]);

  constructor(protected translate: TranslateService,
              productPort: ProductPort,
              cartState: CartState) {
    console.log(cartState.listProductIds());
    if (cartState.isEmpty()) {
      this.cartProducts$ = of();
    } else {
      this.cartProducts$ = productPort.byIds(cartState.listProductIds())
        .pipe(map(products => products.map(product => new CartProduct(product, cartState.forId(product.id).count))));
      this.subscription = this.cartProducts$.subscribe(cartProducts => {
        this.tableResult = new TableResult(cartProducts);
      });
    }
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
