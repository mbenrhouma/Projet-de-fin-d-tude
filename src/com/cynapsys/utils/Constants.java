package com.cynapsys.utils;

import java.io.File;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "Constants")
@ApplicationScoped
public class Constants implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String bundle_Edition_ar="com.cynapsys.bundles.edition-resource_ar";
	public final static String bundle_Edition_fr="com.cynapsys.bundles.edition-resource_fr";
	public final static String bundle_TABSoldeclient_ar="com.cynapsys.bundles.tableauDesSoldeClients-resources_ar";
	public final static String bundle_TABSoldeclient_fr="com.cynapsys.bundles.tableauDesSoldeClients-resources_fr";
	public final static String bundle_ancienneQuittance_ar="com.cynapsys.bundles.ancienneQuittance-resources_ar";
	public final static String bundle_ancienneQuittance_fr="com.cynapsys.bundles.ancienneQuittance-resources_fr";
	public final static String bundle_apurement_fr="com.cynapsys.bundles.apurement-resources_fr";
	public final static String bundle_apurement_ar="com.cynapsys.bundles.apurement-resources_ar";
	public final static String bundle_imprimerMainlevee_ar="com.cynapsys.bundles.imprimerMainlevee-resources_ar";
	public final static String bundle_imprimerMainlevee_fr="com.cynapsys.bundles.imprimerMainlevee-resources_fr";
	public final static String bundle_decompte_fr="com.cynapsys.bundles.decompte-resources_fr";
	public final static String bundle_decompte_ar="com.cynapsys.bundles.decompte-resources_ar";
	public final static String bundle_clientLocataire_ar="com.cynapsys.bundles.clientLocataire-resources_ar";
	public final static String bundle_clientLocataire_fr="com.cynapsys.bundles.clientLocataire-resources_fr";
	public final static String bundle_logement_fr="com.cynapsys.bundles.logement-resources_fr";
	public final static String bundle_logement_ar="com.cynapsys.bundles.logement-resources_ar";
	public final static String bundle_noteDebit_ar="com.cynapsys.bundles.noteDebit-resources_ar";
	public final static String bundle_noteDebit_fr="com.cynapsys.bundles.noteDebit-resources_fr";
	public final static String bundle_parametrage_ar = "com.cynapsys.bundles.parametrage-resources_ar";
	public final static String bundle_parametrage_fr = "com.cynapsys.bundles.parametrage-resources_fr";
	public final static String bundle_general_fr = "com.cynapsys.bundles.general-resources_fr";
	public final static String bundle_general_ar = "com.cynapsys.bundles.general-resources_ar";
	public final static String bundle_smtp = "com.cynapsys.bundles.smtp-resources";
	public final static String bundle_groupe_fr = "com.cynapsys.bundles.groupe-resources_fr";
	public final static String bundle_groupe_ar = "com.cynapsys.bundles.groupe-resources_ar";
	public final static String bundle_utilisateur_fr = "com.cynapsys.bundles.utilisateur-resources_fr";
	public final static String bundle_utilisateur_ar = "com.cynapsys.bundles.utilisateur-resources_ar";

	public final static String bundle_assureur_fr = "com.cynapsys.bundles.assureur-resources_fr";
	public final static String bundle_assureur_ar = "com.cynapsys.bundles.assureur-resources_ar";
	public final static String bundle_reclamation_fr = "com.cynapsys.bundles.reclamation-resources_fr";
	public final static String bundle_reclamation_ar = "com.cynapsys.bundles.reclamation-resources_ar";
	public final static String bundle_assurance_fr = "com.cynapsys.bundles.assurance-resources_fr";
	public final static String bundle_assurance_ar = "com.cynapsys.bundles.assurance-resources_ar";
	public final static String bundle_deces_ar = "com.cynapsys.bundles.deces-resources_ar";
	public final static String bundle_deces_fr = "com.cynapsys.bundles.deces-resources_fr";



	public final static String bundle_employeur_ar = "com.cynapsys.bundles.employeur-resources_ar";
	public final static String bundle_employeur_fr = "com.cynapsys.bundles.employeur-resources_fr";
	public final static String bundle_cession_ar = "com.cynapsys.bundles.cession-resources_ar";
	public final static String bundle_cession_fr = "com.cynapsys.bundles.cession-resources_fr";

	public final static String bundle_clientAcquereur_fr = "com.cynapsys.bundles.clienAcquereur-resources_fr";
	public final static String bundle_clientAcquereur_ar = "com.cynapsys.bundles.clienAcquereur-resources_ar";
	public final static String bundle_quittance_ar = "com.cynapsys.bundles.quittance-resources_ar";
	public final static String bundle_quittance_fr = "com.cynapsys.bundles.quittance-resources_fr";
	
	public final static String bundle_tableauxAmortissement_ar = "com.cynapsys.bundles.tableauxAmortissement-resources_ar";
	public final static String bundle_tableauxAmortissement_fr = "com.cynapsys.bundles.tableauxAmortissement-resources_fr";
	
	public static String premierLoginMessage;
	public static String urlPath;
	public static String title;
	private static Constants instance;
	public static Integer clientLocataire=2;
	public static Integer clientAcquereur=1;
	public static Integer centpourCent=100;
	public static Integer nbreMoins=12;
	public static int nbrJoursDecembre = 31;

