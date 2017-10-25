package com.cynapsys.Views;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.DuplicateKeyException;

import com.cynapsys.entities.Cession;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.CompteAttente;
import com.cynapsys.entities.DetailQuittanceEmployeur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.Quitance;
import com.cynapsys.entities.QuitanceEmployeur;
import com.cynapsys.pojo.CessionSurSalaire;
import com.cynapsys.pojo.DetailCession;
import com.cynapsys.service.CessionService;
import com.cynapsys.service.ClientAcquereurService;
import com.cynapsys.service.CompteAttenteService;
import com.cynapsys.service.DetailQuittanceEmployeurService;
import com.cynapsys.service.EmployeurService;
import com.cynapsys.service.QuitanceEmployeurService;
import com.cynapsys.service.QuitanceService;
import com.cynapsys.utils.Constants;
import com.cynapsys.utils.JsfUtil;

@ManagedBean(name = "reglemenetEmployeurBean")
@SessionScoped
public class ReglemenetEmployeurBean {
	
	@ManagedProperty(value = "#{employeurService}")
	private EmployeurService  employeurService;
	
	@ManagedProperty(value = "#{detailQuittanceEmployeurService}")
	private DetailQuittanceEmployeurService  detailQuittanceEmployeurService;
	
	@ManagedProperty(value = "#{cessionService}")
	private CessionService  cessionService;
	
	@ManagedProperty(value = "#{quitanceEmployeurService}")
	private QuitanceEmployeurService  quitanceEmployeurService ;
	
	@ManagedProperty(value = "#{compteAttenteService}")
	private CompteAttenteService compteAttenteService;
	
	@ManagedProperty(value = "#{quitanceService}")
	private QuitanceService quitanceService ;
	
