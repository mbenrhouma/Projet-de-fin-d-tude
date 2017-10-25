package com.cynapsys.Views.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.FoncGroupUser;
import com.cynapsys.entities.Fonctionnalite;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.GroupeUtilisateur;
import com.cynapsys.entities.Utilisateur;

@ManagedBean(name = "profileBean")
@SessionScoped
public class ProfilBean {

	private Utilisateur currentUtilisateur;
	private List<FoncGroupUser> fonctionnalites = new ArrayList<FoncGroupUser>();
	private HashMap<String, Integer> currentProfile;

	private int GESTION_BIENS = 0;
	private int GESTION_IMMEUBLES = 0;
	private int GESTION_BLOC = 0;
	private int GESTION_LOCAUX = 0;
	private int GESTION_LOCATAIRES = 0;
	private int GESTION_CONTRATS = 0;
	private int GESTION_CONVENTION = 0;
	private int GESTION_ADJUDICATION = 0;
	private int GESTION_CAHIER_CHARGE = 0;
	private int GESTION_QUITTANCE = 0;
	private int SUIVI_PAIEMENT = 0;
	private int GESTION_RECETTTES = 0;
	private int MAINTENANCE_LOCAUX = 0;
	private int RECLAMATIONS = 0;
	private int GESTION_TIERS = 0;
	private int GESTION_REPARTITIONS = 0;
	private int REGLEMENT_TIERS = 0;
	private int REPARTITION_CHARGES = 0;
	private int STATISTIQUES = 0;
	private int STATISTIQUES_SNIT = 0;
	private int STATISTIQUES_MINISTERE = 0;
	private int ADMINISTRATION = 0;
	private int GESTION_UTILISATEUR = 0;
	private int GESTION_PROFIL = 0;
	private int PARAMETRAGE = 0;

	public ProfilBean() {

	}

	@PostConstruct
	public void initialisation() {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		currentUtilisateur = (Utilisateur) session.getAttribute("connexion");
		if (currentUtilisateur != null) {
			GroupeUtilisateur groupeUser = currentUtilisateur.getGroupeUtilisateur();
			this.fonctionnalites = groupeUser.getFoncGroupUserList();
		}

		System.out.println("----------------------");
		currentProfile = new HashMap<String, Integer>();
		try {
			Class taClasse = Class
					.forName("com.cynapsys.Views.controller.FonctionnaliteUtil");
			Field[] fields = taClasse.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				currentProfile.put(fields[i].getName(), 0);
			}
			Iterator i = currentProfile.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				if (checkRole(me.getKey().toString())) {
					currentProfile.put(me.getKey().toString(), 1);
				}
			}

			GESTION_BIENS = currentProfile.get("GESTION_BIENS");
			GESTION_IMMEUBLES = currentProfile.get("GESTION_IMMEUBLES");
			GESTION_BLOC = currentProfile.get("GESTION_BLOC");
			GESTION_LOCAUX = currentProfile.get("GESTION_LOCAUX");
			GESTION_LOCATAIRES = currentProfile.get("GESTION_LOCATAIRES");
			GESTION_CONTRATS = currentProfile.get("GESTION_CONTRATS");
			GESTION_CONVENTION = currentProfile.get("GESTION_CONVENTION");
			GESTION_ADJUDICATION = currentProfile.get("GESTION_ADJUDICATION");
			GESTION_CAHIER_CHARGE = currentProfile.get("GESTION_CAHIER_CHARGE");
			GESTION_QUITTANCE = currentProfile.get("GESTION_QUITTANCE");
			SUIVI_PAIEMENT = currentProfile.get("SUIVI_PAIEMENT");
			GESTION_RECETTTES = currentProfile.get("GESTION_RECETTTES");
			MAINTENANCE_LOCAUX = currentProfile.get("MAINTENANCE_LOCAUX");
			RECLAMATIONS = currentProfile.get("RECLAMATIONS");
			GESTION_TIERS = currentProfile.get("GESTION_TIERS");
			GESTION_REPARTITIONS = currentProfile.get("GESTION_REPARTITIONS");
			REPARTITION_CHARGES = currentProfile.get("REPARTITION_CHARGES");
			REGLEMENT_TIERS = currentProfile.get("REGLEMENT_TIERS");

			STATISTIQUES_SNIT = currentProfile.get("STATISTIQUES_SNIT");
			STATISTIQUES_MINISTERE = currentProfile
					.get("STATISTIQUES_MINISTERE");

