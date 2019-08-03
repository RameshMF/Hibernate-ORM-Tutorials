package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.InstructorDao;
import net.javaguides.hibernate.entity.Instructor;
import net.javaguides.hibernate.entity.InstructorDetail;

public class ManApp {
	public static void main(String[] args) {

		Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@javaguides.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
		// associate the objects
		instructorDetail.setInstructor(instructor);
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);
		
		// when you get instructorDetail then hibernate also saves instructor info
		InstructorDao instructorDao = new InstructorDao(); 
		instructorDao.saveInstructor(instructor);
	}
}
