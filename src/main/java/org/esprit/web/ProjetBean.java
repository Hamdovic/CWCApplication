package org.esprit.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import org.esprit.business.CatalogServiceLocal;
import org.esprit.domain.Project;



@ManagedBean
@ViewScoped
public class ProjetBean {

	@EJB
    private CatalogServiceLocal catalogServicelocal;
	private Project project = new Project();
	List<Project> projects ;
	
	public ProjetBean() {
		
	}

	@PostConstruct
	public void init() {
		projects = catalogServicelocal.findAllProjects();
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the projects
	 */
	public List<Project> getProjects() {
		return projects;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	

	
}