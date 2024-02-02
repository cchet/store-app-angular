import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FeatureCartPaymentComponent } from './feature-cart-payment.component';

describe('FeatureCartPaymentComponent', () => {
  let component: FeatureCartPaymentComponent;
  let fixture: ComponentFixture<FeatureCartPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeatureCartPaymentComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FeatureCartPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
