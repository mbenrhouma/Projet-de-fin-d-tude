package com.cynapsys.Views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import javax.servlet.http.HttpSession;

import com.cynapsys.entities.Cession;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Groupe;
import com.cynapsys.pojo.BundlePojo;
import com.cynapsys.pojo.EditionPojoList;
import com.cynapsys.pojo.ListCessionDelegPojo;
import com.cynapsys.pojo.SubReportClientACPOJO;
import com.cynapsys.pojo.SubreportListCessionDelegPojo;
import com.cynapsys.service.CessionService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.GroupeService;
import com.cynapsys.service.LogementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "editionBean")
@ViewScoped
public class EditionBean {

	public EditionBean() {
	}

	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;

	@ManagedProperty(value = "#{groupeService}")
	private GroupeService groupeService;
	@ManagedProperty(value = "#{logementService}")
	private LogementService logementService;
	@ManagedProperty(value = "#{cessionService}")
	private CessionService cessionService;
	private List<EditionPojoList> listpojoEdit;
	private List<ListCessionDelegPojo> listCessionDelegPojoGlob;

	private List<BundlePojo> listBundlePojo;
	private BundlePojo selectEdition;

	@PostConstruct
	public void initialisation() {
		selectOneMenu();

	}
	 

	public void selectOneMenu() {
		List<String> key = new ArrayList<String>();
		listBundlePojo = new ArrayList();

		if (Constants.getCurrentSession().getAttribute("locale").toString().equals("fr")) {
			key = Collections.list(ResourceBundle.getBundle(Constants.bundle_Edition_fr).getKeys());
			for (String val : key) {
				String valString = ResourceBundle.getBundle(Constants.bundle_Edition_fr).getString(val);
				BundlePojo bundlePojo = new BundlePojo();
				bundlePojo.setKey(val);
				bundlePojo.setValue(valString);
				listBundlePojo.add(bundlePojo);
			}

		} else {
			key = Collections.list(ResourceBundle.getBundle(Constants.bundle_Edition_ar).getKeys());
			for (String val : key) {
				String valString = ResourceBundle.getBundle(Constants.bundle_Edition_fr).getString(val);
				BundlePojo bundlePojo = new BundlePojo();
				bundlePojo.setKey(val);
				bundlePojo.setValue(valString);
				listBundlePojo.add(bundlePojo);
			}
		}

	}

