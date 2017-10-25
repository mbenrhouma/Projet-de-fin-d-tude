package com.cynapsys.pojo;

import java.io.Serializable;
import java.util.Date;

public class FinancierePojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer prix;
	Integer avancePrix;
	Integer prixProv;
	Integer solde;
	String assure;
	Double interetRetard;
	Double interetAprEch;
	Date dateDeb;
	Date dateFin;
	
	//getter & setter
	
	

	public Date getDateFin() {
		return dateFin;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	public Integer getAvancePrix() {
		return avancePrix;
	}
	public void setAvancePrix(Integer avancePrix) {
		this.avancePrix = avancePrix;
	}
	public Integer getPrixProv() {
		return prixProv;
	}
	public void setPrixProv(Integer prixProv) {
		this.prixProv = prixProv;
	}
	public Integer getSolde() {
		return solde;
	}
	public void setSolde(Integer solde) {
		this.solde = solde;
	}
	public String getAssure() {
		return assure;
	}
	public void setAssure(String assure) {
		this.assure = assure;
	}

	public Double getInteretRetard() {
		return interetRetard;
	}
	public void setInteretRetard(Double interetRetard) {
		this.interetRetard = interetRetard;
	}
	public Double getInteretAprEch() {
		return interetAprEch;
	}
	public void setInteretAprEch(Double interetAprEch) {
		this.interetAprEch = interetAprEch;
	}
	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	

}
