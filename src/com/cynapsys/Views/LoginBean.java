package com.cynapsys.Views;

import java.io.IOException;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;



import com.cynapsys.Views.controller.ConstantController;
import com.cynapsys.Views.controller.MenuController;
import com.cynapsys.entities.Utilisateur;
import com.cynapsys.mail.EnvoyerMail;
import com.cynapsys.service.UtilisateurService;
import com.cynapsys.utils.ConfigUtils;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;
import com.cynapsys.utils.RandomGen;
import com.cynapsys.utils.SHAHashing;

@SuppressWarnings("serial")
@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {
	@ManagedProperty(value = "#{utilisateurService}")
	private UtilisateurService utilisateurService;
	private String username;
	private String password;
	private Utilisateur utilisateur;
	private String currentUtilisateur ;
	public LoginBean() {
	}

	@PostConstruct
	public void initialisation() {

		username = "";
		password = "";
		utilisateur = null;
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void relog() {
		username = "";
		password = "";
		utilisateur = null;
	}

	public void login(ActionEvent actionEvent) throws NoSuchAlgorithmException {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		utilisateur = utilisateurService.findByUtilisateur(username,
				SHAHashing.hash(password));
		HttpSession session = (HttpSession) extContext.getSession(true);
		session.setAttribute("connexion", utilisateur);
		if (session.getAttribute("locale") == null)
			session.setAttribute("locale", "fr");
		if (utilisateur != null) {
			session.setAttribute(ConstantController.SESSION_CONNECTED_USER,
					utilisateur);
			if (utilisateur.isActive()) {

				if (utilisateur.getDernierLogin() == null) {
					try {
						utilisateur.setMotPasse(null);
						password = null;
						new MenuController().goToPagePremierLogin();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {

					utilisateur.setDernierLogin(new Date());
					utilisateurService.update(utilisateur);
					try {
						new MenuController().goToPageAccueil();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {

				if (session.getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
							Constants.bundle_utilisateur_fr).getString(
							"login.failed.error.user.active"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
							Constants.bundle_utilisateur_ar).getString(
							"login.failed.error.user.active"));
				}

			}

		} else if (utilisateur == null) {
			if (session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_fr).getString(
						"login.failed.error"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_ar).getString(
						"login.failed.error"));
			}
		} else {
			if (session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_fr).getString(
						"login.failed.error"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_ar).getString(
						"login.failed.error"));
			}
		}
	}

	public void confirm() throws NoSuchAlgorithmException {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
//		session.setAttribute("connexion", utilisateur);
		if (session.getAttribute("locale") == null)
			session.setAttribute("locale", "fr");
		ConfigUtils.getInstance();
		String motDePasse = ConfigUtils
				.loadPropretiesConfigValue("mot_de_passe_par_defaut");
		if (password.trim().equals(motDePasse)) {
			if (session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_fr).getString(
						"password.error.defaultValue"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_ar).getString(
						"password.error.defaultValue"));
			}

			return;
		}

		Utilisateur user = (Utilisateur) session.getAttribute("connexion");
		user.setDernierLogin(new Date());
		user.setMotPasse(SHAHashing.hash(password));
		utilisateurService.update(user);
		session.setAttribute("connexion", user);

		try {
			new MenuController().goToPageAccueil();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCurrentUtilisateur() {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		Utilisateur currentUser = (Utilisateur) session
				.getAttribute("connexion");
		if (currentUser != null)
			return currentUser.getNom();
		else
			return "";

	}

	public String getDeconnexion() {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		extContext.invalidateSession();

		try {
			new MenuController().goToPageLogin();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void changerMotDePasseOublie() throws NoSuchAlgorithmException {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		//utilisateur = utilisateurService.findByUtilisateur(username,SHAHashing.hash(password));
		HttpSession session = (HttpSession) extContext.getSession(true);
		if (session.getAttribute("locale") == null)
			session.setAttribute("locale", "fr");
		ConfigUtils.getInstance();
		String mail = ConfigUtils
				.loadPropretiesConfigValue("extention_email_par_defaut");
		//String email = username + mail;
		String email ;
		String motPass = RandomGen.generateRandomString();
		utilisateur = utilisateurService.findByLogin(username);
		System.out.println("utilisateur user name "+username);
		System.out.println(utilisateur!=null);
		if (utilisateur != null) {
			utilisateur.setMotPasse(SHAHashing.hash(motPass));
			utilisateurService.update(utilisateur);
			email = utilisateur.getEmail() ;
			boolean ok = EnvoyerMail.envoyerMailAdminGestionUser(
					email,
					ConfigUtils.getInstance().loadPropretiesConfigMailValue(
							"objet.mail.motPasse.oublie"),
					getMessageMotPasseOublie(motPass));
			if (ok) {
				if (session.getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
							Constants.bundle_utilisateur_fr).getString(
							"login.succes.mail.nouveau.password"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
							Constants.bundle_utilisateur_ar).getString(
							"login.succes.mail.nouveau.password"));
				}
			} else {
				if (session.getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(
							Constants.bundle_utilisateur_fr).getString(
							"login.error.envoie_mail"));
				else {
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(
							Constants.bundle_utilisateur_ar).getString(
							"login.error.envoie_mail"));
				}
			}
		} else {
			if (session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_fr).getString(
						"login.error.inexistant"));
			else {
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(
						Constants.bundle_utilisateur_ar).getString(
						"login.error.inexistant"));
			}
		}
	}

	private String getMessageMotPasseOublie(String motPass) {
		String message = "<div>"
				+ ConfigUtils.getInstance().loadPropretiesConfigMailValue(
						"msg.mail.part1")
				+ "  "
				+ motPass
				+ " "
				+ ConfigUtils.getInstance().loadPropretiesConfigMailValue(
						"msg.mail.part2") + "</div>";
		return message;
	}

	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public UtilisateurService getUtilisateurService() {
		return utilisateurService;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setCurrentUtilisateur(String currentUtilisateur) {
		this.currentUtilisateur = currentUtilisateur;
	}

}
