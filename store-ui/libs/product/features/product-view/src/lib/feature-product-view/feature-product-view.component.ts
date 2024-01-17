import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Product, ProductEvent, ProductEventType, ProductType } from '@store-ui/product-domain';
import { MetaData, NgEventBus } from 'ng-event-bus';
import { NgbAlert } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'store-ui-feature-product-view',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgbAlert],
  templateUrl: './feature-product-view.component.html',
  styleUrl: './feature-product-view.component.css'
})
export class FeatureProductViewComponent {

  @ViewChild('successAlert', { static: false }) successAlert!: NgbAlert;

  protected productAdded = false;
  readonly product: Product;
  protected addToChartForm: FormGroup;
  private timeoutId?: number | undefined;

  constructor(private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private eventBus: NgEventBus) {
    this.product = {
      id: '00000001',
      name: 'MAC Book Pro 16',
      type: ProductType.LAPTOP,
      count: 10,
      price: 5000.00,
      taxPercent: 20.00
    };

    this.addToChartForm = this.formBuilder.group({
      count: new FormControl(1, [
        Validators.required,
        Validators.min(1),
        Validators.max(this.product.count)
      ])
    });

    eventBus.on(ProductEventType.PRODUCT_ADDED).subscribe(this.onProductAdded);
  }

  onSubmit(): void {
    this.onSubmitStart();
    const productEvent: ProductEvent = {
      id: this.product.id,
      count: this.addToChartForm.controls['count'].value
    };
    this.eventBus.cast(ProductEventType.PRODUCT_ADDED, productEvent);
    this.onSubmitSuccess();
  }

  private onSubmitStart(): void {
    this.productAdded = false;
    clearTimeout(this.timeoutId);
  }

  private onSubmitSuccess(): void {
    this.productAdded = true;
    this.timeoutId = setTimeout(() => this.successAlert?.close(), 3000);
    this.addToChartForm.reset({ count: 1 });
  }

  onSuccessAlertClosed(): void {
    this.productAdded = false;
    this.timeoutId = undefined;
  }

  onProductAdded(meta: MetaData): void {
    console.log(meta);
  }
}
