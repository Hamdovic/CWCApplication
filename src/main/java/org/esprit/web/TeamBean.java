package org.esprit.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;





import org.esprit.business.CatalogServiceLocal;
import org.esprit.domain.Reward;
import org.esprit.domain.Team;




@ManagedBean
@ViewScoped
public class TeamBean {
	
	@EJB
    private CatalogServiceLocal catalogServicelocal;
	private Team team = new Team();
	List<Team> teams ;
	
	public TeamBean() {
		
	}

	@PostConstruct
	public void init() {
		teams = catalogServicelocal.findAllTeams();
	}
	

	

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * @return the teams
	 */
	public List<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams the teams to set
	 */
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	

}
