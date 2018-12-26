package net.javaguides.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;

import net.javaguides.hibernate.dao.CourseDao;
import net.javaguides.hibernate.dao.InstructorDao;
import net.javaguides.hibernate.entity.Course;
import net.javaguides.hibernate.entity.Instructor;
import net.javaguides.hibernate.entity.InstructorDetail;

public class ManApp {
	public static void main(String[] args) {

		Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@javaguides.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
		instructor.setInstructorDetail(instructorDetail);
		
		// create some courses
		List<Course> courses = new ArrayList<>();
		
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		tempCourse1.setInstructor(instructor);
		courses.add(tempCourse1);
		
		
		Course tempCourse2 = new Course("The Pinball Masterclass");
		tempCourse2.setInstructor(instructor);
		courses.add(tempCourse1);

		instructor.setCourses(courses);
		
		CourseDao courseDao = new CourseDao();
		courseDao.saveCourse(tempCourse1);
		courseDao.saveCourse(tempCourse2);
		
		InstructorDao instructorDao = new InstructorDao();
		instructorDao.saveInstructor(instructor);
		
		// Get Only Instructor not course - FetchType.LAZY
		Instructor instructor2 = instructorDao.getInstructor(1);
		System.out.println(instructor2.getFirstName());
	}
}
