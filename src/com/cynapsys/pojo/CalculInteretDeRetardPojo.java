package com.cynapsys.pojo;

import java.io.Serializable;
import java.util.Date;

public class CalculInteretDeRetardPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	Integer date;
	int countMois;
	Integer debit;
	Integer credit;
	Integer echCD;
	Integer solde;
	Integer cumulArriere;
	Integer interet;
	
	//getter & setter
	

	public int getCountMois() {
		return countMois;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	public void setCountMois(int countMois) {
		this.countMois = countMois;
	}
	public Integer getDebit() {
		return debit;
	}
	public void setDebit(Integer debit) {
		this.debit = debit;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getEchCD() {
		return echCD;
	}
	public void setEchCD(Integer echCD) {
		this.echCD = echCD;
	}
	public Integer getSolde() {
		return solde;
	}
	public void setSolde(Integer solde) {
		this.solde = solde;
	}
	public Integer getCumulArriere() {
		return cumulArriere;
	}
	public void setCumulArriere(Integer cumulArriere) {
		this.cumulArriere = cumulArriere;
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
