import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FeaturePaymentStartComponent } from './feature-payment-start.component';

describe('FeaturePaymentStartComponent', () => {
  let component: FeaturePaymentStartComponent;
  let fixture: ComponentFixture<FeaturePaymentStartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeaturePaymentStartComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FeaturePaymentStartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
