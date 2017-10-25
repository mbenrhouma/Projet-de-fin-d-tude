package com.cynapsys.entities;

import java.math.BigDecimal;
import java.util.Date;

public class GroupContentieux {
	String group;
	Date date;
	String codeAquereur;
	String nomPrenomFr;
	String adresseLogement;
	String numDossier;
	Date dateTransmission;
	Date dateFin;
	Integer size;
	
	
	
	public GroupContentieux() {
		// TODO Auto-generated constructor stub
	}





	public String getAdresseLogement() {
		return adresseLogement;
	}





	public void setAdresseLogement(String adresseLogement) {
		this.adresseLogement = adresseLogement;
	}





	public Integer getSize() {
		return size;
	}





	public void setSize(Integer size) {
		this.size = size;
	}





	
	




	public String getCodeAquereur() {
		return codeAquereur;
	}





	public void setCodeAquereur(String codeAquereur) {
		this.codeAquereur = codeAquereur;
	}





	public String getNomPrenomFr() {
		return nomPrenomFr;
	}





	public void setNomPrenomFr(String nomPrenomFr) {
		this.nomPrenomFr = nomPrenomFr;
	}





	public String getNumDossier() {
		return numDossier;
	}





	public void setNumDossier(String numDossier) {
		this.numDossier = numDossier;
	}





	public Date getDateTransmission() {
		return dateTransmission;
	}





	public void setDateTransmission(Date dateTransmission) {
		this.dateTransmission = dateTransmission;
	}






	public Date getDateFin() {
		return dateFin;
	}





	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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

}
