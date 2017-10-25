package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Mainlevee;
import com.cynapsys.service.MainleveeService;

	@ManagedBean
	@ApplicationScoped
	public class MainleveeConverterBean {

		@ManagedProperty(value = "#{mainleveeService}")
		private MainleveeService mainleveeService;
         

		public MainleveeService getMainleveeService() {
			return mainleveeService;
		}

		public void setMainleveeService(MainleveeService mainleveeService) {
			this.mainleveeService = mainleveeService;
		}




		@FacesConverter(value = "mainleveeConverter")
		public static class MainleveeConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Mainlevee mainlevee = new Mainlevee();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					MainleveeConverterBean mainleveeConverterBean = (MainleveeConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{mainleveeConverterBean}",
									MainleveeConverterBean.class);

					mainlevee = mainleveeConverterBean.getMainleveeService().findById(arg2 );


				}

				return mainlevee;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Mainlevee) ? ((Mainlevee) arg2).getId() : null;
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

