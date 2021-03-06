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
import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Logement;
import com.cynapsys.entities.Lotissement;
import com.cynapsys.entities.TypeLogement;
import com.cynapsys.service.GouvernoratService;
import com.cynapsys.service.LocaliteService;
import com.cynapsys.service.LogementService;
import com.cynapsys.service.LotissementService;
import com.cynapsys.service.TypeLogementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "logementBean")
@ViewScoped
public class LogementBean implements Serializable {
	@ManagedProperty(value = "#{logementService}")
	private LogementService logementService;
	
	@ManagedProperty(value = "#{gouvernoratService}")
	private GouvernoratService gouvernoratService;
	@ManagedProperty(value = "#{localiteService}")
	private LocaliteService localiteService;
	@ManagedProperty(value = "#{typeLogementService}")
	private TypeLogementService typeLogementService;

	
	@ManagedProperty(value = "#{lotissementService}")
	private LotissementService lotissementService;
	
	
	
	
	
	private static final long serialVersionUID = 1L;
	private Logement newLogement;
	private Logement selectLogement;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<Logement> LogementFilter;
	private List<Logement> listLogement;
	private boolean enabledBoutonDelete;
	
	private int ModifLogement = 1;

	private List<Gouvernorat> listGouvernerat;
	private List<Localite> listLocalite;
	private List<TypeLogement> listTypeLogement;

	
	private List <Lotissement> listLotissement;

	public LogementBean() {
		
	}

	@PostConstruct
	public void initialisation() {

		newLogement = new Logement();

		listLogement = new ArrayList<Logement>();
		listLogement = logementService.finDTA();
		
		listGouvernerat=new ArrayList<Gouvernorat>();
		listGouvernerat=gouvernoratService.findAll();
		
		listTypeLogement=new ArrayList<TypeLogement>();
		listTypeLogement=typeLogementService.findAll();
		LogementFilter = new ArrayList<Logement>();

	
	}
	
	
public void findlocaliteByGouvernerat(){
	listLocalite=new ArrayList<Localite>();
	listLocalite=localiteService.finlocaliteByGov(newLogement.getGouvernorat());
	
}
public void findLotissByLoc(){
	listLotissement=new ArrayList<Lotissement>();
	listLotissement=lotissementService.findLotissemByLocalite(newLogement.getLocalite());
}
	public void createLogement() {
		newLogement = new Logement();
		ModifLogement = 1;
		selectLogement = null;
		listLogement = new ArrayList<Logement>();
		listLogement = logementService.finDTA();
		modif = 0;
	}

	public void onselectLogement() {
		newLogement =logementService.findById(selectLogement.getCodeLogement()) ;
		findlocaliteByGouvernerat();
		ModifLogement = 0;
		modif = 1;
		listLogement = new ArrayList<Logement>();
		listLogement = logementService.finDTA();
	}

	public void saveLogement() {
		if (ModifLogement == 1) {
			try {
				newLogement.setEtatLog(0);
				if(newLogement.getLocalite().getCodePostal()!=null){
				newLogement.setCodePostal(newLogement.getLocalite().getCodePostal());
				}
				logementService.save(newLogement);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
							.getString("logement.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
							.getString("logement.cree.succes"));
				}
				
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
							.getString("logement.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
							.getString("logement.error.existe"));

				newLogement.setCodeLogement(null);
			}
		} else if (ModifLogement == 0) {
			if(newLogement.getLocalite().getCodePostal()!=null){
				newLogement.setCodePostal(newLogement.getLocalite().getCodePostal());
				}
			logementService.update(newLogement);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
						.getString("logement.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
						.getString("logement.modifie.succes"));

			createLogement();
		}

	}

	public void deleteLogement() {
		try {
			logementService.delete(newLogement);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
						.getString("logement.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
						.getString("logement.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
						.getString("logement.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_logement_fr)
						.getString("logement.error.supprimer"));
		}
		createLogement();
	}

	public LogementService getLogementService() {
		return logementService;
	}

	public void setLogementService(LogementService LogementService) {
		this.logementService = LogementService;
	}

	public Logement getNewLogement() {
		return newLogement;
	}

	public void setNewLogement(Logement newLogement) {
		this.newLogement = newLogement;
	}

	public Logement getSelectLogement() {
		return selectLogement;
	}

	public void setSelectLogement(Logement selectLogement) {
		this.selectLogement = selectLogement;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<Logement> getLogementFilter() {
		return LogementFilter;
	}

	public void setLogementFilter(List<Logement> LogementFilter) {
		this.LogementFilter = LogementFilter;
	}

	public List<Logement> getListLogement() {
		return listLogement;
	}

	public void setListLogement(List<Logement> listLogement) {
		this.listLogement = listLogement;
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

	

	public int getModifLogement() {
		return ModifLogement;
	}

	public void setModifLogement(int modifLogement) {
		ModifLogement = modifLogement;
	}



	
	public GouvernoratService getGouvernoratService() {
		return gouvernoratService;
	}

	public void setGouvernoratService(GouvernoratService gouvernoratService) {
		this.gouvernoratService = gouvernoratService;
	}

	public LocaliteService getLocaliteService() {
		return localiteService;
	}

	public void setLocaliteService(LocaliteService localiteService) {
		this.localiteService = localiteService;
	}

	public TypeLogementService getTypeLogementService() {
		return typeLogementService;
	}

	public void setTypeLogementService(TypeLogementService typeLogementService) {
		this.typeLogementService = typeLogementService;
	}

	public List<Gouvernorat> getListGouvernerat() {
		return listGouvernerat;
	}

	public void setListGouvernerat(List<Gouvernorat> listGouvernerat) {
		this.listGouvernerat = listGouvernerat;
	}

	public List<Localite> getListLocalite() {
		return listLocalite;
	}

	public void setListLocalite(List<Localite> listLocalite) {
		this.listLocalite = listLocalite;
	}

	public List<TypeLogement> getListTypeLogement() {
		return listTypeLogement;
	}

	public void setListTypeLogement(List<TypeLogement> listTypeLogement) {
		this.listTypeLogement = listTypeLogement;
	}


	

	
	public LotissementService getLotissementService() {
		return lotissementService;
	}

	public void setLotissementService(LotissementService lotissementService) {
		this.lotissementService = lotissementService;
	}

	public List<Lotissement> getListLotissement() {
		return listLotissement;
	}

	public void setListLotissement(List<Lotissement> listLotissement) {
		this.listLotissement = listLotissement;
	}
	
	

}
