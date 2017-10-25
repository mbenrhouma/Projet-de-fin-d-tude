package com.cynapsys.Views;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.Views.controller.MenuController;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.ClientLocataire;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.entities.NoteDebit;
import com.cynapsys.entities.TypeFrais;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.ClientLocataireService;
import com.cynapsys.service.GroupeService;
import com.cynapsys.service.MouvementService;
import com.cynapsys.service.NoteDebitService;
import com.cynapsys.service.TypeFraisService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "noteDebitBean")
@SessionScoped
public class NoteDebitBean implements Serializable {
	@ManagedProperty(value = "#{noteDebitService}")
	private NoteDebitService noteDebitService;
	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	@ManagedProperty(value = "#{typeFraisService}")
	private TypeFraisService typeFraisService;
	@ManagedProperty(value = "#{menuController}")
	private MenuController menuController;
	@ManagedProperty(value = "#{clientLocataireService}")
	private ClientLocataireService clientLocataireService;
	@ManagedProperty(value = "#{mouvementService}")
	private MouvementService mouvementService;
	
	
	

	private static final long serialVersionUID = 1L;
	private NoteDebit newNoteDebit;
	private NoteDebit selectNoteDebit;
	private int modif = 0; // Modification 0 : insertion 1;
	private List<NoteDebit> NoteDebitFilter;
	private List<NoteDebit> listNoteDebit;
	private boolean enabledBoutonDelete;
	
	private int ModifNoteDebit = 1;
	private Integer typeClient;
	private NoteDebit suppnotedebit;
	
	public NoteDebit getSuppnotedebit() {
		return suppnotedebit;
	}

	public void setSuppnotedebit(NoteDebit suppnotedebit) {
		this.suppnotedebit = suppnotedebit;
	}

	private List<ClientLocataire> listClientLocataire;

	// attribut recherche avance

	

	private Date dateDebitRechercheDe;
	private Date dateDebitRechercheA;
	private Double montantRechercheDE;
	private Double montantRechercheA;
	private Groupe groupeRecherche;
	private List<Groupe> listGrouperecherche;
	private List<ClientAcquereur> listClientAcquereur;
	private List <TypeFrais> listTypeFrais;
	

	// fin attribut recherche

	public NoteDebitBean() {
		

	}

	@PostConstruct
	public void initialisation() {

		newNoteDebit = new NoteDebit();
		newNoteDebit.setDateDebit(new Date());
	
		NoteDebitFilter = new ArrayList<NoteDebit>();
		listGrouperecherche=new ArrayList<Groupe>();
		listGrouperecherche=groupeService.findAll();
		
		listTypeFrais=new ArrayList<TypeFrais>();
		listTypeFrais=typeFraisService.findAll();
	}

	public TypeFraisService getTypeFraisService() {
		return typeFraisService;
	}

	public void setTypeFraisService(TypeFraisService typeFraisService) {
		this.typeFraisService = typeFraisService;
	}

	public List<TypeFrais> getListTypeFrais() {
		return listTypeFrais;
	}

	public void setListTypeFrais(List<TypeFrais> listTypeFrais) {
		this.listTypeFrais = listTypeFrais;
	}

	// methode rechrche avance
	public void rechercheAvance() {

		
	
			listNoteDebit = new ArrayList<NoteDebit>();
			listNoteDebit = noteDebitService.recherchAv(dateDebitRechercheDe, dateDebitRechercheA, montantRechercheDE,
					montantRechercheA, groupeRecherche);
		
	}
	
	
//	recherche List Client par type ACQUEREUR ou LOCATAIRE
	
	public void recherchepartype(){
		if(typeClient==Constants.clientAcquereur){
			listClientAcquereur=new ArrayList<ClientAcquereur>();
			listClientAcquereur=clientAcquereurService.findDTA();
			listClientLocataire=null;
			newNoteDebit.setClientLocataire(null);
			
		}else{
			listClientLocataire=new ArrayList<ClientLocataire>();
			listClientLocataire=clientLocataireService.findDTA();
			listClientAcquereur=null;
			newNoteDebit.setClientAcquereur(null);
		}
		
		
	}
	

	// initialisation de la methode de recherche
	public void initRecherche() {
		dateDebitRechercheDe = null;
		dateDebitRechercheA = null;
		montantRechercheDE = null;
		montantRechercheA = null;
		groupeRecherche = null;
		typeClient=null;
		listNoteDebit=null;
		 

	}

	public void createNoteDebit() {
		newNoteDebit = new NoteDebit();
		newNoteDebit.setDateDebit(new Date());
		ModifNoteDebit = 1;
		selectNoteDebit = null;
		suppnotedebit=null;
		initRecherche();
		modif = 0;
	}

	public void onselectNoteDebit() {
		newNoteDebit = selectNoteDebit;
		if(newNoteDebit.getClientAcquereur()==null){
			typeClient=Constants.clientLocataire;
		}else{
			typeClient=Constants.clientAcquereur;
		}
		ModifNoteDebit = 0;
		modif = 1;
		listNoteDebit = noteDebitService.findDTA();
	}

