package converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.esprit.domain.Team;
import org.esprit.web.HelperBean;


@ManagedBean
//@FacesConverter("cc")
public class CategoryConverter implements Converter{
	
	

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Team equivalentCategory = null;
		if (!value.trim().equals("")) {
			HelperBean helperBean = context
						.getApplication()
							.evaluateExpressionGet(context, "#{helperBean}", HelperBean.class);
			equivalentCategory = helperBean.findTeamByName(value);
		}
		
		return equivalentCategory;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String equivalentString = null;
		if (value == null || value.equals("")) {
			equivalentString = "";
		}else{
			equivalentString = ((Team)value).getTeam_name();
		}
		
		return equivalentString;
	}

}
