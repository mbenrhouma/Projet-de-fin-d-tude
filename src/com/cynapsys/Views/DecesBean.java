package com.cynapsys.Views;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Deces;
import com.cynapsys.service.AssuranceService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.DecesService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "decesBean")
@ViewScoped
public class DecesBean extends AbstractBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Deces newDeces;
	private Deces selectDeces;
	public Integer modifDeces;
	private List<Deces> decess;
	private List<Assurance> clientAssurer;
	private String codeClientAcquereur = null;
	private ClientAcquereur newClientAcquereur;
	private Assureur selectAssureur;
	

	
	public List<Assurance> getClientAssurer() {
		return clientAssurer;
	}

	public void setClientAssurer(List<Assurance> clientAssurer) {
		this.clientAssurer = clientAssurer;
	}

	

	public Assureur getSelectAssureur() {
		return selectAssureur;
	}

	public void setSelectAssureur(Assureur selectAssureur) {
		this.selectAssureur = selectAssureur;
	}

	public ClientAcquereur getNewClientAcquereur() {
		return newClientAcquereur;
	}

	public void setNewClientAcquereur(ClientAcquereur newClientAcquereur) {
		this.newClientAcquereur = newClientAcquereur;
	}

	public String getCodeClientAcquereur() {
		return codeClientAcquereur;
	}

	public void setCodeClientAcquereur(String codeClientAcquereur) {
		this.codeClientAcquereur = codeClientAcquereur;
	}

	public Deces getNewDeces() {
		return newDeces;
	}

	public void setNewDeces(Deces newDeces) {
		this.newDeces = newDeces;
	}

	public Deces getSelectDeces() {
		return selectDeces;
	}

	public void setSelectDeces(Deces selectDeces) {
		this.selectDeces = selectDeces;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public Integer getModifDeces() {
		return modifDeces;
	}

	public void setModifDeces(Integer modifDeces) {
		this.modifDeces = modifDeces;
	}

	public List<Deces> getDecess() {
		return decess;
	}

	public void setDecess(List<Deces> decess) {
		this.decess = decess;
	}

	public DecesService getDecesService() {
		return decesService;
	}

	public void setDecesService(DecesService decesService) {
		this.decesService = decesService;
	}

	@ManagedProperty(value = "#{decesService}")
	private DecesService decesService;

	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	
	@ManagedProperty(value = "#{assuranceService}")
	private AssuranceService assuranceService;
	
	
	public DecesBean() {

		
	}

	@PostConstruct
	public void initialisation() {
		newDeces = new Deces();
		decess = decesService.findDta();
		newClientAcquereur = null;
		modifDeces = null;
	}

	public void createDeces() {
		codeClientAcquereur = null;
		newClientAcquereur = null;
		newDeces = new Deces();
		selectDeces = new Deces();
		decess = decesService.findDta();
		modifDeces = null;
		clientAssurer=null;
	}

	public void onChange() {
		newClientAcquereur= new ClientAcquereur();
		newClientAcquereur = clientAcquereurService.findById(codeClientAcquereur);
		newDeces.setClientAcquereur(newClientAcquereur);
		modifDeces = 1;
		
		if (newClientAcquereur == null){
			createDeces();
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addWarningMessage(
						ResourceBundle.getBundle(Constants.bundle_reclamation_fr).getString("reclamation.client.null"));
			else {
				JsfUtil.addWarningMessage(
						ResourceBundle.getBundle(Constants.bundle_reclamation_ar).getString("reclamation.client.null"));
			}
		}else {
			clientAssurer = assuranceService.findAssuranceByClient(newDeces.getClientAcquereur().getCodeAcquereur().toString());

		}
	}

	public void onSelectDeces() {
		newDeces = selectDeces;
		codeClientAcquereur = selectDeces.getClientAcquereur().getCodeAcquereur() + "";
		newClientAcquereur= selectDeces.getClientAcquereur();
		clientAssurer = assuranceService.findAssuranceByClient(newDeces.getClientAcquereur().getCodeAcquereur().toString());
		modifDeces = 0;
	}

	public void saveDeces() {

		newDeces.setClientAcquereur(newClientAcquereur);
		if (modifDeces == 1) {
			if(clientAssurer.size()<2 && newClientAcquereur.getCompteConjoint()==1 ) {
				decesService.save(newDeces);
				newClientAcquereur.setDeces(newDeces);
				createDeces();
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(
							ResourceBundle.getBundle(Constants.bundle_deces_fr).getString("deces.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(
							ResourceBundle.getBundle(Constants.bundle_deces_ar).getString("deces.cree.succes"));
				}
			}else if (newClientAcquereur.getCompteConjoint()==0 && clientAssurer.size()<1){
				decesService.save(newDeces);
				newClientAcquereur.setDeces(newDeces);
				createDeces();
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(
							ResourceBundle.getBundle(Constants.bundle_deces_fr).getString("deces.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(
							ResourceBundle.getBundle(Constants.bundle_deces_ar).getString("deces.cree.succes"));
				}
			} else if (newClientAcquereur.getCompteConjoint()==1 && clientAssurer.size()<2){
				
				decesService.save(newDeces);
				newClientAcquereur.setDeces(newDeces);
				createDeces();
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(
							ResourceBundle.getBundle(Constants.bundle_deces_fr).getString("deces.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(
							ResourceBundle.getBundle(Constants.bundle_deces_ar).getString("deces.cree.succes"));
				}
			}else{
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_deces_fr)
							.getString("deces.erreur.existe"));
				else {
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_deces_ar)
							.getString("deces.erreur.existe"));
				}
			}
			
		} else {
			try {
				decesService.update(selectDeces);
				newClientAcquereur.setDeces(newDeces);
				createDeces();
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_deces_fr)
							.getString("deces.modifie.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_deces_ar)
							.getString("deces.modifie.succes"));
				}

			} catch (DuplicateKeyException e) {
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_deces_fr)
							.getString("deces.erreur.existe"));
				else {
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_deces_ar)
							.getString("deces.erreur.existe"));
				}
			}
		}
		if (!isValidFailed()) {
			createDeces();
		}

	}

	private boolean isValidFailed() {
		return JsfUtil.isValidationFailed();
	}

	public AssuranceService getAssuranceService() {
		return assuranceService;
	}

	public void setAssuranceService(AssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}

}
