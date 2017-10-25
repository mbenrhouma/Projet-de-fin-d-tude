package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Quitance;
import com.cynapsys.service.QuitanceService;

	@ManagedBean
	@ApplicationScoped
	public class QuitanceConverterBean {

		@ManagedProperty(value = "#{quitanceService}")
		private QuitanceService quitanceService;
         

		public QuitanceService getQuitanceService() {
			return quitanceService;
		}


		public void setQuitanceService(QuitanceService quitanceService) {
			this.quitanceService = quitanceService;
		}


		@FacesConverter(value = "quitanceConverter")
		public static class QuitanceConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Quitance quitance = new Quitance();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					QuitanceConverterBean quitanceConverterBean = (QuitanceConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{quitanceConverterBean}",
									QuitanceConverterBean.class);

					quitance = quitanceConverterBean.getQuitanceService().findById(arg2);


				}

				return quitance;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof Quitance) ? ((Quitance) arg2).getNumQuittance() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

