package com.cg.service;

import java.util.List;
import java.util.Set;

import com.cg.entities.Movie;
import com.cg.entities.Screen;
import com.cg.entities.Show;
import com.cg.entities.Theatre;

public interface MovieServiceI {
	public void createMovie(Movie movie);
	public void createShow(Show show);
	public void createScreen(Screen screen);
	public Movie findById(Integer id);
	public Movie getbyName(String movie_name);
	public Movie updateMovie(Movie movie);
	public List<Theatre> searchByMovie(String movie_name);
	public List<Movie> fetchAllMovies(); 
	public void createTheatre(Theatre theatre);
	public Theatre update(Theatre theatre);
	public Theatre getTheatreById(int theatreId);
	public Theatre searchTheatre(String theatre_name);
	public List<Movie> searchByCity(String theatre_city);
	public List<Theatre> fetchAllTheatres();
	public Set<Movie> getSetOfMovies(String theatre_city);
	public Set<Theatre> searchByMovieName(String movie_name);
	

}
