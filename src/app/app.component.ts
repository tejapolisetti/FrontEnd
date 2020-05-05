import { Component } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {MovieserviceService} from './movieservice.service';
import {Theatre} from './Theatre';
import {Movie} from './Movie';
import { Observable, Subject } from 'rxjs';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
 
  title = 'Welcome to Online Movie Booking';
}
