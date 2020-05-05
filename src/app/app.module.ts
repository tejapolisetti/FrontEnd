import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchComponentComponent } from './search-component/search-component.component';
import { HttpClientModule, HttpClient } from "@angular/common/http";
import { FormsModule } from '@angular/forms';

import { MovieserviceService } from './movieservice.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchMovieComponentComponent } from './search-movie-component/search-movie-component.component';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponentComponent,
    SearchMovieComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule
  ],
  providers: [MovieserviceService],
  bootstrap: [AppComponent]

})
export class AppModule { }
