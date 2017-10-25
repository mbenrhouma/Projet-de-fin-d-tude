package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.GroupeUtilisateur;
import com.cynapsys.service.GroupeUtilisateurService;

@ManagedBean
@ApplicationScoped
public class GroupeUtilisateurConverterBean {

	@ManagedProperty(value = "#{groupeUtilisateurService}")
	private GroupeUtilisateurService groupeUtilisateurService;

	public GroupeUtilisateurService getGroupeUtilisateurService() {
		return groupeUtilisateurService;
	}

	public void setGroupeUtilisateurService(GroupeUtilisateurService groupeUtilisateurService) {
		this.groupeUtilisateurService = groupeUtilisateurService;
	}

	@FacesConverter(value = "groupeUtilisateurConverter")
	public static class GroupeUtilisateurConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			GroupeUtilisateur groupeUtilisateur = new GroupeUtilisateur();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				GroupeUtilisateurConverterBean groupeUtilisateurConverterBean = (GroupeUtilisateurConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{groupeUtilisateurConverterBean}", GroupeUtilisateurConverterBean.class);

				groupeUtilisateur = groupeUtilisateurConverterBean.getGroupeUtilisateurService().findById(arg2);

			}

			return groupeUtilisateur;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof GroupeUtilisateur) ? ((GroupeUtilisateur) arg2).getCode() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
