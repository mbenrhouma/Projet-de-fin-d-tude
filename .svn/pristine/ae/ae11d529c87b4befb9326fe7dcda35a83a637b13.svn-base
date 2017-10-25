package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.AncienneQuittance;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.service.AncienneQuittanceService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "ancienneQuittanceBean")
@ViewScoped
public class AncienneQuittanceBean implements Serializable {
	@ManagedProperty(value = "#{ancienneQuittanceService}")
	private AncienneQuittanceService ancienneQuittanceService;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;

	private static final long serialVersionUID = 1L;
	private AncienneQuittance newAncienneQuittance;
	private AncienneQuittance selectAncienneQuittance;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<AncienneQuittance> AncienneQuittanceFilter;
	private List<AncienneQuittance> listAncienneQuittance;
	private boolean enabledBoutonDelete;
	
	private int ModifAncienneQuittance = 1;
	private List<ClientAcquereur>listClientAquereur;

	public AncienneQuittanceBean() {
		

	}

	@PostConstruct
	public void initialisation() {
		listClientAquereur=new ArrayList<ClientAcquereur>();
		listClientAquereur=clientAcquereurService.findDTA();

		newAncienneQuittance = new AncienneQuittance();

		listAncienneQuittance = new ArrayList<AncienneQuittance>();
		listAncienneQuittance = ancienneQuittanceService.findDTA();

		

	}

	public void createAncienneQuittance() {
		newAncienneQuittance = new AncienneQuittance();
		ModifAncienneQuittance = 1;
		selectAncienneQuittance = null;
		listAncienneQuittance = ancienneQuittanceService.findDTA();
		modif = 0;
	}

	public void onselectAncienneQuittance() {
		newAncienneQuittance = selectAncienneQuittance;
		ModifAncienneQuittance = 0;
		modif = 1;
		listAncienneQuittance = ancienneQuittanceService.findDTA();
	}

	public void saveAncienneQuittance() {
		if (ModifAncienneQuittance == 1) {
			try {
				ancienneQuittanceService.save(newAncienneQuittance);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_fr)
							.getString("ancienneQuittance.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_ar)
							.getString("ancienneQuittance.cree.succes"));
				}
				createAncienneQuittance();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_fr)
							.getString("ancienneQuittance.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_ar)
							.getString("ancienneQuittance.error.existe"));

			
			}
		} else if (ModifAncienneQuittance == 0) {
			ancienneQuittanceService.update(newAncienneQuittance);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_fr)
						.getString("ancienneQuittance.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_ar)
						.getString("ancienneQuittance.modifie.succes"));

			createAncienneQuittance();
		}

	}

	public void deleteAncienneQuittance() {
		try {
			ancienneQuittanceService.delete(newAncienneQuittance);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_fr)
						.getString("ancienneQuittance.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_ar)
						.getString("ancienneQuittance.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_fr)
						.getString("ancienneQuittance.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_ancienneQuittance_ar)
						.getString("ancienneQuittance.error.supprimer"));
		}
		createAncienneQuittance();
	}

	public AncienneQuittanceService getAncienneQuittanceService() {
		return ancienneQuittanceService;
	}

	public void setAncienneQuittanceService(AncienneQuittanceService AncienneQuittanceService) {
		this.ancienneQuittanceService = AncienneQuittanceService;
	}

	public AncienneQuittance getNewAncienneQuittance() {
		return newAncienneQuittance;
	}

	public void setNewAncienneQuittance(AncienneQuittance newAncienneQuittance) {
		this.newAncienneQuittance = newAncienneQuittance;
	}

	public AncienneQuittance getSelectAncienneQuittance() {
		return selectAncienneQuittance;
	}

	public void setSelectAncienneQuittance(AncienneQuittance selectAncienneQuittance) {
		this.selectAncienneQuittance = selectAncienneQuittance;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<AncienneQuittance> getAncienneQuittanceFilter() {
		return AncienneQuittanceFilter;
	}

	public void setAncienneQuittanceFilter(List<AncienneQuittance> AncienneQuittanceFilter) {
		this.AncienneQuittanceFilter = AncienneQuittanceFilter;
	}

	public List<AncienneQuittance> getListAncienneQuittance() {
		return listAncienneQuittance;
	}

	public void setListAncienneQuittance(List<AncienneQuittance> listAncienneQuittance) {
		this.listAncienneQuittance = listAncienneQuittance;
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

	

	public int getModifAncienneQuittance() {
		return ModifAncienneQuittance;
	}

	public void setModifAncienneQuittance(int modifAncienneQuittance) {
		ModifAncienneQuittance = modifAncienneQuittance;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public List<ClientAcquereur> getListClientAquereur() {
		return listClientAquereur;
	}

	public void setListClientAquereur(List<ClientAcquereur> listClientAquereur) {
		this.listClientAquereur = listClientAquereur;
	}

}
