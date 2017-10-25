package com.cynapsys.Views;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.DetailMensualite;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.entities.TableauAmortissement;
import com.cynapsys.pojo.TableauListePojo;
import com.cynapsys.pojo.TableauSoldeClientPOJO;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.DetailMensualiteService;
import com.cynapsys.service.MensualiteService;
import com.cynapsys.service.MouvementService;
import com.cynapsys.service.TableauAmortissementService;
import com.cynapsys.utils.GenerateRapport;

@ManagedBean(name = "tablSoldesClientBean")
@ViewScoped
public class TablSoldesClientBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	@ManagedProperty(value = "#{tableauAmortissementService}")
	private TableauAmortissementService tableauAmortissementService;
	@ManagedProperty(value = "#{mensualiteService}")
	private MensualiteService mensualiteService;
	@ManagedProperty(value = "#{detailMensualiteService}")
	private DetailMensualiteService detailMensualiteService;
	@ManagedProperty(value = "#{mouvementService}")
	private MouvementService mouvementService;
	
	
	
	private List<ClientAcquereur> listClientAcquereur;
	private ClientAcquereur newClientAcquereur;
	private Date dateArret;
	private Date dateArretmoin1;
	private List<TableauSoldeClientPOJO> listTableauSoldeClientPOJO;
	private TableauSoldeClientPOJO selectTableauSoldeClientPOJO;
	
	public TablSoldesClientBean() {
	}
	@PostConstruct
	public void initialisation() {
		listClientAcquereur=new ArrayList<ClientAcquereur>();
		listClientAcquereur=clientAcquereurService.findDTA();
	}
	
	
public void rechercher(){
	Integer index=1;
	listTableauSoldeClientPOJO= new ArrayList<TableauSoldeClientPOJO>();
	
	for(ClientAcquereur client :listClientAcquereur ){
		TableauSoldeClientPOJO  soldeClient=new TableauSoldeClientPOJO();
		soldeClient.setId(index);
		soldeClient.setCodeClient(client.getCodeAcquereur().toString());
		soldeClient.setNometPrenom(client.getNomPrenomFr());
		soldeClient.setGroupeClient(client.getGroupe().getLibelle());
		soldeClient.setPrix(client.getPrix().toString());
		soldeClient.setAvance(client.getAvance().toString());
		soldeClient.setDateDebut(client.getDateDebut().toString());
		soldeClient.setDateFin(client.getDateFin().toString());
		soldeClient.setMensualite(calculMensualite(client));
		soldeClient.setEcheancesAu(calculEcheanceAu(client,dateArretmoin1));
		soldeClient.setEcheancesDe(calculEcheanceDe(client, dateArret));
		soldeClient.setNoteDebitDEbit(calculNoteDebit(client,dateArret));
		soldeClient.setNoteDebitCredit(calculNoteDebitCredit(client, dateArret));
		soldeClient.setRecetteAu(calculrecetteAu(client, dateArretmoin1));
		soldeClient.setRecetteDe(calculRecetteDe(client, dateArret));
		soldeClient.setSoldeClientAu(CalculSoldeClient(soldeClient));
		listTableauSoldeClientPOJO.add(soldeClient);
		index=index+1;
	}
}



	public String calculMensualite(ClientAcquereur client) {
		Integer mensDef = 0;
		TableauAmortissement tab = new TableauAmortissement();
		tab = tableauAmortissementService.findByClientEtat(client);

		List<Mensualite> listMens = new ArrayList<Mensualite>();
		if (tab!=null){
		listMens = mensualiteService.findByTabAm(tab);

		for (Mensualite mens : listMens) {
			List<DetailMensualite> listdet = new ArrayList<DetailMensualite>();
			listdet = detailMensualiteService.findbyMensualite(mens);

			for (DetailMensualite detail : listdet) {
				mensDef = mensDef + detail.getMensualiteDef();
			}

		}
		}
		return mensDef.toString();

	}
	public String calculEcheanceAu(ClientAcquereur client,Date  date) {
		Integer echeanceAu = 0;
		TableauAmortissement tab = new TableauAmortissement();
		tab = tableauAmortissementService.findByClientEtat(client);
		if (tab!=null){
		List<Mensualite> listMens = new ArrayList<Mensualite>();
		listMens = mensualiteService.findByTabAm(tab);
		if(listMens!=null){
		for (Mensualite mens : listMens) {
			List<DetailMensualite> listdet = new ArrayList<DetailMensualite>();
			listdet = detailMensualiteService.findbymensDateAu(mens, date);
			if(listdet!=null){
			for (DetailMensualite detail : listdet) {
				echeanceAu = echeanceAu + detail.getMensualiteDef();
			}}
		
		}}
		}
		return echeanceAu.toString();

	}
	public String calculEcheanceDe(ClientAcquereur client,Date  date) {
		Integer echeanceDe = 0;
		TableauAmortissement tab = new TableauAmortissement();
		tab = tableauAmortissementService.findByClientEtat(client);
		if (tab!=null){

		List<Mensualite> listMens = new ArrayList<Mensualite>();
		listMens = mensualiteService.findByTabAm(tab);
		if (listMens!=null){
		for (Mensualite mens : listMens) {
			List<DetailMensualite> listdet = new ArrayList<DetailMensualite>();
			listdet = detailMensualiteService.findbymensDateDe(mens, date);
			if (listdet!=null){
			for (DetailMensualite detail : listdet) {
				echeanceDe = echeanceDe + detail.getMensualiteDef();
			}
			}
		}
		}}
		return echeanceDe.toString();

	}
	
	
	public String calculNoteDebit(ClientAcquereur client,Date date){
		Integer notedebit = 0;
		List <Mouvement> listDebit=new ArrayList<Mouvement>();
		listDebit=mouvementService.findByClient(client, date);
		if(listDebit!=null){
		for(Mouvement mouv: listDebit){
			if (mouv.getMontantDebit()!=null){
			notedebit=notedebit+mouv.getMontantDebit();
			}
		}
		
		
		
		}
		return notedebit.toString();

}
	
	public String calculNoteDebitCredit(ClientAcquereur client,Date date){
		Integer montantCredit = 0;
		List <Mouvement> listDebit=new ArrayList<Mouvement>();
		listDebit=mouvementService.findByClient(client, date);
		if(listDebit!=null){
		for(Mouvement mouv: listDebit){
			if(mouv.getMontantCredit()!=null){
			montantCredit=montantCredit+mouv.getMontantCredit();
			}
		}
		
		
		}
		
		return montantCredit.toString();

			
}
	
	
	
