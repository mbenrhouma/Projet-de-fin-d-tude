package com.cynapsys.Views;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.Employeur;
import com.cynapsys.service.EmployeurService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;


@ManagedBean(name = "employeurBean")
@ViewScoped
public class EmployeurBean {
	
	@ManagedProperty(value = "#{employeurService}")
	private EmployeurService employeurService ; 
	private static final long serialVersionUID = 1L;
	private Employeur newEmployeur;
	private Employeur selectEmployeur ;
	public Integer ModifEmployeur = 1 ;
	private List<Employeur> employeurs;
	private List<Employeur> filtered;
	private SelectItem[] employeurOptions;
	
	
	public EmployeurService getEmployeurService() {
		return employeurService;
	}

	public void setEmployeurService(EmployeurService employeurService) {
		this.employeurService = employeurService;
	}

	public Employeur getNewEmployeur() {
		return newEmployeur;
	}

	public void setNewEmployeur(Employeur newEmployeur) {
		this.newEmployeur = newEmployeur;
	}

	public Employeur getSelectEmployeur() {
		return selectEmployeur;
	}

	public void setSelectEmployeur(Employeur selectEmployeur) {
		this.selectEmployeur = selectEmployeur;
	}

	public Integer getModifEmployeur() {
		return ModifEmployeur;
	}

	public void setModifEmployeur(Integer modifEmployeur) {
		ModifEmployeur = modifEmployeur;
	}

	public List<Employeur> getEmployeurs() {
		return employeurs;
	}

	public void setEmployeurs(List<Employeur> employeurs) {
		this.employeurs = employeurs;
	}

	public List<Employeur> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Employeur> filtered) {
		this.filtered = filtered;
	}


	public void setEmployeurOptions(SelectItem[] employeurOptions) {
		this.employeurOptions = employeurOptions;
	}

	public EmployeurBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initialisation(){
		newEmployeur= new Employeur();
		employeurs=employeurService.findAll() ;
	}
	
	
	
	public void createEmployeur(){
		newEmployeur = new Employeur();
		ModifEmployeur=1;
		selectEmployeur=null;
		employeurs=employeurService.findAll();
	    filtered = new ArrayList<Employeur>();
		
	}
	
	public void onSelectEmployeur(){
		newEmployeur=selectEmployeur;
		ModifEmployeur=0;
		
		
	}
	
	public void deleteEmployeur() {
	 try {
		if(employeurService.delete(newEmployeur)){
		 JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.supprime.succes"));
		  createEmployeur();
		 }else{
			 JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.error.supprime"));
		 }
	} catch (DataIntegrityViolationException e) {
		 JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.error.supprime"));

	} catch (Exception e){ JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.error.supprime"));

}
		 
	}
	
public void saveEmployeur(){
		
	if(ModifEmployeur==1) {
		try{	
			employeurService.save(newEmployeur);
	    JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.cree.succes"));}
	    catch (DuplicateKeyException e){JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.erreur.existe"));
      }
		} else{
		try{
			employeurService.update(newEmployeur);
			JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_employeur_fr).getString("employeur.modifie.succes"));
		
			} catch (DuplicateKeyException e) {
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(
						Constants.bundle_employeur_fr).getString(
						"employeur.error.modifie"));
			}
		}
		if(! isValidFailed()){
			createEmployeur();
		}
		
		}

	private boolean  isValidFailed(){
		return JsfUtil.isValidationFailed();
	}
	
	
	
	   public SelectItem[] getEmployeurOptions() {
		   employeurOptions=new SelectItem[this.getEmployeurs().size()+1];
		   employeurOptions[0] =new SelectItem("","choisir");
		for(int i=0; i<this.getEmployeurs().size(); i++) {
			employeurOptions[i+1]=new SelectItem(this.getEmployeurs().get(i).getNomEmployeurFr(),this.getEmployeurs().get(i).getNomEmployeurFr());
		}
		
		return employeurOptions;
	}

	

}
