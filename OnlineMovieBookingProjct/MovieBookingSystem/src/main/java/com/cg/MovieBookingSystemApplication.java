package com.cg;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.dao.MovieDaoI;
import com.cg.entities.Movie;
import com.cg.entities.Screen;
import com.cg.entities.Show;
import com.cg.entities.Theatre;
import com.cg.service.MovieServiceI;
import com.sun.xml.bind.v2.runtime.reflect.ListIterator;

import javassist.bytecode.Descriptor.Iterator;

@SpringBootApplication
public class MovieBookingSystemApplication implements CommandLineRunner {
	@Autowired
	MovieServiceI service; 
	

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started Movie Booking Application");
		
		
	}

}
