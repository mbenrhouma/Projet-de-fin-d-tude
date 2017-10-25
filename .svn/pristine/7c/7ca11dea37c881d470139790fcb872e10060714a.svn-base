package com.cynapsys.Views.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cynapsys.Views.ClientLocataireBean;

@ManagedBean(name = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{clientLocataireBean}")
	private ClientLocataireBean clientLocataireBean;
	private Locale locale;
	private HttpSession session;
	private String languageAffich;
	private Integer testFr = 1;

	public LanguageBean() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		session = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("locale", context.getViewRoot().getLocale());
	}

	@PostConstruct
	public void initialisation() {
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		session.setAttribute("locale", locale);

	}

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		locale = new Locale(language);
		session.setAttribute("locale", locale);
	}

	public void reload() {
		try {
			testFr = 1;
			languageAffich = "LTR";
			FacesContext.getCurrentInstance().getExternalContext().redirect("");
			if (locale.getLanguage() == "fr") {
				languageAffich = "LTR";
				clientLocataireBean.setEtatClienLocataireFRAR();
				testFr = 1;
			} else {
				languageAffich = "RTL";
				clientLocataireBean.setEtatClienLocataireFRAR();
				testFr = 0;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getLanguageAffich() {
		return languageAffich;
	}

	public void setLanguageAffich(String languageAffich) {
		this.languageAffich = languageAffich;
	}

	public ClientLocataireBean getClientLocataireBean() {
		return clientLocataireBean;
	}

	public void setClientLocataireBean(ClientLocataireBean clientLocataireBean) {
		this.clientLocataireBean = clientLocataireBean;
	}

	public Integer getTestFr() {
		return testFr;
	}

	public void setTestFr(Integer testFr) {
		this.testFr = testFr;
	}

}
