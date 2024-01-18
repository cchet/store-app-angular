import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Product, ProductPort } from '@store-ui/product-domain';
import { TranslateService } from '@ngx-translate/core';
import { Observable } from 'rxjs';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEye } from '@fortawesome/free-solid-svg-icons';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'store-ui-feature-product-list',
  standalone: true,
  imports: [CommonModule, FontAwesomeModule, RouterLink],
  templateUrl: './feature-product-list.component.html',
  styleUrl: './feature-product-list.component.css'
})
export class FeatureProductListComponent implements OnInit {

  protected products$: Observable<Array<Product>> | undefined;
  protected readonly iconDetail = faEye;

  constructor(private productPort: ProductPort,
              protected translate: TranslateService) {
  }

  ngOnInit(): void {
    this.products$ = this.productPort.list();
  }
}
