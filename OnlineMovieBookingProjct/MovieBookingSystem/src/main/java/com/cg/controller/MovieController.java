package com.cg.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dao.MovieDaoI;
import com.cg.entities.Movie;
import com.cg.entities.Theatre;
import com.cg.exceptions.NoTheatreOrMovieFoundException;
import com.cg.service.MovieServiceI;



@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MovieController {
	@Autowired
	MovieServiceI service;
	
	/**************************************************************************************************
	 *@GetMapping              -Handles HTTP GET requests.
     *created by               -Teja Polisetti
     *created date             -21-APR-2020
**************************************************************************************************/
	
	@GetMapping(value="/getmoviedetails/{name}")
	@ResponseBody
    public ResponseEntity<Movie> searchMovie(@PathVariable String name)
    {
    	Movie movie= service.getbyName(name);
    	return new ResponseEntity<Movie>(movie,HttpStatus.OK);
    }
	@GetMapping(value="/searchCity/{city}")
	@ResponseBody
    public ResponseEntity<Set<Movie>> searchByCity(@PathVariable String city) throws NoTheatreOrMovieFoundException
    {
    	Set<Movie> list=service.getSetOfMovies(city);
    	return new ResponseEntity<Set<Movie>>(list,HttpStatus.OK);
    }
	@GetMapping(value="/theatre/{m_name}")
	@ResponseBody
	public ResponseEntity<Set<Theatre>> searchByMovieName(@PathVariable String m_name) throws NoTheatreOrMovieFoundException
	{
		Set<Theatre> set=service.searchByMovieName(m_name); 
		return new ResponseEntity<Set<Theatre>>(set,HttpStatus.OK);
	}
	
	}