			ADMINISTRATION = currentProfile.get("ADMINISTRATION");
			GESTION_UTILISATEUR = currentProfile.get("GESTION_UTILISATEUR");
			GESTION_PROFIL = currentProfile.get("GESTION_GROUPE");
			PARAMETRAGE = currentProfile.get("PARAMETRAGE");

			if (GESTION_IMMEUBLES == 1 || GESTION_BLOC == 1
					|| GESTION_LOCAUX == 1 || GESTION_LOCATAIRES == 1
					|| GESTION_CONTRATS == 1 || GESTION_CONVENTION == 1
					|| GESTION_ADJUDICATION == 1 || GESTION_CAHIER_CHARGE == 1
					|| GESTION_QUITTANCE == 1 || SUIVI_PAIEMENT == 1
					|| GESTION_RECETTTES == 1) {
				GESTION_BIENS = 1;
			} else {
				GESTION_BIENS = 0;
			}

			if (RECLAMATIONS == 1 || GESTION_TIERS == 1
					|| GESTION_REPARTITIONS == 1 || GESTION_TIERS == 1
					|| REPARTITION_CHARGES == 1) {
				MAINTENANCE_LOCAUX = 1;
			} else {
				MAINTENANCE_LOCAUX = 0;
			}

			if (STATISTIQUES_MINISTERE == 1 || STATISTIQUES_SNIT == 1) {
				STATISTIQUES = 1;
			} else {
				STATISTIQUES = 0;
			}

