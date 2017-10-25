package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Groupe;
import com.cynapsys.service.GroupeService;

@ManagedBean
@ApplicationScoped
public class GroupeConverterBean {

	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	@FacesConverter(value = "groupeConverter")
	public static class GroupeConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Groupe groupe = new Groupe();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				GroupeConverterBean groupeConverterBean = (GroupeConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{groupeConverterBean}", GroupeConverterBean.class);

				groupe = groupeConverterBean.getGroupeService().findById(arg2);

			}

			return groupe;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			String id = (arg2 instanceof Groupe) ? ((Groupe) arg2).getCode() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
