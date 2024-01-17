import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeatureProductViewComponent } from '@store-ui/feature-product-view';

@Component({
  selector: 'store-ui-ui-product-view',
  standalone: true,
  imports: [CommonModule, FeatureProductViewComponent],
  templateUrl: './ui-product-view.component.html',
  styleUrl: './ui-product-view.component.css',
})
export class UiProductViewComponent {}
