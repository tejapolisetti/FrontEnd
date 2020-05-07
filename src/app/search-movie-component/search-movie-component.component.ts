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
  info:string;
  errorinfo:string;

  nameIsEmptyFlag: boolean = false;
   /*********************************************************************
   *  Instance of Movie for manupulation
   **********************************************************************/
  movie:Movie=new Movie();
    theatres:Theatre[]=[]

    constructor(private router: Router,private movieservice:MovieserviceService) { }
    searchName()
    {
  
  
        this.movieservice.searchName(this.movie.movieName).subscribe(data=>
    {
      this.theatres=data
      this.info=data
      this.errorinfo=undefined;
      this.searchNameFlag = true;
    },

    (error)=>
    {
      // alert("error");
      // console.log("error occured", error);
      this.errorinfo=error.error
      this.info=undefined
      
    });
 
  }


  

  ngOnInit(): void {
  }
  back() {
    this.searchNameFlag = false;
    this.router.navigate(["/"]);
  }

}
