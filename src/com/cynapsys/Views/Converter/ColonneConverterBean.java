package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Colonne;
import com.cynapsys.service.ColonneService;

@ManagedBean
@ApplicationScoped
public class ColonneConverterBean {

	@ManagedProperty(value = "#{colonneService}")
	private ColonneService colonneService;

	public ColonneService getColonneService() {
		return colonneService;
	}

	public void setColonneService(ColonneService colonneService) {
		this.colonneService = colonneService;
	}

	@FacesConverter(value = "colonneConverter")
	public static class ColonneConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Colonne colonne = new Colonne();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				ColonneConverterBean colonneConverterBean = (ColonneConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{colonneConverterBean}", ColonneConverterBean.class);

				colonne = colonneConverterBean.getColonneService().findById(arg2);

			}

			return colonne;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			String id = (arg2 instanceof Colonne) ? ((Colonne) arg2).getCode() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
