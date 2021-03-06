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

import com.cynapsys.entities.TypeLogement;
import com.cynapsys.service.TypeLogementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "typeLogementBean")
@ViewScoped
public class TypeLogementBean implements Serializable {
	@ManagedProperty(value = "#{typeLogementService}")
	private TypeLogementService typeLogementService;

	private static final long serialVersionUID = 1L;
	private TypeLogement newTypeLogement;
	private TypeLogement selectTypeLogement;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<TypeLogement> TypeLogementFilter;
	private List<TypeLogement> listTypeLogement;
	private boolean enabledBoutonDelete;
	
	private int ModifTypeLogement = 1;

	public TypeLogementBean() {
	}

	@PostConstruct
	public void initialisation() {

		newTypeLogement = new TypeLogement();

		listTypeLogement = new ArrayList<TypeLogement>();
		listTypeLogement = typeLogementService.findAll();

		TypeLogementFilter = new ArrayList<TypeLogement>();

	}

	public void createTypeLogement() {
		newTypeLogement = new TypeLogement();
		ModifTypeLogement = 1;
		selectTypeLogement = null;
		listTypeLogement = typeLogementService.findAll();
		modif = 0;
	}

	public void onselectTypeLogement() {
		newTypeLogement = selectTypeLogement;
		ModifTypeLogement = 0;
		modif = 1;
		listTypeLogement = typeLogementService.findAll();
	}

	public void saveTypeLogement() {
		if (ModifTypeLogement == 1) {
			try {
				typeLogementService.save(newTypeLogement);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.typeLogement.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.typeLogement.cree.succes"));
				}
				createTypeLogement();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.typeLogement.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.typeLogement.error.existe"));

				newTypeLogement.setCodeType("");
			}
		} else if (ModifTypeLogement == 0) {
			typeLogementService.update(newTypeLogement);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeLogement.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeLogement.modifie.succes"));

			createTypeLogement();
		}

	}

	public void deleteTypeLogement() {
		try {
			typeLogementService.delete(newTypeLogement);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeLogement.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeLogement.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeLogement.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeLogement.error.supprimer"));
		}
		createTypeLogement();
	}

	public TypeLogementService getTypeLogementService() {
		return typeLogementService;
	}

	public void setTypeLogementService(TypeLogementService TypeLogementService) {
		this.typeLogementService = TypeLogementService;
	}

	public TypeLogement getNewTypeLogement() {
		return newTypeLogement;
	}

	public void setNewTypeLogement(TypeLogement newTypeLogement) {
		this.newTypeLogement = newTypeLogement;
	}

	public TypeLogement getSelectTypeLogement() {
		return selectTypeLogement;
	}

	public void setSelectTypeLogement(TypeLogement selectTypeLogement) {
		this.selectTypeLogement = selectTypeLogement;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<TypeLogement> getTypeLogementFilter() {
		return TypeLogementFilter;
	}

	public void setTypeLogementFilter(List<TypeLogement> TypeLogementFilter) {
		this.TypeLogementFilter = TypeLogementFilter;
	}

	public List<TypeLogement> getListTypeLogement() {
		return listTypeLogement;
	}

	public void setListTypeLogement(List<TypeLogement> listTypeLogement) {
		this.listTypeLogement = listTypeLogement;
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

	

	public int getModifTypeLogement() {
		return ModifTypeLogement;
	}

	public void setModifTypeLogement(int modifTypeLogement) {
		ModifTypeLogement = modifTypeLogement;
	}

}
