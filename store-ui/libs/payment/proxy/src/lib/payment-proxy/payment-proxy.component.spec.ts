import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PaymentProxyComponent } from './payment-proxy.component';

describe('PaymentProxyComponent', () => {
  let component: PaymentProxyComponent;
  let fixture: ComponentFixture<PaymentProxyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PaymentProxyComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PaymentProxyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
