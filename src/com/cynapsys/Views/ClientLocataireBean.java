package com.cynapsys.Views;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.Views.controller.MenuController;
import com.cynapsys.entities.AnneeBudgetaire;
import com.cynapsys.entities.ClientLocataire;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.HistoriqueClientLoc;
import com.cynapsys.entities.Logement;
import com.cynapsys.service.AnneeBudgetaireService;
import com.cynapsys.service.ClientLocataireService;
import com.cynapsys.service.GroupeService;
import com.cynapsys.service.HistoriqueClientLocService;
import com.cynapsys.service.LocaliteService;
import com.cynapsys.service.LogementService;
import com.cynapsys.service.LotissementService;
import com.cynapsys.service.TypeLogementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "clientLocataireBean")
@SessionScoped
public class ClientLocataireBean implements Serializable {
	@ManagedProperty(value = "#{clientLocataireService}")
	private ClientLocataireService clientLocataireService;
	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;
	@ManagedProperty(value = "#{menuController}")
	private MenuController menuController;
	@ManagedProperty(value = "#{logementService}")
	private LogementService logementService;
	@ManagedProperty(value = "#{historiqueClientLocService}")
	private HistoriqueClientLocService historiqueClientLocService;
	@ManagedProperty(value = "#{localiteService}")
	private LocaliteService localiteService;
	@ManagedProperty(value = "#{lotissementService}")
	private LotissementService lotissementService;
	@ManagedProperty(value = "#{typeLogementService}")
	private TypeLogementService typeLogementService;
	@ManagedProperty(value = "#{anneeBudgetaireService}")
	private AnneeBudgetaireService anneeBudgetaireService;
	

	private static final long serialVersionUID = 1L;
	private ClientLocataire newClientLocataire;
	private ClientLocataire selectClientLocataire;
	private ClientLocataire oldClientLocataire;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<ClientLocataire> ClientLocataireFilter;
	private List<ClientLocataire> listClientLocataire;
	private boolean enabledBoutonDelete;
	
	private int ModifClientLocataire = 1;
	private List<Groupe> listGroupe;
	private String dateFin;
	private List<Logement> listLogement;
	private List<HistoriqueClientLoc> listHistoriqueClientLocService;
	private HistoriqueClientLoc historiqueClientLoc;
	private static SelectItem[] etatFilter;
	private String clientActiveString;
	private String clientSupprimeString;
	private String codeClientLocataire;
	private List<AnneeBudgetaire> listAnneeBudgetaire;
	private AnneeBudgetaire anneeBudgetaire;

	public ClientLocataireBean() {
		

	}

	@PostConstruct
	public void initialisation() {
		codeClientLocataire=Constants.codeClientLocataire;
		listAnneeBudgetaire=new ArrayList<AnneeBudgetaire>();
		listAnneeBudgetaire=anneeBudgetaireService.findAll();
		newClientLocataire = new ClientLocataire();
		newClientLocataire.setDuree(1);
		listLogement = new ArrayList<Logement>();
		listLogement = logementService.finAllJoinLibre();
		listClientLocataire = new ArrayList<ClientLocataire>();
		listClientLocataire = clientLocataireService.findDTA();
		listGroupe = new ArrayList<Groupe>();
		listGroupe = groupeService.findAll();
		
		

	}

