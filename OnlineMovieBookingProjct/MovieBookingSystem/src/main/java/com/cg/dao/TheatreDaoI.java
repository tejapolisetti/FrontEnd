package com.cg.dao;

import java.util.List;
import java.util.Set;

import com.cg.entities.Movie;
import com.cg.entities.Theatre;

public interface TheatreDaoI {
	public void createTheatre(Theatre theatre);
	public Theatre update(Theatre theatre);
	public Theatre getTheatreById(int theatreId);
	public Theatre searchTheatre(String theatre_name);
	public List<Movie> searchByCity(String theatre_city);
	public List<Theatre> fetchAllTheatres();
	public Set<Movie> getSetOfMovies(String theatre_city);

}
