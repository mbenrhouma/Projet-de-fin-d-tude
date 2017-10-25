

package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.service.ClientAcquereurService;

@ManagedBean(name = "actePrecisionBean")
@ViewScoped
public class ActePrecisionBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	
	
	private List<ClientAcquereur> listClientAcquereur;
	private ClientAcquereur clientAquereur;
	private Date datedernereQuittance;
	private Date dateActePrecision;
	

	public ActePrecisionBean() {
		
	}

	@PostConstruct
	public void initialisation() {
		clientAquereur=new ClientAcquereur();
		listClientAcquereur=new ArrayList<ClientAcquereur>();
		listClientAcquereur=clientAcquereurService.findDTA();
		dateActePrecision=new Date();
		datedernereQuittance=null;
		

	}



	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public List<ClientAcquereur> getListClientAcquereur() {
		return listClientAcquereur;
	}

	public void setListClientAcquereur(List<ClientAcquereur> listClientAcquereur) {
		this.listClientAcquereur = listClientAcquereur;
	}

	public ClientAcquereur getClientAquereur() {
		return clientAquereur;
	}

	public void setClientAquereur(ClientAcquereur clientAquereur) {
		this.clientAquereur = clientAquereur;
	}

	public Date getDatedernereQuittance() {
		return datedernereQuittance;
	}

	public void setDatedernereQuittance(Date datedernereQuittance) {
		this.datedernereQuittance = datedernereQuittance;
	}

	public Date getDateEnvoieAlaDof() {
		return dateActePrecision;
	}

	public void setDateEnvoieAlaDof(Date dateActePrecision) {
		this.dateActePrecision = dateActePrecision;
	}

	public Date getDateActePrecision() {
		return dateActePrecision;
	}

	public void setDateActePrecision(Date dateActePrecision) {
		this.dateActePrecision = dateActePrecision;
	}

	


}
