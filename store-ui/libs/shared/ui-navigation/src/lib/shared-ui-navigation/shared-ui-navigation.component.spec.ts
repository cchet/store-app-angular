import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SharedUiNavigationComponent } from './shared-ui-navigation.component';

describe('SharedUiNavigationComponent', () => {
  let component: SharedUiNavigationComponent;
  let fixture: ComponentFixture<SharedUiNavigationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SharedUiNavigationComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(SharedUiNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
