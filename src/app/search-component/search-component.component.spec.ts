import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchComponentComponent } from './search-component.component';
import {FormControl} from '@angular/forms';

describe('SearchComponentComponent', () => {
  let component: SearchComponentComponent;
  let fixture: ComponentFixture<SearchComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
