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

import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Lotissement;
import com.cynapsys.service.LocaliteService;
import com.cynapsys.service.LotissementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "lotissementBean")
@ViewScoped
public class LotissementBean implements Serializable {
	@ManagedProperty(value = "#{lotissementService}")
	private LotissementService lotissementService;
	@ManagedProperty(value = "#{localiteService}")
	private LocaliteService localiteService;

	private static final long serialVersionUID = 1L;
	private Lotissement newLotissement;
	private Lotissement selectLotissement;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<Lotissement> LotissementFilter;
	private List<Lotissement> listLotissement;
	private List<Localite> listLocalite;
	private boolean enabledBoutonDelete;
	
	private int ModifLotissement = 1;

	public LotissementBean() {
		

	}

	@PostConstruct
	public void initialisation() {

		newLotissement = new Lotissement();

		listLotissement = new ArrayList<Lotissement>();
		listLotissement = lotissementService.finddta();
		listLocalite=new ArrayList<Localite>();
		listLocalite=localiteService.finddta();
		LotissementFilter = new ArrayList<Lotissement>();

	}

	public void createLotissement() {
		newLotissement = new Lotissement();
		ModifLotissement = 1;
		selectLotissement = null;
		listLotissement = lotissementService.finddta();
		modif = 0;
	}

	public void onselectLotissement() {
		newLotissement = selectLotissement;
		ModifLotissement = 0;
		modif = 1;
		listLotissement = lotissementService.finddta();
	}

	public void saveLotissement() {
		if (ModifLotissement == 1) {
			try {
				lotissementService.save(newLotissement);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.lotissement.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.lotissement.cree.succes"));
				}
				createLotissement();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.lotissement.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.lotissement.error.existe"));

				newLotissement.setCode(null);
			}
		} else if (ModifLotissement == 0) {
			lotissementService.update(newLotissement);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.lotissement.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.lotissement.modifie.succes"));

			createLotissement();
		}

	}

	public void deleteLotissement() {
		try {
			lotissementService.delete(newLotissement);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.lotissement.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.lotissement.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.lotissement.error.supprimerr"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.lotissement.error.supprimer"));
		}
		createLotissement();
	}

	public LotissementService getLotissementService() {
		return lotissementService;
	}

	public void setLotissementService(LotissementService LotissementService) {
		this.lotissementService = LotissementService;
	}

	public Lotissement getNewLotissement() {
		return newLotissement;
	}

	public void setNewLotissement(Lotissement newLotissement) {
		this.newLotissement = newLotissement;
	}

	public Lotissement getSelectLotissement() {
		return selectLotissement;
	}

	public void setSelectLotissement(Lotissement selectLotissement) {
		this.selectLotissement = selectLotissement;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<Lotissement> getLotissementFilter() {
		return LotissementFilter;
	}

	public void setLotissementFilter(List<Lotissement> LotissementFilter) {
		this.LotissementFilter = LotissementFilter;
	}

	public List<Lotissement> getListLotissement() {
		return listLotissement;
	}

	public void setListLotissement(List<Lotissement> listLotissement) {
		this.listLotissement = listLotissement;
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

	

	public int getModifLotissement() {
		return ModifLotissement;
	}

	public void setModifLotissement(int modifLotissement) {
		ModifLotissement = modifLotissement;
	}

	public LocaliteService getLocaliteService() {
		return localiteService;
	}

	public void setLocaliteService(LocaliteService localiteService) {
		this.localiteService = localiteService;
	}

	public List<Localite> getListLocalite() {
		return listLocalite;
	}

	public void setListLocalite(List<Localite> listLocalite) {
		this.listLocalite = listLocalite;
	}

}
