package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.InstructorDao;
import net.javaguides.hibernate.entity.Course;
import net.javaguides.hibernate.entity.Instructor;

public class ManApp {
	public static void main(String[] args) {

		InstructorDao instructorDao = new InstructorDao();
		
		Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@javaguides.com");
		instructorDao.saveInstructor(instructor);
		
		// create some courses
		Course tempCourse1 = new Course("Learn Spring Boot");
		instructor.getCourses().add(tempCourse1);
		
		Course tempCourse2 = new Course("Learn hibernate");
		instructor.getCourses().add(tempCourse2);
		
		instructorDao.saveInstructor(instructor);
	}
}
