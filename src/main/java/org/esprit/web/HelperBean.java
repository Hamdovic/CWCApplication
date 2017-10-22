package org.esprit.web;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.esprit.business.CatalogServiceLocal;
import org.esprit.domain.Team;


@ManagedBean
@ApplicationScoped
public class HelperBean {
	
	
	@EJB
	private CatalogServiceLocal catalog;
	
	
	public HelperBean() {
	}


	public Team findTeamByName(String name) {
		return catalog.findTeamByName(name);
	}


	
	
	

}