//etatClientLocataire::	
	public static short clintLocatiareSupprime=1; /*client supprimé */
	public static short clintLocatiareactive=2; /*client active */
	public static String clientSupprimeString="Client Supprimer";
	public static String clientActiveString="Client Active";
	public static String clientSupprimeS="S";
	public static String clientModifie="M";
	// decompte
	public static String oui="OUI";
	public static String non="NON";
//Etat Logement::	
public static Integer logementLibre=0;
public static Integer	logementEnLocation=1;
public static Integer logementEncourDeVente=2;
public static Integer	logementVendu=3;
//etatQuittance
public static Integer etatQuittanceNouve=1;
public static Integer etatQuittanceDeclass=2;
public static Integer etatQuittanceAnnul=3;

public static Integer enContentieux=1;
public static Integer pasEnContentieux=0;
public static Integer ayantArrangement=1;
public static Integer pasArrangement=0;

public static HttpSession session;

	
public static String codeClientLocataire="3";	
	public static Constants getInstance() {
		if (instance != null)
			return instance;
		else
			return new Constants();
	}

	public String getPremierLoginMessage() {
		if (premierLoginMessage == null)
			premierLoginMessage = ConfigUtils
					.loadPropretiesConfigValue("premier_login.message");
		return premierLoginMessage;
	}

	public static void setPremierLoginMessage(String premierLoginMessage) {
		Constants.premierLoginMessage = premierLoginMessage;
	}

	public static String getUrlPath() {
		if (urlPath == null)
			urlPath = ConfigUtils.loadPropretiesConfigValue("url_base");
		return urlPath;
	}

	public static void setUrlPath(String urlPath) {
		Constants.urlPath = urlPath;
	}

	public static String getFilesExcels() {
		String report = "";
		report = getUrlPath()
				+ ConfigUtils.loadPropretiesConfigValue("dossier_excel");
		return report;
	}

	public static String getFilesEtats() {
		String report = "";
		report = getUrlPath()
				+ ConfigUtils.loadPropretiesConfigValue("dossier_etat");
		return report;
	}

	public static void createDirectory(String outputDirectory) {
		File rep = new File(outputDirectory);
		if (!rep.exists()) {
			rep.mkdirs();
		}
	}

	public String getTitle() {
		if (title == null) {
			title = ConfigUtils.loadPropretiesConfigValue("be.version");
		}
		return title;
	}
	
	public static HttpSession getCurrentSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		session = (HttpSession) extContext.getSession(false);
		return session;
	}
}
