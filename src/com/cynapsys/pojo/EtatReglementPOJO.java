package com.cynapsys.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class EtatReglementPOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public EtatReglementPOJO() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	private int id;
	private String codeProp;
	private String nomfr;
	private String quotePart;
	private Date dateReglement;
	private BigInteger montant;
	private BigInteger numDecompte;
	private BigInteger totalReglProp;
	private BigInteger totalReglGeneral;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodeProp() {
		return codeProp;
	}
	public void setCodeProp(String codeProp) {
		this.codeProp = codeProp;
	}
	public String getNomfr() {
		return nomfr;
	}
	public void setNomfr(String nomfr) {
		this.nomfr = nomfr;
	}
	public String getQuotePart() {
		return quotePart;
	}
	public void setQuotePart(String quotePart) {
		this.quotePart = quotePart;
	}
	public Date getDateReglement() {
		return dateReglement;
	}
	public void setDateReglement(Date dateReglement) {
		this.dateReglement = dateReglement;
	}
	public BigInteger getMontant() {
		return montant;
	}
	public void setMontant(BigInteger montant) {
		this.montant = montant;
	}
	public BigInteger getNumDecompte() {
		return numDecompte;
	}
	public void setNumDecompte(BigInteger numDecompte) {
		this.numDecompte = numDecompte;
	}
	public BigInteger getTotalReglProp() {
		return totalReglProp;
	}
	public void setTotalReglProp(BigInteger totalReglProp) {
		this.totalReglProp = totalReglProp;
	}
	public BigInteger getTotalReglGeneral() {
		return totalReglGeneral;
	}
	public void setTotalReglGeneral(BigInteger totalReglGeneral) {
		this.totalReglGeneral = totalReglGeneral;
	}
	
	
	
}
