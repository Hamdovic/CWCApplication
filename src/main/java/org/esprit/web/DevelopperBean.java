package org.esprit.web;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.esprit.business.DevelopperServiceLocal;
import org.esprit.domain.Developper;



@ViewScoped
@ManagedBean
public class DevelopperBean{
	
	
	/**
	 * 
	 */
	
	@EJB
	private DevelopperServiceLocal developperServiceLocal;
	public List<Developper> developpers ;
	private Developper developer =new Developper();

	public DevelopperBean() {
	}
	
	@PostConstruct
	public void Init() {
		developpers = developperServiceLocal.findAllDeveloppers();
		//developer = developperServiceLocal.findDevelopperById(9);
		
		for (Developper developper : developpers) {
			System.out.println("develop : "+developper.getDevelopper_firstname());
		}
		
	
	}

	public List<Developper> getDeveloppers() {
		return developpers;
	}

	public void setDeveloppers(List<Developper> developpers) {
		this.developpers = developpers;
	}
	
	public String doSaveOrUpdate(){
		String navigateTo=null;
		developperServiceLocal.saveOrUpdateProduct(developer);
		
	return navigateTo;
	
}

	public Developper getDeveloper() {
		
		return developer;
	}

	public void setDeveloper(Developper developer) {
		this.developer = developer;
	} 

}
