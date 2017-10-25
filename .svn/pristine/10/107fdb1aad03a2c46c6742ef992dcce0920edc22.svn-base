
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

@ManagedBean(name = "noteAlaDOFBean")
@ViewScoped
public class NoteAlaDOFBean implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	

	private List<ClientAcquereur> listClientAcquereur;
	private ClientAcquereur clientAquereur;
	private Date datedernereQuittance;
	private Date dateEnvoieAlaDof;
	

	public NoteAlaDOFBean() {
	

	}

	@PostConstruct
	public void initialisation() {
		clientAquereur = new ClientAcquereur();
		listClientAcquereur=new ArrayList<ClientAcquereur>();
		listClientAcquereur=clientAcquereurService.findDTA();
		dateEnvoieAlaDof=new Date();
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
		return dateEnvoieAlaDof;
	}

	public void setDateEnvoieAlaDof(Date dateEnvoieAlaDof) {
		this.dateEnvoieAlaDof = dateEnvoieAlaDof;
	}

	


}
