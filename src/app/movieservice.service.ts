import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

import { Observable } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import {Theatre} from './Theatre';
import {Movie} from './Movie';

@Injectable({
  providedIn: 'root'
})
export class MovieserviceService {
 

  constructor(private http: HttpClient
) { }
 /*********************************************************************
   * Method: searchMovie
   * params:
   * return: Observable
   * Description: this method fetches the all Movies in city
   *
   * Created Date: 27 APR 2020
   * Author: Polisetti Venkata Dharma Teja
   ************************************************************************/
searchMovie(name:string):Observable<any>
{
  let url='http://localhost:4826/searchCity/'+name;
  return this.http.get(url);
}
/*********************************************************************
   * Method: searchName
   * params:
   * return: Observable
   * Description: this method fetches the all Theatres in which movie is present
   *
   * Created Date: 27 APR 2020
   * Author: Polisetti Venkata Dharma Teja
   ************************************************************************/
searchName(movie_name:any):Observable<any>
{
  let url1='http://localhost:4826/theatre/'+movie_name;
  return this.http.get(url1);

}


  
  }

