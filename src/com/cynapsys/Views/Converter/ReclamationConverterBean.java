package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Reclamation;
import com.cynapsys.service.ReclamationService;

	@ManagedBean
	@ApplicationScoped
	public class ReclamationConverterBean {

		@ManagedProperty(value = "#{reclamationService}")
		private ReclamationService reclamationService;
         
		
		public ReclamationService getReclamationService() {
			return reclamationService;
		}


		public void setReclamationService(ReclamationService reclamationService) {
			this.reclamationService = reclamationService;
		}


		@FacesConverter(value = "reclamationConverter")
		public static class ReclamationConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Reclamation reclamation = new Reclamation();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					ReclamationConverterBean reclamationConverterBean = (ReclamationConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{reclamationConverterBean}",
									ReclamationConverterBean.class);

					reclamation = reclamationConverterBean.getReclamationService().findById(arg2);


				}

				return reclamation;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Reclamation) ? ((Reclamation) arg2).getId() : null;
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	
		@FacesConverter("myDateTimeConverter")
		public static class MyDateTimeConverter extends DateTimeConverter {

		    public MyDateTimeConverter() {
		        setPattern("dd/MM/yyyy");
		    }

		    @Override
		    public Object getAsObject(FacesContext context, UIComponent component, String value) {
		        if (value != null && value.length() != getPattern().length()) {
		            throw new ConverterException("Invalid format");
		        }

		        return super.getAsObject(context, component, value);
		    }

		}
	}

