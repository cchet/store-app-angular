import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FeatureCartOverviewComponent } from './feature-cart-overview.component';

describe('BasketOverviewComponent', () => {
  let component: FeatureCartOverviewComponent;
  let fixture: ComponentFixture<FeatureCartOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FeatureCartOverviewComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FeatureCartOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
