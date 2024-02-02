import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Product, ProductEventType, ProductPort } from '@store-ui/product-domain';
import { NgEventBus } from 'ng-event-bus';
import { NgbAlert } from '@ng-bootstrap/ng-bootstrap';
import { filter, map, switchMap } from 'rxjs';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'store-ui-feature-product-view',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgbAlert],
  templateUrl: './feature-product-view.component.html',
  styleUrl: './feature-product-view.component.css'
})
export class FeatureProductViewComponent implements OnInit {

  @ViewChild('successAlert', { static: false }) successAlert: NgbAlert | undefined;

  protected loadFailed: boolean = false;
  protected productAdded = false;
  protected product: Product | undefined;
  protected addToChartForm: FormGroup = this.formBuilder.group({
    count: new FormControl(1, [
      Validators.required,
      Validators.min(1),
      Validators.max(10)
    ])
  });
  private timeoutId: number | undefined;

  constructor(protected translate:TranslateService,
              private formBuilder: FormBuilder,
              private productPort: ProductPort,
              private activatedRoute: ActivatedRoute,
              private eventBus: NgEventBus) {
  }

  ngOnInit(): void {
    this.activatedRoute.params
      .pipe(map(params => params['id']))
      .pipe(filter(id => id !== undefined))
      .pipe(switchMap(id => this.productPort.byId(id)))
      .subscribe({
        next: product => this.product = product,
        error: (error) => {
          this.loadFailed = true;
          console.error(error);
        }
      });
  }

  onSubmit(id: string): void {
    this.onSubmitStart();
    this.eventBus.cast(ProductEventType.PRODUCT_ADDED, {
      id: id,
      count: this.addToChartForm.controls['count'].value
    });
    this.onSubmitSuccess();
  }

  onSuccessAlertClosed(): void {
    this.productAdded = false;
    this.timeoutId = undefined;
  }

  isLoading(): boolean {
    return this.product === undefined && !this.loadFailed;
  }

  isFailed(): boolean {
    return this.product === undefined && this.loadFailed;
  }

  private onSubmitStart(): void {
    this.productAdded = false;
    clearTimeout(this.timeoutId);
    this.timeoutId = undefined;
  }

  private onSubmitSuccess(): void {
    this.productAdded = true;
    this.timeoutId = setTimeout(() => this.successAlert?.close(), 3000);
    this.addToChartForm?.reset({ count: 1 });
  }
}
