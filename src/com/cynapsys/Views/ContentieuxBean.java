package com.cynapsys.Views;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Contentieux;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.Impayee;
import com.cynapsys.entities.Precontentieu;
import com.cynapsys.service.ContentieuxService;
import com.cynapsys.service.GroupeService;
import com.cynapsys.service.PrecontentieuService;
import com.cynapsys.utils.JsfUtil;



@ManagedBean(name = "contentieuxBean")
@ViewScoped
public class ContentieuxBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty(value = "#{precontentieuService}")
	private PrecontentieuService precontentieuService;
	
	
	@ManagedProperty(value = "#{contentieuxService}")
	private ContentieuxService contentieuxService;
	
	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;
	
	private List<Contentieux> contentieuxs;
	private Contentieux selectContentieux;
	private Contentieux newContentieux;
	private Date dateDebTrans;
	private Date dateFinTrans;
	private Integer codeC;
	private String nomC;
	private Contentieux rechContentieux;
	private List<Groupe> groupes;
	private Groupe selectGroupe;
	private String etatRelance="t";
	private String numDossierC;
	
	@PostConstruct
	public void initialisation(){
		//contentieuxs=contentieuxService.findAllDta();
		selectContentieux=null;
		dateDebTrans=null;
		dateFinTrans=null;
		codeC=null;
		nomC=null;
		rechContentieux=new Contentieux();
		groupes=groupeService.findAll();
		selectGroupe = null;
		etatRelance="t";
		numDossierC=null;
	}
	
	public void createContentieux(){
		//contentieuxs=contentieuxService.findAllDta();
		selectContentieux=null;
		dateDebTrans=null;
		dateFinTrans=null;
		codeC=null;
		nomC=null;
		rechContentieux=new Contentieux();
		groupes=groupeService.findAll();
		selectGroupe = null;
		etatRelance="t";
		numDossierC=null;
	}
		
	public void onSelectC(){
		newContentieux=selectContentieux;
	}
	
	public void reglerContentieux(){
		Date dateFin = new Date();
		newContentieux.setDateFin(dateFin);
		contentieuxService.update(newContentieux);
	}
	
	public void arreterExecutionJugement(){
		Date dateSyst = new Date();
		newContentieux.setDatedebarrex(dateSyst);
		newContentieux.setEtatcontentieux("Arret d'execution de jugement");
		contentieuxService.update(newContentieux);
	}
	
	public void arreterPoursuite(){
		Date dateSyst = new Date();
		newContentieux.setDatedebarrprste(dateSyst);
		newContentieux.setEtatcontentieux("Arret de poursuite");
		contentieuxService.update(newContentieux);
		JsfUtil.addSuccessMessage("arrêt de poursuite est ajouté avec succés");
	}
	
	public void rechercher(){
		ClientAcquereur clientAcquereur=new ClientAcquereur();
		if(codeC !=null ){
			clientAcquereur.setCodeAcquereur(String.valueOf(codeC));
		}
		if(nomC !=null && !nomC.isEmpty()){
			clientAcquereur.setNomPrenomFr(nomC);
		}
		
		if(numDossierC !=null && !numDossierC.isEmpty()){
			rechContentieux.setNumDossier(numDossierC);
		}
		clientAcquereur.setGroupe(selectGroupe);
		Impayee impayee=new Impayee();
		Precontentieu precontentieu=new Precontentieu();
		impayee.setClientAcquereur(clientAcquereur);
		precontentieu.setImpayee(impayee);
		rechContentieux.setPrecontentieu(precontentieu);
		
		contentieuxs=contentieuxService.findByCriteres(rechContentieux, dateDebTrans, dateFinTrans, etatRelance);
	}

	public PrecontentieuService getPrecontentieuService() {
		return precontentieuService;
	}

	public void setPrecontentieuService(PrecontentieuService precontentieuService) {
		this.precontentieuService = precontentieuService;
	}

	public ContentieuxService getContentieuxService() {
		return contentieuxService;
	}

	public void setContentieuxService(ContentieuxService contentieuxService) {
		this.contentieuxService = contentieuxService;
	}

	public List<Contentieux> getContentieuxs() {
		return contentieuxs;
	}

	public void setContentieuxs(List<Contentieux> contentieuxs) {
		this.contentieuxs = contentieuxs;
	}

	public Contentieux getSelectContentieux() {
		return selectContentieux;
	}

	public void setSelectContentieux(Contentieux selectContentieux) {
		this.selectContentieux = selectContentieux;
	}

	public Contentieux getNewContentieux() {
		return newContentieux;
	}

	public void setNewContentieux(Contentieux newContentieux) {
		this.newContentieux = newContentieux;
	}

	public Date getDateDebTrans() {
		return dateDebTrans;
	}

	public void setDateDebTrans(Date dateDebTrans) {
		this.dateDebTrans = dateDebTrans;
	}

	public Date getDateFinTrans() {
		return dateFinTrans;
	}

	public void setDateFinTrans(Date dateFinTrans) {
		this.dateFinTrans = dateFinTrans;
	}

	public Integer getCodeC() {
		return codeC;
	}

	public void setCodeC(Integer codeC) {
		this.codeC = codeC;
	}

	public Contentieux getRechContentieux() {
		return rechContentieux;
	}

	public void setRechContentieux(Contentieux rechContentieux) {
		this.rechContentieux = rechContentieux;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe getSelectGroupe() {
		return selectGroupe;
	}

	public void setSelectGroupe(Groupe selectGroupe) {
		this.selectGroupe = selectGroupe;
	}

	public String getNomC() {
		return nomC;
	}

	public void setNomC(String nomC) {
		this.nomC = nomC;
	}

	public String getEtatRelance() {
		return etatRelance;
	}

	public void setEtatRelance(String etatRelance) {
		this.etatRelance = etatRelance;
	}

	public String getNumDossierC() {
		return numDossierC;
	}

	public void setNumDossierC(String numDossierC) {
		this.numDossierC = numDossierC;
	}
	
	
	
	
	
	

}
