package net.javaguides.hibernate;

import javax.persistence.EntityManager;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.JPAUtil;

public class App {
	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();

		JPAUtil.shutdown();
	}

}