	public void impressionSuitchVal() {
		if (selectEdition.getKey().equals("Listedesclients/groupe/parcode")) {
			List<ClientAcquereur> listCAPG = new ArrayList<ClientAcquereur>();
			listCAPG = clientAcquereurService.rechercheClientAcQEDITION();
			imprimerlisteClient(listCAPG);

		} else {
			if (selectEdition.getKey().equals("Listingdesclientsayantarrangement")) {
				List<ClientAcquereur> listCAPG = new ArrayList<ClientAcquereur>();
				listCAPG = clientAcquereurService.ayantArrEdition();
				imprimerlisteClient(listCAPG);

			} else {
				if (selectEdition.getKey().equals("ListingDesClientsQuiSonEnContentieux")) {
					List<ClientAcquereur> listCAPG = new ArrayList<ClientAcquereur>();
					listCAPG = clientAcquereurService.enContEdition();
					imprimerlisteClient(listCAPG);
				} else {
					if (selectEdition.getKey().equals("Listingdesclientsayantunprixprovisoire")) {
						List<ClientAcquereur> listCAPG = new ArrayList<ClientAcquereur>();
						listCAPG = clientAcquereurService.ayantPrixProvisEdition();
						imprimerlisteClient(listCAPG);
					} else {
						if (selectEdition.getKey()
								.equals("ListingDesClientsQuiOntUneCessionDelegationRetenuealasource")) {
							List<Cession> listCession = new ArrayList<Cession>();
							listCession = cessionService.ayantCessionDelegation();
							imprimerListCessionDelegPojo(listCession);

						} else {
							if (selectEdition.getKey().equals("ListedesclientsayantCDactive")) {
								List<Cession> listCession = new ArrayList<Cession>();
								listCession = cessionService.findCessionByClientAcquereurEditionCDActive();
								imprimerListCessionDelegPojo(listCession);

							} else {
								if (selectEdition.getKey().equals("ListedesclientsayantsCDechuenomarchive")) {

									List<Cession> listCession = new ArrayList<Cession>();
									listCession = cessionService.findCessionByClientAcquereurEditionCDEchuNonArchive();
									imprimerListCessionDelegPojo(listCession);
								}
							}

						}
					}

				}
			}
		}

	}

	
	
	
	public void trieparGroupe(List<ClientAcquereur> clientAquereurEdition) {

		Groupe lastGroup = new Groupe();
		lastGroup = null;
		listpojoEdit = new ArrayList<EditionPojoList>();

		EditionPojoList editionPojoList = new EditionPojoList();
		List<SubReportClientACPOJO> listGroupAcq = new ArrayList<SubReportClientACPOJO>();
		for (ClientAcquereur client : clientAquereurEdition) {

			if (lastGroup == null) {
				editionPojoList.setGroupe(client.getGroupe().getLibelle());
				SubReportClientACPOJO subReportClientACPOJO = new SubReportClientACPOJO();

				subReportClientACPOJO.setCodeAcquereur(client.getCodeAcquereur());
				subReportClientACPOJO.setAdresseLoge(client.getLogement().getAdresseLoge());
				subReportClientACPOJO.setCodePostal(client.getLogement().getCodePostal());
				subReportClientACPOJO.setNomPrenomFr(client.getNomPrenomFr());
				subReportClientACPOJO.setGroupe(client.getGroupe().getLibelle());
				if (client.getSolde() != null) {
					subReportClientACPOJO.setSolde(client.getSolde().toString());
				}
				listGroupAcq.add(subReportClientACPOJO);
				lastGroup = new Groupe();
				lastGroup = client.getGroupe();
			} else {

				if (client.getGroupe().getLibelle().equals(lastGroup.getLibelle())) {
					SubReportClientACPOJO subReportClientACPOJO = new SubReportClientACPOJO();
					subReportClientACPOJO.setCodeAcquereur(client.getCodeAcquereur());
					subReportClientACPOJO.setAdresseLoge(client.getLogement().getAdresseLoge());
					subReportClientACPOJO.setCodePostal(client.getLogement().getCodePostal());
					subReportClientACPOJO.setNomPrenomFr(client.getNomPrenomFr());
					subReportClientACPOJO.setGroupe(client.getGroupe().getLibelle());
					if (client.getSolde() != null) {
						subReportClientACPOJO.setSolde(client.getSolde().toString());
					}
					listGroupAcq.add(subReportClientACPOJO);

				} else {
					editionPojoList.setListEdition(listGroupAcq);
					listpojoEdit.add(editionPojoList);

					editionPojoList = new EditionPojoList();
					listGroupAcq = new ArrayList<SubReportClientACPOJO>();

					lastGroup = client.getGroupe();
					editionPojoList.setGroupe(lastGroup.getLibelle());
					SubReportClientACPOJO subReportClientACPOJO = new SubReportClientACPOJO();
					subReportClientACPOJO.setCodeAcquereur(client.getCodeAcquereur());
					subReportClientACPOJO.setAdresseLoge(client.getLogement().getAdresseLoge());
					subReportClientACPOJO.setNomPrenomFr(client.getNomPrenomFr());
					subReportClientACPOJO.setCodePostal(client.getLogement().getCodePostal());
					subReportClientACPOJO.setGroupe(client.getGroupe().getLibelle());
					if (client.getSolde() != null) {
						subReportClientACPOJO.setSolde(client.getSolde().toString());
					}
					listGroupAcq.add(subReportClientACPOJO);
				}
			}

		}
		editionPojoList.setListEdition(listGroupAcq);
		listpojoEdit.add(editionPojoList);

		editionPojoList = new EditionPojoList();
		listGroupAcq = new ArrayList<SubReportClientACPOJO>();

	}

	public void imprimerlisteClient(List<ClientAcquereur> clientAquereurEdition) {
		String subReportFileName = "ClientAcquereur_subreport1.jasper";
		String masterReportFileName = "ClientAcquereur.jasper";

		trieparGroupe(clientAquereurEdition);
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();

		Date sCertDate = (new Date());
		data.put("currentDate", sCertDate);
		data.put("titreEdition", selectEdition.getValue());

		GenerateRapport.exportPDFWithDataSourceSubReport(subReportFileName, masterReportFileName, listpojoEdit, data,
				selectEdition.getValue() + ".pdf", "listEdition");

	}

	public void ListCessionDelegPojo(List<Cession> listCession) {

		listCessionDelegPojoGlob = new ArrayList();
		List<SubreportListCessionDelegPojo> listSubreportListCessionDelegPojo = new ArrayList();
		ListCessionDelegPojo listCessionDelegPojo = new ListCessionDelegPojo();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");

		if (listCession != null) {
			for (Cession cession : listCession) {
				SubreportListCessionDelegPojo subreportListCessionDelegPojo = new SubreportListCessionDelegPojo();
				subreportListCessionDelegPojo
						.setCodeAcquereur(cession.getCessionClient().getClientAcquereur().getCodeAcquereur());
				subreportListCessionDelegPojo
						.setGroupe(cession.getCessionClient().getClientAcquereur().getGroupe().getLibelle());
				subreportListCessionDelegPojo
						.setNomPrenomFr(cession.getCessionClient().getClientAcquereur().getNomPrenomFr());
				subreportListCessionDelegPojo.setMensualites(cession.getMensualite().toString());
				List<Cession> listcount = new ArrayList();
				listcount = cessionService.findCessionByClientAcquereurEdition(
						cession.getCessionClient().getClientAcquereur().getCodeAcquereur());

				subreportListCessionDelegPojo.setNbLignes(listcount.size());
				String val = simpleFormat.format(cession.getDateDebut());
				val = val.concat("-");
				val = val.concat(simpleFormat.format(cession.getDateFin()));
				subreportListCessionDelegPojo.setEcheances(val);
				
			
				
				subreportListCessionDelegPojo.setMontantGlob(calculMontantTotalCession(cession));
				listSubreportListCessionDelegPojo.add(subreportListCessionDelegPojo);

			}

			listCessionDelegPojo.setListSubreportCessDelegPojo(listSubreportListCessionDelegPojo);
			listCessionDelegPojo.setNbTotalCd(listSubreportListCessionDelegPojo.size());
			

			

			listCessionDelegPojoGlob.add(listCessionDelegPojo);
		}
	}

