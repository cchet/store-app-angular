import { registerLocaleData } from '@angular/common';
import { HttpClient, provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import localeDeAt from '@angular/common/locales/de-AT';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { APP_INITIALIZER, ApplicationConfig, importProvidersFrom, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { TranslateLoader, TranslateModule, TranslateService } from '@ngx-translate/core';
import { provideRouter } from '@angular/router';
import { appRoutes } from './app.routes';
import { ProductPort } from '@store-ui/product-domain';
import { ProductProxy } from '../../libs/product/proxy/src/lib/product-proxy/ProductProxy';
import { NgEventBus } from 'ng-event-bus';

registerLocaleData(localeDeAt, 'de-AT');


// AOT compilation support
export function httpTranslateLoader(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

// Preloads the i18n file on app load, so we can use instant instead of handling async behaviour
function appInitializerFactory(translate: TranslateService) {
  return () => {
    translate.setDefaultLang('de');
    return translate.use('de').toPromise();
  };
}

export const appConfig: ApplicationConfig = {
  providers: [
    NgEventBus,
    // Injections for interfaces
    { provide: ProductPort, useExisting: ProductProxy },
    // Initializer for preloading the i18n files
    {
      provide: APP_INITIALIZER,
      useFactory: appInitializerFactory,
      deps: [TranslateService],
      multi: true
    },
    importProvidersFrom(
      BrowserModule,
      TranslateModule.forRoot({
          loader: {
            provide: TranslateLoader,
            useFactory: httpTranslateLoader,
            deps: [HttpClient]
          }
        }
      )
    ),
    { provide: LOCALE_ID, useValue: 'de-AT' },
    provideRouter(appRoutes),
    provideHttpClient(withInterceptorsFromDi()),
  ]
};