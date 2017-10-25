package com.cynapsys.pojo;

import java.io.Serializable;

public class FraisPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer fraisAssurance;
	Integer fraisContentieux;
	Integer fraisContrat;
	Integer fraisLotissement;
	Integer autresFrais;
	Integer totalFrais;
	
	//Getter & setter
	
	public Integer getFraisAssurance() {
		return fraisAssurance;
	}
	public void setFraisAssurance(Integer fraisAssurance) {
		this.fraisAssurance = fraisAssurance;
	}
	public Integer getFraisContentieux() {
		return fraisContentieux;
	}
	public void setFraisContentieux(Integer fraisContentieux) {
		this.fraisContentieux = fraisContentieux;
	}
	public Integer getFraisContrat() {
		return fraisContrat;
	}
	public void setFraisContrat(Integer fraisContrat) {
		this.fraisContrat = fraisContrat;
	}
	public Integer getFraisLotissement() {
		return fraisLotissement;
	}
	public void setFraisLotissement(Integer fraisLotissement) {
		this.fraisLotissement = fraisLotissement;
	}
	public Integer getAutresFrais() {
		return autresFrais;
	}
	public void setAutresFrais(Integer autresFrais) {
		this.autresFrais = autresFrais;
	}
	public Integer getTotalFrais() {
		return totalFrais;
	}
	public void setTotalFrais(Integer totalFrais) {
		this.totalFrais = totalFrais;
	}
	
}
