package com.cynapsys.pojo;

import java.io.Serializable;

import com.cynapsys.entities.Cession;

public class ClientAcqCessionPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientAcqCessionPojo() {
		// TODO Auto-generated constructor stub
		}
private Cession cession;
private Integer montantTotal;

public Cession getCession() {
	return cession;
}
public void setCession(Cession cession) {
	this.cession = cession;
}
public Integer getMontantTotal() {
	return montantTotal;
}
public void setMontantTotal(Integer montantTotal) {
	this.montantTotal = montantTotal;
}

}
