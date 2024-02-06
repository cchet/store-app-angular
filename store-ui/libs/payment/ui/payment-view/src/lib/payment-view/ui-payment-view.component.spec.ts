import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UiPaymentViewComponent } from './ui-payment-view.component';

describe('PaymentViewComponent', () => {
  let component: UiPaymentViewComponent;
  let fixture: ComponentFixture<UiPaymentViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UiPaymentViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UiPaymentViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
