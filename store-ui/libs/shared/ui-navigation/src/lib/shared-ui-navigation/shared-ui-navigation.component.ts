import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import { globalConfiguration, Link } from '@store-ui/shared-domain';
import { TranslateService } from '@ngx-translate/core';
import { NgForOf } from '@angular/common';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faBasketShopping, faEye } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'store-ui-shared-ui-navigation',
  standalone: true,
  imports: [
    RouterLink, NgbCollapseModule, NgForOf, RouterLinkActive, FaIconComponent
  ],
  templateUrl: './shared-ui-navigation.component.html',
  styleUrl: './shared-ui-navigation.component.css'
})
export class SharedUiNavigationComponent {
  protected readonly globalConfiguration = globalConfiguration;
  protected isMenuCollapsed = true;
  readonly navigationLinks = new Array<Link>();
  protected readonly iconBasket = faBasketShopping;

  constructor(protected translate: TranslateService) {
    const keys = Object.keys(globalConfiguration.navLinks) as Array<keyof typeof globalConfiguration.navLinks>;
    keys.forEach(key => {
      const pageLink = globalConfiguration.navLinks[key];
      this.navigationLinks.push({ name: translate.instant(pageLink.i18n), uri: pageLink.uri });
    });
  }

}
