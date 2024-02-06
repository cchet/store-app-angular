import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateService } from '@ngx-translate/core';
import { OrderPort } from '@store-ui/domain';

@Component({
  selector: 'store-ui-payment-view',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './ui-payment-view.component.html',
  styleUrl: './ui-payment-view.component.css',
})
export class UiPaymentViewComponent {

  constructor(protected translate: TranslateService,
              protected orderPort: OrderPort) {
  }
}
