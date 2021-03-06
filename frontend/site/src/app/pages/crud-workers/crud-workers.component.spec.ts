import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrudWorkersComponent } from './crud-workers.component';

describe('CrudWorkersComponent', () => {
  let component: CrudWorkersComponent;
  let fixture: ComponentFixture<CrudWorkersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrudWorkersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrudWorkersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
