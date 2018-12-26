package net.javaguides.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Project;
import net.javaguides.hibernate.util.HibernateUtil;

public class ProjectDao {
	public void saveProject(Project project) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			Transaction transaction = session.beginTransaction();
			// save the project object
			session.save(project);
			// commit transaction
			transaction.commit();
		}
	}

	public List<Project> getProjects() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Project", Project.class).list();
		}
	}
}
