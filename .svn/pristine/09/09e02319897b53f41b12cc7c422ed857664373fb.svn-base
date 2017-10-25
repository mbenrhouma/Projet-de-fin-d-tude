package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Lotissement;
import com.cynapsys.service.LotissementService;

	@ManagedBean
	@ApplicationScoped
	public class LotissementConverterBean {

		@ManagedProperty(value = "#{lotissementService}")
		private LotissementService lotissementService;
         

	
		
		public LotissementService getLotissementService() {
			return lotissementService;
		}




		public void setLotissementService(LotissementService lotissementService) {
			this.lotissementService = lotissementService;
		}




		@FacesConverter(value = "lotissementConverter")
		public static class LotissementConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Lotissement lotissement = new Lotissement();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					LotissementConverterBean lotissementConverterBean = (LotissementConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{lotissementConverterBean}",
									LotissementConverterBean.class);

					lotissement = lotissementConverterBean.getLotissementService().findById(arg2);


				}

				return lotissement;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				String id = (arg2 instanceof Lotissement) ? ((Lotissement) arg2).getCode() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

