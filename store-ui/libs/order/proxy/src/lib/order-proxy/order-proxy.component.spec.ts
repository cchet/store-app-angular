import { ComponentFixture, TestBed } from '@angular/core/testing';
import { OrderProxyComponent } from './order-proxy.component';

describe('OrderProxyComponent', () => {
  let component: OrderProxyComponent;
  let fixture: ComponentFixture<OrderProxyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OrderProxyComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(OrderProxyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
