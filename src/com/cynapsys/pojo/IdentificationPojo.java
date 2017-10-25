package com.cynapsys.pojo;

import java.io.Serializable;

public class IdentificationPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	String numOrdre;
	String codeClient;
	String rang;
	String groupe;
	String nomClient;
	String adresse;
	String codePostal;
	
	
	//getter & setter
	
	public String getNumOrdre() {
		return numOrdre;
	}
	public void setNumOrdre(String numOrdre) {
	this.numOrdre = numOrdre;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}
	public String getRang() {
		return rang;
	}
	public void setRang(String rang) {
		this.rang = rang;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	
	
}
