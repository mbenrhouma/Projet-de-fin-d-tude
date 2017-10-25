package com.cynapsys.Views.Converter;
import java.math.BigDecimal;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.TypeReclamation;
import com.cynapsys.service.TypeReclamationService;

	@ManagedBean
	@ApplicationScoped
	public class TypeReclamationConverterBean {

		@ManagedProperty(value = "#{typeReclamationService}")
		private TypeReclamationService typeReclamationService;
         
		
		public TypeReclamationService getTypeReclamationService() {
			return typeReclamationService;
		}

		public void setTypeReclamationService(
				TypeReclamationService typeReclamationService) {
			this.typeReclamationService = typeReclamationService;
		}



		@FacesConverter(value = "typeReclamationConverter")
		public static class TypeReclamationConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				TypeReclamation typeReclamation = new TypeReclamation();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TypeReclamationConverterBean typeReclamationConverterBean = (TypeReclamationConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{typeReclamationConverterBean}",
									TypeReclamationConverterBean.class);

					typeReclamation = typeReclamationConverterBean.getTypeReclamationService().findById(arg2);


				}

				return typeReclamation;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
		    BigDecimal	id  = (arg2 instanceof TypeReclamation) ? ((TypeReclamation) arg2).getCode(): null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

