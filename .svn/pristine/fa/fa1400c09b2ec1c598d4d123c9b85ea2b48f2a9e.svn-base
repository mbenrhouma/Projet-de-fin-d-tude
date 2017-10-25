package com.cynapsys.Views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Cession;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Decompte;
import com.cynapsys.entities.DetailMensualite;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.NoteDebit;
import com.cynapsys.pojo.CalculInteretApresEcheancePojo;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;
import com.cynapsys.pojo.DecomptePojo;
import com.cynapsys.pojo.FinancierePojo;
import com.cynapsys.pojo.FraisPojo;
import com.cynapsys.pojo.IdentificationPojo;
import com.cynapsys.pojo.RecapPojo;
import com.cynapsys.pojo.TableauAmortissementImpressionPojo;
import com.cynapsys.service.AssuranceService;
import com.cynapsys.service.CessionService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.DecompteService;
import com.cynapsys.service.DetailMensualiteService;
import com.cynapsys.service.MensualiteService;
import com.cynapsys.service.MouvementService;
import com.cynapsys.service.NoteDebitService;
import com.cynapsys.service.TableauAmortissementService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "decompteBean")
@SessionScoped
public class DecompteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ************************************** Attributs
	// **************************************//



	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;

	@ManagedProperty(value = "#{mensualiteService}")
	private MensualiteService mensualiteService;

	@ManagedProperty(value = "#{tableauAmortissementService}")
	private TableauAmortissementService tableauAmortissementService;

	@ManagedProperty(value = "#{assuranceService}")
	private AssuranceService assuranceService;

	@ManagedProperty(value = "#{cessionService}")
	private CessionService cessionService;

	@ManagedProperty(value = "#{noteDebitService}")
	private NoteDebitService noteDebitService;
	
	@ManagedProperty(value = "#{mouvementService}")
	private MouvementService mouvementService;
	
	@ManagedProperty(value = "#{detailMensualiteService}")
	private DetailMensualiteService detailMensualiteService;
	
	@ManagedProperty(value = "#{decompteService}")
	private DecompteService decompteService;
	
	private List<ClientAcquereur> clientAcquereurList;
	

	private List<Mensualite> mensualiteList;
	private ClientAcquereur clientAcquereur;
	private String codeclient;
	private Integer fraisContrat;
	private Integer fraisLotissement;
	private Integer autreFrais;
	private Double interetRetard;
	private Double interetAprEch;
	private DecomptePojo decompte;
	private Integer rendered = 1;
	private Integer dureeContrat;
	
	
	private Integer totalCredit;
	private Integer totalDebit;
	private Integer totalEchCD;
	private Integer totalRestant;
	private Integer totalInteret;
	
	
	private Integer totalInteretApEch;
	private Integer totalVersApEch;
	

	
	
	
	// ************************************** Attributs
	// **************************************//

	public DecompteBean() {
		
	}
	
	// ************************************** Methodes
	// **************************************//

	@PostConstruct
	public void initialisation() {
		rendered = 1;
		clientAcquereur = new ClientAcquereur();
	//	clientAcquereurList = clientAcquereurService.findAllList();
		mensualiteList = new ArrayList<Mensualite>();
		autreFrais = 0;
		fraisContrat = 0;
		fraisLotissement = 0;
		interetAprEch=0.0;
		interetRetard=0.0;
		mensualiteList = new ArrayList<Mensualite>();
		decompte = new DecomptePojo();
		codeclient = "";

	}
	
	
	public void imprimeDecompte(){
		
		String report = "decompte.jasper";
		String subReport="decompte_sub1.jasper";
		
		IdentificationPojo identification =new IdentificationPojo();
		identification = decompte.getIdentification();
		
		FinancierePojo financiere =new FinancierePojo();
		financiere = decompte.getFinanciere();

		
		List<DecomptePojo> listDecompte = new ArrayList<DecomptePojo>();
		listDecompte.add(decompte);

		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("numOrdre", identification.getNumOrdre());
		params.put("codeClient", identification.getCodeClient());
		params.put("rang", identification.getRang());
		params.put("groupe", identification.getGroupe());
		params.put("nomClient", identification.getNomClient());
		params.put("adresse", identification.getAdresse());
		params.put("codePostal", identification.getCodePostal());
		params.put("prixProv", financiere.getPrixProv());
		params.put("prix", financiere.getPrix());
		params.put("avancePrix", financiere.getAvancePrix());
		params.put("solde", financiere.getSolde());
		params.put("assure", financiere.getAssure());
		params.put("interetRetard", financiere.getInteretRetard());
		params.put("interetAprEch", financiere.getInteretAprEch());
		params.put("dateDeb", financiere.getDateDeb());
		params.put("dateFin", financiere.getDateFin());
		
		params.put("dateDebContrat", decompte.getDateDebContrat());
		params.put("dateFinContrat", decompte.getDateFinContrat());
		
		
		params.put("totalCredit", totalCredit);
		params.put("totalDebit", totalDebit);
		params.put("totalEchCD", totalEchCD);
		params.put("totalRestant", totalRestant);
		params.put("totalInteret", totalInteret);

		
		//params frais
		params.put("fraisAssurance", decompte.getFrais().getFraisAssurance());
		params.put("fraisContentieux", decompte.getFrais().getFraisContentieux());
		params.put("fraisContrat", decompte.getFrais().getFraisContrat());
		params.put("fraisLotissement", decompte.getFrais().getFraisLotissement());
		params.put("autresFrais", decompte.getFrais().getAutresFrais());
		params.put("totalFrais", decompte.getFrais().getTotalFrais());
		
		//params recap
		params.put("soldeRecap", decompte.getRecap().getSolde());
		params.put("interet1Recap", decompte.getRecap().getInteret1());
		params.put("interet2Recap", decompte.getRecap().getInteret2());
		params.put("capitalRestantDuRecap", decompte.getRecap().getCapitalRestantDu());
		params.put("reliquatPrixRecap", decompte.getRecap().getReliquatPrix());
		params.put("echeanceCDRecap", decompte.getRecap().getEcheanceCD());
		
		params.put("recetteCDRecap", decompte.getRecap().getRecetteCD());
		params.put("cDNPRecap", decompte.getRecap().getcDNP());
		params.put("totalFraisRecap", decompte.getRecap().getTotalFrais());
		params.put("capitalDecesRecap", decompte.getRecap().getCapitalDeces());
		params.put("versApEchRecap", decompte.getRecap().getVersApEch());
		params.put("soldeDefinitifRecap", decompte.getRecap().getSoldeDefinitif());
		params.put("dateDecompte", decompte.getDateDecompte());
		params.put("datFineDecompte", decompte.getDateFinDecompte());
		GenerateRapport.exportPDFWithDataSourceSubReport(subReport, report, listDecompte, params, "decompte_"+clientAcquereur.getCodeAcquereur(), "mensualiteList");
		
	}
	
	public void saveDecompte(){
			try {
				
				Decompte newDecompte = new Decompte(interetRetard, new Date(), dureeContrat, totalDebit, totalCredit,decompte.getRecap().getSolde() , totalRestant,totalInteret ,
						interetAprEch,totalInteretApEch , totalInteret, decompte.getFrais().getFraisAssurance(), decompte.getFrais().getFraisContentieux(), fraisContrat, fraisLotissement,
						autreFrais, 0, "", 0, 0, clientAcquereur);
			
				decompteService.save(newDecompte);
				if (Constants.session.getAttribute("locale").toString().equals("fr"))
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_decompte_fr)
							.getString("decompte.cree.succes"));
				else {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_decompte_ar)
							.getString("decompte.cree.succes"));
				}
				initialisation();
			} catch (DuplicateKeyException e) {

				if (Constants.session.getAttribute("locale").toString().equals("fr"))
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_decompte_fr)
							.getString("decompte.error.existe"));
				else
					JsfUtil.addErrorMessage(ResourceBundle.getBundle(Constants.bundle_decompte_ar)
							.getString("decompte.error.existe"));

			}
		}


	public void calculDecompte() {
		rendered = 0;
		decompte = new DecomptePojo();
		clientAcquereur = clientAcquereurService.findById(codeclient);
		identification();
		financiere();
		tableauAmortissement();
		cessionSurSalaire();
		interetDeRetard();
		interetApresEcheance();
		frais();
		recap();
		
		decompte.setDateDebContrat(clientAcquereur.getDateDebut());
		decompte.setDateFinContrat(getDateFinContrat());
		decompte.setDateDecompte(new Date());
		decompte.setDateFinDecompte(new Date(new Date().getYear(), new Date().getMonth()+1, -1));
		
		
		if(clientAcquereur.getPrix()==null || clientAcquereur.getPrix()==0){
			if (Constants.session.getAttribute("locale").toString().equals("fr"))
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_decompte_fr)
						.getString("decompte.alertProv"));
			else {
				JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_decompte_ar)
						.getString("decompte.alertProv"));
			}
		}
	}

	private void recap() {

		RecapPojo recap = new RecapPojo();
		recap.setSolde(totalRestant);
		recap.setInteret1(totalInteret);
		recap.setInteret2(totalInteretApEch);
		Integer recetteCD = mouvementService.calculeRecetteCD(clientAcquereur);
		
		recap.setEcheanceCD(0-totalEchCD);
		recap.setRecetteCD(recetteCD);
		recap.setcDNP(totalEchCD+recetteCD);
		recap.setTotalFrais(decompte.getFrais().getTotalFrais());
		recap.setCapitalDeces(0);
		Date dateFin = getDateFinContrat();
		recap.setReliquatPrix(calculReliquatPrix());
		if(dateFin.before(new Date())){
			recap.setCapitalRestantDu(0);
		}else{
			
			recap.setCapitalRestantDu(calculRestantDu());
		}
		recap.setVersApEch(totalVersApEch);
		Integer soldeDef = totalRestant + totalInteret+totalInteretApEch +recetteCD-totalEchCD +recap.getTotalFrais()
				+recap.getCapitalDeces()+recap.getReliquatPrix()+totalVersApEch+recap.getCapitalRestantDu();
		recap.setSoldeDefinitif(soldeDef);
		
		decompte.setRecap(recap);

		
	}

	
	private Integer calculReliquatPrix(){
		
		clientAcquereur.getPrixProvisoire();
		Integer reliquatPrix=0;
		if(clientAcquereur.getPrixProvisoire()!=null && clientAcquereur.getPrixProvisoire().intValue()!=0){
			
			if(clientAcquereur.getPrix()!=null && clientAcquereur.getPrix().intValue()>clientAcquereur.getPrixProvisoire().intValue()){
				reliquatPrix = clientAcquereur.getPrix().intValue()-clientAcquereur.getPrixProvisoire().intValue();
			}
			
		}
		
		return reliquatPrix;
	}
	
	
	private Integer calculRestantDu(){
		
		Integer restanDu = 0;
		Date dateDeJour = new Date() ;

			List<DetailMensualite> listeDetailMens = detailMensualiteService.findAllMensualiteByClient(clientAcquereur);
			for (DetailMensualite detailMensualite : listeDetailMens) {
			if(!new Date().before(detailMensualite.getDateDeb()) && !new Date().after(detailMensualite.getDateFin())){
				int deff = nbrMoisEntreDeuxDate(detailMensualite.getDateDeb(), detailMensualite.getDateFin())+1;
				int moisCourant = dateDeJour.getMonth()+1;
				restanDu = detailMensualite.getCapitalRestantDu() -((detailMensualite.getAmortissement()*moisCourant)/deff);
			
			}
			
				
			}
			return restanDu ;
	
	
	}
	private void frais() {


		FraisPojo frais = new FraisPojo();
		
		frais.setAutresFrais(autreFrais);
		frais.setFraisContrat(fraisContrat);
		frais.setFraisLotissement(fraisLotissement);
		
		//frais assurance pas encore
		frais.setFraisAssurance(0);
		
		//frais contentieux
		List<NoteDebit> noteDebitList = new ArrayList<NoteDebit>();
		noteDebitList=noteDebitService.fraisContentieuxByClientAcquereur(clientAcquereur);
		int sommeFraisContentieux = 0;
		for (NoteDebit noteDebit : noteDebitList) {
			sommeFraisContentieux=sommeFraisContentieux+noteDebit.getMontant();
		}
		frais.setFraisContentieux(sommeFraisContentieux);
		int totalFrais = autreFrais+fraisContrat+fraisLotissement+sommeFraisContentieux+frais.getFraisAssurance();
		frais.setTotalFrais(totalFrais);
		decompte.setFrais(frais);
	}

	private void interetApresEcheance() {
		totalInteretApEch = 0;
		totalVersApEch=0;
		List<CalculInteretApresEcheancePojo> listInteretApresEch  = new ArrayList<CalculInteretApresEcheancePojo>();
		CalculInteretApresEcheancePojo premiereEch = new CalculInteretApresEcheancePojo();
		CalculInteretApresEcheancePojo derniereEch = new CalculInteretApresEcheancePojo();
		derniereEch.setDate(new Date());
		derniereEch.setMontant(0);
		Date derniereDate;
		Integer derniereSolde=totalRestant;
		
		Date dateFinContrat;
		dateFinContrat =getDateFinContrat();
		derniereDate=dateFinContrat;
		premiereEch = premiereEch(dateFinContrat);
		List<CalculInteretApresEcheancePojo> interetApresEchList = new ArrayList<CalculInteretApresEcheancePojo>();
		interetApresEchList = mouvementService.listMvmtApresEch(clientAcquereur, dateFinContrat);
		interetApresEchList.add(derniereEch);
		
		for (CalculInteretApresEcheancePojo calculInteretApresEcheancePojo : interetApresEchList) {
			totalVersApEch = totalVersApEch+calculInteretApresEcheancePojo.getMontant();
			int nbrMois = nbrMoisEntreDeuxDate(derniereDate,calculInteretApresEcheancePojo.getDate());
			Double interet = 0.0;
			if(derniereSolde.intValue()<0){
				interet= (derniereSolde*interetAprEch*nbrMois)/1200;
				totalInteretApEch = totalInteretApEch+interet.intValue();
			}
			calculInteretApresEcheancePojo.setSolde(derniereSolde);
			calculInteretApresEcheancePojo.setInteret(interet.intValue());
			derniereDate = calculInteretApresEcheancePojo.getDate();
			derniereSolde=derniereSolde+calculInteretApresEcheancePojo.getMontant();
		}
		listInteretApresEch.add(premiereEch);
		listInteretApresEch.addAll(interetApresEchList);
		
		decompte.setInteretApresEcheanceList(listInteretApresEch);
		
	}
	
	private int nbrMoisEntreDeuxDate(Date premiereDate,Date deuxiemeDate){
		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(premiereDate);
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(deuxiemeDate);

		int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		return diffMonth;
	}
	
	private CalculInteretApresEcheancePojo premiereEch(Date dateFinContrat){
		CalculInteretApresEcheancePojo premiereEch = new CalculInteretApresEcheancePojo();
		premiereEch.setDate(dateFinContrat);
		premiereEch.setInteret(0);
		premiereEch.setMontant(0);
		premiereEch.setSolde(totalRestant);
		
		return premiereEch;
	}
	
	
	@SuppressWarnings("deprecation")
	private void interetDeRetard() {
		
		totalCredit=0;
		 totalDebit=0;
		 totalEchCD=0;
		 totalRestant=0;
		totalInteret=0;
		Date dateFinContrat;
		
		Integer nbrMois = 12 - clientAcquereur.getDateDebut().getMonth() ;
		Integer solde=0;
		Integer cumul = 0;
		int testCession=0;
		List<CalculInteretDeRetardPojo> interetRetardList = new ArrayList<CalculInteretDeRetardPojo>();
		List<CalculInteretDeRetardPojo> listDebitRetard = new ArrayList<CalculInteretDeRetardPojo>();
		
		dateFinContrat =getDateFinContrat();
		interetRetardList=detailMensualiteService.findMensualiteByClient(clientAcquereur);
		listDebitRetard=mouvementService.calculeListDebitCridet(clientAcquereur,dateFinContrat);
		for (CalculInteretDeRetardPojo calculInteretDeRetardPojo : interetRetardList) {
			for (CalculInteretDeRetardPojo debitRetar : listDebitRetard) {
				if(calculInteretDeRetardPojo.getDate().equals(debitRetar.getDate())){
					calculInteretDeRetardPojo.setCredit(debitRetar.getCredit());
					break;
				}
			}
		}
		
		for (CalculInteretDeRetardPojo calculInteretDeRetardPojo : interetRetardList) {
			if(calculInteretDeRetardPojo.getCredit()==null){
				calculInteretDeRetardPojo.setCredit(0);
			}
			if(calculInteretDeRetardPojo.getDebit()==null){
				calculInteretDeRetardPojo.setDebit(0);
			}
			 testCession = testCessionSurSalaire(calculInteretDeRetardPojo.getDate());
			solde=calculInteretDeRetardPojo.getCredit()-calculInteretDeRetardPojo.getDebit();
			if(testCession!=0){
				calculInteretDeRetardPojo.setEchCD(testCession);
				solde=solde-testCession;
			}else {
				calculInteretDeRetardPojo.setEchCD(0);
			}
			cumul = cumul+solde;
			calculInteretDeRetardPojo.setSolde(solde);
			calculInteretDeRetardPojo.setCumulArriere(cumul);
			calculInteretDeRetardPojo.setCountMois(nbrMois);
			nbrMois = nbrMois+12;
			if(nbrMois>dureeContrat){
				nbrMois = dureeContrat;
			}
			
			Integer anneeCourante = 1900+new Date().getYear();
			
			if((calculInteretDeRetardPojo.getCumulArriere()+calculInteretDeRetardPojo.getDebit())<0 && (calculInteretDeRetardPojo.getDate()<anneeCourante)){
				//Calcule interet retard
				
				Double ip1= (calculInteretDeRetardPojo.getSolde()*interetRetard)/200;
				Double ip2 = ((calculInteretDeRetardPojo.getCumulArriere()-calculInteretDeRetardPojo.getSolde())*interetRetard)/100;
				Double interet = ip1+ip2;
				calculInteretDeRetardPojo.setInteret(interet.intValue());
				
			}else{
				calculInteretDeRetardPojo.setInteret(0);
			}
			
			
			totalCredit=totalCredit+calculInteretDeRetardPojo.getCredit();
			 totalDebit=totalDebit+calculInteretDeRetardPojo.getCredit();
			 totalEchCD=totalEchCD+calculInteretDeRetardPojo.getEchCD();
			 totalRestant=cumul;
			 totalInteret=totalInteret+calculInteretDeRetardPojo.getInteret();
			
		}
		
		decompte.setInteretRetardList(interetRetardList);
		
	}
	
	@SuppressWarnings("deprecation")
	private Date getDateFinContrat(){
		
		List<Mensualite> mensualiteList = new ArrayList<Mensualite>();
		mensualiteList=decompte.getMensualiteList();
		int flagDate=1;
		Date dateFin = new Date() ;
		for (Mensualite mensualite : mensualiteList) {
			
			if(flagDate==1){
				flagDate=0;
				dateFin=mensualite.getDateFin();
			}
			else{
				if(mensualite.getDateFin().after(dateFin)){
					dateFin=mensualite.getDateFin();
				}
				
			}
			
		}
		
		return 	new Date(dateFin.getYear(), dateFin.getMonth()+1, 1) ;
	}
	@SuppressWarnings("deprecation")
	private int testCessionSurSalaire(Integer annee){
		List<Cession> cessionList = decompte.getCessionList();
		int testCession = 0;

		if(cessionList!=null){
			Integer anneeDeb;
			Integer anneeFin;
		
		for (Cession cession : cessionList) {
			anneeDeb=1900+cession.getDateDebut().getYear();
			anneeFin=1900+cession.getDateFin().getYear();
			if(anneeDeb<annee &&anneeFin >annee){
				testCession=12*cession.getMensualite();
			}
			if(anneeDeb==annee){
				testCession=(12-cession.getDateDebut().getMonth())*cession.getMensualite();
			}
			if(anneeFin==annee){
				testCession=(cession.getDateFin().getMonth()+1)*cession.getMensualite();
			}
		}
		}
		return testCession;
	}
	
	
	private void cessionSurSalaire() {
		List<Cession> cessionList = new ArrayList<Cession>();
		cessionList = cessionService
				.findCessionByClientAcquereur(clientAcquereur);
		decompte.setCessionList(cessionList);
	}

	private void tableauAmortissement() {
		dureeContrat=0;
		List<Mensualite> mensualiteList = new ArrayList<Mensualite>();
		mensualiteList = mensualiteService
				.findByClientAcquereur(clientAcquereur);
		for (Mensualite mensualite : mensualiteList) {
			dureeContrat=dureeContrat+(mensualite.getDuree()*12);
		}
		decompte.setMensualiteList(mensualiteList);

	}

	private void financiere() {

		FinancierePojo financierePojo = new FinancierePojo();

		List<Assurance> assuranceList = new ArrayList<Assurance>();
		assuranceList = assuranceService.findAssuranceByClient(clientAcquereur
				.getCodeAcquereur());

		if (clientAcquereur.getAvance() != null) {
			financierePojo.setAvancePrix(clientAcquereur.getAvance());
		} else {
			financierePojo.setAvancePrix(0);

		}

		if (clientAcquereur.getPrix() != null) {
			financierePojo.setPrix(clientAcquereur.getPrix());
		} else {
			financierePojo.setPrix(0);
		}

		if (clientAcquereur.getPrixProvisoire() != null) {
			financierePojo.setPrixProv(clientAcquereur.getPrixProvisoire());
		} else {
			financierePojo.setPrixProv(0);
		}
		financierePojo.setSolde(clientAcquereur.getSolde());
		financierePojo.setInteretRetard(interetRetard);
		financierePojo.setInteretAprEch(interetAprEch);

		financierePojo.setDateDeb(clientAcquereur.getDateDebut());
		financierePojo.setDateFin(new Date());
		financierePojo.setAssure(Constants.non);
		for (Assurance assurance : assuranceList) {
			if (assurance.getTypeAssurance() != null
					&& assurance.getTypeAssurance() != 1) {
				financierePojo.setAssure(Constants.oui);
			}
		}
		decompte.setFinanciere(financierePojo);

	}

	private void identification() {

		IdentificationPojo identificationPojo = new IdentificationPojo();
		identificationPojo = clientAcquereurService
				.findIdentifClient(clientAcquereur);
		decompte.setIdentification(identificationPojo);

	}

	// ************************************** Methodes*********************************//

	// ************************************** Getter & Setter**************************//

	
	
	


	public CessionService getCessionService() {
		return cessionService;
	}

	public void setCessionService(CessionService cessionService) {
		this.cessionService = cessionService;
	}

	

	public ClientAcquereurService getClientAcquereurService() {
		return clientAcquereurService;
	}

	public void setClientAcquereurService(
			ClientAcquereurService clientAcquereurService) {
		this.clientAcquereurService = clientAcquereurService;
	}

	public MensualiteService getMensualiteService() {
		return mensualiteService;
	}

	public void setMensualiteService(MensualiteService mensualiteService) {
		this.mensualiteService = mensualiteService;
	}

	public TableauAmortissementService getTableauAmortissementService() {
		return tableauAmortissementService;
	}

	public void setTableauAmortissementService(
			TableauAmortissementService tableauAmortissementService) {
		this.tableauAmortissementService = tableauAmortissementService;
	}

	public List<Mensualite> getMensualiteList() {
		return mensualiteList;
	}

	public void setMensualiteList(List<Mensualite> mensualiteList) {
		this.mensualiteList = mensualiteList;
	}

	public List<ClientAcquereur> getClientAcquereurList() {
		return clientAcquereurList;
	}

	public void setClientAcquereurList(List<ClientAcquereur> clientAcquereurList) {
		this.clientAcquereurList = clientAcquereurList;
	}

	public ClientAcquereur getClientAcquereur() {
		return clientAcquereur;
	}

	public void setClientAcquereur(ClientAcquereur clientAcquereur) {
		this.clientAcquereur = clientAcquereur;
	}

	public Integer getFraisContrat() {
		return fraisContrat;
	}

	public void setFraisContrat(Integer fraisContrat) {
		this.fraisContrat = fraisContrat;
	}

	public Integer getFraisLotissement() {
		return fraisLotissement;
	}

	public void setFraisLotissement(Integer fraisLotissement) {
		this.fraisLotissement = fraisLotissement;
	}

	public Integer getAutreFrais() {
		return autreFrais;
	}

	public void setAutreFrais(Integer autreFrais) {
		this.autreFrais = autreFrais;
	}

	public DecomptePojo getDecompte() {
		return decompte;
	}

	public void setDecompte(DecomptePojo decompte) {
		this.decompte = decompte;
	}

	public Integer getRendered() {
		return rendered;
	}

	public void setRendered(Integer rendered) {
		this.rendered = rendered;
	}

	public AssuranceService getAssuranceService() {
		return assuranceService;
	}

	public void setAssuranceService(AssuranceService assuranceService) {
		this.assuranceService = assuranceService;
	}

	public NoteDebitService getNoteDebitService() {
		return noteDebitService;
	}

	public void setNoteDebitService(NoteDebitService noteDebitService) {
		this.noteDebitService = noteDebitService;
	}

	public String getCodeclient() {
		return codeclient;
	}

	public void setCodeclient(String codeclient) {
		this.codeclient = codeclient;
	}

	public Double getInteretRetard() {
		return interetRetard;
	}

	public void setInteretRetard(Double interetRetard) {
		this.interetRetard = interetRetard;
	}

	public Double getInteretAprEch() {
		return interetAprEch;
	}

	public void setInteretAprEch(Double interetAprEch) {
		this.interetAprEch = interetAprEch;
	}

	public MouvementService getMouvementService() {
		return mouvementService;
	}

	public void setMouvementService(MouvementService mouvementService) {
		this.mouvementService = mouvementService;
	}

	public Integer getDureeContrat() {
		return dureeContrat;
	}

	public void setDureeContrat(Integer dureeContrat) {
		this.dureeContrat = dureeContrat;
	}

	public Integer getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(Integer totalCredit) {
		this.totalCredit = totalCredit;
	}

	public Integer getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(Integer totalDebit) {
		this.totalDebit = totalDebit;
	}

	public Integer getTotalEchCD() {
		return totalEchCD;
	}

	public void setTotalEchCD(Integer totalEchCD) {
		this.totalEchCD = totalEchCD;
	}

	public Integer getTotalRestant() {
		return totalRestant;
	}

	public void setTotalRestant(Integer totalRestant) {
		this.totalRestant = totalRestant;
	}

	public Integer getTotalInteret() {
		return totalInteret;
	}

	public void setTotalInteret(Integer totalInteret) {
		this.totalInteret = totalInteret;
	}

	public DetailMensualiteService getDetailMensualiteService() {
		return detailMensualiteService;
	}

	public void setDetailMensualiteService(
			DetailMensualiteService detailMensualiteService) {
		this.detailMensualiteService = detailMensualiteService;
	}

	public Integer getTotalInteretApEch() {
		return totalInteretApEch;
	}

	public void setTotalInteretApEch(Integer totalInteretApEch) {
		this.totalInteretApEch = totalInteretApEch;
	}

	public Integer getTotalVersApEch() {
		return totalVersApEch;
	}

	public void setTotalVersApEch(Integer totalVersApEch) {
		this.totalVersApEch = totalVersApEch;
	}

	public DecompteService getDecompteService() {
		return decompteService;
	}

	public void setDecompteService(DecompteService decompteService) {
		this.decompteService = decompteService;
	}

	
	// ************************************** Getter & Setter*******************************//

}