			if (GESTION_UTILISATEUR == 1 || GESTION_PROFIL == 1
					|| PARAMETRAGE == 1) {
				ADMINISTRATION = 1;
			} else {
				ADMINISTRATION = 0;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean checkRole(String role) {
		boolean existe = false;
		for (int i = 0; i < fonctionnalites.size(); i++) {
			if (fonctionnalites.get(i).getFonctionnalite().equals(role)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	public Utilisateur getCurrentUtilisateur() {
		return currentUtilisateur;
	}

	public void setCurrentUtilisateur(Utilisateur currentUtilisateur) {
		this.currentUtilisateur = currentUtilisateur;
	}


	public List<FoncGroupUser> getFonctionnalites() {
		return fonctionnalites;
	}

	public void setFonctionnalites(List<FoncGroupUser> fonctionnalites) {
		this.fonctionnalites = fonctionnalites;
	}

	public HashMap<String, Integer> getCurrentProfile() {
		return currentProfile;
	}

	public void setCurrentProfile(HashMap<String, Integer> currentProfile) {
		this.currentProfile = currentProfile;
	}

	public int getGESTION_BIENS() {
		return GESTION_BIENS;
	}

	public void setGESTION_BIENS(int gESTION_BIENS) {
		GESTION_BIENS = gESTION_BIENS;
	}

	public int getGESTION_IMMEUBLES() {
		return GESTION_IMMEUBLES;
	}

	public void setGESTION_IMMEUBLES(int gESTION_IMMEUBLES) {
		GESTION_IMMEUBLES = gESTION_IMMEUBLES;
	}

	public int getGESTION_BLOC() {
		return GESTION_BLOC;
	}

	public void setGESTION_BLOC(int gESTION_BLOC) {
		GESTION_BLOC = gESTION_BLOC;
	}

	public int getGESTION_LOCAUX() {
		return GESTION_LOCAUX;
	}

	public void setGESTION_LOCAUX(int gESTION_LOCAUX) {
		GESTION_LOCAUX = gESTION_LOCAUX;
	}

	public int getGESTION_LOCATAIRES() {
		return GESTION_LOCATAIRES;
	}

	public void setGESTION_LOCATAIRES(int gESTION_LOCATAIRES) {
		GESTION_LOCATAIRES = gESTION_LOCATAIRES;
	}

	public int getGESTION_CONTRATS() {
		return GESTION_CONTRATS;
	}

	public void setGESTION_CONTRATS(int gESTION_CONTRATS) {
		GESTION_CONTRATS = gESTION_CONTRATS;
	}

	public int getGESTION_CONVENTION() {
		return GESTION_CONVENTION;
	}

	public void setGESTION_CONVENTION(int gESTION_CONVENTION) {
		GESTION_CONVENTION = gESTION_CONVENTION;
	}

	public int getGESTION_ADJUDICATION() {
		return GESTION_ADJUDICATION;
	}

	public void setGESTION_ADJUDICATION(int gESTION_ADJUDICATION) {
		GESTION_ADJUDICATION = gESTION_ADJUDICATION;
	}

	public int getGESTION_CAHIER_CHARGE() {
		return GESTION_CAHIER_CHARGE;
	}

	public void setGESTION_CAHIER_CHARGE(int gESTION_CAHIER_CHARGE) {
		GESTION_CAHIER_CHARGE = gESTION_CAHIER_CHARGE;
	}

	public int getGESTION_QUITTANCE() {
		return GESTION_QUITTANCE;
	}

	public void setGESTION_QUITTANCE(int gESTION_QUITTANCE) {
		GESTION_QUITTANCE = gESTION_QUITTANCE;
	}

	public int getSUIVI_PAIEMENT() {
		return SUIVI_PAIEMENT;
	}

	public void setSUIVI_PAIEMENT(int sUIVI_PAIEMENT) {
		SUIVI_PAIEMENT = sUIVI_PAIEMENT;
	}

	public int getGESTION_RECETTTES() {
		return GESTION_RECETTTES;
	}

	public void setGESTION_RECETTTES(int gESTION_RECETTTES) {
		GESTION_RECETTTES = gESTION_RECETTTES;
	}

	public int getMAINTENANCE_LOCAUX() {
		return MAINTENANCE_LOCAUX;
	}

	public void setMAINTENANCE_LOCAUX(int mAINTENANCE_LOCAUX) {
		MAINTENANCE_LOCAUX = mAINTENANCE_LOCAUX;
	}

	public int getRECLAMATIONS() {
		return RECLAMATIONS;
	}

	public void setRECLAMATIONS(int rECLAMATIONS) {
		RECLAMATIONS = rECLAMATIONS;
	}

	public int getGESTION_TIERS() {
		return GESTION_TIERS;
	}

	public void setGESTION_TIERS(int gESTION_TIERS) {
		GESTION_TIERS = gESTION_TIERS;
	}

	public int getGESTION_REPARTITIONS() {
		return GESTION_REPARTITIONS;
	}

	public void setGESTION_REPARTITIONS(int gESTION_REPARTITIONS) {
		GESTION_REPARTITIONS = gESTION_REPARTITIONS;
	}

	public int getREGLEMENT_TIERS() {
		return REGLEMENT_TIERS;
	}

	public void setREGLEMENT_TIERS(int rEGLEMENT_TIERS) {
		REGLEMENT_TIERS = rEGLEMENT_TIERS;
	}

	public int getREPARTITION_CHARGES() {
		return REPARTITION_CHARGES;
	}

	public void setREPARTITION_CHARGES(int rEPARTITION_CHARGES) {
		REPARTITION_CHARGES = rEPARTITION_CHARGES;
	}

	public int getSTATISTIQUES() {
		return STATISTIQUES;
	}

	public void setSTATISTIQUES(int sTATISTIQUES) {
		STATISTIQUES = sTATISTIQUES;
	}

	public int getSTATISTIQUES_SNIT() {
		return STATISTIQUES_SNIT;
	}

	public void setSTATISTIQUES_SNIT(int sTATISTIQUES_SNIT) {
		STATISTIQUES_SNIT = sTATISTIQUES_SNIT;
	}

	public int getSTATISTIQUES_MINISTERE() {
		return STATISTIQUES_MINISTERE;
	}

	public void setSTATISTIQUES_MINISTERE(int sTATISTIQUES_MINISTERE) {
		STATISTIQUES_MINISTERE = sTATISTIQUES_MINISTERE;
	}

	public int getADMINISTRATION() {
		return ADMINISTRATION;
	}

	public void setADMINISTRATION(int aDMINISTRATION) {
		ADMINISTRATION = aDMINISTRATION;
	}

	public int getGESTION_UTILISATEUR() {
		return GESTION_UTILISATEUR;
	}

	public void setGESTION_UTILISATEUR(int gESTION_UTILISATEUR) {
		GESTION_UTILISATEUR = gESTION_UTILISATEUR;
	}

	public int getGESTION_PROFIL() {
		return GESTION_PROFIL;
	}

	public void setGESTION_PROFIL(int gESTION_PROFIL) {
		GESTION_PROFIL = gESTION_PROFIL;
	}

	public int getPARAMETRAGE() {
		return PARAMETRAGE;
	}

	public void setPARAMETRAGE(int pARAMETRAGE) {
		PARAMETRAGE = pARAMETRAGE;
	}

}
