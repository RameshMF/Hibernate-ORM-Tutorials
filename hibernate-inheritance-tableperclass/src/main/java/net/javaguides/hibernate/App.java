package net.javaguides.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Account;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the account object
			Account account = new Account();
			account.setBalance(10000.0);
			account.setInterestRate(10.0);
			account.setOwner("Ramesh");
			session.save(account);

			// commit transaction
			transaction.commit();
		}
		HibernateUtil.shutdown();
	}
}
