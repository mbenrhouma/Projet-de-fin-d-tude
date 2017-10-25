package com.cynapsys.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.Groupe;

public class ClientAcquereurRecherchPOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientAcquereurRecherchPOJO() {
		// TODO Auto-generated constructor stub
		}
	
	private Groupe groupe;
	private String codeAcquereur;
	private String cin;
	private String nomPrenomFr;
	private Integer etatTableauAmortissemet;
	private Integer contentieux;
	private Integer arrongement;
	private Boolean cessionSalaire;
	private Boolean cessEchu;
	private Boolean cessionActive;
//	archivage
	private Boolean archive;
	private Boolean archiveAnc;
	private Boolean archiveNv;
	private Employeur employeur;
	private Assureur assureur;

	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public String getCodeAcquereur() {
		return codeAcquereur;
	}
	public void setCodeAcquereur(String codeAcquereur) {
		this.codeAcquereur = codeAcquereur;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNomPrenomFr() {
		return nomPrenomFr;
	}
	public void setNomPrenomFr(String nomPrenomFr) {
		this.nomPrenomFr = nomPrenomFr;
	}
	public Integer getEtatTableauAmortissemet() {
		return etatTableauAmortissemet;
	}
	public void setEtatTableauAmortissemet(Integer etatTableauAmortissemet) {
		this.etatTableauAmortissemet = etatTableauAmortissemet;
	}
	public Integer getContentieux() {
		return contentieux;
	}
	public void setContentieux(Integer contentieux) {
		this.contentieux = contentieux;
	}
	public Integer getArrongement() {
		return arrongement;
	}
	public void setArrongement(Integer arrongement) {
		this.arrongement = arrongement;
	}
	public Boolean getCessionSalaire() {
		return cessionSalaire;
	}
	public void setCessionSalaire(Boolean cessionSalaire) {
		this.cessionSalaire = cessionSalaire;
	}
	public Boolean getCessEchu() {
		return cessEchu;
	}
	public void setCessEchu(Boolean cessEchu) {
		this.cessEchu = cessEchu;
	}
	public Boolean getCessionActive() {
		return cessionActive;
	}
	public void setCessionActive(Boolean cessionActive) {
		this.cessionActive = cessionActive;
	}
	public Employeur getEmployeur() {
		return employeur;
	}
	public void setEmployeur(Employeur employeur) {
		this.employeur = employeur;
	}
	
	
	
	public Assureur getAssureur() {
		return assureur;
	}
	public void setAssureur(Assureur assureur) {
		this.assureur = assureur;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	public Boolean getArchiveAnc() {
		return archiveAnc;
	}
	public void setArchiveAnc(Boolean archiveAnc) {
		this.archiveAnc = archiveAnc;
	}
	public Boolean getArchiveNv() {
		return archiveNv;
	}
	public void setArchiveNv(Boolean archiveNv) {
		this.archiveNv = archiveNv;
	}
	
}
