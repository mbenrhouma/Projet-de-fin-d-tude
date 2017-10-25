package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Mensualite;
import com.cynapsys.service.MensualiteService;

	@ManagedBean
	@ApplicationScoped
	public class MensualiteConverterBean {

		@ManagedProperty(value = "#{mensualiteService}")
		private MensualiteService mensualiteService;
         
	

		
		public MensualiteService getMensualiteService() {
			return mensualiteService;
		}




		public void setMensualiteService(MensualiteService mensualiteService) {
			this.mensualiteService = mensualiteService;
		}




		@FacesConverter(value = "mensualiteConverter")
		public static class MensualiteConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Mensualite mensualite = new Mensualite();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					MensualiteConverterBean mensualiteConverterBean = (MensualiteConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{mensualiteConverterBean}",
									MensualiteConverterBean.class);

					mensualite = mensualiteConverterBean.getMensualiteService().findById(arg2);


				}

				return mensualite;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Mensualite) ? ((Mensualite) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

