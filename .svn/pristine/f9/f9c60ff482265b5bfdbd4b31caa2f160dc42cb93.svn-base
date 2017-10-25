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

import com.cynapsys.entities.HuissiersNotaires;
import com.cynapsys.service.HuissiersNotairesService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "huissiersNotairesBean")
@ViewScoped
public class HuissiersNotairesBean implements Serializable {
	@ManagedProperty(value = "#{huissiersNotairesService}")
	private HuissiersNotairesService huissiersNotairesService;

	private static final long serialVersionUID = 1L;
	private HuissiersNotaires newHuissiersNotaires;
	private HuissiersNotaires selectHuissiersNotaires;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<HuissiersNotaires> HuissiersNotairesFilter;
	private List<HuissiersNotaires> listHuissiersNotaires;
	private boolean enabledBoutonDelete;
	
	private int ModifHuissiersNotaires = 1;

	public HuissiersNotairesBean() {
	}

	@PostConstruct
	public void initialisation() {

		newHuissiersNotaires = new HuissiersNotaires();

		listHuissiersNotaires = new ArrayList<HuissiersNotaires>();
		listHuissiersNotaires = huissiersNotairesService.findAll();

		HuissiersNotairesFilter = new ArrayList<HuissiersNotaires>();

	}

	public void createHuissiersNotaires() {
		newHuissiersNotaires = new HuissiersNotaires();
		ModifHuissiersNotaires = 1;
		selectHuissiersNotaires = null;
		listHuissiersNotaires = huissiersNotairesService.findAll();
		modif = 0;
	}

	public void onselectHuissiersNotaires() {
		newHuissiersNotaires = selectHuissiersNotaires;
		ModifHuissiersNotaires = 0;
		modif = 1;
		listHuissiersNotaires = huissiersNotairesService.findAll();
	}

	public void saveHuissiersNotaires() {
		if (ModifHuissiersNotaires == 1) {
			try {
				huissiersNotairesService.save(newHuissiersNotaires);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.huissiersNotaires.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.huissiersNotaires.cree.succes"));
				}
				createHuissiersNotaires();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.huissiersNotaires.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.huissiersNotaires.error.existe"));

				newHuissiersNotaires.setId(null);
			}
		} else if (ModifHuissiersNotaires == 0) {
			huissiersNotairesService.update(newHuissiersNotaires);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.huissiersNotaires.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.huissiersNotaires.modifie.succes"));

			createHuissiersNotaires();
		}

	}

	public void deleteHuissiersNotaires() {
		try {
			huissiersNotairesService.delete(newHuissiersNotaires);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.huissiersNotaires.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.huissiersNotaires.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.huissiersNotaires.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.huissiersNotaires.error.supprimer"));
		}
		createHuissiersNotaires();
	}

	public HuissiersNotairesService getHuissiersNotairesService() {
		return huissiersNotairesService;
	}

	public void setHuissiersNotairesService(HuissiersNotairesService HuissiersNotairesService) {
		this.huissiersNotairesService = HuissiersNotairesService;
	}

	public HuissiersNotaires getNewHuissiersNotaires() {
		return newHuissiersNotaires;
	}

	public void setNewHuissiersNotaires(HuissiersNotaires newHuissiersNotaires) {
		this.newHuissiersNotaires = newHuissiersNotaires;
	}

	public HuissiersNotaires getSelectHuissiersNotaires() {
		return selectHuissiersNotaires;
	}

	public void setSelectHuissiersNotaires(HuissiersNotaires selectHuissiersNotaires) {
		this.selectHuissiersNotaires = selectHuissiersNotaires;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<HuissiersNotaires> getHuissiersNotairesFilter() {
		return HuissiersNotairesFilter;
	}

	public void setHuissiersNotairesFilter(List<HuissiersNotaires> HuissiersNotairesFilter) {
		this.HuissiersNotairesFilter = HuissiersNotairesFilter;
	}

	public List<HuissiersNotaires> getListHuissiersNotaires() {
		return listHuissiersNotaires;
	}

	public void setListHuissiersNotaires(List<HuissiersNotaires> listHuissiersNotaires) {
		this.listHuissiersNotaires = listHuissiersNotaires;
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

	

	public int getModifHuissiersNotaires() {
		return ModifHuissiersNotaires;
	}

	public void setModifHuissiersNotaires(int modifHuissiersNotaires) {
		ModifHuissiersNotaires = modifHuissiersNotaires;
	}

}
