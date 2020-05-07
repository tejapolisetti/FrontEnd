package com.cg.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.entities.Movie;
import com.cg.entities.Theatre;
import com.cg.exceptions.NoTheatreOrMovieFoundException;
@Repository
@Transactional
public class TheatreDaoimpl implements TheatreDaoI {
	@PersistenceContext
	EntityManager manager;
	
	/**************************************************************************************************
     *Method:                   -createTheatre
     *description:              - To create theatre i.e to convert object to relational
     *theatre                   -object to theatre entity class
     *@returns                  -Void 
     *created by                -Teja Polisetti
     *created date              -21-APR-2020
**************************************************************************************************/
	@Override
	public void createTheatre(Theatre theatre) {
		manager.persist(theatre);
		
	}
	/**************************************************************************************************
     *Method:                   -getTheatreById
     *description:              - get theatre details based on Id
     *theatreId	                -fetches theatre details
     *@returns                  -Theatre 
     *created by                -Teja Polisetti
     *created date              -21-APR-2020
**************************************************************************************************/
	@Override
	public Theatre getTheatreById(int theatreId) {
		Theatre theatre=manager.find(Theatre.class,theatreId);
		// TODO Auto-generated method stub
		return theatre;
	}
	/**************************************************************************************************
     *Method:                   -update
     *description:              - Update theatre in database
     *theatre	                -object to that entity Theatre
     *@returns                  -Theatre 
     *created by                -Teja Polisetti
     *created date              -21-APR-2020
**************************************************************************************************/
	@Override
	public Theatre update(Theatre theatre) {
		// TODO Auto-generated method stub
		manager.merge(theatre);
		return theatre;
	}
	
	@Override
	public Theatre searchTheatre(String theatre_name) {
		 String query1 = "SELECT t from Theatre t where t.theatreName=:name";
		 TypedQuery<Theatre> query = manager.createQuery(query1, Theatre.class);
		 query.setParameter("name",theatre_name);
		return query.getSingleResult();
	}
	 
	/**************************************************************************************************
     *Method:                   -searchByCity
     *description:              - display the list of movies in that city 
     *theatre_city                -fetches the movies of that particular city
     *@returns                  -list of Movies
     *@throws NoTheatreOrMovieFoundException  -it is raised due to no city found
     *created by                -Teja Polisetti
     *created date              -22-APR-2020
**************************************************************************************************/
	@Override
	public List<Movie> searchByCity(String theatre_city) {
		Query query=manager.createQuery("select t.listOfMovies from Theatre t where t.theatreCity=:name");
		 query.setParameter("name",theatre_city);
		return query.getResultList();
	}
	
	
	
	@Override
	public List<Theatre> fetchAllTheatres() {
		Query query=manager.createQuery("select t from Theatre t");
		return query.getResultList();
	}

	/**************************************************************************************************
     *Method:                   -getSetOfMovies
     *description:              - display the set of movies in that city by converting list of movies to set of movies
     *theatre_city              -fetches the details of that particular city
     *@returns                  -set of Movies
     *@throws NoTheatreOrMovieFoundException    -It is raised due to no city found
     *created by                -Teja Polisetti
     *created date              -22-APR-2020
**************************************************************************************************/
	@Override
	public Set<Movie> getSetOfMovies(String theatre_city) {
		List<Movie> movies=searchByCity(theatre_city);
		Set<Movie> m=new HashSet<Movie>();
		for(Movie x:movies)
		{
			m.add(x);
		}
		
		return m;
	}


}
