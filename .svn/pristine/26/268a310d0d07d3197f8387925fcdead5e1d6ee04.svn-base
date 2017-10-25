package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.Utilisateur;
import com.cynapsys.service.UtilisateurService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;
import com.cynapsys.utils.SHAHashing;

@ManagedBean(name = "motPasseBean")
@ViewScoped
public class MotPasseBean implements Serializable {
	@ManagedProperty(value = "#{utilisateurService}")
	private UtilisateurService utilisateurService;

	private String motDePasse;

	public MotPasseBean() {
	}

	public void UpdateMotPasseUtilisateur() {
		try {
			FacesContext cx = FacesContext.getCurrentInstance();
			ExternalContext extContext = cx.getExternalContext();
			HttpSession session = (HttpSession) extContext.getSession(true);
			Utilisateur currentUtilisateur = (Utilisateur) session
					.getAttribute("connexion");
			currentUtilisateur = utilisateurService.findById(currentUtilisateur
					.getId().intValue());
			currentUtilisateur.setMotPasse(SHAHashing.hash(motDePasse));
			utilisateurService.update(currentUtilisateur);
			session.setAttribute("connexion", currentUtilisateur);
			
			if (session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_fr).getString(
						"mot.passe.change.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_ar).getString(
						"mot.passe.change.succes"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext cx = FacesContext.getCurrentInstance();
			ExternalContext extContext = cx.getExternalContext();
			HttpSession session = (HttpSession) extContext.getSession(true);
			if (session.getAttribute("locale") == null)
				session.setAttribute("locale", "fr");
			if (session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_fr).getString(
						"mot.passe.change.error"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_ar).getString(
						"mot.passe.change.error"));
			}
		} finally {
			motDePasse = null;
		}
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}