import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SharedUiNavigationComponent } from '@store-ui/shared-ui-navigation';
import { NgOptimizedImage } from '@angular/common';
import { TranslateService } from '@ngx-translate/core';

@Component({
  standalone: true,
  imports: [RouterModule, SharedUiNavigationComponent, NgOptimizedImage],
  selector: 'store-ui-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'store-ui';
}
