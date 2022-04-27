import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapWorkersComponent } from './map-workers.component';

describe('MapWorkersComponent', () => {
  let component: MapWorkersComponent;
  let fixture: ComponentFixture<MapWorkersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MapWorkersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MapWorkersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
