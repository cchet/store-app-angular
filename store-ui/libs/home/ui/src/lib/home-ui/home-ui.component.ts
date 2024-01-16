import { Component } from '@angular/core';
import { CommonModule, NgOptimizedImage } from '@angular/common';
import { translate } from '@angular/localize/tools';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'store-ui-home-ui',
  standalone: true,
  imports: [CommonModule, NgOptimizedImage],
  templateUrl: './home-ui.component.html',
  styleUrl: './home-ui.component.css',
})
export class HomeUiComponent {

  constructor(protected translate: TranslateService) {
  }
}
