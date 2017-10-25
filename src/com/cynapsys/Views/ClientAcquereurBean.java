package com.cynapsys.Views;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.Views.controller.MenuController;
import com.cynapsys.entities.AnneeBudgetaire;
import com.cynapsys.entities.Arrangement;
import com.cynapsys.entities.Cession;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Contentieux;
import com.cynapsys.entities.Deces;
import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Logement;
import com.cynapsys.entities.Lotissement;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.TypeLogement;
import com.cynapsys.pojo.ClientAcqCessionPojo;
import com.cynapsys.pojo.EditionPojoList;
import com.cynapsys.pojo.SubReportClientACPOJO;
import com.cynapsys.service.AnneeBudgetaireService;
import com.cynapsys.service.ArrangementService;
import com.cynapsys.service.CessionService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.ContentieuxService;
import com.cynapsys.service.DecesService;
import com.cynapsys.service.GouvernoratService;
import com.cynapsys.service.GroupeService;
import com.cynapsys.service.LocaliteService;
import com.cynapsys.service.LogementService;
import com.cynapsys.service.LotissementService;
import com.cynapsys.service.MainleveeService;
import com.cynapsys.service.MensualiteService;
import com.cynapsys.service.TypeLogementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "clientAcquereurBean")
@SessionScoped
public class ClientAcquereurBean {

	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	

	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;
	
	@ManagedProperty(value = "#{anneeBudgetaireService}")
	private AnneeBudgetaireService anneeBudgetaireService;

	@ManagedProperty(value = "#{logementService}")
	private LogementService logementService;
	
	
	
	@ManagedProperty(value = "#{gouvernoratService}")
	private GouvernoratService gouvernoratService;
	
	@ManagedProperty(value = "#{typeLogementService}")
	private TypeLogementService typeLogementService;
	
	@ManagedProperty(value = "#{localiteService}")
	private LocaliteService localiteService;
	@ManagedProperty(value = "#{mainleveeService}")
	private MainleveeService mainleveeService;
	
	@ManagedProperty(value = "#{lotissementService}")
	private LotissementService lotissementService;
	@ManagedProperty(value = "#{cessionService}")
	private CessionService cessionService;
	@ManagedProperty(value = "#{contentieuxService}")
	private ContentieuxService contentieuxService;
	@ManagedProperty(value = "#{arrangementService}")
	private ArrangementService arrangementService;
	@ManagedProperty(value = "#{decesService}")
	private DecesService decesService;
	@ManagedProperty(value = "#{menuController}")
	private MenuController menuController;

	@ManagedProperty(value = "#{mensualiteService}")
	private MensualiteService mensualiteService;
	
	private ClientAcquereur newClientAcquereur;
	private Boolean compteConjoint;
	private ClientAcquereur selectClientAcquereur;
	public int ModifClientAcquereur = 1;
	private List<ClientAcquereur> clientAcquereurs;
	private Groupe Employeur;
	private List<Groupe> groupes;
    private int log = 0;
    private List<EditionPojoList> listpojoEdit;
	
	private List<Gouvernorat> gouvernerats;
	private List<Localite> localites;
	private List<Lotissement> lotissments ;

	private List<Mensualite> mensualiteList ;
	
	private List<TypeLogement> typeslogements ;
	private List<Logement> logements;
	private List<AnneeBudgetaire> anneebudgetaires;
//	debut zied
	private List<Cession> cessionListPasConj;
	private List<Cession> cessionListConj;
	private List <ClientAcqCessionPojo> listcessionPasConjPojo;
	private List <ClientAcqCessionPojo> listcessionConjPojo;
	private List <Contentieux> listCont;
	private Contentieux contentieuxClient;
	private List<Arrangement> listArrangement;
	private Arrangement arrangement;
	private Deces deces;
	
	private String varMenu;
	
	private int addTA;
	
	public ClientAcquereurBean() {
	}
//fin zied
	private Logement newLogement;

	private Logement selectLogement;
	private Groupe selectGroupe;

	private String dateFin;

