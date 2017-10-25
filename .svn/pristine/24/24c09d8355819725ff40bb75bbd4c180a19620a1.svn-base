package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Utilisateur;
import com.cynapsys.service.UtilisateurService;

	@ManagedBean
	@ApplicationScoped
	public class UtilisateurConverterBean {

		@ManagedProperty(value = "#{utilisateurService}")
		private UtilisateurService utilisateurService;
         
		public UtilisateurService getUtilisateurService() {
			return utilisateurService;
		}

		public void setUtilisateurService(UtilisateurService utilisateurService) {
			this.utilisateurService = utilisateurService;
		}



		@FacesConverter(value = "utilisateurConverter")
		public static class UtilisateurConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Utilisateur utilisateur = new Utilisateur();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					UtilisateurConverterBean utilisateurConverterBean = (UtilisateurConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{utilisateurConverterBean}",
									UtilisateurConverterBean.class);

					utilisateur = utilisateurConverterBean.getUtilisateurService().findById(Integer.valueOf(arg2));


				}
				
				return utilisateur;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Utilisateur) ? ((Utilisateur) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

