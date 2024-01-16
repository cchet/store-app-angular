import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { NgbCollapseModule } from '@ng-bootstrap/ng-bootstrap';
import { globalConfiguration, Link } from '@store-ui/shared-domain';
import { TranslateService } from '@ngx-translate/core';
import { NgForOf } from '@angular/common';

@Component({
  selector: 'store-ui-shared-ui-navigation',
  standalone: true,
  imports: [
    RouterLink, NgbCollapseModule, NgForOf, RouterLinkActive
  ],
  templateUrl: './shared-ui-navigation.component.html',
  styleUrl: './shared-ui-navigation.component.css'
})
export class SharedUiNavigationComponent {
  isMenuCollapsed = true;
  readonly navigationLinks = new Array<Link>();

  constructor(protected translate: TranslateService) {
    const keys = Object.keys(globalConfiguration.PAGE_LINKS) as Array<keyof typeof globalConfiguration.PAGE_LINKS>;
    keys.forEach(key => {
      const pageLink = globalConfiguration.PAGE_LINKS[key];
      this.navigationLinks.push({ name: translate.instant(pageLink.i18n), uri: pageLink.uri });
    });
  }
}
