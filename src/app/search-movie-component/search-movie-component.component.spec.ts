import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchMovieComponentComponent } from './search-movie-component.component';

describe('SearchMovieComponentComponent', () => {
  let component: SearchMovieComponentComponent;
  let fixture: ComponentFixture<SearchMovieComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchMovieComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchMovieComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
