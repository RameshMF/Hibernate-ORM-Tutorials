package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.InstructorDao;
import net.javaguides.hibernate.entity.Instructor;
import net.javaguides.hibernate.entity.InstructorDetail;

public class ManApp {
	public static void main(String[] args) {

		Instructor instructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		InstructorDao instructorDao = new InstructorDao();
		instructorDao.saveInstructor(instructor);
	}
}
