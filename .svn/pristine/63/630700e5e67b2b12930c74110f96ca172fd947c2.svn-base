package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.service.GouvernoratService;

	@ManagedBean
	@ApplicationScoped
	public class GouvernoratConverterBean {

		@ManagedProperty(value = "#{gouvernoratService}")
		private GouvernoratService gouvernoratService;
         
	public GouvernoratService getGouvernoratService() {
		return gouvernoratService;
	}
	public void setGouvernoratService(GouvernoratService gouvernoratService) {
		this.gouvernoratService = gouvernoratService;
	}
	
		
		@FacesConverter(value = "gouvernoratConverter")
		public static class GouvernoratConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Gouvernorat gouvernorat = new Gouvernorat();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					GouvernoratConverterBean gouvernoratConverterBean = (GouvernoratConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{gouvernoratConverterBean}",
									GouvernoratConverterBean.class);

					gouvernorat = gouvernoratConverterBean.getGouvernoratService().findById(arg2);


				}

				return gouvernorat;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Gouvernorat) ? ((Gouvernorat) arg2).getCode() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

