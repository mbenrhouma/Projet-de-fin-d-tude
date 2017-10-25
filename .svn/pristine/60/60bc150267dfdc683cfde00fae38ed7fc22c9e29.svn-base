package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.HuissiersNotaires;
import com.cynapsys.service.HuissiersNotairesService;

@ManagedBean
@ApplicationScoped
public class HuissiersNotairesConverterBean {

	@ManagedProperty(value = "#{huissiersNotairesService}")
	private HuissiersNotairesService huissiersNotairesService;

	public HuissiersNotairesService getHuissiersNotairesService() {
		return huissiersNotairesService;
	}

	public void setHuissiersNotairesService(HuissiersNotairesService huissiersNotairesService) {
		this.huissiersNotairesService = huissiersNotairesService;
	}

	@FacesConverter(value = "huissiersNotairesConverter")
	public static class HuissiersNotairesConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			HuissiersNotaires huissiersNotaires = new HuissiersNotaires();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				HuissiersNotairesConverterBean huissiersNotairesConverterBean = (HuissiersNotairesConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{huissiersNotairesConverterBean}", HuissiersNotairesConverterBean.class);

				huissiersNotaires = huissiersNotairesConverterBean.getHuissiersNotairesService().findById(arg2);

			}

			return huissiersNotaires;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof HuissiersNotaires) ? ((HuissiersNotaires) arg2).getId() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
