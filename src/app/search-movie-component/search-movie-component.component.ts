import { Component, OnInit,ViewChild} from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {MovieserviceService} from '../movieservice.service';
import {Theatre} from '../Theatre';
import {Movie} from '../Movie';
import { Observable, Subject } from 'rxjs';
import { NgForm } from '@angular/forms';
import { Router } from "@angular/router";

@Component({
  selector: 'app-search-movie-component',
  templateUrl: './search-movie-component.component.html',
  styleUrls: ['./search-movie-component.component.css']
})
export class SearchMovieComponentComponent implements OnInit {
  @ViewChild("#formdata")
  form:NgForm;
  searchNameFlag: boolean = false;

  nameIsEmptyFlag: boolean = false;
  errorFlag: boolean = false;
  movie:Movie=new Movie();
    theatres:Theatre[]=[]

    constructor(private router: Router,private movieservice:MovieserviceService) { }
    searchName()
    {
      if (this.movie.movieName == "") {
        this.nameIsEmptyFlag = true;
      } else {
        this.nameIsEmptyFlag = false;
      }
  
        this.theatres.splice(0, this.theatres.length);
  
        this.movieservice.searchName(this.movie.movieName).subscribe(data=>
    {
      this.theatres=data
      if (this.theatres.length === 0) {
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

}
