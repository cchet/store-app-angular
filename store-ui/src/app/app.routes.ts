import { Route } from '@angular/router';
import { globalConfiguration } from '@store-ui/shared-model';
import { OrderUiComponent } from '@store-ui/ui';
import { HomeUiComponent } from '@store-ui/home-ui';
import { FeatureProductListComponent } from '@store-ui/feature-product-list';

export const appRoutes: Route[] = [
  {
    path: globalConfiguration.PAGE_LINKS.home.uri,
    component: HomeUiComponent,
  },
  {
    path: globalConfiguration.PAGE_LINKS.products.uri,
    component: FeatureProductListComponent,
  },
  {
    path: globalConfiguration.PAGE_LINKS.orders.uri,
    component: OrderUiComponent,
  }
];
