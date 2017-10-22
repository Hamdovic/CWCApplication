package org.esprit.web;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.esprit.business.DevelopperServiceLocal;
import org.esprit.domain.Developper;



@ViewScoped
@ManagedBean
public class TeamConsultBean{
	
	
	/**
	 * 
	 */
	
	@EJB
	private DevelopperServiceLocal developperServiceLocal;
	public List<Developper> developpers  ;
	




	public TeamConsultBean() {
	}
	
	@PostConstruct
	public void Init() {
		 Developper D=AuthenticationBean.Dev;
		developpers= developperServiceLocal.findAllDeveloppers();
	
		
	
	
		
		
		
	
	}

	public List<Developper> getDeveloppers() {
		return developpers;
	}

	public void setDeveloppers(List<Developper> developpers) {
		this.developpers = developpers;
	}
	
	


}
