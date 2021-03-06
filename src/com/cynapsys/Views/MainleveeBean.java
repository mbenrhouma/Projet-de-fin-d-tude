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

import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.Mainlevee;
import com.cynapsys.service.GouvernoratService;
import com.cynapsys.service.MainleveeService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "mainleveeBean")
@ViewScoped
public class MainleveeBean implements Serializable {
	@ManagedProperty(value = "#{mainleveeService}")
	private MainleveeService mainleveeService;
	@ManagedProperty(value = "#{gouvernoratService}")
	private GouvernoratService gouvernoratService;

	private static final long serialVersionUID = 1L;
	private Mainlevee newMainlevee;
	private Mainlevee selectMainlevee;
	private int modif = 0; // Modification 0 : insertion 1;

	private List<Mainlevee> listMainlevee;
	private List<Gouvernorat> listGouvernorat;
	private boolean enabledBoutonDelete;
	
	private int ModifMainlevee = 1;

	public MainleveeBean() {
		

	}

	@PostConstruct
	public void initialisation() {

		newMainlevee = new Mainlevee();

		listMainlevee = new ArrayList<Mainlevee>();
		listMainlevee = mainleveeService.findAll();
		listGouvernorat=new ArrayList<Gouvernorat>();
		listGouvernorat=gouvernoratService.findAll();
	

	}

	public GouvernoratService getGouvernoratService() {
		return gouvernoratService;
	}

	public void setGouvernoratService(GouvernoratService gouvernoratService) {
		this.gouvernoratService = gouvernoratService;
	}

	public List<Gouvernorat> getListGouvernorat() {
		return listGouvernorat;
	}

	public void setListGouvernorat(List<Gouvernorat> listGouvernorat) {
		this.listGouvernorat = listGouvernorat;
	}

	public void createMainlevee() {
		newMainlevee = new Mainlevee();
		ModifMainlevee = 1;
		selectMainlevee = null;
		listMainlevee = mainleveeService.findAll();
		modif = 0;
	}

	public void onselectMainlevee() {
		newMainlevee = selectMainlevee;
		ModifMainlevee = 0;
		modif = 1;
		listMainlevee = mainleveeService.findAll();
	}

	public void saveMainlevee() {
		if (ModifMainlevee == 1) {
			try {
				mainleveeService.save(newMainlevee);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.mainlevee.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.mainlevee.cree.succes"));
				}
				createMainlevee();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.mainlevee.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.mainlevee.error.existe"));

				newMainlevee.setId(null);
			}
		} else if (ModifMainlevee == 0) {
			mainleveeService.update(newMainlevee);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.modifie.succes"));

			createMainlevee();
		}

	}

	public void deleteMainlevee() {
		try {
			mainleveeService.delete(newMainlevee);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.error.supprimer"));
		}
		createMainlevee();
	}

	public MainleveeService getMainleveeService() {
		return mainleveeService;
	}

	public void setMainleveeService(MainleveeService MainleveeService) {
		this.mainleveeService = MainleveeService;
	}

	public Mainlevee getNewMainlevee() {
		return newMainlevee;
	}

	public void setNewMainlevee(Mainlevee newMainlevee) {
		this.newMainlevee = newMainlevee;
	}

	public Mainlevee getSelectMainlevee() {
		return selectMainlevee;
	}

	public void setSelectMainlevee(Mainlevee selectMainlevee) {
		this.selectMainlevee = selectMainlevee;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	

	public List<Mainlevee> getListMainlevee() {
		return listMainlevee;
	}

	public void setListMainlevee(List<Mainlevee> listMainlevee) {
		this.listMainlevee = listMainlevee;
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

	

	public int getModifMainlevee() {
		return ModifMainlevee;
	}

	public void setModifMainlevee(int modifMainlevee) {
		ModifMainlevee = modifMainlevee;
	}

}
