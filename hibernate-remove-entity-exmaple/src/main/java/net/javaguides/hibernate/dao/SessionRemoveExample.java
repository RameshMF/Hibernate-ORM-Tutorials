package net.javaguides.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class SessionRemoveExample {
	public void removeStudent(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a persistent object
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.remove(student);
				System.out.println("student 1 is deleted");
			}

			// Delete a transient object
			Student student2 = new Student();
			student2.setId(2);
			session.remove(student2);
			System.out.println("Student 2 is deleted");

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
