package com.cynapsys.Views;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.Impayee;
import com.cynapsys.entities.Precontentieu;
import com.cynapsys.service.GroupeService;
import com.cynapsys.service.ImpayeeService;
import com.cynapsys.service.PrecontentieuService;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "suiviDesRecouvrementsBean")
@ViewScoped
public class SuiviDesRecouvrementsBean implements Serializable {

	/**
	 * 
	 */

	public SuiviDesRecouvrementsBean() {
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{impayeeService}")
	private ImpayeeService impayeeService;

	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;

	@ManagedProperty(value = "#{precontentieuService}")
	private PrecontentieuService precontentieuService;

	List<Impayee> listImpayes;
	private Impayee newImpayee;
	private Impayee selectImpayee;
	private List<Impayee> selectListImpayee;
	private List<Impayee> ListImpayeenonreglé;
	private Impayee impayeeRecherche;
	private List<Groupe> groupes;
	private Groupe selectGroupe;
	private ClientAcquereur acquereur;
	private String modeComparaison;
	private static SelectItem[] etatFilter;

	@PostConstruct
	public void initialisation() {
		listImpayes = impayeeService.findAllDta();
	
		selectImpayee = null;
		selectListImpayee = null;
		impayeeRecherche = new Impayee();
		groupes = new ArrayList<Groupe>();
		groupes = groupeService.findAll();
		selectGroupe = null;
		modeComparaison = "e";

	}


	public void onSelectImpayee() {
      newImpayee = selectImpayee;

	}

	public void createImpayee() {
		listImpayes = impayeeService.findAllDta();
		impayeeRecherche = new Impayee();
		modeComparaison = "e";
		selectListImpayee = null;
		selectGroupe = null;
	}

	public void rechercher() {
		System.out.println("dans bean recherche");

		acquereur = new ClientAcquereur();
		acquereur.setGroupe(selectGroupe);
		impayeeRecherche.setClientAcquereur(acquereur);

		listImpayes = impayeeService.findByCriteres(impayeeRecherche,
				modeComparaison);

	}

	public void imprimerAffectation(Impayee impayee) {

		Date d = new Date();

		Locale saudi = new Locale("ar", "SA");

		Formatter formatter = new Formatter(System.out, Locale.FRENCH);
		formatter.format("month: %tB\n", impayee.getDateRelance());
		System.out.printf(saudi, "month: %tB\n", impayee.getDateRelance());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();
		// String codeTitre =
		// newDossierContentieux.getTitreFoncier().getCodetitre();
		System.out.println("ديسمبر");
		data.put("mois", getMonthNameArabic(impayee.getDateRelance()));
		data.put("montant", impayee.getSoldeDebiteur().toString());
		if(impayee.getClientAcquereur().getNomPrenomAr()!=null){
			data.put("nom", impayee.getClientAcquereur().getNomPrenomAr());
		} else {data.put("nom", impayee.getClientAcquereur().getNomPrenomFr());
		}
		data.put("adresse", impayee.getClientAcquereur()
				.getAdresseCorrespondance());

		GenerateRapport.exportPDFWithDataSource("RelanceClient.jasper",
				data, "Lettre_De_Relance_"
						+ impayee.getClientAcquereur().getNomPrenomFr()
						+ ".pdf");
		JsfUtil.addSuccessMessage("Impayés relancés avec succés");

	}

	
	public void relancerImpayee() {
		Date dateRelance = new Date();
		System.out.println("dans relance");

			Precontentieu newPrecontentieu = new Precontentieu();
            selectImpayee.setDateRelance(dateRelance);
			impayeeService.update(selectImpayee);
			newPrecontentieu.setDateRelance(dateRelance);
			newPrecontentieu.setImpayee(selectImpayee);
			newPrecontentieu.setDateEffectuation(dateRelance);
			precontentieuService.save(newPrecontentieu);

			selectImpayee.setPrecontentieu(newPrecontentieu);
			impayeeService.update(selectImpayee);

			imprimerAffectation(selectImpayee);
		

	}

	public SelectItem[] getEtatFilter() {

		etatFilter = new SelectItem[groupes.size() + 1];
		etatFilter[0] = new SelectItem("", "","");
		for (int i = 1; i <= groupes.size(); i++) {
			etatFilter[i] = new SelectItem(groupes.get(i - 1).getLibelle(),groupes.get(i - 1).getLibelle().concat(groupes.get(i - 1).getCode()));
			
		}
		

		return etatFilter;
	}

	public void setEtatFilter(SelectItem[] etatFilter) {
		SuiviDesRecouvrementsBean.etatFilter = etatFilter;
	}

	public String getMonthNameArabic(Date date) {
		if (date.getMonth() == 1) {
			return "جانفي";
		}
		if (date.getMonth() == 2) {
			return "فيفري";
		}
		if (date.getMonth() == 1) {
			return "مارس";
		}
		if (date.getMonth() == 3) {
			return "أفريل";
		}
		if (date.getMonth() == 4) {
			return "ماي";
		}
		if (date.getMonth() == 5) {
			return "جانفي";
		}
		if (date.getMonth() == 6) {
			return "جوان";
		}
		if (date.getMonth() == 7) {
			return "جويلية";
		}
		if (date.getMonth() == 8) {
			return "اوت";
		}
		if (date.getMonth() == 9) {
			return "سبتمبر";
		}
		if (date.getMonth() == 10) {
			return "اكتوبر";
		}
		if (date.getMonth() == 11) {
			return "نوفمبر";
		}
		if (date.getMonth() == 12) {
			return "ديسمبر";
		}
		return "faux";

	}

	public ImpayeeService getImpayeeService() {
		return impayeeService;
	}

	public void setImpayeeService(ImpayeeService impayeeService) {
		this.impayeeService = impayeeService;
	}

	public List<Impayee> getListImpayes() {
		return listImpayes;
	}

	public void setListImpayes(List<Impayee> listImpayes) {
		this.listImpayes = listImpayes;
	}

	public Impayee getSelectImpayee() {
		return selectImpayee;
	}

	public void setSelectImpayee(Impayee selectImpayee) {
		this.selectImpayee = selectImpayee;
	}

	public Impayee getNewImpayee() {
		return newImpayee;
	}

	public void setNewImpayee(Impayee newImpayee) {
		this.newImpayee = newImpayee;
	}

	public Impayee getImpayeeRecherche() {
		return impayeeRecherche;
	}

	public void setImpayeeRecherche(Impayee impayeeRecherche) {
		this.impayeeRecherche = impayeeRecherche;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe getSelectGroupe() {
		return selectGroupe;
	}

	public void setSelectGroupe(Groupe selectGroupe) {
		this.selectGroupe = selectGroupe;
	}

	public ClientAcquereur getAcquereur() {
		return acquereur;
	}

	public void setAcquereur(ClientAcquereur acquereur) {
		this.acquereur = acquereur;
	}

	public String getModeComparaison() {
		return modeComparaison;
	}

	public void setModeComparaison(String modeComparaison) {
		this.modeComparaison = modeComparaison;
	}

	public List<Impayee> getSelectListImpayee() {
		return selectListImpayee;
	}

	public void setSelectListImpayee(List<Impayee> selectListImpayee) {
		this.selectListImpayee = selectListImpayee;
	}

	public PrecontentieuService getPrecontentieuService() {
		return precontentieuService;
	}

	public void setPrecontentieuService(
			PrecontentieuService precontentieuService) {
		this.precontentieuService = precontentieuService;
	}

	public List<Impayee> getListImpayeenonreglé() {
		return ListImpayeenonreglé;
	}

	public void setListImpayeenonreglé(List<Impayee> listImpayeenonreglé) {
		ListImpayeenonreglé = listImpayeenonreglé;
	}

}
