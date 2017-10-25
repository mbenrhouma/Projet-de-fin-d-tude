package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Logement;
import com.cynapsys.service.LogementService;

	@ManagedBean
	@ApplicationScoped
	public class LogementConverterBean {

		@ManagedProperty(value = "#{logementService}")
		private LogementService logementService;
         

	
		
		public LogementService getLogementService() {
			return logementService;
		}




		public void setLogementService(LogementService logementService) {
			this.logementService = logementService;
		}




		@FacesConverter(value = "logementConverter")
		public static class LogementConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Logement logement = new Logement();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					LogementConverterBean logementConverterBean = (LogementConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{logementConverterBean}",
									LogementConverterBean.class);

					logement = logementConverterBean.getLogementService().findById(arg2);


				}

				return logement;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof Logement) ? ((Logement) arg2).getCodeLogement() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

