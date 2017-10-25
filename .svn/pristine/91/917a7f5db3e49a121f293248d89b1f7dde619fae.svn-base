package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Cellule;
import com.cynapsys.service.CelluleService;

@ManagedBean
@ApplicationScoped
public class CelluleConverterBean {

	@ManagedProperty(value = "#{celluleService}")
	private CelluleService celluleService;

	public CelluleService getCelluleService() {
		return celluleService;
	}

	public void setCelluleService(CelluleService celluleService) {
		this.celluleService = celluleService;
	}

	@FacesConverter(value = "celluleConverter")
	public static class CelluleConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Cellule cellule = new Cellule();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				CelluleConverterBean celluleConverterBean = (CelluleConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{celluleConverterBean}", CelluleConverterBean.class);

				cellule = celluleConverterBean.getCelluleService().findById(arg2);

			}

			return cellule;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof Cellule) ? ((Cellule) arg2).getCode() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
