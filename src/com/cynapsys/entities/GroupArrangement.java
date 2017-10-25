package com.cynapsys.entities;

import java.math.BigDecimal;
import java.util.Date;

public class GroupArrangement {

	String group;
	Date date;
	BigDecimal codeAquereur;
	String nomPrenomFr;
	String adresseCorrespondance;
	
	Integer montantArrieres;
	public GroupArrangement() {
		// TODO Auto-generated constructor stub
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getCodeAquereur() {
		return codeAquereur;
	}
	public void setCodeAquereur(BigDecimal codeAquereur) {
		this.codeAquereur = codeAquereur;
	}
	public String getNomPrenomFr() {
		return nomPrenomFr;
	}
	public void setNomPrenomFr(String nomPrenomFr) {
		this.nomPrenomFr = nomPrenomFr;
	}
	public String getAdresseCorrespondance() {
		return adresseCorrespondance;
	}
	public void setAdresseCorrespondance(String adresseCorrespondance) {
		this.adresseCorrespondance = adresseCorrespondance;
	}
	public Integer getMontantArrieres() {
		return montantArrieres;
	}
	public void setMontantArrieres(Integer montantArrieres) {
		this.montantArrieres = montantArrieres;
	}

}
