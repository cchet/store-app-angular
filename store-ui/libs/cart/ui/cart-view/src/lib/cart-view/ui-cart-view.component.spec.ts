import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UiCartViewComponent } from './ui-cart-view.component';

describe('BasketViewComponent', () => {
  let component: UiCartViewComponent;
  let fixture: ComponentFixture<UiCartViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UiCartViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UiCartViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
