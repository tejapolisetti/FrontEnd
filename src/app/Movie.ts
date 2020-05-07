import { Theatre } from './Theatre';

export class Movie
{
    movieId:number;
    movieName:String;
    genre:String;
    director:String;
    runtime:number;
    hero:String;
    heroine:String;
    listOfTheatres:Theatre[];
    imageLinks:string
    // constructor(movieId,movieName,genre,director,runtime,hero,heroine,listOfTheatres)
    // {
    //     this.movieId=movieId;
    //     this.movieName=movieName;
    //     this.genre=genre;
    //     this.director=director;
    //     this.runtime=runtime;
    //     this.hero=hero;
    //     this.heroine=heroine;
    //     this.listOfTheatres=listOfTheatres;
    // }
    
}