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

import com.cynapsys.entities.TypeFrais;
import com.cynapsys.service.TypeFraisService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "typeFraisBean")
@ViewScoped
public class TypeFraisBean implements Serializable {
	@ManagedProperty(value = "#{typeFraisService}")
	private TypeFraisService typeFraisService;

	private static final long serialVersionUID = 1L;
	private TypeFrais newTypeFrais;
	private TypeFrais selectTypeFrais;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<TypeFrais> TypeFraisFilter;
	private List<TypeFrais> listTypeFrais;
	private boolean enabledBoutonDelete;

	private int ModifTypeFrais = 1;

	public TypeFraisBean() {
	}

	@PostConstruct
	public void initialisation() {

		newTypeFrais = new TypeFrais();

		listTypeFrais = new ArrayList<TypeFrais>();
		listTypeFrais = typeFraisService.findAll();

		TypeFraisFilter = new ArrayList<TypeFrais>();

	}

	public void createTypeFrais() {
		newTypeFrais = new TypeFrais();
		ModifTypeFrais = 1;
		selectTypeFrais = null;
		listTypeFrais = typeFraisService.findAll();
		modif = 0;
	}

	public void onselectTypeFrais() {
		newTypeFrais = selectTypeFrais;
		ModifTypeFrais = 0;
		modif = 1;
		listTypeFrais = typeFraisService.findAll();
	}

	public void saveTypeFrais() {
		if (ModifTypeFrais == 1) {
			try {
				typeFraisService.save(newTypeFrais);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.typeFrais.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.typeFrais.cree.succes"));
				}
				createTypeFrais();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.typeFrais.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.typeFrais.error.existe"));

				newTypeFrais.setId(null);
			}
		} else if (ModifTypeFrais == 0) {
			typeFraisService.update(newTypeFrais);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeFrais.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeFrais.modifie.succes"));

			createTypeFrais();
		}

	}

	public void deleteTypeFrais() {
		try {
			typeFraisService.delete(newTypeFrais);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeFrais.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeFrais.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.typeFrais.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.typeFrais.error.supprimer"));
		}
		createTypeFrais();
	}

	public TypeFraisService getTypeFraisService() {
		return typeFraisService;
	}

	public void setTypeFraisService(TypeFraisService TypeFraisService) {
		this.typeFraisService = TypeFraisService;
	}

	public TypeFrais getNewTypeFrais() {
		return newTypeFrais;
	}

	public void setNewTypeFrais(TypeFrais newTypeFrais) {
		this.newTypeFrais = newTypeFrais;
	}

	public TypeFrais getSelectTypeFrais() {
		return selectTypeFrais;
	}

	public void setSelectTypeFrais(TypeFrais selectTypeFrais) {
		this.selectTypeFrais = selectTypeFrais;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<TypeFrais> getTypeFraisFilter() {
		return TypeFraisFilter;
	}

	public void setTypeFraisFilter(List<TypeFrais> TypeFraisFilter) {
		this.TypeFraisFilter = TypeFraisFilter;
	}

	public List<TypeFrais> getListTypeFrais() {
		return listTypeFrais;
	}

	public void setListTypeFrais(List<TypeFrais> listTypeFrais) {
		this.listTypeFrais = listTypeFrais;
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

	
	public int getModifTypeFrais() {
		return ModifTypeFrais;
	}

	public void setModifTypeFrais(int modifTypeFrais) {
		ModifTypeFrais = modifTypeFrais;
	}

}