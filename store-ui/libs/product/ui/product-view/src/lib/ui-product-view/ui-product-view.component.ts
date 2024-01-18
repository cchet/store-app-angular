import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeatureProductViewComponent } from '@store-ui/feature-product-view';
import { globalConfiguration } from '@store-ui/shared-model';
import { FeatureProductListComponent } from '@store-ui/feature-product-list';
import { RouterLink } from '@angular/router';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';

@Component({
  selector: 'store-ui-ui-product-view',
  standalone: true,
  imports: [CommonModule, FeatureProductViewComponent, FeatureProductListComponent, RouterLink, FaIconComponent],
  templateUrl: './ui-product-view.component.html',
  styleUrl: './ui-product-view.component.css'
})
export class UiProductViewComponent {
  protected readonly globalConfiguration = globalConfiguration;
}
