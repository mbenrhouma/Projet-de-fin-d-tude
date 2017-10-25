package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Contentieux;
import com.cynapsys.service.ContentieuxService;

@ManagedBean
@ApplicationScoped
public class ContentieuxConverterBean {

	@ManagedProperty(value = "#{contentieuxService}")
	private ContentieuxService contentieuxService;

	public ContentieuxService getContentieuxService() {
		return contentieuxService;
	}

	public void setContentieuxService(ContentieuxService contentieuxService) {
		this.contentieuxService = contentieuxService;
	}

	@FacesConverter(value = "contentieuxConverter")
	public static class ContentieuxConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Contentieux contentieux = new Contentieux();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				ContentieuxConverterBean contentieuxConverterBean = (ContentieuxConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{contentieuxConverterBean}", ContentieuxConverterBean.class);

				contentieux = contentieuxConverterBean.getContentieuxService().findById(arg2);

			}

			return contentieux;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			String id = (arg2 instanceof Contentieux) ? ((Contentieux) arg2).getNumDossier() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
}
