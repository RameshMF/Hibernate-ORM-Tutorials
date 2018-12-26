package net.javaguides.hibernate;

import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.entity.Student;

public class App {
	public static void main(String[] args) {
		
		StudentDao studentDao = new StudentDao();
		
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
		Student student1 = new Student("Tom", "Cruise", "tom@javaguides.com");
		Student student2 = new Student("Tony", "stark", "tony@javaguides.com");
		studentDao.saveStudent(student);
		studentDao.saveStudent(student1);
		studentDao.saveStudent(student2);
		
		studentDao.getStudent(1);
		studentDao.loadStudent(2);
		studentDao.getStudentById(3);
	}
}
