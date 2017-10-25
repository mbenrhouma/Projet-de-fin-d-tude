package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Cession;
import com.cynapsys.service.CessionService;

@ManagedBean
@ApplicationScoped
public class CessionConverterBean {

	@ManagedProperty(value = "#{cessionService}")
	private CessionService cessionService;

	public CessionService getCessionService() {
		return cessionService;
	}

	public void setCessionService(CessionService cessionService) {
		this.cessionService = cessionService;
	}

	@FacesConverter(value = "cessionConverter")
	public static class CessionConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Cession cession = new Cession();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				CessionConverterBean cessionConverterBean = (CessionConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{cessionConverterBean}", CessionConverterBean.class);

				cession = cessionConverterBean.getCessionService().findById(arg2);

			}

			return cession;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof Cession) ? ((Cession) arg2).getId() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
