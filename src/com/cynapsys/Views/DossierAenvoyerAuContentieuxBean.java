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
import com.cynapsys.entities.Precontentieu;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.ContentieuxService;
import com.cynapsys.service.PrecontentieuService;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "dossierAenvoyerAuContentieuxBean")
@ViewScoped
public class DossierAenvoyerAuContentieuxBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{precontentieuService}")
	private PrecontentieuService precontentieuService;

	@ManagedProperty(value = "#{contentieuxService}")
	private ContentieuxService contentieuxService;

	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;

	private List<Precontentieu> precontentieus;
	private Precontentieu selectPrec;
	private Precontentieu newPrecontentieu;
	private Date delaiRech = null;
	private Contentieux newContentieux;
	private Integer rechDelaiJour;

	@PostConstruct
	public void initialisation() {
		precontentieus = precontentieuService.findAllDta();
		selectPrec = null;
		newPrecontentieu = new Precontentieu();
		delaiRech = null;
		newContentieux = new Contentieux();
		rechDelaiJour=null;

	}

	public void createContentieu() {
		precontentieus = precontentieuService.findAllDta();
		selectPrec = null;
		newPrecontentieu = new Precontentieu();
		delaiRech = null;
		newContentieux = new Contentieux();
		rechDelaiJour=null;
	}

	public void onSelectPrec() {
		newPrecontentieu = selectPrec;
	}

	public void rechercher() {
		System.out.println("from bean dossier : " + delaiRech);
		precontentieus = precontentieuService.findByDelai(delaiRech, rechDelaiJour);
	}

	public void saveContentieux() {
		newContentieux.setPrecontentieu(newPrecontentieu);
		contentieuxService.save(newContentieux);
		newPrecontentieu.setContentieux(newContentieux);
		precontentieuService.update(newPrecontentieu);
		ClientAcquereur clientAcquereur = new ClientAcquereur();
		clientAcquereur = newPrecontentieu.getImpayee().getClientAcquereur();
//		clientAcquereur.setEnContentieux(true);
		clientAcquereur.setContentieux(true);
		clientAcquereurService.update(clientAcquereur);
		createContentieu();
		JsfUtil.addSuccessMessage("Dossier envoyé au contentieux avec succés");
	}

	public PrecontentieuService getPrecontentieuService() {
		return precontentieuService;
	}

	public void setPrecontentieuService(PrecontentieuService precontentieuService) {
		this.precontentieuService = precontentieuService;
	}

	public List<Precontentieu> getPrecontentieus() {
		return precontentieus;
	}

	public void setPrecontentieus(List<Precontentieu> precontentieus) {
		this.precontentieus = precontentieus;
	}

	public Precontentieu getSelectPrec() {
		return selectPrec;
	}

	public void setSelectPrec(Precontentieu selectPrec) {
		this.selectPrec = selectPrec;
	}

	public Precontentieu getNewPrecontentieu() {
		return newPrecontentieu;
	}

	public void setNewPrecontentieu(Precontentieu newPrecontentieu) {
		this.newPrecontentieu = newPrecontentieu;
	}

	public Date getDelaiRech() {
		return delaiRech;
	}

	public void setDelaiRech(Date delaiRech) {
		this.delaiRech = delaiRech;
	}

	public ContentieuxService getContentieuxService() {
		return contentieuxService;
	}

	public void setContentieuxService(ContentieuxService contentieuxService) {
		this.contentieuxService = contentieuxService;
	}

	public Contentieux getNewContentieux() {
		return newContentieux;
	}

	public void setNewContentieux(Contentieux newContentieux) {
		this.newContentieux = newContentieux;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public Integer getRechDelaiJour() {
		return rechDelaiJour;
	}

	public void setRechDelaiJour(Integer rechDelaiJour) {
		this.rechDelaiJour = rechDelaiJour;
	}
	
	

}
