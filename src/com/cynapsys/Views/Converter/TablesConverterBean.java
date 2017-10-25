package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Tables;
import com.cynapsys.service.TablesService;

	@ManagedBean
	@ApplicationScoped
	public class TablesConverterBean {

		@ManagedProperty(value = "#{tablesService}")
		private TablesService tablesService;
	
		public TablesService getTablesService() {
			return tablesService;
		}

		public void setTablesService(TablesService tablesService) {
			this.tablesService = tablesService;
		}


		@FacesConverter(value = "tablesConverter")
		public static class TablesConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Tables tables = new Tables();
				
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					TablesConverterBean tablesConverterBean = (TablesConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{tablesConverterBean}",
									TablesConverterBean.class);

					tables = tablesConverterBean.getTablesService().findById(arg2);


				}

				return tables;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof Tables) ? ((Tables) arg2).getCode() : null;
				return (id != null) ? String.valueOf(id) : null;
			}
		}
	}

