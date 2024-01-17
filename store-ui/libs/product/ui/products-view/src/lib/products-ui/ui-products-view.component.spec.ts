import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UiProductsViewComponent } from '@store-ui/ui-products-view';

describe('ProductUiComponent', () => {
  let component: UiProductsViewComponent;
  let fixture: ComponentFixture<UiProductsViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UiProductsViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UiProductsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
