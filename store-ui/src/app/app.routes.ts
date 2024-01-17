import { Route } from '@angular/router';
import { globalConfiguration } from '@store-ui/shared-model';
import { OrderUiComponent } from '@store-ui/ui';
import { HomeUiComponent } from '@store-ui/home-ui';
import { UiProductsViewComponent } from '@store-ui/ui-products-view';
import { UiProductViewComponent } from '@store-ui/ui-product-view';

export const appRoutes: Route[] = [
  {
    path: '',
    redirectTo: globalConfiguration.NAV_LINKS.home.uri,
    pathMatch: 'full',
  },
  {
    path: globalConfiguration.NAV_LINKS.home.uri,
    component: HomeUiComponent,
  },
  {
    path: globalConfiguration.NAV_LINKS.products.uri,
    component: UiProductsViewComponent,
  },
  {
    path: globalConfiguration.PAGE_ROUTER_URI.product,
    component: UiProductViewComponent,
  },
  {
    path: globalConfiguration.NAV_LINKS.orders.uri,
    component: OrderUiComponent,
  },
];
