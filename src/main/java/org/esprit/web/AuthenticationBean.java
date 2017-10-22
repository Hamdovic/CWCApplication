package org.esprit.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.esprit.domain.Developper;
import org.esprit.business.*;

@ManagedBean(name="authbean") // gerrer par la faces servlet
@SessionScoped // ce bean reste en dispo tant la session est active
public class AuthenticationBean implements Serializable {
    @EJB
	private AuthenticationServiceLocal authenticationServiceLocal;
    private Developper developper = new Developper();
	private static final long serialVersionUID = 6710404278650523921L;
     public static Developper Dev;

		
		
		public AuthenticationBean() {
			
		}
		public String login(){
			String navigateTo = null;
	Developper found = authenticationServiceLocal.authenticate(developper.getDevelopper_login(),developper.getDevelopper_password());
			if (found != null){
				developper = found;
				Dev=developper;
				navigateTo = "/index";
			}else{
				navigateTo = "/pages/login";	
			}
			return navigateTo;
			
		}
		public Developper getDevelopper() {
			return developper;
		}
		public void setDevelopper(Developper developper) {
			this.developper = developper;
		}
		public AuthenticationServiceLocal getAuthenticationServiceLocal() {
			return authenticationServiceLocal;
		}
		public void setAuthenticationServiceLocal(
				AuthenticationServiceLocal authenticationServiceLocal) {
			this.authenticationServiceLocal = authenticationServiceLocal;
		}
		
		

		
		

}