	@ManagedProperty(value = "#{clientAcquereurService}")
	private ClientAcquereurService clientAcquereurService;
	
//	private CompteAttente compte410500 ;
	private Quitance newQuitance ;
    private CompteAttente compte ;
	private Employeur selectEmployeur;
	private Quitance selectQuitance ;
	private List<Employeur>  employeurs ;
	private Integer montant;
	private List<Cession> cessions;
	private QuitanceEmployeur newQuittanceEmployeur;
	private String dateFin;
	private Integer difference;
	private List<QuitanceEmployeur> quitances ;
	private List <Quitance> quitancesAttentes ;
	private List <CessionSurSalaire> cessioneEmploye ;
	private CessionSurSalaire newCession ;
	private Integer selectQ = 1 ;
	private DetailQuittanceEmployeur newDetailQuittance ;
    private Long sommeQuittance ;
    private Integer reste ;
    private List<DetailCession> detaiCessions ;
	private ClientAcquereur clientacq ;

	



@PostConstruct
public void initialisation(){	
	compte = new CompteAttente();
	employeurs= employeurService.findAll();
	newQuittanceEmployeur= new QuitanceEmployeur();
	quitances = quitanceEmployeurService.findAll();
	newQuitance = new Quitance();
	quitancesAttentes = new ArrayList<Quitance>();
	cessioneEmploye = new ArrayList<CessionSurSalaire>();
	newCession = new CessionSurSalaire();
	newDetailQuittance = new DetailQuittanceEmployeur();
	clientacq = new ClientAcquereur();
	
	}



public void createQuittance(){
	newQuittanceEmployeur= new QuitanceEmployeur();
	selectEmployeur = null;
	dateFin = null ;
	difference = null ;
	montant = null ;
	newQuittanceEmployeur= new QuitanceEmployeur();
	cessioneEmploye = new ArrayList<CessionSurSalaire>();
	newQuitance = new Quitance();
	quitancesAttentes = new ArrayList<Quitance>();
	selectQ = 1 ;
	selectQuitance = null ;
	
	
	
	
}

public Integer testmontant() {
	Integer total = 0 ;
	for (CessionSurSalaire c : cessioneEmploye){
		total = total + c.getMontantrecu();
	}
	return total;
	
	
}
public void saveQuittance(){ 
	Integer tot = testmontant();
	if (tot.equals(newQuittanceEmployeur.getMontantEnc()) ){
	try {
		
		
	
		
	newQuittanceEmployeur.setEmployeur(selectEmployeur);
	newQuittanceEmployeur.setMontantImpayee(difference);
	quitanceEmployeurService.save(newQuittanceEmployeur);
	compte = compteAttenteService.findById("410500");
	compte.setSolde(compte.getSolde() - newQuittanceEmployeur.getMontantEnc());
	compteAttenteService.update(compte);
	selectQuitance.setEtatQuitance(1);
	quitanceService.update(selectQuitance);
	
	for (CessionSurSalaire a : cessioneEmploye) {
		newDetailQuittance = new DetailQuittanceEmployeur() ;
		newDetailQuittance.setQuittanceEmployeur(newQuittanceEmployeur);
		newDetailQuittance.setCession(a.getCession());
		newDetailQuittance.setNombredemois(a.getDuree());
		newDetailQuittance.setMontantapayé(a.getMontant());
		newDetailQuittance.setMontantrecu(a.getMontantrecu());
		newDetailQuittance.setMontantrestant(a.getMontant() - a.getMontantrecu() );
		clientacq=a.getCession().getCessionClient().getClientAcquereur();
		clientacq.setSolde(clientacq.getSolde()+a.getMontantrecu());
		clientAcquereurService.update(clientacq);
		
		detailQuittanceEmployeurService.save(newDetailQuittance);
		
	}
	JsfUtil.addSuccessMessage(ResourceBundle.getBundle(Constants.bundle_quittance_fr).getString("quittance.declasser.succes"));
	} catch (DuplicateKeyException e) {
		JsfUtil.addErrorMessage(ResourceBundle.getBundle(
				Constants.bundle_quittance_fr).getString(
				"quittance.error.ajout"));
	}

	createQuittance();} 
	else {JsfUtil.addErrorMessage("Somme montant encaissé invalide ");
}
	
	
}

public void chercherQuittance(){ 
	newQuitance.setNomEmployeur(selectEmployeur.getNomEmployeurFr());
	compte.setNumCompte("410500");
	newQuitance.setCompteAttente(compte);
	newQuitance.setEtatQuitance(0);
	quitancesAttentes = quitanceService.rechercheQuitance(newQuitance);
	
}

public void onSelectQuittance (){
	newQuittanceEmployeur.setNumQuittance(Integer.valueOf(selectQuitance.getNumQuittance()));
	newQuittanceEmployeur.setEmployeur(selectEmployeur);
	newQuittanceEmployeur.setMontantEnc(selectQuitance.getMontant());
	selectQ = 0 ;
	
}




public void initDate() {
	newQuittanceEmployeur.setDateDeb(null);
	newQuittanceEmployeur.setDateFin(null);
	dateFin = null;
}

public void updateDateFin() {
	reste = 0 ;
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	Calendar c = Calendar.getInstance();
	Calendar c2 = Calendar.getInstance();
	
	c2.setTime(newQuittanceEmployeur.getDateDeb());
	newQuittanceEmployeur.setDateDeb(new Date(newQuittanceEmployeur
			.getDateDeb().getYear(), newQuittanceEmployeur.getDateDeb()
			.getMonth(), 1));
	
	c.setTime(newQuittanceEmployeur.getDateDeb());
	
	c.add(Calendar.MONTH, newQuittanceEmployeur.getDuree());
	c.add(Calendar.DAY_OF_MONTH, -1);
   	newQuittanceEmployeur.setDateFin(c.getTime());
	dateFin = format.format(newQuittanceEmployeur.getDateFin());
	newQuittanceEmployeur.setEmployeur(selectEmployeur);
	reste = CalculerMontant()- SommeQuittance() ;
	calculerDifference();

}

//public String getThisYearTotal() {
//    int total = 0;
//
//    for(CessionSurSalaire sale : cessioneEmploye) {
//        total += sale.getMontantrecu();
//    }
//
//    return new DecimalFormat("###,###.###").format(total);
//}
	

public Integer CalculerMontant() {
	montant = 0;
	cessions=cessionService.findCessionbyDate(newQuittanceEmployeur.getDateDeb(), newQuittanceEmployeur.getDateFin(), newQuittanceEmployeur.getEmployeur());
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	for (Cession cession : cessions) {
		
		if((cession.getDateDebut().compareTo(newQuittanceEmployeur.getDateDeb())>=0)&&(cession.getDateFin().compareTo(newQuittanceEmployeur.getDateFin())<=0)){
			    
			 Date gc1;
		        gc1= cession.getDateDebut();
		        Date gc2;
		        gc2=cession.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
		        }
			
			montant=montant+(gap * cession.getMensualite());
		        
			   
			
 		}else if((cession.getDateDebut().compareTo(newQuittanceEmployeur.getDateDeb())>=0)&& (cession.getDateFin().compareTo(newQuittanceEmployeur.getDateFin())>0)){
		       
		        Date gc1;
		        gc1= cession.getDateDebut();
		        Date gc2;
		        gc2=newQuittanceEmployeur.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
 		        }
		        montant=montant+(gap * cession.getMensualite());
		
		}else if ((newQuittanceEmployeur.getDateDeb().compareTo(cession.getDateDebut())>=0)&&(newQuittanceEmployeur.getDateFin().compareTo(cession.getDateFin())<=0)) {
			
			 Date gc1;
		        gc1= newQuittanceEmployeur.getDateDeb();
		        Date gc2;
		        gc2=newQuittanceEmployeur.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
		        }
		        montant=montant+(gap * cession.getMensualite());
			
		   }else  {
			
			  Date gc1;
		        gc1= newQuittanceEmployeur.getDateDeb();
		        Date gc2;
		        gc2=cession.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
		        }
		        montant=montant+(gap * cession.getMensualite());
			
	 }}
	
	return montant;
				
}

