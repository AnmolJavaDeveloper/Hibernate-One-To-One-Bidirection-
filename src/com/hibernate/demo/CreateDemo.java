package com.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetail;
import com.hibernate.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
    
	 //create session factory
	 SessionFactory factory = new Configuration()
			   				  .configure("hibernate.cfg.xml")
			   				  .addAnnotatedClass(Instructor.class)
			   				  .addAnnotatedClass(InstructorDetail.class)
			   				  .buildSessionFactory();
		
		//create session
	 Session session =  factory.getCurrentSession();
	   
	 try {
		 //create the objects
		 /*
		 Instructor tempInstructor=
				 new Instructor("Chad", "Darby" , "darby@luv2code.com");
		 
		 InstructorDetail tempInstructorDetail = new InstructorDetail(
				                                 "http://www.luv2code.com/youtube",
				                                 "Luv 2 Code!!!");
		 */
		 Instructor tempInstructor=
				 new Instructor("Madhu", "Patel" , "mahu@luv2code.com");
		 
		 InstructorDetail tempInstructorDetail = new InstructorDetail(
				                                 "http://www.youtube.com",
				                                 "Guitar!!!");
		 
		 //associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		 //start a transaction
		 session.beginTransaction();
		 
		 //save the instructor
		 //Note: this will also save the details object
		 //because of CascadeType.All
		 System.out.println("Saving Instructor: " + tempInstructor);
		 session.save(tempInstructor);
		 
		
		 //commit transaction
		 session.getTransaction().commit();
		 System.out.println("Done!");
		 
		 
		 
		 
	 }
		finally {
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
