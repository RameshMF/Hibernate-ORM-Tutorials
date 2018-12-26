package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.InstructorDao;
import net.javaguides.hibernate.entity.Instructor;
import net.javaguides.hibernate.entity.InstructorDetail;

public class ManApp {
	public static void main(String[] args) {

		// Save two instructors
		Instructor instructor = new Instructor("Ramesh", "Fadatare", "ramesh@javaguides.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
		instructorDetail.setInstructor(instructor);
		instructor.setInstructorDetail(instructorDetail);
		
		Instructor instructor1 = new Instructor("Ram", "Fadatare", "ramesh@javaguides.com");
		InstructorDetail instructorDetail1 = new InstructorDetail("http://www.youtube.com", "Guitar");
		instructorDetail1.setInstructor(instructor1);
		instructor1.setInstructorDetail(instructorDetail1);
		
		InstructorDao instructorDao = new InstructorDao();
		instructorDao.saveInstructor(instructor);
		instructorDao.saveInstructor(instructor1);
		
		// Get all instructors
		List<Instructor> instructors = instructorDao.getAllInstructor();
		instructors.forEach(instructorTemp -> System.out.println(instructorTemp.getFirstName()));
	}
}
