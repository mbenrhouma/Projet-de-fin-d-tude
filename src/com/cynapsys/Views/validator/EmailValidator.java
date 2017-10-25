package com.cynapsys.Views.validator;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
			+ "(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		System.err.println("email validator");
		if (value == null) {
			System.out.println("email null");
			return;
		}
		if (value.toString().length()==0)
		{
			System.out.println("email length ="+value.toString().length());
			return ;
		}
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {
			JsfUtil.addErrorMessage(ResourceBundle.getBundle(
					Constants.bundle_general_fr).getString("message.email.validation"));
		}

	}

}
