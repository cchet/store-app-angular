import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UiProductViewComponent } from './ui-product-view.component';

describe('UiProductViewComponent', () => {
  let component: UiProductViewComponent;
  let fixture: ComponentFixture<UiProductViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UiProductViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(UiProductViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
