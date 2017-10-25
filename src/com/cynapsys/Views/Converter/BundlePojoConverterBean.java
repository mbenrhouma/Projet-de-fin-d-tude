package com.cynapsys.Views.Converter;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cynapsys.Views.EditionBean;
import com.cynapsys.pojo.BundlePojo;

@ManagedBean
@ApplicationScoped
public class BundlePojoConverterBean {



	@FacesConverter(value = "bundlePojoConverter")
	public static class BundlePojoConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
			BundlePojo bundlePojo = new BundlePojo();
			if (arg2 != null && !String.valueOf(arg2).equals("") && !arg2.contains("------------")) {
				BundlePojoConverterBean bundlePojoConverterBean = (BundlePojoConverterBean) FacesContext.getCurrentInstance()
						.getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(),
								"#{bundlePojoConverterBean}", BundlePojoConverterBean.class);
				
				
				EditionBean editionBean = ( EditionBean) FacesContext
		                .getCurrentInstance()
		                .getApplication()
		                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
		                             "#{editionBean}",
		                             EditionBean.class);
				  
				

				bundlePojo = editionBean.findBundlePojoById(arg2);

			}

			return bundlePojo;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
			String id = (arg2 instanceof BundlePojo) ? ((BundlePojo) arg2).getKey() : null;

			return (id != null) ? String.valueOf(id) : null;
		}

	}
	
	
}
