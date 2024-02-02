import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateService } from '@ngx-translate/core';

export enum PaymentStep {
  OPEN = 'OPEN',
  STARTED = 'STARTED',
  PAYED = 'PAYED',
  ERROR = 'ERROR'
}

@Component({
  selector: 'store-ui-feature-cart-payment',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './feature-cart-payment.component.html',
  styleUrl: './feature-cart-payment.component.css',
})
export class FeatureCartPaymentComponent {

  protected step:PaymentStep = PaymentStep.OPEN;
  protected readonly PaymentStep = PaymentStep;

  constructor(protected translate:TranslateService,
              ) {
  }
}
