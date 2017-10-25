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

import com.cynapsys.entities.TypeMainlevee;
import com.cynapsys.service.TypeMainleveeService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "typeMainleveeBean")
@ViewScoped
public class TypeMainleveeBean implements Serializable {
	@ManagedProperty(value = "#{typeMainleveeService}")
	private TypeMainleveeService typeMainleveeService;

	private static final long serialVersionUID = 1L;
	private TypeMainlevee newTypeMainlevee;
	private TypeMainlevee selectTypeMainlevee;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<TypeMainlevee> TypeMainleveeFilter;
	private List<TypeMainlevee> listTypeMainlevee;
	private boolean enabledBoutonDelete;
	
	private int ModifTypeMainlevee = 1;

	public TypeMainleveeBean() {
	}

	@PostConstruct
	public void initialisation() {

		newTypeMainlevee = new TypeMainlevee();

		listTypeMainlevee = new ArrayList<TypeMainlevee>();
		listTypeMainlevee = typeMainleveeService.findAll();

		TypeMainleveeFilter = new ArrayList<TypeMainlevee>();

	}

	public void createTypeMainlevee() {
		newTypeMainlevee = new TypeMainlevee();
		ModifTypeMainlevee = 1;
		selectTypeMainlevee = null;
		listTypeMainlevee = typeMainleveeService.findAll();
		modif = 0;
	}

	public void onselectTypeMainlevee() {
		newTypeMainlevee = selectTypeMainlevee;
		ModifTypeMainlevee = 0;
		modif = 1;
		listTypeMainlevee = typeMainleveeService.findAll();
	}

	public void saveTypeMainlevee() {
		if (ModifTypeMainlevee == 1) {
			try {
				typeMainleveeService.save(newTypeMainlevee);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.typeMainlevee.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.typeMainlevee.cree.succes"));
				}
				createTypeMainlevee();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.typeMainlevee.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.typeMainlevee.error.existe"));

				newTypeMainlevee.setId(null);
			}
		} else if (ModifTypeMainlevee == 0) {
			typeMainleveeService.update(newTypeMainlevee);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeMainlevee.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeMainlevee.modifie.succes"));

			createTypeMainlevee();
		}

	}

	public void deleteTypeMainlevee() {
		try {
			typeMainleveeService.delete(newTypeMainlevee);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeMainlevee.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeMainlevee.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeMainlevee.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeMainlevee.error.supprimer"));
		}
		createTypeMainlevee();
	}

	public TypeMainleveeService getTypeMainleveeService() {
		return typeMainleveeService;
	}

	public void setTypeMainleveeService(TypeMainleveeService TypeMainleveeService) {
		this.typeMainleveeService = TypeMainleveeService;
	}

	public TypeMainlevee getNewTypeMainlevee() {
		return newTypeMainlevee;
	}

	public void setNewTypeMainlevee(TypeMainlevee newTypeMainlevee) {
		this.newTypeMainlevee = newTypeMainlevee;
	}

	public TypeMainlevee getSelectTypeMainlevee() {
		return selectTypeMainlevee;
	}

	public void setSelectTypeMainlevee(TypeMainlevee selectTypeMainlevee) {
		this.selectTypeMainlevee = selectTypeMainlevee;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<TypeMainlevee> getTypeMainleveeFilter() {
		return TypeMainleveeFilter;
	}

	public void setTypeMainleveeFilter(List<TypeMainlevee> TypeMainleveeFilter) {
		this.TypeMainleveeFilter = TypeMainleveeFilter;
	}

	public List<TypeMainlevee> getListTypeMainlevee() {
		return listTypeMainlevee;
	}

	public void setListTypeMainlevee(List<TypeMainlevee> listTypeMainlevee) {
		this.listTypeMainlevee = listTypeMainlevee;
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

	

	public int getModifTypeMainlevee() {
		return ModifTypeMainlevee;
	}

	public void setModifTypeMainlevee(int modifTypeMainlevee) {
		ModifTypeMainlevee = modifTypeMainlevee;
	}

}
