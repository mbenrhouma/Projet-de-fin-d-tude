package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Arrangement;
import com.cynapsys.service.ArrangementService;

	@ManagedBean
	@ApplicationScoped
	public class ArrangementConverterBean {

		@ManagedProperty(value = "#{arrangementService}")
		private ArrangementService arrangementService;
		
		public ArrangementService getArrangementService() {
			return arrangementService;
		}

		public void setArrangementService(ArrangementService arrangementService) {
			this.arrangementService = arrangementService;
		}




		@FacesConverter(value = "arrangementConverter")
		public static class ArrangementConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Arrangement arrangement = new Arrangement();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					ArrangementConverterBean arrangementConverterBean = (ArrangementConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{arrangementConverterBean}",
									ArrangementConverterBean.class);
					arrangement = arrangementConverterBean.getArrangementService().findById(arg2);
				}

				return arrangement;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Arrangement) ? ((Arrangement) arg2).getId() : null;
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

