import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FeatureProductViewComponent } from './feature-product-view.component';

describe('FeatureProductViewComponent', () => {
  let component: FeatureProductViewComponent;
  let fixture: ComponentFixture<FeatureProductViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeatureProductViewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FeatureProductViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
