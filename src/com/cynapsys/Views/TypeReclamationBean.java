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

import com.cynapsys.entities.Reclamation;
import com.cynapsys.entities.TypeReclamation;
import com.cynapsys.service.ReclamationService;
import com.cynapsys.service.TypeReclamationService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "typeReclamationBean")
@ViewScoped
public class TypeReclamationBean implements Serializable {
	@ManagedProperty(value = "#{reclamationService}")
	private ReclamationService reclamationService;
	
	@ManagedProperty(value = "#{typeReclamationService}")
	private TypeReclamationService typeReclamationService;

	private static final long serialVersionUID = 1L;
	private TypeReclamation newTypeReclamation;
	private TypeReclamation selectTypeReclamation;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<TypeReclamation> typeReclamations;
	private boolean enabledBoutonDelete;
	
	private Integer modifTypeReclamation = null;

	public TypeReclamationBean() {
		

	}

	@PostConstruct
	public void initialisation() {

		newTypeReclamation = new TypeReclamation();
		typeReclamations = new ArrayList<TypeReclamation>();
		typeReclamations = typeReclamationService.findAll();

	}

	public void onChange () {
		modifTypeReclamation=0;
	}
	public void createTypeReclamation() {
		newTypeReclamation = new TypeReclamation();
		modifTypeReclamation = null;
		selectTypeReclamation = null;
		typeReclamations = typeReclamationService.findAll();
	}

	public void onSelectTypeReclamation() {
		newTypeReclamation = selectTypeReclamation;
		modifTypeReclamation = 1;
		typeReclamations = typeReclamationService.findAll();
	}

	public void saveTypeReclamation() {
		if (modifTypeReclamation == 0) {
			try{
			for (TypeReclamation typeReclamation :typeReclamations){
			   if (typeReclamation.getObjetReclamation().equals(newTypeReclamation.getObjetReclamation())){
				 
				   if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")){
						JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_fr)
								.getString("type.reclamation.erreur.existe"));
				   }else{
						JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_ar)
								.getString("type.reclamation.erreur.existe"));
			           }
				   break;
			   }else{
				   typeReclamationService.save(newTypeReclamation);
				   createTypeReclamation();
				   
					if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
						JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_fr)
								.getString("type.reclamation.creation.succe"));
					else {
						JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_ar)
								.getString("type.reclamation.creation.succe"));
					}
					break;
    			   }
			}
			}catch (DuplicateKeyException e) {
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")){
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_fr)
							.getString("type.reclamation.erreur.existe"));
			   }else{
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_ar)
							.getString("type.reclamation.erreur.existe"));
		           }
			}	
		} else if (modifTypeReclamation == 1) {
			typeReclamationService.update(newTypeReclamation);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_fr)
						.getString("type.reclamation.modifier.succe"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_ar)
						.getString("type.reclamation.modifier.succe"));

			createTypeReclamation();
		}

	}

	public void deleteTypeReclamation() throws Exception {
		List<Reclamation> reclamations= reclamationService.findAll() ;
		for (Reclamation reclamation :reclamations){
			if(reclamation.getTypeReclamation().equals(newTypeReclamation)){
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")){
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_fr)
							.getString("type.reclamation.error.supprime.utilise"));
				}else{
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_ar)
							.getString("type.reclamation.error.supprime.utilise"));
			}
		   
			break;
		}else{
			typeReclamationService.delete(newTypeReclamation);
			createTypeReclamation();
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")){
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_fr)
						.getString("type.reclamation.supprime.succes"));
			}else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_reclamation_ar)
						.getString("type.reclamation.supprime.succes"));
			}
		}
		}	
	}

	

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}


	public TypeReclamationService getTypeReclamationService() {
		return typeReclamationService;
	}

	public void setTypeReclamationService(TypeReclamationService typeReclamationService) {
		this.typeReclamationService = typeReclamationService;
	}

	

	

	

	public TypeReclamation getSelectTypeReclamation() {
		return selectTypeReclamation;
	}

	public void setSelectTypeReclamation(TypeReclamation selectTypeReclamation) {
		this.selectTypeReclamation = selectTypeReclamation;
	}

	

	public Integer getModifTypeReclamation() {
		return modifTypeReclamation;
	}

	public List<TypeReclamation> getTypeReclamations() {
		return typeReclamations;
	}

	public void setTypeReclamations(List<TypeReclamation> typeReclamations) {
		this.typeReclamations = typeReclamations;
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

	

	public TypeReclamation getNewTypeReclamation() {
		return newTypeReclamation;
	}

	

	public void setNewTypeReclamation(TypeReclamation newTypeReclamation) {
		this.newTypeReclamation = newTypeReclamation;
	}

	public ReclamationService getReclamationService() {
		return reclamationService;
	}

	public void setReclamationService(ReclamationService reclamationService) {
		this.reclamationService = reclamationService;
	}

	public void setModifTypeReclamation(Integer modifTypeReclamation) {
		this.modifTypeReclamation = modifTypeReclamation;
	}

}
