package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mainlevee;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.MainleveeService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "archivageClientBean")
@ViewScoped
public class ArchivageClientBean implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	@ManagedProperty(value = "#{mainleveeService}")
	private MainleveeService mainleveeService;
	
	private List<ClientAcquereur> listClientAcquereur;
	private ClientAcquereur newClientAcquereur;
	private Mainlevee newMainlevee;
	
	
	
	public ArchivageClientBean() {
		

	}
	
	
	@PostConstruct
	public void initialisation() {
		listClientAcquereur=new ArrayList<ClientAcquereur>();
		listClientAcquereur=clientAcquereurService.findDTA();
	}

	public void updateClientAquereur(){
		clientAcquereurService.update(newClientAcquereur);
		if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_imprimerMainlevee_fr)
					.getString("archivage.cree.succe"));
		else {
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_imprimerMainlevee_ar)
					.getString("archivage.cree.succe"));
			
			
			initialisation();
		}
		
	
}
	public void rechercheMainlevee(){
		if (newClientAcquereur.getMainlevee()==null){
			newMainlevee=mainleveeService.findByClientLoc(newClientAcquereur);
			if(newMainlevee!=null){
				newClientAcquereur.setDatemainlevee(newMainlevee.getDateMainlevee());
			}
			
		}
		
		
	}
	
public void init (){
	newClientAcquereur=new ClientAcquereur();
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






	public ClientAcquereur getNewClientAcquereur() {
		return newClientAcquereur;
	}






	public void setNewClientAcquereur(ClientAcquereur newClientAcquereur) {
		this.newClientAcquereur = newClientAcquereur;
	}

	


	public MainleveeService getMainleveeService() {
		return mainleveeService;
	}


	public void setMainleveeService(MainleveeService mainleveeService) {
		this.mainleveeService = mainleveeService;
	}


	public Mainlevee getNewMainlevee() {
		return newMainlevee;
	}


	public void setNewMainlevee(Mainlevee newMainlevee) {
		this.newMainlevee = newMainlevee;
	}
	
}
