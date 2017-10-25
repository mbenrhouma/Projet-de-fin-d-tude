package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.AnneeBudgetaire;
import com.cynapsys.service.AnneeBudgetaireService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "anneeBudgetaireBean")
@ViewScoped
public class AnneeBudgetaireBean implements Serializable {
	@ManagedProperty(value = "#{anneeBudgetaireService}")
	private AnneeBudgetaireService anneeBudgetaireService;

	private static final long serialVersionUID = 1L;
	private AnneeBudgetaire newAnneeBudgetaire;
	private AnneeBudgetaire selectAnneeBudgetaire;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<AnneeBudgetaire> AnneeBudgetaireFilter;
	private List<AnneeBudgetaire> listAnneeBudgetaire;
	private boolean enabledBoutonDelete;

	private int ModifAnneeBudgetaire = 1;
	private Date anneselect;

	public AnneeBudgetaireBean() {
		

	}

	@PostConstruct
	public void initialisation() {

		newAnneeBudgetaire = new AnneeBudgetaire();

		listAnneeBudgetaire = new ArrayList<AnneeBudgetaire>();
		listAnneeBudgetaire = anneeBudgetaireService.findAll();

		AnneeBudgetaireFilter = new ArrayList<AnneeBudgetaire>();

	}
	
	public void updateCodeAndDateAnne(){
		if (ModifAnneeBudgetaire == 1){
		Integer dateTrans=anneselect.getYear();
		String var=dateTrans.toString();
		var=var.substring(1);
		newAnneeBudgetaire.setCode(var);
		newAnneeBudgetaire.setAnnee(Integer.parseInt(var));
		}
		
	}

	public void createAnneeBudgetaire() {
		newAnneeBudgetaire = new AnneeBudgetaire();
		ModifAnneeBudgetaire = 1;
		selectAnneeBudgetaire = null;
		listAnneeBudgetaire = anneeBudgetaireService.findAll();
		modif = 0;
		anneselect = new Date() ;
			}

	public void onselectAnneeBudgetaire() {
		newAnneeBudgetaire = selectAnneeBudgetaire;
		ModifAnneeBudgetaire = 0;
		modif = 1;
		listAnneeBudgetaire = anneeBudgetaireService.findAll();
	}

	public void saveAnneeBudgetaire() {
		if (ModifAnneeBudgetaire == 1) {
			try {
				anneeBudgetaireService.save(newAnneeBudgetaire);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.anneeBudgetaire.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.anneeBudgetaire.cree.succes"));
				}
				createAnneeBudgetaire();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.anneeBudgetaire.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.anneeBudgetaire.error.existe"));

				
			}
		} else if (ModifAnneeBudgetaire == 0) {
			anneeBudgetaireService.update(newAnneeBudgetaire);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.anneeBudgetaire.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.anneeBudgetaire.modifie.succes"));

			createAnneeBudgetaire();
		}

	}

	public void deleteAnneeBudgetaire() {
		try {
			anneeBudgetaireService.delete(newAnneeBudgetaire);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.anneeBudgetaire.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.anneeBudgetaire.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.anneeBudgetaire.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.anneeBudgetaire.error.supprimer"));
		}
		createAnneeBudgetaire();
	}

	public AnneeBudgetaireService getAnneeBudgetaireService() {
		return anneeBudgetaireService;
	}

	public void setAnneeBudgetaireService(AnneeBudgetaireService AnneeBudgetaireService) {
		this.anneeBudgetaireService = AnneeBudgetaireService;
	}

	public AnneeBudgetaire getNewAnneeBudgetaire() {
		return newAnneeBudgetaire;
	}

	public void setNewAnneeBudgetaire(AnneeBudgetaire newAnneeBudgetaire) {
		this.newAnneeBudgetaire = newAnneeBudgetaire;
	}

	public AnneeBudgetaire getSelectAnneeBudgetaire() {
		return selectAnneeBudgetaire;
	}

	public void setSelectAnneeBudgetaire(AnneeBudgetaire selectAnneeBudgetaire) {
		this.selectAnneeBudgetaire = selectAnneeBudgetaire;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<AnneeBudgetaire> getAnneeBudgetaireFilter() {
		return AnneeBudgetaireFilter;
	}

	public void setAnneeBudgetaireFilter(List<AnneeBudgetaire> AnneeBudgetaireFilter) {
		this.AnneeBudgetaireFilter = AnneeBudgetaireFilter;
	}

	public List<AnneeBudgetaire> getListAnneeBudgetaire() {
		return listAnneeBudgetaire;
	}

	public void setListAnneeBudgetaire(List<AnneeBudgetaire> listAnneeBudgetaire) {
		this.listAnneeBudgetaire = listAnneeBudgetaire;
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

	

	public int getModifAnneeBudgetaire() {
		return ModifAnneeBudgetaire;
	}

	public void setModifAnneeBudgetaire(int modifAnneeBudgetaire) {
		ModifAnneeBudgetaire = modifAnneeBudgetaire;
	}

	public Date getAnneselect() {
		return anneselect;
	}

	public void setAnneselect(Date anneselect) {
		this.anneselect = anneselect;
	}

}