	public void imprimerListCessionDelegPojo(List<Cession> listCession) {
		if(listCession==null){
			JsfUtil.addWarningMessage(ResourceBundle.getBundle(Constants.bundle_Edition_fr).getString("listeVide"));
			String masterReportFileName = "cessionDelegationVide.jasper";

			FacesContext cx = FacesContext.getCurrentInstance();
			ExternalContext extContext = cx.getExternalContext();
			HttpSession session = (HttpSession) extContext.getSession(true);
			HashMap<String, Object> data = new HashMap<String, Object>();

			Date sCertDate = (new Date());
			SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
			String DateEdition = simpleFormat.format(sCertDate);
			Integer AnneeEnC = Calendar.getInstance().get(Calendar.YEAR);
			String AnneeEnCour = AnneeEnC.toString();
			data.put("AnneeEnCour", AnneeEnCour);
			data.put("DateEdition", DateEdition);
			data.put("titreEdition", selectEdition.getValue());
			GenerateRapport.exportPDFWithDataSource( masterReportFileName, data, selectEdition.getValue() + ".pdf");
		
			
		}else{
		ListCessionDelegPojo(listCession);
		String subReportFileName = "listClientCessDEL_subreport1.jasper";
		String masterReportFileName = "listClientCessDEL.jasper";

		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();

		Date sCertDate = (new Date());
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");
		String DateEdition = simpleFormat.format(sCertDate);
		Integer AnneeEnC = Calendar.getInstance().get(Calendar.YEAR);
		String AnneeEnCour = AnneeEnC.toString();
		data.put("AnneeEnCour", AnneeEnCour);
		data.put("DateEdition", DateEdition);
		data.put("titreEdition", selectEdition.getValue());

		GenerateRapport.exportPDFWithDataSourceSubReport(subReportFileName, masterReportFileName,
				listCessionDelegPojoGlob, data, selectEdition.getValue() + ".pdf", "listSubreportCessDelegPojo");
		
		}
	}

	private Integer calculMontantTotalCession(Cession cession) {
		Integer duree, montant;
		if(cession.getDateFin().getYear()==cession.getDateDebut().getYear()){
		duree = (cession.getDateFin().getMonth() - cession.getDateDebut().getMonth());
		if(duree<0){
			duree=duree*-1;
		}
		if(duree==0){
			duree=1;
		}
		}else{
			Integer annee;
			Integer coef;
			annee=cession.getDateFin().getYear()-cession.getDateDebut().getYear();
			coef=cession.getDateFin().getMonth() - cession.getDateDebut().getMonth();
			duree=coef+(annee*12);
		}
		montant = duree * cession.getMensualite();
		if (montant != null && montant != 0) {
			return montant;
		} else {

			return null;
		}
	}

	
	public BundlePojo findBundlePojoById(String key){
		for(BundlePojo bundle: listBundlePojo) {
			if(bundle.getKey().equals(key)){
				return bundle;
			}
		}
		return null;
	}
	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public GroupeService getGroupeService() {
		return groupeService;
	}

	public void setGroupeService(GroupeService groupeService) {
		this.groupeService = groupeService;
	}

	public LogementService getLogementService() {
		return logementService;
	}

	public void setLogementService(LogementService logementService) {
		this.logementService = logementService;
	}

	public List<EditionPojoList> getListpojoEdit() {
		return listpojoEdit;
	}

	public void setListpojoEdit(List<EditionPojoList> listpojoEdit) {
		this.listpojoEdit = listpojoEdit;
	}

	public CessionService getCessionService() {
		return cessionService;
	}

	public void setCessionService(CessionService cessionService) {
		this.cessionService = cessionService;
	}

	public List<ListCessionDelegPojo> getListCessionDelegPojoGlob() {
		return listCessionDelegPojoGlob;
	}

	public void setListCessionDelegPojoGlob(List<ListCessionDelegPojo> listCessionDelegPojoGlob) {
		this.listCessionDelegPojoGlob = listCessionDelegPojoGlob;
	}

	public List<BundlePojo> getListBundlePojo() {
		return listBundlePojo;
	}

	public void setListBundlePojo(List<BundlePojo> listBundlePojo) {
		this.listBundlePojo = listBundlePojo;
	}

	public BundlePojo getSelectEdition() {
		return selectEdition;
	}

	public void setSelectEdition(BundlePojo selectEdition) {
		this.selectEdition = selectEdition;
	}

}
