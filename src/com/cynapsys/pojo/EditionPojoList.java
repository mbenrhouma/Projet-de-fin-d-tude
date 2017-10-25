package com.cynapsys.pojo;

import java.io.Serializable;
import java.util.List;

public class EditionPojoList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String groupe;
	private List<SubReportClientACPOJO> listEdition;	
	
	public List<SubReportClientACPOJO> getListEdition() {
		return listEdition;
	}
	public void setListEdition(List<SubReportClientACPOJO> listEdition) {
		this.listEdition = listEdition;
	}
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	
}
