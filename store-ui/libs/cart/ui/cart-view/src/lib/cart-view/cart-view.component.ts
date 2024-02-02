import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeatureCartOverviewComponent } from '@store-ui/feature-cart-overview';
import { FeatureCartPaymentComponent } from '@store-ui/feature-cart-payment';
import { CartState } from '@store-ui/cart-state';

@Component({
  selector: 'store-ui-cart-view',
  standalone: true,
  imports: [CommonModule, FeatureCartOverviewComponent, FeatureCartPaymentComponent],
  templateUrl: './cart-view.component.html',
  styleUrl: './cart-view.component.css',
})
export class CartViewComponent {

  constructor(protected cartState:CartState) {
  }
}
