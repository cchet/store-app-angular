import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product, ProductPort } from '@store-ui/product-domain';
import { TranslateService } from '@ngx-translate/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'store-ui-feature-product-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './feature-product-list.component.html',
  styleUrl: './feature-product-list.component.css'
})
export class FeatureProductListComponent {

  protected products$: Observable<Array<Product>>;

  constructor(private productPort: ProductPort,
              protected translate: TranslateService) {
    this.products$ = productPort.list();
  }
}
