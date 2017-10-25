package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.TableauAmortissement;
import com.cynapsys.service.TableauAmortissementService;

	@ManagedBean
	@ApplicationScoped
	public class TableauAmortissementConverterBean {

		@ManagedProperty(value = "#{tableauAmortissementService}")
		private TableauAmortissementService tableauAmortissementService;
         

		public TableauAmortissementService getTableauAmortissementService() {
			return tableauAmortissementService;
		}

		public void setTableauAmortissementService(
				TableauAmortissementService tableauAmortissementService) {
			this.tableauAmortissementService = tableauAmortissementService;
		}



		@FacesConverter(value = "tableauAmortissementConverter")
		public static class TableauAmortissementConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				TableauAmortissement tableauAmortissement = new TableauAmortissement();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TableauAmortissementConverterBean tableauAmortissementConverterBean = (TableauAmortissementConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{tableauAmortissementConverterBean}",
									TableauAmortissementConverterBean.class);

					tableauAmortissement = tableauAmortissementConverterBean.getTableauAmortissementService().findById(arg2);


				}

				return tableauAmortissement;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof TableauAmortissement) ? ((TableauAmortissement) arg2).getId() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

