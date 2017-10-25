package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Impayee;
import com.cynapsys.service.ImpayeeService;

	@ManagedBean
	@ApplicationScoped
	public class ImpayeeConverterBean {

		@ManagedProperty(value = "#{impayeeService}")
		private ImpayeeService ImpayeetService;

		public ImpayeeService getImpayeetService() {
			return ImpayeetService;
		}

		public void setImpayeetService(ImpayeeService impayeetService) {
			ImpayeetService = impayeetService;
		}
         
	
	
	
		
		@FacesConverter(value = "impayeeConverter")
		public static class ImpayeeConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Impayee impayee = new Impayee();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					ImpayeeConverterBean impayeeConverterBean = (ImpayeeConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{impayeeConverterBean}",
									ImpayeeConverterBean.class);

					impayee = impayeeConverterBean.getImpayeetService().findById(arg2);


				}

				return impayee;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Impayee) ? ((Impayee) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