//public List<CessionSurSalaire> List (){
//	List<DetailQuittanceEmployeur> li = detailQuittanceEmployeurService.findAll() ;
//	while (li.size()<0) {
//		int so = 0 ;
//		Cession = Cessio 
//		
//	}
//}


public Integer testerlist ( Cession cess ){
	  
	   Long test=0L;
	   detaiCessions=new ArrayList<DetailCession>();
	   detaiCessions=detailQuittanceEmployeurService.calculeSommeDQ(newQuittanceEmployeur, newQuittanceEmployeur.getEmployeur());

	   for (int i = 0 ; i < detaiCessions.size() ; i++) {
		   System.out.println(detaiCessions);
		if (detaiCessions.get(i).equals(cess.getId())) {
			test= detaiCessions.get(i).getSommeMontantrecu() ;
				}  else {test = 0L ; }
   }
	   return Integer.valueOf(test.intValue()) ;  	  
}





public List<CessionSurSalaire> ListerCession() {
	
	cessions=cessionService.findCessionbyDate(newQuittanceEmployeur.getDateDeb(), newQuittanceEmployeur.getDateFin(), newQuittanceEmployeur.getEmployeur());
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 
	
	cessioneEmploye = new ArrayList<CessionSurSalaire>();
	for (Cession cession : cessions) {
		
		if((cession.getDateDebut().compareTo(newQuittanceEmployeur.getDateDeb())>=0)&& (cession.getDateFin().compareTo(newQuittanceEmployeur.getDateFin())<=0)){
			    
			   Date gc1;
	            gc1= cession.getDateDebut();
	           Date gc2;
	            gc2=cession.getDateFin();
	        int gap = 0;
	        while(gc1.compareTo(gc2)<=0) {
	            gap++;
	            Calendar c1=Calendar.getInstance();
	            c1.setTime(gc1);
	            c1.add(Calendar.MONTH, 1);
	            gc1=c1.getTime();
		        }
			    
		        newCession = new CessionSurSalaire();
		        newCession.setCession(cession);
		        newCession.setDuree(gap);
		        newCession.setMontant(cession.getDuree() * cession.getMensualite());
		        cessioneEmploye.add(newCession);
		        
		       
		        
		        
			   
			
 		}else if(cession.getDateDebut().compareTo(newQuittanceEmployeur.getDateDeb())>=0 && (cession.getDateFin().compareTo(newQuittanceEmployeur.getDateFin())>0)){
		       
		        Date gc1;
		        gc1= cession.getDateDebut();
		        Date gc2;
		        gc2=newQuittanceEmployeur.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
 		        }
		        
		        newCession = new CessionSurSalaire();
		        newCession.setCession(cession);
		        newCession.setDuree(gap);
		        newCession.setMontant(gap * cession.getMensualite());
		        cessioneEmploye.add(newCession);
		        
		}else if ((newQuittanceEmployeur.getDateDeb().compareTo(cession.getDateDebut())>=0)&&(newQuittanceEmployeur.getDateFin().compareTo(cession.getDateFin())<=0)) {
			 Date gc1;
		        gc1= newQuittanceEmployeur.getDateDeb();
		        Date gc2;
		        gc2=newQuittanceEmployeur.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
		        }
		        
		        newCession = new CessionSurSalaire();
		        newCession.setCession(cession);
		        newCession.setDuree(gap);
		        newCession.setMontant(gap * cession.getMensualite());
		        cessioneEmploye.add(newCession);
			
			
		}else{
			
			
			  Date gc1;
		        gc1= newQuittanceEmployeur.getDateDeb();
		        Date gc2;
		        gc2=cession.getDateFin();
		        int gap = 0;
		        while(gc1.compareTo(gc2)<=0) {
		            gap++;
		            Calendar c1=Calendar.getInstance();
		            c1.setTime(gc1);
		            c1.add(Calendar.MONTH, 1);
		            gc1=c1.getTime();
		        }	
		        
		        newCession = new CessionSurSalaire();
		        newCession.setCession(cession);
		        newCession.setDuree(gap);
		        newCession.setMontant(gap * cession.getMensualite());
		        cessioneEmploye.add(newCession);	
		        
					
		}
			
	}
	
	return cessioneEmploye ;
				 
}