	public void saveNoteDebit() {
		if (ModifNoteDebit == 1) {
			
			try {
				noteDebitService.save(newNoteDebit);
				Mouvement mouv =new Mouvement();
				mouv.setClientAcquereur(newNoteDebit.getClientAcquereur());
				mouv.setDateMv(new Date());
				mouv.setMontantDebit(newNoteDebit.getMontant());
				mouv.setSoldeDebiteur(mouv.getSoldeDebiteur()+newNoteDebit.getMontant());
				mouvementService.save(mouv);
				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
							.getString("noteDebit.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
							.getString("noteDebit.cree.succes"));
				}
				
			} catch (DuplicateKeyException e) {

				if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
							.getString("noteDebit.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
							.getString("noteDebit.error.existe"));

				newNoteDebit.setId(null);
			}
			try {
				menuController.goToPageModifierNoteDebit();
				ModifNoteDebit = 0;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (ModifNoteDebit == 0) {
			noteDebitService.update(newNoteDebit);
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
						.getString("noteDebit.modifie.succes"));
			else
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
						.getString("noteDebit.modifie.succes"));

			createNoteDebit();
		}

	}

	public void deleteNoteDebit() {
		try {

			suppnotedebit = new NoteDebit();
			suppnotedebit.setClientAcquereur(newNoteDebit.getClientAcquereur());
			suppnotedebit.setClientLocataire(newNoteDebit.getClientLocataire());
			suppnotedebit.setDateDebit(newNoteDebit.getDateDebit());
			suppnotedebit.setTypeFrais(newNoteDebit.getTypeFrais());
			suppnotedebit.setMontant(-(newNoteDebit.getMontant()));
			Mouvement mouv =new Mouvement();
			mouv.setClientAcquereur(newNoteDebit.getClientAcquereur());
			mouv.setDateMv(new Date());
			mouv.setMontantCredit(newNoteDebit.getMontant());
			mouv.setSoldeCrediteur(mouv.getSoldeCrediteur()+newNoteDebit.getMontant());
			mouvementService.save(mouv);
			noteDebitService.save(suppnotedebit);

			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(
						ResourceBundle.getBundle(Constants.bundle_noteDebit_fr).getString("noteDebit.supprime.succes"));
			else {
				JsfUtil.addSuccessMessage(
						ResourceBundle.getBundle(Constants.bundle_noteDebit_fr).getString("noteDebit.supprime.succes"));
			}

		} catch (Exception e) {
			if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr"))
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
						.getString("panoteDebit.error.supprimer"));
			else
				JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_noteDebit_fr)
						.getString("panoteDebit.error.supprimer"));
		}
		createNoteDebit();
	}

	public NoteDebitService getNoteDebitService() {
		return noteDebitService;
	}

	public void setNoteDebitService(NoteDebitService NoteDebitService) {
		this.noteDebitService = NoteDebitService;
	}

	public NoteDebit getNewNoteDebit() {
		return newNoteDebit;
	}

	public void setNewNoteDebit(NoteDebit newNoteDebit) {
		this.newNoteDebit = newNoteDebit;
	}

	public NoteDebit getSelectNoteDebit() {
		return selectNoteDebit;
	}

	public void setSelectNoteDebit(NoteDebit selectNoteDebit) {
		this.selectNoteDebit = selectNoteDebit;
	}

	public int getModif() {
		return modif;
	}

	public void setModif(int modif) {
		this.modif = modif;
	}

	public List<NoteDebit> getNoteDebitFilter() {
		return NoteDebitFilter;
	}

	public void setNoteDebitFilter(List<NoteDebit> NoteDebitFilter) {
		this.NoteDebitFilter = NoteDebitFilter;
	}

	public List<NoteDebit> getListNoteDebit() {
		return listNoteDebit;
	}

	public void setListNoteDebit(List<NoteDebit> listNoteDebit) {
		this.listNoteDebit = listNoteDebit;
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

	

	public int getModifNoteDebit() {
		return ModifNoteDebit;
	}

	public void setModifNoteDebit(int modifNoteDebit) {
		ModifNoteDebit = modifNoteDebit;
	}

	public Date getDateDebitRechercheDe() {
		return dateDebitRechercheDe;
	}

	public void setDateDebitRechercheDe(Date dateDebitRechercheDe) {
		this.dateDebitRechercheDe = dateDebitRechercheDe;
	}

	public Date getDateDebitRechercheA() {
		return dateDebitRechercheA;
	}

	public void setDateDebitRechercheA(Date dateDebitRechercheA) {
		this.dateDebitRechercheA = dateDebitRechercheA;
	}

	public Double getMontantRechercheDE() {
		return montantRechercheDE;
	}

	public void setMontantRechercheDE(Double montantRechercheDE) {
		this.montantRechercheDE = montantRechercheDE;
	}

	public Double getMontantRechercheA() {
		return montantRechercheA;
	}

	public void setMontantRechercheA(Double montantRechercheA) {
		this.montantRechercheA = montantRechercheA;
	}

	public Groupe getGroupeRecherche() {
		return groupeRecherche;
	}

	public void setGroupeRecherche(Groupe groupeRecherche) {
		this.groupeRecherche = groupeRecherche;
	}

	public List<Groupe> getListGrouperecherche() {
		return listGrouperecherche;
	}

	public void setListGrouperecherche(List<Groupe> listGrouperecherche) {
		this.listGrouperecherche = listGrouperecherche;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public List<ClientAcquereur> getListClientAcquereur() {
		return listClientAcquereur;
	}

	public void setListClientAcquereur(List<ClientAcquereur> listClientAcquereur) {
		this.listClientAcquereur = listClientAcquereur;
	}

	public MenuController getMenuController() {
		return menuController;
	}

	public void setMenuController(MenuController menuController) {
		this.menuController = menuController;
	}


	public ClientLocataireService getClientLocataireService() {
		return clientLocataireService;
	}

	public void setClientLocataireService(ClientLocataireService clientLocataireService) {
		this.clientLocataireService = clientLocataireService;
	}
	public List<ClientLocataire> getListClientLocataire() {
		return listClientLocataire;
	}

	public void setListClientLocataire(List<ClientLocataire> listClientLocataire) {
		this.listClientLocataire = listClientLocataire;
	}

	public Integer getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(Integer typeClient) {
		this.typeClient = typeClient;
	}
	
}
