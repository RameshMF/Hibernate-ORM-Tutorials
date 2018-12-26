package net.javaguides.hibernate;

import org.hibernate.Session;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		Integer studentId = 1;
		/************************** Save Entity ***************************/
		Session sessionOne = HibernateUtil.getSessionFactory().openSession();
		sessionOne.beginTransaction();

		// create new student object
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
		
		// save student object to database
		sessionOne.save(student);
		sessionOne.getTransaction().commit();
		
		/*******************************************************************/
		
		//Let's open a new session to test load() methods
	      Session sessionTwo = HibernateUtil.getSessionFactory().openSession();
	      sessionTwo.beginTransaction();
	       
	      //first load() method example
	      Student student1 = (Student) sessionTwo.load(Student.class, studentId);
	      System.out.println(student1.getFirstName() + " - " +student1.getLastName());
	       
	      //Let's verify the entity name
	      System.out.println(sessionTwo.getEntityName(student1));
	       
	      sessionTwo.getTransaction().commit();
	      
	      /************************************************************************/
	       
	      Session sessionThree = HibernateUtil.getSessionFactory().openSession();
	      sessionThree.beginTransaction();
	       
	      //second load() method example
	      Student student2 = (Student) sessionThree.load("net.javaguides.hibernate.entity.Student", studentId);
	      System.out.println(student2.getFirstName() + " - " +student2.getLastName());
	       
	      sessionThree.getTransaction().commit();
	       
	      /************************************************************************/
	       
	      Session sessionFour = HibernateUtil.getSessionFactory().openSession();
	      sessionFour.beginTransaction();
	       
	      //third load() method example
	      Student student3 = new Student();
	      sessionFour.load(student3 , studentId);
	      System.out.println(student3.getFirstName() + " - " +student3.getLastName());
	       
	      sessionFour.getTransaction().commit();
	}
}
