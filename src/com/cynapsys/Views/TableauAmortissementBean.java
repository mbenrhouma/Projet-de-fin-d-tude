package com.cynapsys.Views;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.Views.controller.MenuController;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.DetailMensualite;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.TableauAmortissement;
import com.cynapsys.pojo.TableauAmortissementImpressionPojo;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.DetailMensualiteService;
import com.cynapsys.service.MensualiteService;
import com.cynapsys.service.TableauAmortissementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;


@ManagedBean(name = "tableauAmortissementBean")
@SessionScoped
public class TableauAmortissementBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value = "#{tableauAmortissementService}")
	private TableauAmortissementService tableauAmortissementService;
	
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	
	@ManagedProperty(value = "#{mensualiteService}")
	private MensualiteService mensualiteService;
	
	
	@ManagedProperty(value = "#{detailMensualiteService}")
	private DetailMensualiteService detailMensualiteService;
	
	@ManagedProperty(value = "#{menuController}")
	private MenuController menuController;
	
	private List<DetailMensualite> tableauAmortissement = new ArrayList<DetailMensualite>();
	private Mensualite newMensualite;
	private  Mensualite selectedMensualite;
	private List<Mensualite> mensualiteList;
	private Integer modifMensualite=0;
	private Integer consultTA=0;
	private Integer disabled;
	private String dateFin;
	private String codeclient;
	private List<ClientAcquereur> clientAcquereurList;
	private TableauAmortissement newTableauAmortissement ;
	private List<TableauAmortissement> tableauAmortissementList;
	private TableauAmortissement selectedTableauAmortissement;
	
	
	private int consulterTAClientAcquereur;
	
	public TableauAmortissementBean() {
	}
	
	
	@PostConstruct
	public void initialisation() {
		
//		clientAcquereurList = clientAcquereurService.findAll();
		consulterTAClientAcquereur=0;
		codeclient="";
		mensualiteList = new ArrayList<Mensualite>();
		newTableauAmortissement = new TableauAmortissement();
		newMensualite = new Mensualite();
		tableauAmortissementList = new ArrayList<TableauAmortissement>();
		tableauAmortissementList = tableauAmortissementService.findAmortissementActif();
		disabled=0;
		consultTA=0;
		selectedTableauAmortissement = null;
	}
	
	public void annuler(){
		try {
			consulterTAClientAcquereur=0;
			menuController.goToPageModifClientacquereur();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initDate() {
		newMensualite.setDateDebut(null);
		newMensualite.setDateFin(null);
		dateFin = null;
	}
	
	public void updateDateFin() {
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c2.setTime(newMensualite.getDateDebut());
		newMensualite.setDateDebut(
				new Date(newMensualite.getDateDebut().getYear(), newMensualite.getDateDebut().getMonth(), 1));
		c.setTime(newMensualite.getDateDebut());
		c.add(Calendar.YEAR, newMensualite.getDuree());
		c.add(Calendar.DAY_OF_MONTH, -1);

		newMensualite.setDateFin(c.getTime());
		dateFin = format.format(newMensualite.getDateFin());

	}
	
	public void onselectMensualite(){
		modifMensualite = 1 ;
		newMensualite = selectedMensualite;
		selectedMensualite = new Mensualite();
	}
	
	public void validTableauAmortissement(){
		ClientAcquereur clientAcquereur = new ClientAcquereur();
		clientAcquereur = clientAcquereurService.findById(codeclient);
		newTableauAmortissement.setClientAcquereur(clientAcquereur);
		disabled=1;
	}
	
	public void addMensualite(){
		if(modifMensualite==0){
			
			if(mensualiteList.size()==0){
				newMensualite.setId(1);
			}else{
				
				int id = 0;
				for (Mensualite mensualite : mensualiteList) {
					if(mensualite.getId()>id){
						id=mensualite.getId();
					}
				}
					newMensualite.setId(id+1);
			}
			mensualiteList.add(newMensualite);
			newMensualite = new Mensualite();
			modifMensualite=0;
		}else{
			
			for (Mensualite mensualite : mensualiteList) {
				if(mensualite.getId()==newMensualite.getId() ){
					mensualite=newMensualite;
					newMensualite = new Mensualite();
					modifMensualite=0;
				}
			}
			
			
		}
	
	}
	
	public void initMensualite(){
		newMensualite = new Mensualite();
		modifMensualite = 0;
		
	}


	
	public void imprimeTA(){
		
		String report = "ta.jasper";
		String subReport="ta_sub.jasper";
		List<String> tauxList =new ArrayList<String>();
		List<TableauAmortissementImpressionPojo> taListModele = new ArrayList<TableauAmortissementImpressionPojo>();
		TableauAmortissementImpressionPojo taModele =new TableauAmortissementImpressionPojo();
		
		ClientAcquereur clientAcquereur = clientAcquereurService.findById(String.valueOf(newTableauAmortissement.getClientAcquereur().getCodeAcquereur()));
		
		taModele.setAcquereur(clientAcquereur.getNomPrenomFr());
		taModele.setAvance(String.valueOf(clientAcquereur.getAvance()));
		taModele.setCode(String.valueOf(clientAcquereur.getCodeAcquereur()));
		taModele.setDuree(String.valueOf(newTableauAmortissement.getDuree()));
		
		taModele.setGroupe(String.valueOf(clientAcquereur.getGroupe().getCode())+"-"+String.valueOf(clientAcquereur.getGroupe().getLibelle()));
		if(clientAcquereur.getLogement()!=null){
			taModele.setCite(clientAcquereur.getLogement().getAdresseLoge());
			taModele.setLocalite(String.valueOf(clientAcquereur.getLogement().getLocalite().getLibelleFr()));
			taModele.setLotissement(String.valueOf(clientAcquereur.getLogement().getLotissement().getLibelleFr()));
			taModele.setNumLog(String.valueOf(clientAcquereur.getLogement().getCodeLogement()));
			taModele.setOrdre(String.valueOf(clientAcquereur.getLogement().getNumOrdre()));
			taModele.setTypeLog(String.valueOf(clientAcquereur.getLogement().getTypeLogement().getLibelle()));
		}
		int countTaux = 1;
		for (Mensualite mensualite : mensualiteList) {
			String taux="Taux"+countTaux+":  "+mensualite.getTaux();
			tauxList.add(taux);
			countTaux++;
			
		}
		taModele.setTauxList(tauxList);
		
		if(newTableauAmortissement.getClientAcquereur().getPrix()!=null){
			taModele.setPrix(String.valueOf(clientAcquereur.getPrix()));
		}else{
			taModele.setPrix(String.valueOf(clientAcquereur.getPrixProvisoire()));
		}
		
		taModele.setListM(tableauAmortissement);
		
		taListModele.add(taModele);
		
		Map<String, Object> params = new HashMap<String, Object>();
		GenerateRapport.exportPDFWithDataSourceSubReport(subReport, report, taListModele, params, "ta_"+newTableauAmortissement.getClientAcquereur().getCodeAcquereur(), "listM");
		
	}
	
	
	public void saveTableauAmortissementBean() {
		try {
			
		List<TableauAmortissement> taList = new ArrayList<TableauAmortissement>();
		newTableauAmortissement.setEtat(1);
		taList = tableauAmortissementService.findAmortissementClientAcquereur(newTableauAmortissement.getClientAcquereur());
		for (TableauAmortissement ta : taList) {
			ta.setEtat(0);
			//ta.setDateAnnulation(dateAnnulation);

			tableauAmortissementService.update(ta);
			
		}
		TableauAmortissement tableauAmortissementSave=	(TableauAmortissement) tableauAmortissementService.save(newTableauAmortissement);
		
		
		for (Mensualite mensualite : mensualiteList) {
			mensualite.setId(null);
			mensualite.setTableauAmortissement(tableauAmortissementSave);
			Mensualite mensual =(Mensualite) mensualiteService.save(mensualite);
			for (DetailMensualite detailMens : tableauAmortissement) {
				if(detailMens.getMensualite().getDateDebut().equals(mensual.getDateDebut())){
					detailMens.setId(null);
					detailMens.setMensualite(mensual);
					detailMensualiteService.save(detailMens);
					
				}
			}
			
		}

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
							.getString("ta.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
							.getString("ta.cree.succes"));
				}

				try {
					
					if(consulterTAClientAcquereur==0){
						menuController.goToPageTableauxAmortissement();

					}else{
						menuController.goToPageModifClientacquereurByTA();

					}
					
					

				} catch (IOException e) {
					e.printStackTrace();
				}	
				
		} catch (DuplicateKeyException e) {


				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
							.getString("ta.error.existe"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
							.getString("ta.error.existe"));
				}
		}
	}
	
	
	
	public void onselectTA(){

		newTableauAmortissement = selectedTableauAmortissement;
		consultTA = 1;
		codeclient=newTableauAmortissement.getClientAcquereur().getCodeAcquereur();
		mensualiteList = mensualiteService.findByTa(newTableauAmortissement);
	
	}
	
	
	@SuppressWarnings("deprecation")
	public void calculTableauAmortissement(){
		
		
		
		//List Mensualite vide
		if(mensualiteList==null || mensualiteList.size()==0){
			
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
						.getString("amortissement.errormsg.listvide"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
						.getString("amortissement.errormsg.listvide"));
			}
			
			return;
			
		}
		
		
		int sommeDuree =0;
		boolean valid = false;
		
		for (Mensualite mensual : mensualiteList) {
			sommeDuree = sommeDuree+mensual.getDuree();
			
			if(newTableauAmortissement.getDateEffet().getMonth()==mensual.getDateDebut().getMonth()
					&& newTableauAmortissement.getDateEffet().getYear()==mensual.getDateDebut().getYear()){
				
				valid=true;
				
			}
			
			for (Mensualite mensualite : mensualiteList) {
				
				if(mensual.getId()!=mensualite.getId()){
					if(!mensual.getDateDebut().before(mensualite.getDateDebut()) 
							&& !mensual.getDateDebut().after(mensualite.getDateFin())){
						
						//msg erreur
						
						if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
							JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
									.getString("amortissement.errormsg.chevauchement"));
						else {
							JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
									.getString("amortissement.errormsg.chevauchement"));
						}
						
						
						return;
						
					}
					
					if(!mensual.getDateFin().before(mensualite.getDateDebut()) 
							&& !mensual.getDateFin().after(mensualite.getDateFin())){
						
						
						
						if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
							JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
									.getString("amortissement.errormsg.chevauchement"));
						else {
							JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
									.getString("amortissement.errormsg.chevauchement"));
						}
						
						
						return;
						
					}
				}
				
			}
			
			
		}
		
		
		if(sommeDuree!=newTableauAmortissement.getDuree()){
			
			
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
						.getString("amortissement.errormsg.durre"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
						.getString("amortissement.errormsg.durre"));
			}
			
			return;
		}

		
		if(valid==false){
			
			
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_fr)
						.getString("ta.errorDatedebDateEffet"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_tableauxAmortissement_ar)
						.getString("ta.errorDatedebDateEffet"));
			}
			
			
			return;
		}
		
		
		
		Integer prix;
		
		if(newTableauAmortissement.getClientAcquereur().getPrix()!=null &&
				newTableauAmortissement.getClientAcquereur().getPrix()!=0){
			prix= newTableauAmortissement.getClientAcquereur().getPrix();
		}else{
			prix=newTableauAmortissement.getClientAcquereur().getPrixProvisoire();	
		}
		
		Integer avance = newTableauAmortissement.getClientAcquereur().getAvance();
		Integer restantDu =  prix - avance;
		
		Integer taxAssurance = newTableauAmortissement.getTaxAssurance();
		Integer assuranceAnnuelle = newTableauAmortissement.getAssuranceAnnuelle();
		
		Integer taxMensuelle = taxAssurance/Constants.nbreMoins;
		Integer assuranceMensuelle =  assuranceAnnuelle/Constants.nbreMoins;
		
		tableauAmortissement = new ArrayList<DetailMensualite>();
		int id=1;
		
		Integer dureRestant=newTableauAmortissement.getDuree();
		
		for (Mensualite mensualite : mensualiteList) {
			
			if(mensualite.getFixe()!=1){
				
				Integer interer = mensualite.getTaux().intValue();
				//newTableauAmortissement.get
				//duree dureRestant
				//Integer duree =  mensualite.getDuree();
				Integer duree =dureRestant;
				Integer mensualiteDeterminer;
				if(interer!=0){
					double interetPourcentage = Double.valueOf(interer)/100;
					Double mensualiteDouble = ((restantDu*(interetPourcentage))/(1-Math.pow(1+(interetPourcentage),0-duree)))/12;
					 mensualiteDeterminer = (int) Math.round(mensualiteDouble)+taxMensuelle+assuranceMensuelle;
				}else{
					mensualiteDeterminer = (restantDu/(duree*12))+taxMensuelle+assuranceMensuelle;
				}

				
				mensualite.setMensualite(mensualiteDeterminer);
			}
			
			
			DetailMensualite detailTa = new DetailMensualite();
			detailTa.setId(id);
			
			int nbrMoisDeb = mensualite.getDateDebut().getMonth()+1;
			int nbrMoiRestant = Constants.nbreMoins - nbrMoisDeb+1;
			
			
			detailTa.setDateDeb(
					new Date(mensualite.getDateDebut().getYear(), mensualite.getDateDebut().getMonth(), 1));
			detailTa.setDateFin(
					new Date(mensualite.getDateDebut().getYear(), 11,Constants.nbrJoursDecembre));
			
			Integer taxAssu = (taxAssurance*nbrMoiRestant)/Constants.nbreMoins;
			Integer assuAnnu = (assuranceAnnuelle*nbrMoiRestant)/Constants.nbreMoins;

				
				Integer mensual = mensualite.getMensualite() -taxMensuelle -assuranceMensuelle;
				Integer annuite = mensual*nbrMoiRestant;
				Integer interetMensuelle = (restantDu*mensualite.getTaux().intValue())/100;
				
				
				detailTa.setMensualiteDef(mensualite.getMensualite());
				detailTa.setCapitalRestantDu(restantDu);
				detailTa.setTaxeAssurance(taxAssu);
				detailTa.setAssuranceAnnuelle(assuAnnu);
				detailTa.setMontantMens(mensual);
				detailTa.setAnnuite(annuite);
				detailTa.setInteret((interetMensuelle*nbrMoiRestant)/12);
				detailTa.setAmortissement(annuite-detailTa.getInteret());
				
				restantDu = restantDu- (int) detailTa.getAmortissement();
				detailTa.setMensualite(mensualite);
				tableauAmortissement.add(detailTa);
				
				for(int i =1 ; i<mensualite.getDuree();i++){
					detailTa = new DetailMensualite();
					
					detailTa.setDateDeb(
							new Date(mensualite.getDateDebut().getYear()+i, 0, 1));
					detailTa.setDateFin(
							new Date(mensualite.getDateDebut().getYear()+i, 11,Constants.nbrJoursDecembre));
					detailTa.setMensualiteDef(mensualite.getMensualite());
					detailTa.setCapitalRestantDu(restantDu);
					
					detailTa.setTaxeAssurance(taxAssurance);
					detailTa.setAssuranceAnnuelle(assuranceAnnuelle);
					
					detailTa.setMontantMens(mensual);
					detailTa.setAnnuite(mensual*Constants.nbreMoins);
					
					interetMensuelle = (restantDu*mensualite.getTaux().intValue())/100;
					detailTa.setInteret(interetMensuelle);
					detailTa.setAmortissement(detailTa.getAnnuite()-detailTa.getInteret());
					
					restantDu = restantDu- (int) detailTa.getAmortissement();
					detailTa.setMensualite(mensualite);
					tableauAmortissement.add(detailTa);
				}
				
				if(nbrMoisDeb!=1){
					detailTa = new DetailMensualite();
					
					detailTa.setDateDeb(
							new Date(mensualite.getDateFin().getYear(), 0, 1));
					detailTa.setDateFin(mensualite.getDateFin());
					detailTa.setMensualiteDef(mensualite.getMensualite());
					detailTa.setCapitalRestantDu(restantDu);
					int nbrMonth = mensualite.getDateFin().getMonth()+1;
					
					detailTa.setTaxeAssurance((taxAssurance * nbrMonth)/Constants.nbreMoins);
					detailTa.setAssuranceAnnuelle((assuranceAnnuelle* nbrMonth)/Constants.nbreMoins);
					
					detailTa.setMontantMens(mensual);
					detailTa.setAnnuite(mensual*nbrMonth);
					interetMensuelle = (restantDu*mensualite.getTaux().intValue())/100;
					detailTa.setInteret((interetMensuelle*nbrMonth)/12);
					
					//a voir !!!!
					int yearFin = newTableauAmortissement.getDateEffet().getYear()+newTableauAmortissement.getDuree();
					if(mensualite.getDateFin().getYear()==yearFin){
						detailTa.setInteret(interetMensuelle);
						
					}
					
					detailTa.setAmortissement(detailTa.getAnnuite()-detailTa.getInteret());
					restantDu = restantDu- (int) detailTa.getAmortissement();
					detailTa.setMensualite(mensualite);
					tableauAmortissement.add(detailTa);
					
				}
				dureRestant = dureRestant-mensualite.getDuree();
				id++;
		}
		
		MenuController menuController = (MenuController) FacesContext
				.getCurrentInstance()
				.getApplication()
				.evaluateExpressionGet(
						FacesContext.getCurrentInstance(),
						"#{menuController}",
						MenuController.class);
		try {
			menuController.goToPageDetailTA();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		return "/views/pageAccueil/pageAccueil.xhtml";	
	}

	


	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}


	public void setClientAcquereurService(
			ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}


	public List<ClientAcquereur> getClientAcquereurList() {
		return clientAcquereurList;
	}


	public void setClientAcquereurList(List<ClientAcquereur> clientAcquereurList) {
		this.clientAcquereurList = clientAcquereurList;
	}


	public TableauAmortissement getNewTableauAmortissement() {
		return newTableauAmortissement;
	}


	public void setNewTableauAmortissement(
			TableauAmortissement newTableauAmortissement) {
		this.newTableauAmortissement = newTableauAmortissement;
	}


	public MensualiteService getMensualiteService() {
		return mensualiteService;
	}


	public void setMensualiteService(MensualiteService mensualiteService) {
		this.mensualiteService = mensualiteService;
	}


	public Mensualite getNewMensualite() {
		return newMensualite;
	}


	public void setNewMensualite(Mensualite newMensualite) {
		this.newMensualite = newMensualite;
	}


	public List<Mensualite> getMensualiteList() {
		return mensualiteList;
	}


	public void setMensualiteList(List<Mensualite> mensualiteList) {
		this.mensualiteList = mensualiteList;
	}


	public Integer getModifMensualite() {
		return modifMensualite;
	}


	public void setModifMensualite(Integer modifMensualite) {
		this.modifMensualite = modifMensualite;
	}


	public Mensualite getSelectedMensualite() {
		return selectedMensualite;
	}


	public void setSelectedMensualite(Mensualite selectedMensualite) {
		this.selectedMensualite = selectedMensualite;
	}


	public Integer getDisabled() {
		return disabled;
	}


	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public List<DetailMensualite> getTableauAmortissement() {
		return tableauAmortissement;
	}


	public void setTableauAmortissement(
			List<DetailMensualite> tableauAmortissement) {
		this.tableauAmortissement = tableauAmortissement;
	}


	public TableauAmortissementService getTableauAmortissementService() {
		return tableauAmortissementService;
	}


	public void setTableauAmortissementService(
			TableauAmortissementService tableauAmortissementService) {
		this.tableauAmortissementService = tableauAmortissementService;
	}


	public DetailMensualiteService getDetailMensualiteService() {
		return detailMensualiteService;
	}


	public void setDetailMensualiteService(
			DetailMensualiteService detailMensualiteService) {
		this.detailMensualiteService = detailMensualiteService;
	}


	public List<TableauAmortissement> getTableauAmortissementList() {
		return tableauAmortissementList;
	}


	public void setTableauAmortissementList(
			List<TableauAmortissement> tableauAmortissementList) {
		this.tableauAmortissementList = tableauAmortissementList;
	}


	public TableauAmortissement getSelectedTableauAmortissement() {
		return selectedTableauAmortissement;
	}


	public void setSelectedTableauAmortissement(
			TableauAmortissement selectedTableauAmortissement) {
		this.selectedTableauAmortissement = selectedTableauAmortissement;
	}


	public Integer getConsultTA() {
		return consultTA;
	}


	public void setConsultTA(Integer consultTA) {
		this.consultTA = consultTA;
	}


	public String getCodeclient() {
		return codeclient;
	}


	public void setCodeclient(String codeclient) {
		this.codeclient = codeclient;
	}


	public int getConsulterTAClientAcquereur() {
		return consulterTAClientAcquereur;
	}


	public void setConsulterTAClientAcquereur(int consulterTAClientAcquereur) {
		this.consulterTAClientAcquereur = consulterTAClientAcquereur;
	}


	public MenuController getMenuController() {
		return menuController;
	}


	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}

	
	
}
