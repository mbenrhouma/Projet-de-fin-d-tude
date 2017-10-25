package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.FoncGroupUser;
import com.cynapsys.service.FoncGroupUserService;

@ManagedBean
@ApplicationScoped
public class FoncGroupUserConverterBean {

	@ManagedProperty(value = "#{FoncGroupUserService}")
	private FoncGroupUserService foncGroupUserService;

	public FoncGroupUserService getFoncGroupUserService() {
		return foncGroupUserService;
	}

	public void setFoncGroupUserService(FoncGroupUserService foncGroupUserService) {
		this.foncGroupUserService = foncGroupUserService;
	}

	@FacesConverter(value = "foncGroupUserConverter")
	public static class FoncGroupUserConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			FoncGroupUser foncGroupUser = new FoncGroupUser();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				FoncGroupUserConverterBean foncGroupUserConverterBean = (FoncGroupUserConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{foncGroupUserConverterBean}", FoncGroupUserConverterBean.class);

				foncGroupUser = foncGroupUserConverterBean.getFoncGroupUserService().findById(arg2);

			}

			return foncGroupUser;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof FoncGroupUser) ? ((FoncGroupUser) arg2).getId() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
