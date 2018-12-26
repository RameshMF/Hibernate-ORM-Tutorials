package net.javaguides.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Address;
import net.javaguides.hibernate.entity.Name;
import net.javaguides.hibernate.entity.User;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Name name = new Name("Ramesh", "M", "Fadatare");
		Address address = new Address("111", "Puadroad", "Pune", "Maharastra", "India", "411038");
		User user = new User(name, "ramesh@gmail.com", address);

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
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
