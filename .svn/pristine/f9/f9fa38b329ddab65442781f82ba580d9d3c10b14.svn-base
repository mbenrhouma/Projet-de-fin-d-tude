package com.cynapsys.Views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.Cession;
import com.cynapsys.entities.CessionClient;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.service.CessionClientService;
import com.cynapsys.service.CessionService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.EmployeurService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.GenerateRapport;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "cessionBean")
@ViewScoped
public class CessionBean {

	@ManagedProperty(value = "#{cessionService}")
	private CessionService cessionService;

	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;

	@ManagedProperty(value = "#{employeurService}")
	private EmployeurService employeurService;

	@ManagedProperty(value = "#{cessionClientService}")
	private CessionClientService cessionClientService;

	private ClientAcquereur clientRechercher;
	private String codeclient;
	private String codeClient;
	private String nomclientfr;
	private Integer etatCession;

	private Boolean etat;
	private Cession newCession1;
	private Cession newCession2;
	private Cession newCession1C;
	private Cession newCession2C;
	private CessionClient newCessionClient;

	private Date dateCloture;

	private Cession selectCession;
	private CessionClient selectCessionClient;

	public int ModifCession = 1;
	private List<CessionClient> cessions;

	private List<CessionClient> cessionsClient;

	private List<Cession> filtered;
	private List<Cession> cession;
	private Employeur Employeur;
	private Employeur EmployeurC;

	private String matriculeEmployer1;
	private String matriculeEmployer2;

	private int compteconjoint;
	private CessionClient cessionCRecherche;

	private List<Employeur> employeurs;
	private String dateFin;

	@PostConstruct
	public void initialisation() {
		codeclient = null;
		nomclientfr = null;
		matriculeEmployer1 = null;
		matriculeEmployer2 = null;
		newCession1 = new Cession();
		newCession2 = new Cession();
		newCession1C = new Cession();
		newCession2C = new Cession();
		cessionCRecherche = new CessionClient();
		employeurs = employeurService.findAll();
		clientRechercher = new ClientAcquereur();
		newCessionClient = new CessionClient();

	}

	public void createCession() {
		matriculeEmployer1 = null;
		matriculeEmployer2 = null;
		codeclient = null;
		codeClient = null;
		nomclientfr = null;
		newCession1 = new Cession();
		newCession2 = new Cession();
		newCession1C = new Cession();
		newCession2C = new Cession();
		ModifCession = 1;
		selectCession = null;
		selectCessionClient = null;
		Employeur = new Employeur();
		EmployeurC = new Employeur();
		clientRechercher = new ClientAcquereur();
		cessions = null;
		etat = false;
		dateCloture = null;
	}

	public void confirmerClient() {
		RechercheClientAcquereurBean rechercheClientAcquereurBean = (RechercheClientAcquereurBean) FacesContext
				.getCurrentInstance()
				.getApplication()
				.evaluateExpressionGet(FacesContext.getCurrentInstance(),
						"#{rechercheClientAcquereurBean}",
						RechercheClientAcquereurBean.class);
		// ClientAcquereur clientAc =
		// rechercheClientAcquereurBean.getNewClientAcquereur();
		// newCession.setClientAcquereur(rechercheClientAcquereurBean.getNewClientAcquereur());
		codeclient = rechercheClientAcquereurBean.getNewClientAcquereur()
				.getCodeAcquereur().toString();
		onChange();
		rechercheClientAcquereurBean.initialisation();

	}

	public void onSelectCession() {
		newCessionClient = selectCessionClient;
		cession = new ArrayList<Cession>();
		ModifCession = 0;
		cession = cessionService.findCessionByCessionClient(newCessionClient);
	}

	public void initDate(Cession newCession) {
		newCession.setDateDebut(null);
		newCession.setDateFin(null);
		dateFin = null;
	}

	public void Rechercher() {

		ClientAcquereur clientaq = new ClientAcquereur();
		clientaq.setNomPrenomFr(nomclientfr);
		clientaq.setCodeAcquereur(codeClient);
		cessionCRecherche.setClientAcquereur(clientaq);
		cessionCRecherche.setActif(etatCession);
		cessions = cessionClientService.findByCriteres(cessionCRecherche);

	}

	public void onChange() {
		clientRechercher = clientAcquereurService.findById(codeclient);

		if (clientRechercher.getCompteConjoint() != null  && clientRechercher.getCompteConjoint()==1) {
			etat = true;
		} else  {
			etat = false;
		}

	}

	public void updateDateFin1() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTime(newCession1.getDateDebut());
		newCession1.setDateDebut(new Date(newCession1.getDateDebut().getYear(),
				newCession1.getDateDebut().getMonth(), 1));

