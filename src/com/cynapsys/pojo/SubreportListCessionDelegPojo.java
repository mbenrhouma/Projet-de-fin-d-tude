package com.cynapsys.pojo;

import java.io.Serializable;

public class SubreportListCessionDelegPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String codeAcquereur;
	private String nomPrenomFr;
	private String groupe;
	private Integer montantGlob;
	private String mensualites;
	private String echeances;
	private Integer nbLignes;
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
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public Integer getMontantGlob() {
		return montantGlob;
	}
	public void setMontantGlob(Integer montantGlob) {
		this.montantGlob = montantGlob;
	}
	public String getMensualites() {
		return mensualites;
	}
	public void setMensualites(String mensualites) {
		this.mensualites = mensualites;
	}
	public String getEcheances() {
		return echeances;
	}
	public void setEcheances(String echeances) {
		this.echeances = echeances;
	}
	public Integer getNbLignes() {
		return nbLignes;
	}
	public void setNbLignes(Integer nbLignes) {
		this.nbLignes = nbLignes;
	}
	
	
}
