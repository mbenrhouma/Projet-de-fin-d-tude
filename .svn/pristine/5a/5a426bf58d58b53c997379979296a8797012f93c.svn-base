package com.cynapsys.Views;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.Utilisateur;

public class AbstractBean {
	
	
	public Utilisateur getUtilisateurConnecte(){
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		Utilisateur currentUtilisateur = (Utilisateur) session
				.getAttribute("connexion");
		return currentUtilisateur;
	} 

}
