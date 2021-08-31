import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandInputComponent } from './land-input.component';

describe('LandInputComponent', () => {
  let component: LandInputComponent;
  let fixture: ComponentFixture<LandInputComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandInputComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LandInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
