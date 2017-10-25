package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Tracabilite;
import com.cynapsys.service.TracabiliteService;

	@ManagedBean
	@ApplicationScoped
	public class TracabiliteConverterBean {

		@ManagedProperty(value = "#{tracabiliteService}")
		private TracabiliteService tracabiliteService;
         

		public TracabiliteService getTracabiliteService() {
			return tracabiliteService;
		}

		public void setTracabiliteService(TracabiliteService tracabiliteService) {
			this.tracabiliteService = tracabiliteService;
		}



		@FacesConverter(value = "tracabiliteConverter")
		public static class TracabiliteConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Tracabilite tracabilite = new Tracabilite();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TracabiliteConverterBean tracabiliteConverterBean = (TracabiliteConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{tracabiliteConverterBean}",
									TracabiliteConverterBean.class);

					tracabilite = tracabiliteConverterBean.getTracabiliteService().findById(arg2);


				}

				return tracabilite;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Tracabilite) ? ((Tracabilite) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