public String calculrecetteAu(ClientAcquereur client,Date date){
	Integer recette=0;
	Integer notedebit = 0;
	Integer montantCredit = 0;
	List <Mouvement> listDebit=new ArrayList<Mouvement>();

	listDebit=mouvementService.findByClientAu(client, date);
	if(listDebit!=null){
	for(Mouvement mouv: listDebit){
		if (mouv.getMontantCredit()!=null){
		montantCredit=montantCredit+mouv.getMontantCredit();
		}
		if (mouv.getMontantDebit()!=null){
		notedebit=notedebit+mouv.getMontantDebit();
	}}
	
	recette=montantCredit-notedebit;
	}
	
	return recette.toString();

	
}
	
public String calculRecetteDe(ClientAcquereur client,Date date)	{
	Integer recette=0;
	Integer notedebit = 0;
	Integer montantCredit = 0;
	notedebit=Integer.parseInt(calculNoteDebit(client, date));
	montantCredit=Integer.parseInt(calculNoteDebitCredit(client,date));
	if((notedebit!=null)&&(montantCredit!=null)){
	recette=notedebit+montantCredit;
	}
	return recette.toString();
}
	
	
	
	
	
	
	
	public void updateDateFin() {

		Calendar c = Calendar.getInstance();
		dateArretmoin1 = new Date(dateArret.getYear(), 12, 31);
		c.setTime(dateArretmoin1);
		c.add(Calendar.YEAR, -1);
		dateArretmoin1 = (c.getTime());

	}
	
	
	
	public String CalculSoldeClient(TableauSoldeClientPOJO tab){
					
		Integer recette=0;
		if (tab!=null){
			
		recette=(Integer.parseInt(tab.getEcheancesAu())+Integer.parseInt(tab.getEcheancesDe())+Integer.parseInt(tab.getNoteDebitDEbit()))
				-(Integer.parseInt(tab.getNoteDebitCredit())+Integer.parseInt(tab.getRecetteAu())+Integer.parseInt(tab.getRecetteDe()));
		
		}
		return recette.toString();

	}
	
	
	
	
	
	
	
	
	
	
	public void imprimerTableauDesSolesClients() {
        String subReportFileName = "tableSoldesClients_subreport1.jasper";
        String masterReportFileName = "tableSoldesClients.jasper";
        TableauListePojo tab=new TableauListePojo();
        tab.setListTableauSoldeClientPOJO(listTableauSoldeClientPOJO);
        List<TableauListePojo> listPojo=new ArrayList<TableauListePojo>();
        listPojo.add(tab);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();

		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();
		String tabSoldeClient="tableauSoldeClient" ;
		tabSoldeClient=tabSoldeClient.concat(dateArret.toString());

	       GenerateRapport.exportPDFWithDataSourceSubReport(subReportFileName, masterReportFileName, listPojo,
	    		   data,"tabSoldeClient.pdf","listTableauSoldeClientPOJO");


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
	public Date getDateArret() {
		return dateArret;
	}
	public void setDateArret(Date dateArret) {
		this.dateArret = dateArret;
	}
	public List<TableauSoldeClientPOJO> getListTableauSoldeClientPOJO() {
		return listTableauSoldeClientPOJO;
	}
	public void setListTableauSoldeClientPOJO(List<TableauSoldeClientPOJO> listTableauSoldeClientPOJO) {
		this.listTableauSoldeClientPOJO = listTableauSoldeClientPOJO;
	}
	public TableauAmortissementService getTableauAmortissementService() {
		return tableauAmortissementService;
	}
	public void setTableauAmortissementService(TableauAmortissementService tableauAmortissementService) {
		this.tableauAmortissementService = tableauAmortissementService;
	}
	public MensualiteService getMensualiteService() {
		return mensualiteService;
	}
	public void setMensualiteService(MensualiteService mensualiteService) {
		this.mensualiteService = mensualiteService;
	}
	public DetailMensualiteService getDetailMensualiteService() {
		return detailMensualiteService;
	}
	public void setDetailMensualiteService(DetailMensualiteService detailMensualiteService) {
		this.detailMensualiteService = detailMensualiteService;
	}
	public MouvementService getMouvementService() {
		return mouvementService;
	}
	public void setMouvementService(MouvementService mouvementService) {
		this.mouvementService = mouvementService;
	}
	public Date getDateArretmoin1() {
		return dateArretmoin1;
	}
	public void setDateArretmoin1(Date dateArretmoin1) {
		this.dateArretmoin1 = dateArretmoin1;
	}
	public TableauSoldeClientPOJO getSelectTableauSoldeClientPOJO() {
		return selectTableauSoldeClientPOJO;
	}
	public void setSelectTableauSoldeClientPOJO(TableauSoldeClientPOJO selectTableauSoldeClientPOJO) {
		this.selectTableauSoldeClientPOJO = selectTableauSoldeClientPOJO;
	}

}
