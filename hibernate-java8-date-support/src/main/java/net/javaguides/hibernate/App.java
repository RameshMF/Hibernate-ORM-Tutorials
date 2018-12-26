package net.javaguides.hibernate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.SimpleEntity;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		SimpleEntity simpleEntity = new SimpleEntity();
		simpleEntity.setDate(LocalDate.now());
		simpleEntity.setDateTime(LocalDateTime.now());
		simpleEntity.setDuration(Duration.ofDays(2));
				
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(simpleEntity);
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
