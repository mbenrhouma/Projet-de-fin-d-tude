package com.cynapsys.pojo;

import com.cynapsys.entities.Cession;

public class CessionSurSalaire {
	
	private Cession cession ;
	private Integer montant ;
	private Integer duree ;
	private Integer montantrecu ;
	
	public Cession getCession() {
		return cession;
	}
	public void setCession(Cession cession) {
		this.cession = cession;
	}
	public Integer getMontant() {
		return montant;
	}
	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Integer getMontantrecu() {
		return montantrecu;
	}
	public void setMontantrecu(Integer montantrecu) {
		this.montantrecu = montantrecu;
	}
	

}