public Integer SommeQuittance (){
	Integer i ;
	sommeQuittance = quitanceEmployeurService.sommeQuittanceEmployeur(newQuittanceEmployeur, newQuittanceEmployeur.getEmployeur()).get(0);
	if (sommeQuittance == null) {
		i=0 ;
	}else {i=Integer.valueOf(sommeQuittance.intValue());}
	return i ;
}



public Integer calculerDifference(){
	 	 
	 difference =  reste - newQuittanceEmployeur.getMontantEnc() ;
	 return difference ;
}




public Quitance getSelectQuitance() {
	return selectQuitance;
}

public void setSelectQuitance(Quitance selectQuitance) {
	this.selectQuitance = selectQuitance;
}

public EmployeurService getEmployeurService() {
	return employeurService;
}



public void setEmployeurService(EmployeurService employeurService) {
	this.employeurService = employeurService;
}



public Employeur getSelectEmployeur() {
	return selectEmployeur;
}



public void setSelectEmployeur(Employeur selectEmployeur) {
	this.selectEmployeur = selectEmployeur;
}



public List<Employeur> getEmployeurs() {
	return employeurs;
}



public void setEmployeurs(List<Employeur> employeurs) {
	this.employeurs = employeurs;
}




public Integer getMontant() {
	return montant;
}



public void setMontant(Integer montant) {
	this.montant = montant;
}






public List<Cession> getCessions() {
	return cessions;
}



public void setCessions(List<Cession> cessions) {
	this.cessions = cessions;
}






public CessionService getCessionService() {
	return cessionService;
}






public void setCessionService(CessionService cessionService) {
	this.cessionService = cessionService;
	
}



