package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.CompteAttente;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.entities.Quitance;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.CompteAttenteService;
import com.cynapsys.service.MouvementService;
import com.cynapsys.service.QuitanceService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "apurementBean")
@SessionScoped
public class ApurementBean implements Serializable {
	@ManagedProperty(value = "#{compteAttenteService}")
	private CompteAttenteService compteAttenteService;
	@ManagedProperty(value = "#{quitanceService}")
	private QuitanceService quitanceService;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	@ManagedProperty(value = "#{mouvementService}")
	private MouvementService mouvementService;

	private static final long serialVersionUID = 1L;

	private List<CompteAttente> listCompteAttente;
	private CompteAttente compteAttente;

	// recherche
	private Integer montantQuittanceRecheche;
	private String numQuittancerecherche;
	private Date dateversemenDe;
	private Date dateversemenA;
	private Date dateVersement;
	private String numCompteDattenterecherche;
	// fin recherche

	private List<Quitance> listQuittance;
	private Quitance selectQuittance;
	private ClientAcquereur clientAq;
	private List<ClientAcquereur>listClientAquereur;
	private Integer etatQuittance;

	public ApurementBean() {
		
	}

	@PostConstruct
	public void initialisation() {
		listClientAquereur=new ArrayList<ClientAcquereur>();
		listClientAquereur=clientAcquereurService.findDTA();
		listQuittance = new ArrayList<Quitance>();
		listQuittance = quitanceService.findDTA();
		compteAttente = new CompteAttente();

	}

	public void initRecheche() {
		montantQuittanceRecheche = null;
		numQuittancerecherche = null;
		dateversemenDe = null;
		dateversemenA = null;
		numCompteDattenterecherche = null;
		dateVersement = null;
		etatQuittance=null;
		selectQuittance=null;
		initialisation();

	}
	public void declassequittance(){
		
		Mouvement newMouvement=new Mouvement();
		newMouvement.setClientAcquereur(clientAq);
		newMouvement.setQuitance(selectQuittance);
		newMouvement.setDateMv(new Date());
		mouvementService.save(newMouvement);
		selectQuittance.setEtatQuitance(Constants.etatQuittanceDeclass);
		quitanceService.update(selectQuittance);
		listQuittance = new ArrayList<Quitance>();
		listQuittance = quitanceService.findDTA();
		
		if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_apurement_fr)
					.getString("apurement.operationDeDeclassement"));
		else {
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_apurement_ar)
					.getString("apurement.operationDeDeclassement"));
		}
		
	
		
		
		
		
	}
	
	public void initClientAq(){
		clientAq=new ClientAcquereur();
	}

	public void rechercheAvance() {
		listQuittance = new ArrayList<Quitance>();
		listQuittance = quitanceService.rechercheAv(montantQuittanceRecheche, numQuittancerecherche, dateversemenDe,
				dateversemenA, numCompteDattenterecherche, dateVersement,etatQuittance);
	}

	

	public CompteAttenteService getCompteAttenteService() {
		return compteAttenteService;
	}

	public void setCompteAttenteService(CompteAttenteService compteAttenteService) {
		this.compteAttenteService = compteAttenteService;
	}

	public List<CompteAttente> getListCompteAttente() {
		return listCompteAttente;
	}

	public void setListCompteAttente(List<CompteAttente> listCompteAttente) {
		this.listCompteAttente = listCompteAttente;
	}

	public CompteAttente getCompteAttente() {
		return compteAttente;
	}

	public void setCompteAttente(CompteAttente compteAttente) {
		this.compteAttente = compteAttente;
	}

	public Integer getMontantQuittanceRecheche() {
		return montantQuittanceRecheche;
	}

	public void setMontantQuittanceRecheche(Integer montantQuittanceRecheche) {
		this.montantQuittanceRecheche = montantQuittanceRecheche;
	}

	public String getNumQuittancerecherche() {
		return numQuittancerecherche;
	}

	public void setNumQuittancerecherche(String numQuittancerecherche) {
		this.numQuittancerecherche = numQuittancerecherche;
	}

	public Date getDateversemenDe() {
		return dateversemenDe;
	}

	public void setDateversemenDe(Date dateversemenDe) {
		this.dateversemenDe = dateversemenDe;
	}

	public Date getDateversemenA() {
		return dateversemenA;
	}

	public void setDateversemenA(Date dateversemenA) {
		this.dateversemenA = dateversemenA;
	}

	public String getNumCompteDattenterecherche() {
		return numCompteDattenterecherche;
	}

	public void setNumCompteDattenterecherche(String numCompteDattenterecherche) {
		this.numCompteDattenterecherche = numCompteDattenterecherche;
	}

	public Date getDateVersement() {
		return dateVersement;
	}

	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}

	public QuitanceService getQuitanceService() {
		return quitanceService;
	}

	public void setQuitanceService(QuitanceService quitanceService) {
		this.quitanceService = quitanceService;
	}

	public List<Quitance> getListQuittance() {
		return listQuittance;
	}

	public void setListQuittance(List<Quitance> listQuittance) {
		this.listQuittance = listQuittance;
	}

	public Quitance getSelectQuittance() {
		return selectQuittance;
	}

	public void setSelectQuittance(Quitance selectQuittance) {
		this.selectQuittance = selectQuittance;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public ClientAcquereur getClientAq() {
		return clientAq;
	}

	public void setClientAq(ClientAcquereur clientAq) {
		this.clientAq = clientAq;
	}

	public List<ClientAcquereur> getListClientAquereur() {
		return listClientAquereur;
	}

	public void setListClientAquereur(List<ClientAcquereur> listClientAquereur) {
		this.listClientAquereur = listClientAquereur;
	}

	public Integer getEtatQuittance() {
		return etatQuittance;
	}

	public void setEtatQuittance(Integer etatQuittance) {
		this.etatQuittance = etatQuittance;
	}

	public MouvementService getMouvementService() {
		return mouvementService;
	}

	public void setMouvementService(MouvementService mouvementService) {
		this.mouvementService = mouvementService;
	}

}