	@PostConstruct
	public void initialisation() {
		
		newLogement=new Logement();
		newClientAcquereur = new ClientAcquereur();
		newClientAcquereur.setDureeContrat(1);
		logements = new ArrayList<Logement>();
		logements = logementService.finAllJoinLibre();
		groupes = groupeService.findAll();
		gouvernerats=gouvernoratService.findAll();

		
		typeslogements= typeLogementService.findAll();
		anneebudgetaires=anneeBudgetaireService.findAll();
		compteConjoint=false;
		


	}
	

	public void CreateClientAcquereur(){
		newClientAcquereur=new ClientAcquereur();
		selectLogement= new Logement();
		log=0;
		compteConjoint=false;
	}
	
	public void findlocaliteByGouverner(){
		localites=new ArrayList<Localite>();
		localites=localiteService.finlocaliteByGov(newLogement.getGouvernorat());
	}
	
	public List<TypeLogement> getTypeslogements() {
		return typeslogements;
	}
	
public void AjoutLogement(){
	     log = 1 ;
		 selectLogement=newLogement ;
		
	}

	public void setEtat() {
		if (compteConjoint) {
			newClientAcquereur.setCompteConjoint(1);
		} else {
			newClientAcquereur.setCompteConjoint(0);
		}
	}
	


//debut zied
	public void onSelect(){
		varMenu="Identification";
		
	newClientAcquereur= new ClientAcquereur();
	newClientAcquereur=clientAcquereurService.findByID(selectClientAcquereur.getCodeAcquereur()) ;
	 cessionListPasConj=new ArrayList<Cession>();
	 cessionListPasConj=cessionService.findCessionByClientAcquereurpasConj(newClientAcquereur);
	 cessionListConj=new ArrayList<Cession>();
	 cessionListPasConj=cessionService.findCessionByClientAcquereurConjoint(newClientAcquereur);
	 remplissageList(listcessionPasConjPojo ,cessionListPasConj);
	 remplissageList(listcessionConjPojo ,cessionListConj);
	 listCont=new ArrayList<Contentieux>();
	 listCont=contentieuxService.findContentieuxByClientAcquereurZ(newClientAcquereur);
	 contentieuxClient=new Contentieux();
	 if(listCont != null && !listCont.isEmpty()){
		for(Contentieux cont:listCont) {
			if (cont.getDateFin()==null){
				 contentieuxClient=cont;
				 
			}
		}
	 }
	
	 updateListMensualite();
	listArrangement=new ArrayList<Arrangement>();
	listArrangement=arrangementService.findArrabgementByClientAcquereur(newClientAcquereur);
	if(listArrangement != null && !listArrangement.isEmpty()){
		for(Arrangement arr:listArrangement) {
			if (arr.getDateFin()==null){
				arrangement=arr;
				 
			}
		}
	 }
	

		
	deces=new Deces();
	deces=decesService.findDecesByClientcust(newClientAcquereur.getCodeAcquereur());
	
	newClientAcquereur.setDateEnregistrement(new Date());
	
	 }
	
	
	public void updateListMensualite(){	
		
	mensualiteList = new ArrayList<Mensualite>();
	mensualiteList = mensualiteService.findByClientAcquereur(newClientAcquereur);
	
	if(mensualiteList!=null && mensualiteList.size()>0){
		
		addTA = 0;
		
	}else{
		addTA=1;
	}
	
	}
	
