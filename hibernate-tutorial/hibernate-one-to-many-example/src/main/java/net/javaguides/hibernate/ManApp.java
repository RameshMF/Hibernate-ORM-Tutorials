package net.javaguides.hibernate;

import java.util.ArrayList;
import java.util.List;

import net.javaguides.hibernate.dao.InstructorDao;
import net.javaguides.hibernate.entity.Course;
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
		
		List<Course> courses = new ArrayList<>();
		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		tempCourse1.setInstructor(instructor);
		courses.add(tempCourse1);
		
		
		Course tempCourse2 = new Course("The Pinball Masterclass");
		tempCourse2.setInstructor(instructor);
		courses.add(tempCourse1);

		instructor.setCourses(courses);
		
		InstructorDao instructorDao = new InstructorDao();
		instructorDao.saveInstructor(instructor);
	}
}
