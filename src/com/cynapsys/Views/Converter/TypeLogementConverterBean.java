package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.TypeLogement;
import com.cynapsys.service.TypeLogementService;

	@ManagedBean
	@ApplicationScoped
	public class TypeLogementConverterBean {

		@ManagedProperty(value = "#{typeLogementService}")
		private TypeLogementService typeLogementService;
         
		public TypeLogementService getTypeLogementService() {
			return typeLogementService;
		}

		public void setTypeLogementService(TypeLogementService typeLogementService) {
			this.typeLogementService = typeLogementService;
		}


		@FacesConverter(value = "typeLogementConverter")
		public static class TypeLogementConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				TypeLogement typeLogement = new TypeLogement();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TypeLogementConverterBean typeLogementConverterBean = (TypeLogementConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{typeLogementConverterBean}",
									TypeLogementConverterBean.class);

					typeLogement = typeLogementConverterBean.getTypeLogementService().findById(arg2);


				}

				return typeLogement;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof TypeLogement) ? ((TypeLogement) arg2).getCodeType(): null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

