import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { SearchComponentComponent } from './search-component/search-component.component';
import { SearchMovieComponentComponent } from './search-movie-component/search-movie-component.component';


const routes: Routes = [{ path: 'searchname', component: SearchMovieComponentComponent },
{ path: 'searchcity', component: SearchComponentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
