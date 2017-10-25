package com.cynapsys.Views;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mainlevee;
import com.cynapsys.entities.TypeMainlevee;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.MainleveeService;
import com.cynapsys.service.TypeMainleveeService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;
import com.cynapsys.utils.Parametre;

import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateException;
import net.sf.jooreports.templates.DocumentTemplateFactory;

@ManagedBean(name = "imprimerMainleveeBean")
@ViewScoped
public class ImprimerMainleveeBean implements Serializable {
	@ManagedProperty(value = "#{mainleveeService}")
	private MainleveeService mainleveeService;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	@ManagedProperty(value = "#{typeMainleveeService}")
	private TypeMainleveeService typeMainleveeService;

	private static final long serialVersionUID = 1L;
	private Mainlevee newMainlevee;
	private Mainlevee selectMainlevee;
	private int modif = 0; // Modification 0 : insertion 1;

	private List<Mainlevee> listMainlevee;
	private boolean enabledBoutonDelete;
	
	private int ModifMainlevee = 1;
	public static String urlodt = Parametre.getProjetRealPath(GenerateRapport.class) + "/Jasper/source/doc/";
	private List<TypeMainlevee> listTypeMainlevee;
	private List<ClientAcquereur> listClientAcquereur;
	
	

	public ImprimerMainleveeBean() {
		

	}

	@PostConstruct
	public void initialisation() {
		

		newMainlevee = new Mainlevee();
		newMainlevee.setDateMainlevee(new Date());
		listClientAcquereur=new ArrayList<ClientAcquereur>();
		listClientAcquereur=clientAcquereurService.findDTA();
		

		listMainlevee = new ArrayList<Mainlevee>();
		listMainlevee = mainleveeService.findAll();
		listTypeMainlevee=new ArrayList<TypeMainlevee>();
		listTypeMainlevee=typeMainleveeService.findAll();
		

		

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
	public void	imprimerMainlevee(){
		
			saveMainlevee();

	    DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
	    try {
	    	String urlFile=urlodt+"Mainlevee.odt";
			DocumentTemplate document = documentTemplateFactory.getTemplate(new File("urlFile"));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dateM;
			dateM = sdf.format(newMainlevee.getDateMainlevee());
			FacesContext cx = FacesContext.getCurrentInstance();
			ExternalContext extContext = cx.getExternalContext();

			
			HashMap<String, Object> data = new HashMap<String, Object>();
		

			data.put("nomEtprenom", newMainlevee.getClientAcquereur().getNomPrenomFr());
			data.put("dateMainlevee",dateM );
			data.put("groupe",newMainlevee.getClientAcquereur().getGroupe().getLibelle() );
			document.createDocument(data, new FileOutputStream("D://Mainlevee.doc"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentTemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
		

	public void saveMainlevee() {
		if (ModifMainlevee == 1) {
			try {
				mainleveeService.save(newMainlevee);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.mainlevee.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.mainlevee.cree.succes"));
				}
				createMainlevee();
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
							.getString("parametrage.mainlevee.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
							.getString("parametrage.mainlevee.error.existe"));

				newMainlevee.setId(null);
			}
		} else if (ModifMainlevee == 0) {
			mainleveeService.update(newMainlevee);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
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
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
						.getString("parametrage.mainlevee.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_fr)
						.getString("parametrage.mainlevee.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_parametrage_ar)
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



	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public TypeMainleveeService getTypeMainleveeService() {
		return typeMainleveeService;
	}

	public void setTypeMainleveeService(TypeMainleveeService typeMainleveeService) {
		this.typeMainleveeService = typeMainleveeService;
	}

	public List<TypeMainlevee> getListTypeMainlevee() {
		return listTypeMainlevee;
	}

	public void setListTypeMainlevee(List<TypeMainlevee> listTypeMainlevee) {
		this.listTypeMainlevee = listTypeMainlevee;
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

	public static String getUrlodt() {
		return urlodt;
	}

	public static void setUrlodt(String urlodt) {
		ImprimerMainleveeBean.urlodt = urlodt;
	}

	public void setModifMainlevee(int modifMainlevee) {
		ModifMainlevee = modifMainlevee;
	}

	public List<ClientAcquereur> getListClientAcquereur() {
		return listClientAcquereur;
	}

	public void setListClientAcquereur(List<ClientAcquereur> listClientAcquereur) {
		this.listClientAcquereur = listClientAcquereur;
	}

	

	
}
