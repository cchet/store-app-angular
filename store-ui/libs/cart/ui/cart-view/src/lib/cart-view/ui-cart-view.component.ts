import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeatureCartOverviewComponent } from '@store-ui/feature-cart-overview';
import { TranslateService } from '@ngx-translate/core';
import { CartPort } from '@store-ui/cart-domain';

@Component({
  selector: 'store-ui-cart-view',
  standalone: true,
  imports: [CommonModule, FeatureCartOverviewComponent],
  templateUrl: './ui-cart-view.component.html',
  styleUrl: './ui-cart-view.component.css'
})
export class UiCartViewComponent {

  constructor(protected cartState: CartPort,
              protected translate: TranslateService) {
  }
}
