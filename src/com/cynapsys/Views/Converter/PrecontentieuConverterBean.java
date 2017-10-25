package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Precontentieu;
import com.cynapsys.service.PrecontentieuService;

	@ManagedBean
	@ApplicationScoped
	public class PrecontentieuConverterBean {

		@ManagedProperty(value = "#{precontentieuService}")
		private PrecontentieuService PrecontentieuService;
         

		public PrecontentieuService getPrecontentieuService() {
			return PrecontentieuService;
		}


		public void setPrecontentieuService(PrecontentieuService precontentieuService) {
			PrecontentieuService = precontentieuService;
		}


		
		@FacesConverter(value = "precontentieuConverter")
		public static class PrecontentieuConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Precontentieu precontentieu = new Precontentieu();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					PrecontentieuConverterBean precontentieuConverterBean = (PrecontentieuConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{precontentieuConverterBean}",
									PrecontentieuConverterBean.class);

					precontentieu = precontentieuConverterBean.getPrecontentieuService().findById(arg2);


				}

				return precontentieu;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Precontentieu) ? ((Precontentieu) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

