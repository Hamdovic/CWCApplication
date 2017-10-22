package org.esprit.web;

import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.esprit.business.ProjectServiceLocal;
import org.esprit.domain.Project;
import org.esprit.domain.State;
import org.esprit.domain.Task;

@ViewScoped
@ManagedBean
public class ProjectBean {
	@EJB
	private ProjectServiceLocal projectServiceLocal;
	List<Project> projects;

	public ProjectBean() {

	}

	@PostConstruct
	public void Init() {
		projects = projectServiceLocal.findAllProjects();

	}

	public Date GetD() {
		return new Date();
	}

	public int Progress(List<Task> tasks) {
		int nb = 0;

		for (Task t : tasks) {
			if (t.getTask_state().toString() == "done") {
				nb++;

			}

		}
		int percentage = nb * 100 / tasks.size();

		return percentage;
	}

	public String Statett(Date Delivery, State s) {
		Date actuelle = new Date();
		if (Delivery.before(actuelle) && s.toString().equals("done"))
			return "project done";
		else if (Delivery.before(actuelle)
				&& s.toString().equals("in_progress"))
			return "delivery date is exceeded";
		else if (Delivery.after(actuelle)
				&& s.toString().endsWith("in_progress"))
			return "project in progress";
		else
			return "project done";

	}

	public String couleur(String x, State s) {
		if (x.equals("delivery date is exceeded"))
			return "small-box bg-red-gradient";
		else if (x.equals("project done"))
			return "small-box bg-green-gradient";
		else if (x.equals("project in progress"))
			return "small-box bg-yellow-gradient";
		else
			return null;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int GetCountDone() {
		int nb = 0;
		for (Project project : projects) {

			if (project.getProject_state().toString().equals("done")) {
				nb++;
			}
		}
		return nb;
	}

	public int GetCountInProgress() {
		int nb = 0;
		for (Project project : projects) {

			if (project.getProject_state().toString().equals("in_progress")) {
				nb++;
			}
		}
		return nb;
	}
}
