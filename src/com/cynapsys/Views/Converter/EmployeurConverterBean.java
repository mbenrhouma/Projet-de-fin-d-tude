package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Employeur;
import com.cynapsys.service.EmployeurService;

@ManagedBean
@ApplicationScoped
public class EmployeurConverterBean {

	@ManagedProperty(value = "#{employeurService}")
	private EmployeurService employeurService;

	

	public EmployeurService getEmployeurService() {
		return employeurService;
	}



	public void setEmployeurService(EmployeurService employeurService) {
		this.employeurService = employeurService;
	}



	@FacesConverter(value = "employeurConverter")
	public static class EmployeurConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Employeur employeur = new Employeur();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				EmployeurConverterBean employeurConverterBean = (EmployeurConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{employeurConverterBean}", EmployeurConverterBean.class);

				employeur = employeurConverterBean.getEmployeurService().findById(arg2);

			}

			return employeur;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof Employeur) ? ((Employeur) arg2).getCodeEmployeur() : null;
         return (id != null) ? String.valueOf(id) : null;
		}

	}
}
