package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.ProjectDao;
import net.javaguides.hibernate.entity.Project;
import net.javaguides.hibernate.entity.ProjectStatus;

public class MainApp {
	public static void main(String[] args) {
		ProjectDao projectDao = new ProjectDao();
		Project project = new Project();
		project.setProjectName("TPO");
		project.setProjectStatus(ProjectStatus.INPROGESS);
		projectDao.saveProject(project);
		
		List<Project> projects = projectDao.getProjects();
		projects.forEach(s -> { 
				System.out.println(s.getProjectName());
				System.out.println(s.getProjectStatus());
		});
	}
}
