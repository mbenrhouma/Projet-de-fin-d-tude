package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.CompteAttente;
import com.cynapsys.service.CompteAttenteService;

@ManagedBean
@ApplicationScoped
public class CompteAttenteConverterBean {

	@ManagedProperty(value = "#{compteAttenteService}")
	private CompteAttenteService compteAttenteService;

	

	@FacesConverter(value = "compteAttenteConverter")
	public static class CompteAttenteConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			CompteAttente compteAttente = new CompteAttente();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				CompteAttenteConverterBean compteAttenteConverterBean = (CompteAttenteConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{compteAttenteConverterBean}", CompteAttenteConverterBean.class);

				compteAttente = compteAttenteConverterBean.getCompteAttenteService().findById(arg2);

			}

			return compteAttente;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			String id = (arg2 instanceof CompteAttente) ? ((CompteAttente) arg2).getNumCompte() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}



	public CompteAttenteService getCompteAttenteService() {
		return compteAttenteService;
	}



	public void setCompteAttenteService(CompteAttenteService compteAttenteService) {
		this.compteAttenteService = compteAttenteService;
	}
	
}
