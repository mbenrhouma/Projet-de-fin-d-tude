package com.cynapsys.Views;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.HuissiersNotaires;
import com.cynapsys.entities.Precontentieu;
import com.cynapsys.service.HuissiersNotairesService;
import com.cynapsys.service.PrecontentieuService;
import com.cynapsys.utils.GenerateRapport;

@ManagedBean(name = "precontentieuxBean")
@ViewScoped
public class PrecontentieuxBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{precontentieuService}")
	private PrecontentieuService precontentieuService;

	@ManagedProperty(value = "#{huissiersNotairesService}")
	private HuissiersNotairesService huissiersNotairesService;

	private List<Precontentieu> precontentieus;
	private Precontentieu selectPrec;
	private Precontentieu newPrecontentieu;
	private List<HuissiersNotaires> huissiersNotaires;
	private HuissiersNotaires selectHuissNotaire;
	private static SelectItem[] etatFilter;
	private List<Groupe> groupes;

	@PostConstruct
	public void initialisation() {
		newPrecontentieu = new Precontentieu();
		precontentieus = precontentieuService.findAllDta();
		selectPrec = null;
		huissiersNotaires = huissiersNotairesService.findAll();
		// selectHuissNotaire=new HuissiersNotaires();
	}

	public void createPrecontentieux() {
		selectPrec = null;
		newPrecontentieu = new Precontentieu();
		// selectHuissNotaire=new HuissiersNotaires();
	}

	public void editionLettreDeCommande() {
		System.out.println(newPrecontentieu.getImpayee().getClientAcquereur()
				.getNomPrenomFr());
		// System.out.println(selectHuissNotaire.getNom());
		Date dateHN = new Date();
		newPrecontentieu.setDateHuissierNotaire(dateHN);
		precontentieuService.update(newPrecontentieu);

		imprimerLettreCommande(newPrecontentieu);
	}

	public void imprimerLettreCommande(Precontentieu precontentieu) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();
		// String codeTitre =
		// newDossierContentieux.getTitreFoncier().getCodetitre();
		if(precontentieu.getHuissiersNotaires().getNomAr()!=null){
			data.put("HuissN", precontentieu.getHuissiersNotaires().getNomAr());
		} else {data.put("HuissN", precontentieu.getHuissiersNotaires().getNomFr());}
		
		data.put("huissAdr", precontentieu.getHuissiersNotaires().getAdresse());
		if(precontentieu.getImpayee().getClientAcquereur().getNomPrenomAr()!=null){
			data.put("impNom", precontentieu.getImpayee().getClientAcquereur()
					.getNomPrenomAr());
		} else {data.put("impNom", precontentieu.getImpayee().getClientAcquereur()
				.getNomPrenomFr());}
		
		data.put("impAdr", precontentieu.getImpayee().getClientAcquereur()
				.getAdresseCorrespondance());
		data.put("impDate", getMonthNameArabic(precontentieu.getDateRelance())
				+ " " + (precontentieu.getDateRelance().getYear() + 1900));
		data.put("impMontant", precontentieu.getImpayee().getSoldeDebiteur());

		GenerateRapport.exportPDFWithDataSource("GCLettreDeCommande.jasper",
				data, "Lettre_De_Commande_"
						+ precontentieu.getHuissiersNotaires().getNomFr()
						+ ".pdf");

	}

	public void onSelectPrec() {
		newPrecontentieu = selectPrec;
	}

	public SelectItem[] getEtatFilter() {

		etatFilter = new SelectItem[groupes.size() + 1];
		etatFilter[0] = new SelectItem("", "");
		for (int i = 1; i <= groupes.size(); i++) {
			etatFilter[i] = new SelectItem(groupes.get(i - 1).getLibelle(),
					groupes.get(i - 1).getLibelle());
		}
		// etatFilter[1] = new
		// SelectItem(groupes.get(0).getLibelle(),groupes.get(0).getLibelle());
		// etatFilter[2] = new
		// SelectItem(groupes.get(1).getLibelle(),groupes.get(1).getLibelle());
		// etatFilter[3] = new
		// SelectItem(groupes.get(2).getLibelle(),groupes.get(2).getLibelle());

		return etatFilter;
	}

	public void setEtatFilter(SelectItem[] etatFilter) {
		PrecontentieuxBean.etatFilter = etatFilter;
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

	public PrecontentieuService getPrecontentieuService() {
		return precontentieuService;
	}

	public void setPrecontentieuService(
			PrecontentieuService precontentieuService) {
		this.precontentieuService = precontentieuService;
	}

	public List<Precontentieu> getPrecontentieus() {
		return precontentieus;
	}

	public void setPrecontentieus(List<Precontentieu> precontentieus) {
		this.precontentieus = precontentieus;
	}

	public Precontentieu getSelectPrec() {
		return selectPrec;
	}

	public void setSelectPrec(Precontentieu selectPrec) {
		this.selectPrec = selectPrec;
	}

	public HuissiersNotairesService getHuissiersNotairesService() {
		return huissiersNotairesService;
	}

	public void setHuissiersNotairesService(
			HuissiersNotairesService huissiersNotairesService) {
		this.huissiersNotairesService = huissiersNotairesService;
	}

	public List<HuissiersNotaires> getHuissiersNotaires() {
		return huissiersNotaires;
	}

	public void setHuissiersNotaires(List<HuissiersNotaires> huissiersNotaires) {
		this.huissiersNotaires = huissiersNotaires;
	}

	public HuissiersNotaires getSelectHuissNotaire() {
		return selectHuissNotaire;
	}

	public void setSelectHuissNotaire(HuissiersNotaires selectHuissNotaire) {
		this.selectHuissNotaire = selectHuissNotaire;
	}

	public Precontentieu getNewPrecontentieu() {
		return newPrecontentieu;
	}

	public void setNewPrecontentieu(Precontentieu newPrecontentieu) {
		this.newPrecontentieu = newPrecontentieu;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

}
