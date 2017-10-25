package com.cynapsys.Views;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.cynapsys.Views.controller.MenuController;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Contentieux;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.GroupContentieux;
import com.cynapsys.entities.Groupe;
import com.cynapsys.pojo.ClientAcquereurRecherchPOJO;
import com.cynapsys.service.AssureurService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.ContentieuxService;
import com.cynapsys.service.EmployeurService;
import com.cynapsys.service.GroupeService;
import com.cynapsys.utils.GenerateRapport;

@ManagedBean(name = "rechercheDesClientsAcquereursBean")
@SessionScoped
public class RechercheDesClientsAcquereursBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;

	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;

	@ManagedProperty(value = "#{contentieuxService}")
	private ContentieuxService contentieuxService;

	@ManagedProperty(value = "#{employeurService}")
	private EmployeurService employeurService;

	@ManagedProperty(value = "#{assureurService}")
	private AssureurService assureurService;
	@ManagedProperty(value = "#{menuController}")
	private MenuController menuController;

	private ClientAcquereurRecherchPOJO clientAcquereurRecherchPOJO;

	private List<ClientAcquereur> listClients;

	private List<Groupe> groupes;
	private List<Employeur> employeurs;
	private List<Assureur> assureurs;
	private static SelectItem[] etatFilter;
	private ClientAcquereur selectClientLocataire;
	private ClientAcquereur newClientAcquereur;
	

	@PostConstruct
	public void initialisation() {
		clientAcquereurRecherchPOJO = new ClientAcquereurRecherchPOJO();
		clientAcquereurRecherchPOJO.setEtatTableauAmortissemet(3);
		clientAcquereurRecherchPOJO.setArrongement(3);
		clientAcquereurRecherchPOJO.setContentieux(3);
		groupes = groupeService.findAll();
		employeurs = employeurService.findAll();
		assureurs = assureurService.findAll();
		listClients=new ArrayList<ClientAcquereur>();

	}

	public void rechercheAV() {
		if (clientAcquereurRecherchPOJO.getCodeAcquereur()!=null) {
			newClientAcquereur = clientAcquereurService.findByID(clientAcquereurRecherchPOJO.getCodeAcquereur());
			if (newClientAcquereur != null) {
				try {
					ClientAcquereurBean clientAcquereurBean = ( ClientAcquereurBean) FacesContext
			                .getCurrentInstance()
			                .getApplication()
			                .evaluateExpressionGet(FacesContext.getCurrentInstance(),
			                             "#{clientAcquereurBean}",
			                             ClientAcquereurBean.class);
					  
					clientAcquereurBean.setNewClientAcquereur(newClientAcquereur);
					clientAcquereurBean.updateListMensualite();
					menuController.goToPageModifClientacquereur();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			listClients = new ArrayList<ClientAcquereur>();
			listClients = clientAcquereurService.rechercheAvancee(clientAcquereurRecherchPOJO);
		}

	}
	
	
	public void updateteCession(){
		if(clientAcquereurRecherchPOJO.getCessionSalaire()==false){
			clientAcquereurRecherchPOJO.setCessionActive(false);
			clientAcquereurRecherchPOJO.setCessEchu(false);
		}
	}
	public void updatetearchivage(){
		if(clientAcquereurRecherchPOJO.getArchive()==false){
			clientAcquereurRecherchPOJO.setArchiveAnc(false);
			clientAcquereurRecherchPOJO.setArchiveNv(false);
		}
	}

	public void imprimerEnContentieux() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<GroupContentieux> listGroupClient = new ArrayList<GroupContentieux>();
		List<ClientAcquereur> listGroups = new ArrayList<ClientAcquereur>();
		listGroups = listClients;
		String group = listGroups.get(0).getGroupe().getCode();

		for (int i = 0; i < listGroups.size(); i++) {
			if (listGroups.get(i).getGroupe().getCode().equals(group)) {
				GroupContentieux groupContentieux = new GroupContentieux();
				groupContentieux.setGroup(group);
				groupContentieux.setDate(new Date());
				groupContentieux.setCodeAquereur(listGroups.get(i)
						.getCodeAcquereur());
				groupContentieux.setNomPrenomFr(listGroups.get(i)
						.getNomPrenomFr());
				groupContentieux.setAdresseLogement(listGroups.get(i)
						.getLogement().getAdresseLoge());

				Contentieux findClientContentieux = contentieuxService
						.findContentieuxByCodeClientAcquereur(listGroups.get(i)
								.getCodeAcquereur());
				groupContentieux.setNumDossier(findClientContentieux
						.getNumDossier());
				groupContentieux.setDateTransmission(findClientContentieux
						.getDateTransmission());
				groupContentieux.setDateFin(findClientContentieux.getDateFin());
				listGroupClient.add(groupContentieux);
			}
		}

		String subreportFile = "contentieux_subreport.jasper";
		String masterReportFile = "contentieux.jasper";
		GenerateRapport.exportPDFWithDataSourceSubReport(subreportFile,
				masterReportFile, listGroupClient, params,
				"Client au contentieux", "listGroupClient");
	}

	public void imprimerEnArrangement() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<GroupContentieux> listGroupClient = new ArrayList<GroupContentieux>();
		List<ClientAcquereur> listGroups = new ArrayList<ClientAcquereur>();
		listGroups = listClients;
		String group = listGroups.get(0).getGroupe().getCode();

		for (int i = 0; i < listGroups.size(); i++) {
			if (listGroups.get(i).getGroupe().getCode().equals(group)) {
				GroupContentieux groupContentieux = new GroupContentieux();
				groupContentieux.setGroup(group);
				groupContentieux.setDate(new Date());
				groupContentieux.setCodeAquereur(listGroups.get(i)
						.getCodeAcquereur());
				groupContentieux.setNomPrenomFr(listGroups.get(i)
						.getNomPrenomFr());
				groupContentieux.setAdresseLogement(listGroups.get(i)
						.getLogement().getAdresseLoge());

				Contentieux findClientContentieux = contentieuxService
						.findContentieuxByCodeClientAcquereur(listGroups.get(i)
								.getCodeAcquereur());
				groupContentieux.setNumDossier(findClientContentieux
						.getNumDossier());
				groupContentieux.setDateTransmission(findClientContentieux
						.getDateTransmission());
				groupContentieux.setDateTransmission(findClientContentieux
						.getDateTransmission());
				listGroupClient.add(groupContentieux);
			}
		}

		String subreportFile = "contentieux_subreport.jasper";
		String masterReportFile = "contentieux.jasper";
		GenerateRapport.exportPDFWithDataSourceSubReport(subreportFile,
				masterReportFile, listGroupClient, params,
				"Client au contentieux", "listGroupClient");
	}


	public SelectItem[] getEtatFilter() {

		etatFilter = new SelectItem[groupes.size() + 1];
		etatFilter[0] = new SelectItem("", "","");
		for (int i = 1; i <= groupes.size(); i++) {
			etatFilter[i] = new SelectItem(groupes.get(i - 1).getLibelle(),groupes.get(i - 1).getLibelle()+"|"+(groupes.get(i - 1).getCode()));
			
		}
		

		return etatFilter;
	}

	


	public static void setEtatFilter(SelectItem[] etatFilter) {
		RechercheDesClientsAcquereursBean.etatFilter = etatFilter;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(
			ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public List<ClientAcquereur> getListClients() {
		return listClients;
	}

	public void setListClients(List<ClientAcquereur> listClients) {
		this.listClients = listClients;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public EmployeurService getEmployeurService() {
		return employeurService;
	}

	public void setEmployeurService(EmployeurService employeurService) {
		this.employeurService = employeurService;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public List<Employeur> getEmployeurs() {
		return employeurs;
	}

	public void setEmployeurs(List<Employeur> employeurs) {
		this.employeurs = employeurs;
	}

	public AssureurService getAssureurService() {
		return assureurService;
	}

	public void setAssureurService(AssureurService assureurService) {
		this.assureurService = assureurService;
	}

	public List<Assureur> getAssureurs() {
		return assureurs;
	}

	public void setAssureurs(List<Assureur> assureurs) {
		this.assureurs = assureurs;
	}

	

	public ContentieuxService getContentieuxService() {
		return contentieuxService;
	}

	public void setContentieuxService(ContentieuxService contentieuxService) {
		this.contentieuxService = contentieuxService;
	}

	public ClientAcquereurRecherchPOJO getClientAcquereurRecherchPOJO() {
		return clientAcquereurRecherchPOJO;
	}

	public void setClientAcquereurRecherchPOJO(
			ClientAcquereurRecherchPOJO clientAcquereurRecherchPOJO) {
		this.clientAcquereurRecherchPOJO = clientAcquereurRecherchPOJO;
	}

	public ClientAcquereur getSelectClientLocataire() {
		return selectClientLocataire;
	}

	public void setSelectClientLocataire(ClientAcquereur selectClientLocataire) {
		this.selectClientLocataire = selectClientLocataire;
	}

	public ClientAcquereur getNewClientAcquereur() {
		return newClientAcquereur;
	}

	public void setNewClientAcquereur(ClientAcquereur newClientAcquereur) {
		this.newClientAcquereur = newClientAcquereur;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

}
