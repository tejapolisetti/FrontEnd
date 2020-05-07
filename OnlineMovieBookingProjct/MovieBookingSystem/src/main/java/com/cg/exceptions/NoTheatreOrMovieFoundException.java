package com.cg.exceptions;

public class NoTheatreOrMovieFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoTheatreOrMovieFoundException(String msg) {
		super(msg);
	}
	
	public  NoTheatreOrMovieFoundException(String msg,Throwable T) {
		super(msg,T);
	}
}
