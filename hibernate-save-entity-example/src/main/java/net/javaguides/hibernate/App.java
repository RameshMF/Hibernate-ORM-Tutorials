package net.javaguides.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
		saveOrUpdateStudent(student);
	}

	public static void saveOrUpdateStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.saveOrUpdate(student);
			
			// get entity from database
			Student student2 = session.get(Student.class, 1);
			
			// do changes 
			student2.setFirstName("Ram");
			
			// update the student object
			session.saveOrUpdate(student2);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
