package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.AncienneQuittance;
import com.cynapsys.service.AncienneQuittanceService;

	@ManagedBean
	@ApplicationScoped
	public class AncienneQuittanceConverterBean {

		@ManagedProperty(value = "#{ancienneQuittanceService}")
		private AncienneQuittanceService ancienneQuittanceService;
         

		public AncienneQuittanceService getAncienneQuittanceService() {
			return ancienneQuittanceService;
		}


		public void setAncienneQuittanceService(AncienneQuittanceService ancienneQuittanceService) {
			this.ancienneQuittanceService = ancienneQuittanceService;
		}


		@FacesConverter(value = "ancienneQuittanceConverter")
		public static class AncienneQuittanceConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				AncienneQuittance ancienneQuittance = new AncienneQuittance();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					AncienneQuittanceConverterBean ancienneQuittanceConverterBean = (AncienneQuittanceConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{ancienneQuittanceConverterBean}",
									AncienneQuittanceConverterBean.class);

					ancienneQuittance = ancienneQuittanceConverterBean.getAncienneQuittanceService().findById(arg2);


				}

				return ancienneQuittance;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof AncienneQuittance) ? ((AncienneQuittance) arg2).getNumQuittance() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

