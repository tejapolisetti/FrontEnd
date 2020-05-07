package com.cg.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.entities.Movie;
import com.cg.entities.Screen;
import com.cg.entities.Show;
import com.cg.entities.Theatre;
import com.cg.exceptions.NoTheatreOrMovieFoundException;

@Repository
@Transactional
public class MovieDaoimpl implements MovieDaoI {
	@PersistenceContext
	EntityManager manager;


	

	@Override
	public void createMovie(Movie movie) {
		manager.persist(movie);
		
		
	}

	@Override
	public void createShow(Show show) {
		manager.persist(show);
		
		
	}

	@Override
	public void createScreen(Screen screen) {
		manager.persist(screen);
		// TODO Auto-generated method stub
		
	}


	@Override
	public Movie findById(Integer id) {
		// TODO Auto-generated method stub
		return manager.find(Movie.class,id);
		
	}
	
	
	@Override
	public Movie getbyName(String name) {
		 String query1 = "SELECT m from Movie m where m.movieName=:name";
		 TypedQuery<Movie> query = manager.createQuery(query1, Movie.class);
		 query.setParameter("name",name);
		// TODO Auto-generated method stub
		return query.getSingleResult();
	}


	@Override
	public Movie updateMovie(Movie movie) {
		manager.merge(movie);
		// TODO Auto-generated method stub
		return movie;
	}
	/**************************************************************************************************
     *Method:                   -searchByMovieName
     *description:              - display set of theatres in which movie is found
     *movie_name                -fetches the theatre details
     *@returns                  -set of theatres
     *@throws NoTheatreOrMovieFoundException    -It is raised due to no Theatre found
     *created by                -Teja Polisetti
     *created date              -21-APR-2020
**************************************************************************************************/
	@Override
	public List<Theatre> searchByMovie(String movie_name) {
		Query query=manager.createQuery("select m.listOfTheatres from Movie m where m.movieName=:name");
		 query.setParameter("name",movie_name);
	
		return query.getResultList();
	}

	@Override
	public List<Movie> fetchAllMovies() {
		Query query=manager.createQuery("select m from Movie m");
		return query.getResultList();
	}

	
	/**************************************************************************************************
     *Method:                   -searchByMovieName
     *description:              - display set of theatres in which movie is found
     *movie_name                -fetches the theatre details
     *@returns                  -set of theatres
     *@throws NoTheatreOrMovieFoundException  -it is raised due to no Theatre found
     *created by                -Teja Polisetti
     *created date              -21-APR-2020
**************************************************************************************************/
	@Override
	public Set<Theatre> searchByMovieName(String movie_name) {
		List<Theatre> theatres=searchByMovie(movie_name);
		Set<Theatre> theatre=new HashSet<Theatre>();
		for(Theatre x:theatres)
		{
			theatre.add(x);
		}
		
		return theatre;
	}
	
}
