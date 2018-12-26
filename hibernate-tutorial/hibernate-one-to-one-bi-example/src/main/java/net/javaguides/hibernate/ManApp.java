package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.InstructorDetailDao;
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
		
		/*InstructorDao instructorDao = new InstructorDao();
		instructorDao.saveInstructor(instructor);*/
		
		// when you save instructorDetail then hibernate also saves instructor info because of cascade and bidirectional
		InstructorDetailDao instructorDetailDao = new InstructorDetailDao();
		instructorDetailDao.saveInstructorDetail(instructorDetail);
		
		// when you get instructorDetail then hibernate also saves instructor info
		InstructorDetail instructorDetail2 = instructorDetailDao.getInstructorDetail(1);
		System.out.println(instructorDetail2.getId());
		System.out.println(instructorDetail2.getInstructor().getFirstName());
	}
}
