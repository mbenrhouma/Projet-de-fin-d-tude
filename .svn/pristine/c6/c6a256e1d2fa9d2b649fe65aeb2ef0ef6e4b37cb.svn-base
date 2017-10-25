package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.service.AssureurService;

	@ManagedBean
	@ApplicationScoped
	public class AssureurConverterBean {

		@ManagedProperty(value = "#{assureurService}")
		private AssureurService assureurService;
         
		
		public AssureurService getAssureurService() {
			return assureurService;
		}

		public void setAssureurService(AssureurService assureurService) {
			this.assureurService = assureurService;
		}


		@FacesConverter(value = "assureurConverter")
		public static class assureurConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Assureur assureur = new Assureur();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					AssureurConverterBean assureurConverterBean = (AssureurConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{assureurConverterBean}",
									AssureurConverterBean.class);

					assureur = assureurConverterBean.getAssureurService().findById(arg2);


				}

				return assureur;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Assureur) ? ((Assureur) arg2).getCode() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

