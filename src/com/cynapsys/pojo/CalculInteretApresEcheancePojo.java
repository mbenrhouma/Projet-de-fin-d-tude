package com.cynapsys.pojo;

import java.io.Serializable;
import java.util.Date;

public class CalculInteretApresEcheancePojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	Date date;
	Integer montant;
	Integer solde;
	Integer interet;
	
	//getter & Setter

	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getMontant() {
		return montant;
	}
	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	public Integer getSolde() {
		return solde;
	}
	public void setSolde(Integer solde) {
		this.solde = solde;
	}
	public Integer getInteret() {
		return interet;
	}
	public void setInteret(Integer interet) {
		this.interet = interet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