	public void addOrUpdateTA(){

		try {
			menuController.goToPageTableauxAmortissementByCA(newClientAcquereur.getCodeAcquereur());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Integer calculMontantTotalCession(Cession cession){
		Integer duree, montant;
		if(cession.getDateFin().getYear()==cession.getDateDebut().getYear()){
		duree = (cession.getDateFin().getMonth() - cession.getDateDebut().getMonth());
		if(duree<0){
			duree=duree*-1;
		}
		if(duree==0){
			duree=1;
		}
		}else{
			Integer annee;
			Integer coef;
			annee=cession.getDateFin().getYear()-cession.getDateDebut().getYear();
			coef=cession.getDateFin().getMonth() - cession.getDateDebut().getMonth();
			duree=coef+(annee*12);
		}
		montant = duree * cession.getMensualite();
		if (montant != null && montant != 0) {
			return montant;
		} else {

			return null;
		}
	}
	private void remplissageList(List <ClientAcqCessionPojo> list ,List<Cession> cessionlist){
		list=new ArrayList<ClientAcqCessionPojo>();
		for(Cession c :cessionlist){
		
			ClientAcqCessionPojo clin = new ClientAcqCessionPojo();
			clin.setCession(c);
			clin.setMontantTotal(calculMontantTotalCession(c));
			
			list.add(clin);
		}
		
		
	}
	
	public Integer calculmensualite(Arrangement arrang) {
		Integer mensualite;
		if((arrang!=null) && (arrang.getNombreMensualite()!=0)){
		mensualite = arrang.getMontantArrieres() / arrang.getNombreMensualite();

		if (mensualite != null) {
			return mensualite;
		} else {
			return null;
		}
		}else{
		return null	;
		}
		}
	public void updateClientAcquereur(){
		  clientAcquereurService.update(newClientAcquereur);
		if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientAcquereur_fr)
					.getString("clientLocataire.modifie.succes"));
		else
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientAcquereur_ar)
					.getString("clientLocataire.modifie.succes"));

		
	}
	public void initClient(){
		newClientAcquereur=new ClientAcquereur();
		
	}
	
	
	public void supprimerClient(){
		newClientAcquereur.setCodeMaj(Constants.clientSupprimeS);
		updateClientAcquereur();
		
	}
	
	
	
	public void trieparGroupe(){
		List<ClientAcquereur> clientAquereurEdition = new ArrayList<ClientAcquereur>();
		clientAquereurEdition = clientAcquereurService.rechercheClientAcQEDITION();
		Groupe lastGroup = new Groupe();
		 lastGroup = null;
		 listpojoEdit = new ArrayList<EditionPojoList>();

		EditionPojoList editionPojoList = new EditionPojoList();
		List<SubReportClientACPOJO> listGroupAcq = new ArrayList<SubReportClientACPOJO>();
		for (ClientAcquereur client : clientAquereurEdition) {
			
		
			
			if(lastGroup==null){
				editionPojoList.setGroupe(client.getGroupe().getLibelle());
				SubReportClientACPOJO subReportClientACPOJO=new SubReportClientACPOJO();
				subReportClientACPOJO.setCodeAcquereur(client.getCodeAcquereur());
				subReportClientACPOJO.setAdresseLoge(client.getLogement().getAdresseLoge());
				subReportClientACPOJO.setCodePostal(client.getLogement().getCodePostal());
				subReportClientACPOJO.setNomPrenomFr(client.getNomPrenomFr());
				subReportClientACPOJO.setGroupe(client.getGroupe().getLibelle());
				if(client.getSolde()!=null){
					subReportClientACPOJO.setSolde(client.getSolde().toString());
					}
				listGroupAcq.add(subReportClientACPOJO);
				lastGroup = new Groupe();
				lastGroup = client.getGroupe();
			}else{
				
				
				if(client.getGroupe().getLibelle().equals(lastGroup.getLibelle())){
					SubReportClientACPOJO subReportClientACPOJO=new SubReportClientACPOJO();
					subReportClientACPOJO.setCodeAcquereur(client.getCodeAcquereur());
					subReportClientACPOJO.setAdresseLoge(client.getLogement().getAdresseLoge());
					subReportClientACPOJO.setCodePostal(client.getLogement().getCodePostal());
					subReportClientACPOJO.setNomPrenomFr(client.getNomPrenomFr());
					subReportClientACPOJO.setGroupe(client.getGroupe().getLibelle());
					if(client.getSolde()!=null){
					subReportClientACPOJO.setSolde(client.getSolde().toString());
					}
					listGroupAcq.add(subReportClientACPOJO);
					
				}else{
					editionPojoList.setListEdition(listGroupAcq);
					listpojoEdit.add(editionPojoList);
					
					 editionPojoList = new EditionPojoList();
					 listGroupAcq = new ArrayList<SubReportClientACPOJO>();
					
					lastGroup = client.getGroupe();
					editionPojoList.setGroupe(lastGroup.getLibelle());
					SubReportClientACPOJO subReportClientACPOJO=new SubReportClientACPOJO();
					subReportClientACPOJO.setCodeAcquereur(client.getCodeAcquereur());
					subReportClientACPOJO.setAdresseLoge(client.getLogement().getAdresseLoge());
					subReportClientACPOJO.setNomPrenomFr(client.getNomPrenomFr());
					subReportClientACPOJO.setCodePostal(client.getLogement().getCodePostal());
					subReportClientACPOJO.setGroupe(client.getGroupe().getLibelle());
					if(client.getSolde()!=null){
						subReportClientACPOJO.setSolde(client.getSolde().toString());
						}
					listGroupAcq.add(subReportClientACPOJO);
				}
			}
			
		}
		editionPojoList.setListEdition(listGroupAcq);
		listpojoEdit.add(editionPojoList);
		
		 editionPojoList = new EditionPojoList();
		 listGroupAcq = new ArrayList<SubReportClientACPOJO>();
		
		

	}
		

	
	
