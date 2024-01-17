import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeatureProductListComponent } from '@store-ui/feature-product-list';

@Component({
  selector: 'store-ui-product-ui',
  standalone: true,
  imports: [CommonModule, FeatureProductListComponent],
  templateUrl: './ui-products-view.component.html',
  styleUrl: './ui-products-view.component.css',
})
export class UiProductsViewComponent {}
