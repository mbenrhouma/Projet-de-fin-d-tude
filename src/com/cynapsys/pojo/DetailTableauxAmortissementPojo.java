package com.cynapsys.pojo;

import java.io.Serializable;
import java.util.Date;

public class DetailTableauxAmortissementPojo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public DetailTableauxAmortissementPojo() {

	}
	
	private Integer id;
	private Date dateDeb;
	private Date dateFin;
	private Integer capitalRestantDu;
	private Integer interet;
	private Integer amortissement;
	private Integer annuite;
	private Integer mensualite;
	private Integer assuranceAnnuelle;
	private Integer taxeAssurance;
	private Integer MensualiteDef;

	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getInteret() {
		return interet;
	}
	public void setInteret(Integer interet) {
		this.interet = interet;
	}
	public Integer getAmortissement() {
		return amortissement;
	}
	public void setAmortissement(Integer amortissement) {
		this.amortissement = amortissement;
	}
	public Integer getAnnuite() {
		return annuite;
	}
	public void setAnnuite(Integer annuite) {
		this.annuite = annuite;
	}
	public Integer getMensualite() {
		return mensualite;
	}
	public void setMensualite(Integer mensualite) {
		this.mensualite = mensualite;
	}
	public Integer getAssuranceAnnuelle() {
		return assuranceAnnuelle;
	}
	public void setAssuranceAnnuelle(Integer assuranceAnnuelle) {
		this.assuranceAnnuelle = assuranceAnnuelle;
	}
	public Integer getTaxeAssurance() {
		return taxeAssurance;
	}
	public void setTaxeAssurance(Integer taxeAssurance) {
		this.taxeAssurance = taxeAssurance;
	}
	public Integer getMensualiteDef() {
		return MensualiteDef;
	}
	public void setMensualiteDef(Integer mensualiteDef) {
		MensualiteDef = mensualiteDef;
	}
	public Integer getCapitalRestantDu() {
		return capitalRestantDu;
	}
	public void setCapitalRestantDu(Integer capitalRestantDu) {
		this.capitalRestantDu = capitalRestantDu;
	}
	
}