		c.setTime(newCession1.getDateDebut());

		c.add(Calendar.MONTH, newCession1.getDuree());
		c.add(Calendar.DAY_OF_MONTH, -1);
		newCession1.setDateFin(c.getTime());
		dateFin = format.format(newCession1.getDateFin());

	}

	public void initDate1() {
		newCession1.setDateDebut(null);
		newCession1.setDateFin(null);
	}

	public void initDate2() {
		newCession2.setDateDebut(null);
		newCession2.setDateFin(null);
	}

	public void initDate1C() {
		newCession1C.setDateDebut(null);
		newCession1C.setDateFin(null);
	}

	public void initDate2C() {
		newCession2C.setDateDebut(null);
		newCession2C.setDateFin(null);
	}

	public void updateDateFin2() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTime(newCession2.getDateDebut());
		newCession2.setDateDebut(new Date(newCession2.getDateDebut().getYear(),
				newCession2.getDateDebut().getMonth(), 1));

		c.setTime(newCession2.getDateDebut());

		c.add(Calendar.MONTH, newCession2.getDuree());
		c.add(Calendar.DAY_OF_MONTH, -1);
		newCession2.setDateFin(c.getTime());

	}

	public void updateDateFin1C() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTime(newCession1C.getDateDebut());
		newCession1C.setDateDebut(new Date(newCession1C.getDateDebut()
				.getYear(), newCession1C.getDateDebut().getMonth(), 1));

		c.setTime(newCession1C.getDateDebut());

		c.add(Calendar.MONTH, newCession1C.getDuree());
		c.add(Calendar.DAY_OF_MONTH, -1);
		newCession1C.setDateFin(c.getTime());

	}

	public void updateDateFin2C() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c2.setTime(newCession2C.getDateDebut());
		newCession2C.setDateDebut(new Date(newCession2C.getDateDebut()
				.getYear(), newCession2C.getDateDebut().getMonth(), 1));

		c.setTime(newCession2C.getDateDebut());

		c.add(Calendar.MONTH, newCession2C.getDuree());
		c.add(Calendar.DAY_OF_MONTH, -1);
		newCession2C.setDateFin(c.getTime());

	}

	public void imprimerCession() {
		FacesContext cx = FacesContext.getCurrentInstance();
		ExternalContext extContext = cx.getExternalContext();
		HttpSession session = (HttpSession) extContext.getSession(true);
		HashMap<String, Object> data = new HashMap<String, Object>();

		if (selectCession.getConjoint() == 0) {

			if (selectCessionClient.getClientAcquereur().getNomPrenomAr() != null) {
				data.put("nomprenomAR", selectCessionClient
						.getClientAcquereur().getNomPrenomAr());
			} else {
				data.put("nomprenomAR", selectCessionClient
						.getClientAcquereur().getNomPrenomFr());
			}

			data.put("code", selectCessionClient.getClientAcquereur()
					.getLogement().getCodeLogement());
			data.put("adresselogement", selectCessionClient
					.getClientAcquereur().getLogement().getAdresseLoge());
			data.put("employeur", selectCession.getEmployeur()
					.getNomEmployeurFr());
			data.put("adresse", selectCessionClient.getClientAcquereur()
					.getAdresseCorrespondance());
			data.put("datedebut", selectCession.getDateDebut().toString().substring(0,10));
			data.put("mensualité", selectCession.getMensualite());
			data.put("periodecession", selectCession.getDuree() );
			data.put("montant", selectCession.getMensualite()*selectCession.getDuree());

			GenerateRapport.exportPDFWithDataSource("CessionSurSalaire.jasper",
					data, "CessionSurSaliare.pdf");
		}

		else if (selectCession.getConjoint() == 1) {

			if (selectCessionClient.getClientAcquereur()
					.getNomPrenomConjointAr() != null) {
				data.put("nomprenomAR", selectCessionClient
						.getClientAcquereur().getNomPrenomConjointAr());
			} else {
				data.put("nomprenomAR", selectCessionClient
						.getClientAcquereur().getNomPrenomConjointFr());
			}
			data.put("code", selectCessionClient.getClientAcquereur()
					.getLogement().getCodeLogement());
			data.put("adresselogement", selectCessionClient
					.getClientAcquereur().getLogement().getAdresseLoge());
			data.put("employeur", selectCession.getEmployeur()
					.getNomEmployeurFr());
			data.put("adresse", selectCessionClient.getClientAcquereur()
					.getAdresseCorrespondance());
			data.put("datedebut", selectCession.getDateDebut().toString().substring(0,10));
			data.put("mensualité", selectCession.getMensualite());
			data.put("periodecession", selectCession.getDuree() );
			data.put("montant", selectCession.getMensualite()*selectCession.getDuree());

			GenerateRapport.exportPDFWithDataSource("CessionSurSalaire.jasper",
					data, "CessionSurSaliare.pdf");
		}

	}

	public Integer testCession() {
		List<CessionClient> cessionsClients = new ArrayList<CessionClient>();
		cessionsClients = cessionClientService
				.findCessionByClientAcquereur(clientRechercher);

		if (cessionsClients.size() == 0) {
			return 0;
		}

		else {
			return 1;
		}
	}

	public void saveCession() {

		if (ModifCession == 1) {

			if (testCession() == 1) {
				JsfUtil.addWarningMessage(ResourceBundle.getBundle(
						Constants.bundle_cession_fr)
						.getString("cession.existe"));
			} else {
				try {
					newCessionClient.setClientAcquereur(clientRechercher);
					newCessionClient.setActif(1);
					newCessionClient = (CessionClient) cessionClientService
							.save(newCessionClient);

					if (newCession1.getDateDebut() != null
							&& newCession1.getDateFin() != null
							&& newCession1.getMensualite() != null) {

						newCession1.setConjoint(0);
						newCession1.setEmployeur(Employeur);
						newCession1.setMatriculeEmployer(matriculeEmployer1);
						newCession1.setCessionClient(newCessionClient);
						newCession1.setCd(1);
						cessionService.save(newCession1);
					}

					if (newCession2.getDateDebut() != null
							&& newCession2.getDateFin() != null
							&& newCession2.getMensualite() != null) {
						newCession2.setConjoint(0);
						newCession2.setCessionClient(newCessionClient);
						newCession2.setEmployeur(Employeur);
						newCession2.setMatriculeEmployer(matriculeEmployer1);
						newCession2.setCd(2);
						cessionService.save(newCession2);
					}

					if (newCession1C.getDateDebut() != null
							&& newCession1C.getDateFin() != null
							&& newCession1C.getMensualite() != null) {
						newCession1C.setConjoint(1);
						newCession1C.setEmployeur(EmployeurC);
						newCession1C.setCessionClient(newCessionClient);
						newCession1C.setMatriculeEmployer(matriculeEmployer2);
						newCession1C.setCd(1);
						cessionService.save(newCession1C);
					}

					if (newCession2C.getDateDebut() != null
							&& newCession2C.getDateFin() != null
							&& newCession2C.getMensualite() != null) {
						newCession2C.setConjoint(1);
						newCession2C.setCessionClient(newCessionClient);
						newCession2C.setEmployeur(EmployeurC);
						newCession2C.setMatriculeEmployer(matriculeEmployer2);
						newCession2C.setCd(2);
						cessionService.save(newCession2C);
					}
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
							Constants.bundle_cession_fr).getString(
							"cession.cree.succes"));

				} catch (DuplicateKeyException e) {
					JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
							Constants.bundle_cession_fr).getString(
							"cession.error.modifie"));
				}
			}
		}
		if (!isValidFailed()) {
			createCession();
		}

		// else {
		// try {
		// if (etat) {
		// newCession.setConjoint(BigInteger.valueOf(1));
		// } else {
		// newCession.setConjoint(BigInteger.valueOf(0));
		// }
		// newCession.setEmployeur(Employeur);
		// cessionService.update(newCession);
		// JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
		// Constants.bundle_cession_fr).getString(
		// "cession.modifie.succes"));
		//
		// } catch (DuplicateKeyException e) {
		// JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
		// Constants.bundle_cession_fr).getString(
		// "employeur.error.modifie"));
		// }
		// }

	}

	public void cloturerCession() {
		for (Cession cession : cession) {

			if (dateCloture.before(cession.getDateDebut())) {
				cession.setDateFin(cession.getDateDebut());
				cessionService.update(cession);
			} else if (dateCloture.before(cession.getDateFin())
					&& dateCloture.after(cession.getDateDebut())) {
				cession.setDateFin(dateCloture);
				cessionService.update(cession);
			}
		}

		selectCessionClient.setActif(0);
		selectCessionClient.setDateCloture(dateCloture);
		cessionClientService.update(selectCessionClient);
		createCession();
		JsfUtil.addSuccessMessage(ResourceBundle.getBundle(
				Constants.bundle_cession_fr)
				.getString("cession.modifie.succes"));

	}

	private boolean isValidFailed() {
		return JsfUtil.isValidationFailed();
	}

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

	public ClientAcquereur getClientRechercher() {
		return clientRechercher;
	}

	public void setClientRechercher(ClientAcquereur clientRechercher) {
		this.clientRechercher = clientRechercher;
	}

	public Cession getSelectCession() {
		return selectCession;
	}

	public void setSelectCession(Cession selectCession) {
		this.selectCession = selectCession;
	}

	public List<CessionClient> getCessions() {
		return cessions;
	}

	public void setCessions(List<CessionClient> cessions) {
		this.cessions = cessions;
	}

	public List<Cession> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Cession> filtered) {
		this.filtered = filtered;
	}

	public SelectItem[] getCessionOptions() {
		return cessionOptions;
	}

	public void setCessionOptions(SelectItem[] cessionOptions) {
		this.cessionOptions = cessionOptions;
	}

	private SelectItem[] cessionOptions;

	public void setEmployeurService(EmployeurService employeurService) {
		this.employeurService = employeurService;
	}

	public EmployeurService getEmployeurService() {
		return employeurService;
	}

	public String getCodeclient() {
		return codeclient;
	}

	public void setCodeclient(String codeclient) {
		this.codeclient = codeclient;
	}

	public Employeur getEmployeur() {
		return Employeur;
	}

	public void setEmployeur(Employeur employeur) {
		Employeur = employeur;
	}

	public int getCompteconjoint() {
		return compteconjoint;
	}

	public void setCompteconjoint(int compteconjoint) {
		this.compteconjoint = compteconjoint;
	}

	public int getModifCession() {
		return ModifCession;
	}

	public void setModifCession(int modifCession) {
		ModifCession = modifCession;
	}

	public String getNomclientfr() {
		return nomclientfr;
	}

	public void setNomclientfr(String nomclientfr) {
		this.nomclientfr = nomclientfr;
	}

	public String getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public List<Employeur> getEmployeurs() {
		return employeurs;
	}

	public void setEmployeurs(List<Employeur> employeurs) {
		this.employeurs = employeurs;
	}

	public Employeur getEmployeurC() {
		return EmployeurC;
	}

	public void setEmployeurC(Employeur employeurC) {
		EmployeurC = employeurC;
	}

	public String getMatriculeEmployer1() {
		return matriculeEmployer1;
	}

	public void setMatriculeEmployer1(String matriculeEmployer1) {
		this.matriculeEmployer1 = matriculeEmployer1;
	}

	public String getMatriculeEmployer2() {
		return matriculeEmployer2;
	}

	public void setMatriculeEmployer2(String matriculeEmployer2) {
		this.matriculeEmployer2 = matriculeEmployer2;
	}

	public Cession getNewCession1() {
		return newCession1;
	}

	public void setNewCession1(Cession newCession1) {
		this.newCession1 = newCession1;
	}

	public Cession getNewCession2() {
		return newCession2;
	}

	public void setNewCession2(Cession newCession2) {
		this.newCession2 = newCession2;
	}

	public Cession getNewCession1C() {
		return newCession1C;
	}

	public void setNewCession1C(Cession newCession1C) {
		this.newCession1C = newCession1C;
	}

	public Cession getNewCession2C() {
		return newCession2C;
	}

	public void setNewCession2C(Cession newCession2C) {
		this.newCession2C = newCession2C;
	}

	public List<CessionClient> getCessionsClient() {
		return cessionsClient;
	}

	public void setCessionsClient(List<CessionClient> cessionsClient) {
		this.cessionsClient = cessionsClient;
	}

	public CessionClient getNewCessionClient() {
		return newCessionClient;
	}

	public void setNewCessionClient(CessionClient newCessionClient) {
		this.newCessionClient = newCessionClient;
	}

	public CessionClientService getCessionClientService() {
		return cessionClientService;
	}

	public void setCessionClientService(
			CessionClientService cessionClientService) {
		this.cessionClientService = cessionClientService;
	}

	public CessionClient getCessionCRecherche() {
		return cessionCRecherche;
	}

	public void setCessionCRecherche(CessionClient cessionCRecherche) {
		this.cessionCRecherche = cessionCRecherche;
	}

	public CessionClient getSelectCessionClient() {
		return selectCessionClient;
	}

	public void setSelectCessionClient(CessionClient selectCessionClient) {
		this.selectCessionClient = selectCessionClient;
	}

	public List<Cession> getCession() {
		return cession;
	}

	public void setCession(List<Cession> cession) {
		this.cession = cession;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Integer getEtatCession() {
		return etatCession;
	}

	public void setEtatCession(Integer etatCession) {
		this.etatCession = etatCession;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

}
