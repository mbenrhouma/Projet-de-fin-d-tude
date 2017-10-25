package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.TypeFrais;
import com.cynapsys.service.TypeFraisService;

	@ManagedBean
	@ApplicationScoped
	public class TypeFraisConverterBean {

		@ManagedProperty(value = "#{typeFraisService}")
		private TypeFraisService typeFraisService;
         

		public TypeFraisService getTypeFraisService() {
			return typeFraisService;
		}

		public void setTypeFraisService(TypeFraisService typeFraisService) {
			this.typeFraisService = typeFraisService;
		}




		@FacesConverter(value = "typeFraisConverter")
		public static class TypeFraisConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				TypeFrais typeFrais = new TypeFrais();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TypeFraisConverterBean typeFraisConverterBean = (TypeFraisConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{typeFraisConverterBean}",
									TypeFraisConverterBean.class);

					typeFrais = typeFraisConverterBean.getTypeFraisService().findById(Integer.parseInt(arg2) );


				}

				return typeFrais;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof TypeFrais) ? ((TypeFrais) arg2).getId() : null;
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

