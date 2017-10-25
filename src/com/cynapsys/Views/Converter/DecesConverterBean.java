package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.entities.Deces;
import com.cynapsys.service.DecesService;

@ManagedBean
@ApplicationScoped
public class DecesConverterBean {

	@ManagedProperty(value = "#{decesService}")
	private DecesService decesService;

	public DecesService getDecesService() {
		return decesService;
	}

	public void setDecesService(DecesService decesService) {
		this.decesService = decesService;
	}

	@FacesConverter(value = "decesConverter")
	public static class DecesConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			Deces deces = new Deces();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				DecesConverterBean decesConverterBean = (DecesConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{decesConverterBean}", DecesConverterBean.class);

				deces = decesConverterBean.getDecesService().findById(arg2);

			}

			return deces;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			Integer id = (arg2 instanceof Deces) ? ((Deces) arg2).getCodeDeces() : null;

			return (id != null) ? String.valueOf(id) : null;
		}
	}
	
	@FacesConverter("myDateTimeConverter")
	public static class MyDateTimeConverter extends DateTimeConverter {

	    public MyDateTimeConverter() {
	        setPattern("dd/MM/yyyy");
	    }

	    @Override
	    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	        if (value != null && value.length() != getPattern().length()) {
	            throw new ConverterException("Invalid format");
	        }

	        return super.getAsObject(context, component, value);
	    }

	}
}
