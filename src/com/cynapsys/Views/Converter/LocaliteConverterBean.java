package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Localite;
import com.cynapsys.service.LocaliteService;

	@ManagedBean
	@ApplicationScoped
	public class LocaliteConverterBean {

		@ManagedProperty(value = "#{localiteService}")
		private LocaliteService localiteService;
         

	
		
		public LocaliteService getLocaliteService() {
			return localiteService;
		}




		public void setLocaliteService(LocaliteService localiteService) {
			this.localiteService = localiteService;
		}




		@FacesConverter(value = "localiteConverter")
		public static class LocaliteConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Localite localite = new Localite();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					LocaliteConverterBean localiteConverterBean = (LocaliteConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{localiteConverterBean}",
									LocaliteConverterBean.class);

					localite = localiteConverterBean.getLocaliteService().findById(arg2);


				}

				return localite;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof Localite) ? ((Localite) arg2).getCode() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

