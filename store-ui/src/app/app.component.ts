import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SharedUiNavigationComponent } from '@store-ui/shared-ui-navigation';

@Component({
  standalone: true,
  imports: [RouterModule, SharedUiNavigationComponent],
  selector: 'store-ui-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'store-ui';
}