public QuitanceEmployeur getNewQuittanceEmployeur() {
	return newQuittanceEmployeur;
}

public void setNewQuittanceEmployeur(QuitanceEmployeur newQuittanceEmployeur) {
	this.newQuittanceEmployeur = newQuittanceEmployeur;
}

public String getDateFin() {
	return dateFin;
}

public void setDateFin(String dateFin) {
	this.dateFin = dateFin;
}

public Integer getDifference() {
	return difference;
}

public void setDifference(Integer difference) {
	this.difference = difference;
}

public QuitanceEmployeurService getQuitanceEmployeurService() {
	return quitanceEmployeurService;
}

public void setQuitanceEmployeurService(
		QuitanceEmployeurService quitanceEmployeurService) {
	this.quitanceEmployeurService = quitanceEmployeurService;
}

public List<QuitanceEmployeur> getQuitances() {
	return quitances;
}

public void setQuitances(List<QuitanceEmployeur> quitances) {
	this.quitances = quitances;
}

public QuitanceService getQuitanceService() {
	return quitanceService;
}

public void setQuitanceService(QuitanceService quitanceService) {
	this.quitanceService = quitanceService;
}

public Quitance getNewQuitance() {
	return newQuitance;
}

public void setNewQuitance(Quitance newQuitance) {
	this.newQuitance = newQuitance;
}

public List<Quitance> getQuitancesAttentes() {
	return quitancesAttentes;
}

public void setQuitancesAttentes(List<Quitance> quitancesAttentes) {
	this.quitancesAttentes = quitancesAttentes;
}

public List<CessionSurSalaire> getCessioneEmploye() {
	return cessioneEmploye;
}

public void setCessioneEmploye(List<CessionSurSalaire> cessioneEmploye) {
	this.cessioneEmploye = cessioneEmploye;
}

public CessionSurSalaire getNewCession() {
	return newCession;
}

public void setNewCession(CessionSurSalaire newCession) {
	this.newCession = newCession;
}



public Integer getSelectQ() {
	return selectQ;
}



public void setSelectQ(Integer selectQ) {
	this.selectQ = selectQ;
}



public CompteAttente getCompte() {
	return compte;
}



public void setCompte(CompteAttente compte) {
	this.compte = compte;
}



public CompteAttenteService getCompteAttenteService() {
	return compteAttenteService;
}



public void setCompteAttenteService(CompteAttenteService compteAttenteService) {
	this.compteAttenteService = compteAttenteService;
}



public DetailQuittanceEmployeurService getDetailQuittanceEmployeurService() {
	return detailQuittanceEmployeurService;
}



public void setDetailQuittanceEmployeurService(
		DetailQuittanceEmployeurService detailQuittanceEmployeurService) {
	this.detailQuittanceEmployeurService = detailQuittanceEmployeurService;
}



public DetailQuittanceEmployeur getNewDetailQuittance() {
	return newDetailQuittance;
}



public void setNewDetailQuittance(DetailQuittanceEmployeur newDetailQuittance) {
	this.newDetailQuittance = newDetailQuittance;
}



public Long getSommeQuittance() {
	return sommeQuittance;
}



public void setSommeQuittance(Long sommeQuittance) {
	this.sommeQuittance = sommeQuittance;
}



public Integer getReste() {
	return reste;
}



public void setReste(Integer reste) {
	this.reste = reste;
}



public List<DetailCession> getDetaiCessions() {
	return detaiCessions;
}



public void setDetaiCessions(List<DetailCession> detaiCessions) {
	this.detaiCessions = detaiCessions;
}



public ClientAcquereurService getClientAcquereurService() {
	return clientAcquereurService;
}



public void setClientAcquereurService(
		ClientAcquereurService clientAcquereurService) {
	this.clientAcquereurService = clientAcquereurService;
}



public ClientAcquereur getClientacq() {
	return clientacq;
}



public void setClientacq(ClientAcquereur clientacq) {
	this.clientacq = clientacq;
}












}