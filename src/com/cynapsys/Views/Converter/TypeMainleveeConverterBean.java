package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.TypeMainlevee;
import com.cynapsys.service.TypeMainleveeService;

	@ManagedBean
	@ApplicationScoped
	public class TypeMainleveeConverterBean {

		@ManagedProperty(value = "#{typeMainleveeService}")
		private TypeMainleveeService typeMainleveeService;
         

		public TypeMainleveeService getTypeMainleveeService() {
			return typeMainleveeService;
		}

		public void setTypeMainleveeService(TypeMainleveeService typeMainleveeService) {
			this.typeMainleveeService = typeMainleveeService;
		}




		@FacesConverter(value = "typeMainleveeConverter")
		public static class TypeMainleveeConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				TypeMainlevee typeMainlevee = new TypeMainlevee();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TypeMainleveeConverterBean typeMainleveeConverterBean = (TypeMainleveeConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{typeMainleveeConverterBean}",
									TypeMainleveeConverterBean.class);

					typeMainlevee = typeMainleveeConverterBean.getTypeMainleveeService().findById(arg2 );


				}

				return typeMainlevee;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof TypeMainlevee) ? ((TypeMainlevee) arg2).getId() : null;
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

