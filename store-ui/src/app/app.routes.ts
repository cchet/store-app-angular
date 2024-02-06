import { Route } from '@angular/router';
import { globalConfiguration } from '@store-ui/shared-model';
import { OrderUiComponent } from '@store-ui/ui';
import { HomeUiComponent } from '@store-ui/home-ui';
import { UiProductsViewComponent } from '@store-ui/ui-products-view';
import { UiProductViewComponent } from '@store-ui/ui-product-view';
import { UiCartViewComponent } from '@store-ui/cart-view';
import { UiPaymentViewComponent } from '@store-ui/payment-view';

export const appRoutes: Route[] = [
  {
    path: '',
    redirectTo: globalConfiguration.navLinks.home.uri,
    pathMatch: 'full',
  },
  {
    path: globalConfiguration.navLinks.home.uri,
    component: HomeUiComponent,
  },
  {
    path: globalConfiguration.navLinks.products.uri,
    component: UiProductsViewComponent,
  },
  {
    path: globalConfiguration.navLinks.orders.uri,
    component: OrderUiComponent,
  },
  {
    path: globalConfiguration.navLinks.cart.uri,
    component: UiCartViewComponent,
  },
  {
    path: globalConfiguration.innerLinks.productDetail.routeURI,
    component: UiProductViewComponent,
  },
  {
    path: globalConfiguration.innerLinks.payment.routeURI,
    component: UiPaymentViewComponent,
  },
];
