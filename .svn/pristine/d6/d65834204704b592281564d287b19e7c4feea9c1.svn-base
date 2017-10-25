package com.cynapsys.Views.Converter;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Mouvement;
import com.cynapsys.service.MouvementService;

	@ManagedBean
	@ApplicationScoped
	public class MouvementConverterBean {

		@ManagedProperty(value = "#{mouvementService}")
		private MouvementService mouvementService;
         

		public MouvementService getMouvementService() {
			return mouvementService;
		}


		public void setMouvementService(MouvementService mouvementService) {
			this.mouvementService = mouvementService;
		}




		@FacesConverter(value = "mouvementConverter")
		public static class mouvementConverter implements Converter {

			@Override
			public Object getAsObject(FacesContext arg0, UIComponent arg1,
					String arg2) {
				Mouvement mouvement = new Mouvement();
				if (arg2 != null && !String.valueOf(arg2).equals("")&& !arg2.contains("------------")) {
					MouvementConverterBean mouvementConverterBean = (MouvementConverterBean) FacesContext
							.getCurrentInstance()
							.getApplication()
							.evaluateExpressionGet(
									FacesContext.getCurrentInstance(),
									"#{mouvementConverterBean}",
									MouvementConverterBean.class);
					mouvement = mouvementConverterBean.getMouvementService().findById(arg2);


				}

				return mouvement;
			}

			@Override
			public String getAsString(FacesContext arg0, UIComponent arg1,
					Object arg2) {
				Integer id = (arg2 instanceof Mouvement) ? ((Mouvement) arg2).getIdMv() : null;
				
				return (id != null) ? String.valueOf(id) : null;
			}

		}
	}

