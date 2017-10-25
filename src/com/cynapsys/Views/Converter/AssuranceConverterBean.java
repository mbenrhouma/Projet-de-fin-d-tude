package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Assurance;
import com.cynapsys.service.AssuranceService;

	@ManagedBean
	@ApplicationScoped
	public class AssuranceConverterBean {

		@ManagedProperty(value = "#{assuranceService}")
		private AssuranceService assuranceService;
         
		
		public AssuranceService getAssuranceService() {
			return assuranceService;
		}

		public void setAssuranceService(AssuranceService assuranceService) {
			this.assuranceService = assuranceService;
		}


		@FacesConverter(value = "assuranceConverter")
		public static class AssuranceConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Assurance assurance = new Assurance();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					AssuranceConverterBean assuranceConverterBean = (AssuranceConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{assuranceConverterBean}",
									AssuranceConverterBean.class);

					assurance = assuranceConverterBean.getAssuranceService().findById(arg2);


				}

				return assurance;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Assurance) ? ((Assurance) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