	public void setEtatClienLocataireFRAR() {
		if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")) {
			clientSupprimeString = ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
					.getString("codeLocataire.etatClientSupprime");
			clientActiveString = ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
					.getString("codeLocataire.etatClientActive");
		} else {
			clientSupprimeString = ResourceBundle.getBundle(Constants.bundle_clientLocataire_ar)
					.getString("codeLocataire.etatClientSupprime");
			clientActiveString = ResourceBundle.getBundle(Constants.bundle_clientLocataire_ar)
					.getString("codeLocataire.etatClientActive");

		}

	}
	
	public void buldCodeClientLocataire(){
		String anneeBudtest ,localiteTest,lostissmentTest,typeLogementTest,numLogementTest,rangTest;
		rangTest="1";
		if(anneeBudgetaire!=null){
			String test=anneeBudgetaire.getCode();
			Integer testIntger=Integer.parseInt(test);
			testIntger=testIntger+100;
			test=testIntger.toString();
			anneeBudtest=test.substring(1);
		}else{
			anneeBudtest="";
		}
		
		if((newClientLocataire.getLogement()!=null)&&(newClientLocataire.getLogement().getLocalite()!=null)){
			String test=newClientLocataire.getLogement().getLocalite().getCode();
			Integer testIntger=Integer.parseInt(test);
			testIntger=testIntger+1000;
			test=testIntger.toString();
			localiteTest=test.substring(1);
			
		}else{
			localiteTest="";
		}
		if((newClientLocataire.getLogement()!=null)&&(newClientLocataire.getLogement().getLotissement().getCode()!=null)){
			String test=newClientLocataire.getLogement().getLotissement().getCode().toString();
			Integer testIntger=Integer.parseInt(test);
			testIntger=testIntger+100;
			test=testIntger.toString();
			lostissmentTest=test.substring(1);
		}else{
			lostissmentTest="";
		}
		if((newClientLocataire.getLogement()!=null)&&(newClientLocataire.getLogement().getTypeLogement().getCodeType()!=null)){
			String test=newClientLocataire.getLogement().getTypeLogement().getCodeType();
			Integer testIntger=Integer.parseInt(test);
			testIntger=testIntger+100;
			test=testIntger.toString();
			typeLogementTest=test.substring(1);
		}else{
			typeLogementTest="";
		}
		if((newClientLocataire.getLogement()!=null)&&(newClientLocataire.getLogement().getCodeLogement()!=null)){
			String test=newClientLocataire.getLogement().getCodeLogement().toString();
			Integer testIntger=Integer.parseInt(test);
			testIntger=testIntger+100;
			test=testIntger.toString();
			numLogementTest=test.substring(1);
		}else{
			numLogementTest="";
		}
		
		codeClientLocataire=Constants.codeClientLocataire;
		codeClientLocataire=codeClientLocataire.concat(anneeBudtest);
		codeClientLocataire=codeClientLocataire.concat(localiteTest);
		codeClientLocataire=codeClientLocataire.concat(lostissmentTest);
		codeClientLocataire=codeClientLocataire.concat(typeLogementTest);
		codeClientLocataire=codeClientLocataire.concat(numLogementTest);
		codeClientLocataire=codeClientLocataire.concat(rangTest);
	
	}
	
	public void createClientLocataire() {
		codeClientLocataire=Constants.codeClientLocataire;
		anneeBudgetaire=null;
		newClientLocataire = new ClientLocataire();
		newClientLocataire.setDuree(1);
		ModifClientLocataire = 1;
		selectClientLocataire = null;
		listClientLocataire = clientLocataireService.findDTA();
		modif = 0;
	}

	public void onselectClientLocataire() {
		anneeBudgetaire=null;
		newClientLocataire = new ClientLocataire();
		newClientLocataire = selectClientLocataire;
		ModifClientLocataire = 0;
		modif = 1;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		dateFin = format.format(newClientLocataire.getDateFin());
		listClientLocataire = clientLocataireService.findDTA();
	}

	public void updateDateFin() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(newClientLocataire.getDateDebut());
		newClientLocataire.setDateDebut(
				new Date(newClientLocataire.getDateDebut().getYear(), newClientLocataire.getDateDebut().getMonth(), 1));
		c.setTime(newClientLocataire.getDateDebut());
		c.add(Calendar.YEAR, newClientLocataire.getDuree());
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);

		newClientLocataire.setDateFin(c.getTime());
		dateFin = format.format(newClientLocataire.getDateFin());

	}
	
