package com.greatlearning.studentapp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main( String[] args ) {
		// create session factory object
		Configuration con = new Configuration().configure( "hibernate.cfg.xml" ).addAnnotatedClass( Student.class );
		SessionFactory sessionFactory = con.buildSessionFactory();
		
		// create BookServiceImpl object and pass it the session factory object
		StudentService ss = new StudentServiceImpl( sessionFactory );

		List<Student> students = ss.findAll();
		
		for( Student student : students ) {
			System.out.println( student );
		}
	}
}