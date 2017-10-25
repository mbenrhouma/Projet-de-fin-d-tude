package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Fonctionnalite;
import com.cynapsys.service.FonctionnaliteService;

@ManagedBean
@ApplicationScoped
public class FonctionnaliteConverterBean {

	@ManagedProperty(value = "#{fonctionnaliteService}")
	private FonctionnaliteService fonctionnaliteService;

	

	public FonctionnaliteService getFonctionnaliteService() {
		return fonctionnaliteService;
	}



	public void setFonctionnaliteService(FonctionnaliteService fonctionnaliteService) {
		this.fonctionnaliteService = fonctionnaliteService;
	}



	@FacesConverter(value = "fonctionnaliteConverter")
	public static class FonctionnaliteConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Fonctionnalite fonctionnalite = new Fonctionnalite();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				FonctionnaliteConverterBean fonctionnaliteConverterBean = (FonctionnaliteConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{fonctionnaliteConverterBean}", FonctionnaliteConverterBean.class);

				fonctionnalite = fonctionnaliteConverterBean.getFonctionnaliteService().findById(arg2);

			}

			return fonctionnalite;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof Fonctionnalite) ? ((Fonctionnalite) arg2).getId() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