public void updatelistLogement(){
	listLogement = new ArrayList<Logement>();
	listLogement = logementService.finAllJoinLibre();
}
public void updateAdressClientLocataireLogement(){
	newClientLocataire.setAdresseLogement(newClientLocataire.getLogement().getAdresseLoge());
	buldCodeClientLocataire();
	
}
	public SelectItem[] getEtatFilter() {
		etatFilter = new SelectItem[3];
		etatFilter[0] = new SelectItem("", "");
		etatFilter[1] = new SelectItem(Constants.clintLocatiareactive,clientActiveString);
		etatFilter[2] = new SelectItem(Constants.clintLocatiareSupprime,clientSupprimeString);

		return etatFilter;
	}

	public void setEtatFilter(SelectItem[] etatFilter) {
		ClientLocataireBean.etatFilter = etatFilter;
	}

	public void rechercheHistorique() {
		listHistoriqueClientLocService = new ArrayList<HistoriqueClientLoc>();
		listHistoriqueClientLocService = historiqueClientLocService.findDTA();

	}

	public void initDate() {
		newClientLocataire.setDateDebut(null);
		newClientLocataire.setDateFin(null);
		dateFin = null;

	}
	

	public void saveClientLocataire() {
		if (ModifClientLocataire == 1) {
			try {
				newClientLocataire.setCodeLocataire(codeClientLocataire);
				newClientLocataire.getLogement().setEtatLog(Constants.logementEnLocation);
				logementService.update(newClientLocataire.getLogement());
				newClientLocataire.setAnneeBudgetaire(anneeBudgetaire);
				newClientLocataire.setEtatClientloc(Constants.clintLocatiareactive);
				clientLocataireService.save(newClientLocataire);
				historiqueClientLoc = new HistoriqueClientLoc();
				historiqueClientLoc.setClientLocataire(newClientLocataire);
				historiqueClientLoc.setDateDebut(newClientLocataire.getDateDebut());
				historiqueClientLoc.setDateFin(newClientLocataire.getDateFin());
			
				historiqueClientLoc.setDateModif(new Date());
				historiqueClientLocService.save(historiqueClientLoc);

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.cree.succes"));
				}

			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.error.existe"));

			}
			try {
				menuController.goToPageModifierClientLocataire();
				ModifClientLocataire = 0;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (ModifClientLocataire == 0) {
			ClientLocataire oldclientloc = new ClientLocataire();
			oldclientloc = clientLocataireService.findById(newClientLocataire.getCodeLocataire());

			if (oldclientloc.getDateFinLocation() == null) {

				oldClientLocataire = new ClientLocataire();
				oldClientLocataire = clientLocataireService.findById(newClientLocataire.getCodeLocataire());

				if ((oldClientLocataire.getDateDebut() != newClientLocataire.getDateDebut())
						|| (oldClientLocataire.getDateFin() != newClientLocataire.getDateFin())
						|| oldClientLocataire.getLoyerMensuel() != newClientLocataire.getLoyerMensuel()
						|| oldClientLocataire.getTauxAugmetation() != newClientLocataire.getTauxAugmetation()) {
					historiqueClientLoc = new HistoriqueClientLoc();
					historiqueClientLoc.setClientLocataire(newClientLocataire);
					historiqueClientLoc.setDateDebut(newClientLocataire.getDateDebut());
					historiqueClientLoc.setDateFin(newClientLocataire.getDateFin());
					
					historiqueClientLoc.setDateModif(new Date());
					historiqueClientLocService.save(historiqueClientLoc);
					if (newClientLocataire.getDateFinLocation() != null) {
						Logement log = new Logement();
						log = logementService.findById(newClientLocataire.getLogement().getCodeLogement().toString());
						log.setEtatLog(Constants.logementLibre);
						logementService.update(log);
						JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
								.getString("clientLocataire.logement.libre"));

					}
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.enregistrer.historique"));

				}
				clientLocataireService.update(newClientLocataire);

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.modifie.succes"));
				else
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
							.getString("clientLocataire.modifie.succes"));

			} else {
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
						.getString("clientLocataire.error.modif"));
			}
		}

	}

	public void deleteClientLocataire() {
		try {
			newClientLocataire.setEtatClientloc(Constants.clintLocatiareSupprime);
			clientLocataireService.update(newClientLocataire);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
						.getString("parametrage.clientLocataire.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
						.getString("parametrage.clientLocataire.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
						.getString("clientLocataire.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_clientLocataire_fr)
						.getString("clientLocataire.error.supprimer"));
		}
		createClientLocataire();
	}

	public ClientLocataireService getClientLocataireService() {
		return clientLocataireService;
	}

	public void setClientLocataireService(ClientLocataireService ClientLocataireService) {
		this.clientLocataireService = ClientLocataireService;
	}

	public ClientLocataire getNewClientLocataire() {
		return newClientLocataire;
	}

	public void setNewClientLocataire(ClientLocataire newClientLocataire) {
		this.newClientLocataire = newClientLocataire;
	}

	public ClientLocataire getSelectClientLocataire() {
		return selectClientLocataire;
	}

	public void setSelectClientLocataire(ClientLocataire selectClientLocataire) {
		this.selectClientLocataire = selectClientLocataire;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<ClientLocataire> getClientLocataireFilter() {
		return ClientLocataireFilter;
	}

	public void setClientLocataireFilter(List<ClientLocataire> ClientLocataireFilter) {
		this.ClientLocataireFilter = ClientLocataireFilter;
	}

	public List<ClientLocataire> getListClientLocataire() {
		return listClientLocataire;
	}

	public void setListClientLocataire(List<ClientLocataire> listClientLocataire) {
		this.listClientLocataire = listClientLocataire;
	}

	public boolean isEnabledBoutonDelete() {
		return enabledBoutonDelete;
	}

	public void setEnabledBoutonDelete(boolean enabledBoutonDelete) {
		this.enabledBoutonDelete = enabledBoutonDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getModifClientLocataire() {
		return ModifClientLocataire;
	}

	public void setModifClientLocataire(int modifClientLocataire) {
		ModifClientLocataire = modifClientLocataire;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public List<Groupe> getListGroupe() {
		return listGroupe;
	}

	public void setListGroupe(List<Groupe> listGroupe) {
		this.listGroupe = listGroupe;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public LogementService getLogementService() {
		return logementService;
	}

	public void setLogementService(LogementService logementService) {
		this.logementService = logementService;
	}

	public List<Logement> getListLogement() {
		return listLogement;
	}

	public void setListLogement(List<Logement> listLogement) {
		this.listLogement = listLogement;
	}

	public HistoriqueClientLocService getHistoriqueClientLocService() {
		return historiqueClientLocService;
	}

	public void setHistoriqueClientLocService(HistoriqueClientLocService historiqueClientLocService) {
		this.historiqueClientLocService = historiqueClientLocService;
	}

	public List<HistoriqueClientLoc> getListHistoriqueClientLocService() {
		return listHistoriqueClientLocService;
	}

	public void setListHistoriqueClientLocService(List<HistoriqueClientLoc> listHistoriqueClientLocService) {
		this.listHistoriqueClientLocService = listHistoriqueClientLocService;
	}

	public ClientLocataire getOldClientLocataire() {
		return oldClientLocataire;
	}

	public void setOldClientLocataire(ClientLocataire oldClientLocataire) {
		this.oldClientLocataire = oldClientLocataire;
	}

	public HistoriqueClientLoc getHistoriqueClientLoc() {
		return historiqueClientLoc;
	}

	public void setHistoriqueClientLoc(HistoriqueClientLoc historiqueClientLoc) {
		this.historiqueClientLoc = historiqueClientLoc;
	}

	public String getClientActiveString() {
		return clientActiveString;
	}

	public void setClientActiveString(String clientActiveString) {
		this.clientActiveString = clientActiveString;
	}

	public String getClientSupprimeString() {
		return clientSupprimeString;
	}

	public void setClientSupprimeString(String clientSupprimeString) {
		this.clientSupprimeString = clientSupprimeString;
	}

	public String getCodeClientLocataire() {
		return codeClientLocataire;
	}

	public void setCodeClientLocataire(String codeClientLocataire) {
		this.codeClientLocataire = codeClientLocataire;
	}

	public LocaliteService getLocaliteService() {
		return localiteService;
	}

	public void setLocaliteService(LocaliteService localiteService) {
		this.localiteService = localiteService;
	}

	public LotissementService getLotissementService() {
		return lotissementService;
	}

	public void setLotissementService(LotissementService lotissementService) {
		this.lotissementService = lotissementService;
	}

	public TypeLogementService getTypeLogementService() {
		return typeLogementService;
	}

	public void setTypeLogementService(TypeLogementService typeLogementService) {
		this.typeLogementService = typeLogementService;
	}

	public AnneeBudgetaireService getAnneeBudgetaireService() {
		return anneeBudgetaireService;
	}

	public void setAnneeBudgetaireService(AnneeBudgetaireService anneeBudgetaireService) {
		this.anneeBudgetaireService = anneeBudgetaireService;
	}

	public List<AnneeBudgetaire> getListAnneeBudgetaire() {
		return listAnneeBudgetaire;
	}

	public void setListAnneeBudgetaire(List<AnneeBudgetaire> listAnneeBudgetaire) {
		this.listAnneeBudgetaire = listAnneeBudgetaire;
	}

	public AnneeBudgetaire getAnneeBudgetaire() {
		return anneeBudgetaire;
	}

	public void setAnneeBudgetaire(AnneeBudgetaire anneeBudgetaire) {
		this.anneeBudgetaire = anneeBudgetaire;
	}

}