public void imprimerlisteClient(){
	  String subReportFileName = "ClientAcquereur_subreport1.jasper";
      String masterReportFileName = "ClientAcquereur.jasper";
    
      trieparGroupe();
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();
	
		Date sCertDate = (new Date());
		data.put("currentDate", sCertDate);

	       GenerateRapport.exportPDFWithDataSourceSubReport(subReportFileName, masterReportFileName, listpojoEdit,
	    		   data,"clientAC.pdf","listEdition");


    }

	
	

	
//fin zied
	
	public void saveClientAcquereur(){
		
		if(log==0){
			try{
	      selectLogement.setEtatLog(2);
	      logementService.update(selectLogement);
	      setEtat();
		  newClientAcquereur.setLogement(selectLogement);
		  newClientAcquereur.setCodeMaj(Constants.clientModifie);
		  clientAcquereurService.save(newClientAcquereur);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")) {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientAcquereur_fr)
							.getString("client.succes.ajout"));
				} else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientAcquereur_ar)
							.getString("client.succes.ajout"));
				}
			menuController.goToPageModifClientacquereur();
		  }
		  catch (DuplicateKeyException e){
			  JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientAcquereur_fr).
					  getString("client.erreur.existe"));
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			
			try{
			selectLogement.setEtatLog(2);
			logementService.save(selectLogement);
			newClientAcquereur.setLogement(selectLogement);
			setEtat();
			clientAcquereurService.save(newClientAcquereur);}
			  catch (DuplicateKeyException e){
				 JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_clientAcquereur_fr).getString("client.erreur.existe"));
		      }

		}
		
		
	}
	
	

	
	public void setTypeslogements(List<TypeLogement> typeslogements) {
		this.typeslogements = typeslogements;
	}


	public void findlotissementBylocalite(){
		lotissments=lotissementService.findLotissemByLocalite(newLogement.getLocalite());
	}

	public void updateDateFin() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(newClientAcquereur.getDateDebut());
		newClientAcquereur.setDateDebut(new Date(newClientAcquereur
				.getDateDebut().getYear(), newClientAcquereur.getDateDebut()
				.getMonth(), 1));
		c.setTime(newClientAcquereur.getDateDebut());
		
		c.add(Calendar.MONTH, newClientAcquereur.getDureeContrat());
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);

		newClientAcquereur.setDateFin(c.getTime());
		dateFin = format.format(newClientAcquereur.getDateFin());

	}
	
	public void updateDateFinAnnee() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(newClientAcquereur.getDateDebut());
		newClientAcquereur.setDateDebut(new Date(newClientAcquereur
				.getDateDebut().getYear(), newClientAcquereur.getDateDebut()
				.getMonth(), 1));
		c.setTime(newClientAcquereur.getDateDebut());
		c.add(Calendar.YEAR, newClientAcquereur.getDureeContrat());
		c.add(Calendar.MONTH, 1);
		c.add(Calendar.DAY_OF_MONTH, -1);

		newClientAcquereur.setDateFin(c.getTime());
		dateFin = format.format(newClientAcquereur.getDateFin());

	}

	public void initDate() {
		newClientAcquereur.setDateDebut(null);
		newClientAcquereur.setDateFin(null);
		dateFin = null;
	}
	
	public void initSelect(){
		selectClientAcquereur=null;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(
			ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public ClientAcquereur getNewClientAcquereur() {
		return newClientAcquereur;
	}

	public void setNewClientAcquereur(ClientAcquereur newClientAcquereur) {
		this.newClientAcquereur = newClientAcquereur;
	}

	public Boolean getCompteConjoint() {
		return compteConjoint;
	}

	public void setCompteConjoint(Boolean compteConjoint) {
		this.compteConjoint = compteConjoint;
	}

	public ClientAcquereur getSelectClientAcquereur() {
		return selectClientAcquereur;
	}

	public void setSelectClientAcquereur(ClientAcquereur selectClientAcquereur) {
		this.selectClientAcquereur = selectClientAcquereur;
	}

	public int getModifClientAcquereur() {
		return ModifClientAcquereur;
	}

	public void setModifClientAcquereur(int modifClientAcquereur) {
		ModifClientAcquereur = modifClientAcquereur;
	}

	public List<ClientAcquereur> getClientAcquereurs() {
		return clientAcquereurs;
	}

	public void setClientAcquereurs(List<ClientAcquereur> clientAcquereurs) {
		this.clientAcquereurs = clientAcquereurs;
	}

	public Groupe getEmployeur() {
		return Employeur;
	}

	public void setEmployeur(Groupe employeur) {
		Employeur = employeur;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public LogementService getLogementService() {
		return logementService;
	}

	public void setLogementService(LogementService logementService) {
		this.logementService = logementService;
	}

	public List<Logement> getLogements() {
		return logements;
	}

	public void setLogements(List<Logement> logements) {
		this.logements = logements;
	}

	public Logement getNewLogement() {
		return newLogement;
	}

	public void setNewLogement(Logement newLogement) {
		this.newLogement = newLogement;
	}

	public Logement getSelectLogement() {
		return selectLogement;
	}

	public void setSelectLogement(Logement selectLogement) {
		this.selectLogement = selectLogement;
	}

	public Groupe getSelectGroupe() {
		return selectGroupe;
	}

	public void setSelectGroupe(Groupe selectGroupe) {
		this.selectGroupe = selectGroupe;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	

	public GouvernoratService getGouvernoratService() {
		return gouvernoratService;
	}

	public void setGouvernoratService(GouvernoratService gouvernoratService) {
		this.gouvernoratService = gouvernoratService;
	}

	public TypeLogementService getTypeLogementService() {
		return typeLogementService;
	}

	public void setTypeLogementService(TypeLogementService typeLogementService) {
		this.typeLogementService = typeLogementService;
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

	public List<Gouvernorat> getGouvernerats() {
		return gouvernerats;
	}

	public void setGouvernerats(List<Gouvernorat> gouvernerats) {
		this.gouvernerats = gouvernerats;
	}

	public List<Localite> getLocalites() {
		return localites;
	}

	public void setLocalites(List<Localite> localites) {
		this.localites = localites;
	}

	public List<Lotissement> getLotissments() {
		return lotissments;
	}

	public void setLotissments(List<Lotissement> lotissments) {
		this.lotissments = lotissments;
	}


	

	public List<TypeLogement> getTypeslogement() {
		return typeslogements;
	}

	public void setTypeslogement(List<TypeLogement> typeslogements) {
		this.typeslogements = typeslogements;
	}


	public int getLog() {
		return log;
	}


	public void setLog(int log) {
		this.log = log;
	}


	


	public AnneeBudgetaireService getAnneeBudgetaireService() {
		return anneeBudgetaireService;
	}


	public void setAnneeBudgetaireService(
			AnneeBudgetaireService anneeBudgetaireService) {
		this.anneeBudgetaireService = anneeBudgetaireService;
	}


	public List<AnneeBudgetaire> getAnneebudgetaires() {
		return anneebudgetaires;
	}


	public void setAnneebudgetaires(List<AnneeBudgetaire> anneebudgetaires) {
		this.anneebudgetaires = anneebudgetaires;
	}


	public List<Cession> getCessionListPasConj() {
		return cessionListPasConj;
	}


	public void setCessionListPasConj(List<Cession> cessionListPasConj) {
		this.cessionListPasConj = cessionListPasConj;
	}


	public List<Cession> getCessionListConj() {
		return cessionListConj;
	}


	public void setCessionListConj(List<Cession> cessionListConj) {
		this.cessionListConj = cessionListConj;
	}


	public CessionService getCessionService() {
		return cessionService;
	}


	public void setCessionService(CessionService cessionService) {
		this.cessionService = cessionService;
	}


	public List<ClientAcqCessionPojo> getListcessionPasConjPojo() {
		return listcessionPasConjPojo;
	}


	public void setListcessionPasConjPojo(List<ClientAcqCessionPojo> listcessionPasConjPojo) {
		this.listcessionPasConjPojo = listcessionPasConjPojo;
	}


	public List<ClientAcqCessionPojo> getListcessionConjPojo() {
		return listcessionConjPojo;
	}


	public void setListcessionConjPojo(List<ClientAcqCessionPojo> listcessionConjPojo) {
		this.listcessionConjPojo = listcessionConjPojo;
	}


	public ContentieuxService getContentieuxService() {
		return contentieuxService;
	}


	public void setContentieuxService(ContentieuxService contentieuxService) {
		this.contentieuxService = contentieuxService;
	}


	public List<Contentieux> getListCont() {
		return listCont;
	}


	public void setListCont(List<Contentieux> listCont) {
		this.listCont = listCont;
	}


	public Contentieux getContentieuxClient() {
		return contentieuxClient;
	}


	public void setContentieuxClient(Contentieux contentieuxClient) {
		this.contentieuxClient = contentieuxClient;
	}


	public List<Arrangement> getListArrangement() {
		return listArrangement;
	}


	public void setListArrangement(List<Arrangement> listArrangement) {
		this.listArrangement = listArrangement;
	}


	public Arrangement getArrangement() {
		return arrangement;
	}


	public void setArrangement(Arrangement arrangement) {
		this.arrangement = arrangement;
	}


	public ArrangementService getArrangementService() {
		return arrangementService;
	}


	public void setArrangementService(ArrangementService arrangementService) {
		this.arrangementService = arrangementService;
	}


	public DecesService getDecesService() {
		return decesService;
	}


	public void setDecesService(DecesService decesService) {
		this.decesService = decesService;
	}


	public Deces getDeces() {
		return deces;
	}


	public void setDeces(Deces deces) {
		this.deces = deces;
	}


	public MainleveeService getMainleveeService() {
		return mainleveeService;
	}


	public void setMainleveeService(MainleveeService mainleveeService) {
		this.mainleveeService = mainleveeService;
	}


	public MenuController getMenuController() {
		return menuController;
	}


	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}


	public String getVarMenu() {
		return varMenu;
	}


	public void setVarMenu(String varMenu) {
		this.varMenu = varMenu;
	}


	public List<EditionPojoList> getListpojoEdit() {
		return listpojoEdit;
	}


	public void setListpojoEdit(List<EditionPojoList> listpojoEdit) {
		this.listpojoEdit = listpojoEdit;
	}


	public MensualiteService getMensualiteService() {
		return mensualiteService;
	}


	public void setMensualiteService(MensualiteService mensualiteService) {
		this.mensualiteService = mensualiteService;
	}


	public List<Mensualite> getMensualiteList() {
		return mensualiteList;
	}


	public void setMensualiteList(List<Mensualite> mensualiteList) {
		this.mensualiteList = mensualiteList;
	}


	public int getAddTA() {
		return addTA;
	}


	public void setAddTA(int addTA) {
		this.addTA = addTA;
	}
	
	

}
