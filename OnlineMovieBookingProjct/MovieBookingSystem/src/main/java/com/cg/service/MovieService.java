package com.cg.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.MovieDaoI;
import com.cg.dao.TheatreDaoI;
import com.cg.entities.Movie;
import com.cg.entities.Screen;
import com.cg.entities.Show;
import com.cg.entities.Theatre;
import com.cg.exceptions.NoTheatreOrMovieFoundException;
@Service
public class MovieService implements MovieServiceI{
	@Autowired
	MovieDaoI dao;
	@Autowired
	TheatreDaoI dao1;

	@Override
	public void createTheatre(Theatre theatre) {
		dao1.createTheatre(theatre);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMovie(Movie movie) {
		dao.createMovie(movie);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createShow(Show show) {
		dao.createShow(show);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createScreen(Screen screen) {
		dao.createScreen(screen);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Theatre getTheatreById(int theatreId) {
		// TODO Auto-generated method stub
		return dao1.getTheatreById(theatreId);
	}

	@Override
	public Movie findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Theatre update(Theatre theatre) {
		// TODO Auto-generated method stub
		return dao1.update(theatre);
	}

	@Override
	public Theatre searchTheatre(String theatre_name) {
		// TODO Auto-generated method stub
		return dao1.searchTheatre(theatre_name);
	}




	@Override
	public Movie updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return dao.updateMovie(movie);
	}

	@Override
	public List<Theatre> searchByMovie(String movie_name) {
		// TODO Auto-generated method stub
		return dao.searchByMovie(movie_name);
	}

	@Override
	public List<Movie> searchByCity(String theatre_city) {
		// TODO Auto-generated method stub
		return dao1.searchByCity(theatre_city);
	}

	@Override
	public List<Theatre> fetchAllTheatres() {
		// TODO Auto-generated method stub
		return dao1.fetchAllTheatres();
	}

	@Override
	public List<Movie> fetchAllMovies() {
		// TODO Auto-generated method stub
		return dao.fetchAllMovies();
	}

	@Override
	public Movie getbyName(String movie_name) {
		// TODO Auto-generated method stub
		return dao.getbyName(movie_name);
	}

	@Override
	public Set<Movie> getSetOfMovies(String theatre_city) {
		if(dao1.getSetOfMovies(theatre_city).size()>0)
		{
			Set<Movie> movie_set=dao1.getSetOfMovies(theatre_city);
			return movie_set;
		}
		throw new NoTheatreOrMovieFoundException("OOPS! City is not available. Please search again");
		
	}

	@Override
	public Set<Theatre> searchByMovieName(String movie_name) {
		if(dao.searchByMovieName(movie_name).size()>0)
		{
			Set<Theatre> theatre_set=dao.searchByMovieName(movie_name);
			return theatre_set;
		}
		throw new NoTheatreOrMovieFoundException("OOPS! Movie is not available. Please search again");
		
	}
	

}
