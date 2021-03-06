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

import com.cynapsys.entities.Parametrage;
import com.cynapsys.service.ParametrageService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "parametrageBean")
@ViewScoped
public class ParametrageBean implements Serializable {
	@ManagedProperty(value = "#{parametrageService}")
	private ParametrageService parametrageService;

	private static final long serialVersionUID = 1L;
	private Parametrage newParametrage;
	private Parametrage selectParametrage;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<Parametrage> ParametrageFilter;
	private List<Parametrage> listParametrage;
	private boolean enabledBoutonDelete;
	private int ModifParametrage = 1;

	public ParametrageBean() {
	}

	@PostConstruct
	public void initialisation() {

		newParametrage = new Parametrage();

		listParametrage = new ArrayList<Parametrage>();
		listParametrage = parametrageService.findAll();

		ParametrageFilter = new ArrayList<Parametrage>();

	}

	public void createParametrage() {
		newParametrage = new Parametrage();
		ModifParametrage = 1;
		selectParametrage = null;
		listParametrage = parametrageService.findAll();
		modif = 0;
	}

	public void onselectParametrage() {
		newParametrage = selectParametrage;
		ModifParametrage = 0;
		modif = 1;
		listParametrage = parametrageService.findAll();
	}

	public void saveParametrage() {
		if (ModifParametrage == 1) {
			try {
				parametrageService.save(newParametrage);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.parametrage.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.parametrage.cree.succes"));
				}
				createParametrage();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.parametrage.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.parametrage.error.existe"));

				newParametrage.setParamId(null);
			}
		} else if (ModifParametrage == 0) {
			parametrageService.update(newParametrage);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.parametrage.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.parametrage.modifie.succes"));

			createParametrage();
		}

	}

	public void deleteParametrage() {
		try {
			parametrageService.delete(newParametrage);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.parametrage.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.parametrage.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.parametrage.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.parametrage.error.supprimer"));
		}
		createParametrage();
	}

	public ParametrageService getParametrageService() {
		return parametrageService;
	}

	public void setParametrageService(ParametrageService ParametrageService) {
		this.parametrageService = ParametrageService;
	}

	public Parametrage getNewParametrage() {
		return newParametrage;
	}

	public void setNewParametrage(Parametrage newParametrage) {
		this.newParametrage = newParametrage;
	}

	public Parametrage getSelectParametrage() {
		return selectParametrage;
	}

	public void setSelectParametrage(Parametrage selectParametrage) {
		this.selectParametrage = selectParametrage;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<Parametrage> getParametrageFilter() {
		return ParametrageFilter;
	}

	public void setParametrageFilter(List<Parametrage> ParametrageFilter) {
		this.ParametrageFilter = ParametrageFilter;
	}

	public List<Parametrage> getListParametrage() {
		return listParametrage;
	}

	public void setListParametrage(List<Parametrage> listParametrage) {
		this.listParametrage = listParametrage;
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

	

	public int getModifParametrage() {
		return ModifParametrage;
	}

	public void setModifParametrage(int modifParametrage) {
		ModifParametrage = modifParametrage;
	}

}
