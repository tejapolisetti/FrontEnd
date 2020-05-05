import { Component, OnInit,ViewChild } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {MovieserviceService} from '../movieservice.service';
import {Theatre} from '../Theatre';
import {Movie} from '../Movie';
import { Observable, Subject } from 'rxjs';
import { NgForm } from '@angular/forms';
import {Router} from '@angular/router';


@Component({
  selector: 'app-search-component',
  templateUrl: './search-component.component.html',
  
  styleUrls: ['./search-component.component.css']
})
export class SearchComponentComponent implements OnInit {
  searchNameFlag: boolean = false;

  nameIsEmptyFlag: boolean = false;
  errorFlag: boolean = false;
  @ViewChild("#formdata")
  form:NgForm;
  movies:Movie[]=[]
    theatre:Theatre=new Theatre();
    constructor(private movieservice:MovieserviceService,private router:Router) { }

  searchMovie()
{
  if (this.theatre.theatreCity == "") {
    this.nameIsEmptyFlag = true;
  } else {
    this.nameIsEmptyFlag = false;
  }

    this.movies.splice(0, this.movies.length);
  this.movieservice.searchMovie(this.theatre.theatreCity).subscribe(data=>
    {
      this.movies=data 
      if (this.movies.length === 0) {
        this.errorFlag = true;
      } else {
        this.errorFlag = false;

        this.searchNameFlag = true;
      }

    },
    error=>
    {
      alert("error");
      console.log("error occured", error);
     
      
    });
 
}

ngOnInit(): void {
  
}
back() {
  this.searchNameFlag = false;
  this.router.navigate(["/"]);
}
back1() {
  this.errorFlag = false;
}
searching()
{
  this.searchNameFlag=false;
  this.router.navigate(["/searchname"])
}

}

