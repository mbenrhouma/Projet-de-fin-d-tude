package com.cynapsys.pojo;

import java.io.Serializable;

public class SubReportClientACPOJO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codeAcquereur;
	private String nomPrenomFr;
	private String adresseLoge;
	private String codePostal;
	private String solde;
	private String groupe;
	public String getCodeAcquereur() {
		return codeAcquereur;
	}
	public void setCodeAcquereur(String codeAcquereur) {
		this.codeAcquereur = codeAcquereur;
	}
	public String getNomPrenomFr() {
		return nomPrenomFr;
	}
	public void setNomPrenomFr(String nomPrenomFr) {
		this.nomPrenomFr = nomPrenomFr;
	}
	public String getAdresseLoge() {
		return adresseLoge;
	}
	public void setAdresseLoge(String adresseLoge) {
		this.adresseLoge = adresseLoge;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getSolde() {
		return solde;
	}
	public void setSolde(String solde) {
		this.solde = solde;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	
	

}
