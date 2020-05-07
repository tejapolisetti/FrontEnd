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

  info:string
  errorinfo:string
  errorFlag: boolean = false;
  @ViewChild("#formdata")
  form:NgForm;
  movies:Movie[]=[]
    theatre:Theatre=new Theatre();
   /*********************************************************************
   * Method: constructor
   * params:
   * return:
   * Description: constructor injects the theatreService and router module
   *
   * Created Date: 26 APR 2020
   * Author: Polisetti Venkata Dharma Teja
   ************************************************************************/
    constructor(private movieservice:MovieserviceService,private router:Router) { }
 /********************************************************************************
   * Method: searchMovie
   * Description: this method call service searchMovie method and display movie details every time
   *              and routes the page to display all theatre detail after adding
   * Created Date: 26 APR 2020
   * Author: Polisetti Venkata Dharma Teja
   **********************************************************************************/
  searchMovie()
{
  this.movieservice.searchMovie(this.theatre.theatreCity).subscribe(data=>
    {
      this.movies=data 
     
        this.searchNameFlag = true;
        this.info=data
        this.errorinfo=undefined

    },
    error=>
    {
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
back1() {
  this.errorFlag = false;
}
searching()
{
  this.searchNameFlag=false;
  this.router.navigate(["/searchname"])
}

}

