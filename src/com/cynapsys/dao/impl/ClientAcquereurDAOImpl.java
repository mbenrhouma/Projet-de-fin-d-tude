package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ArrangementDAO;
import com.cynapsys.dao.CessionDAO;
import com.cynapsys.dao.ClientAcquereurDAO;
import com.cynapsys.dao.ContentieuxDAO;
import com.cynapsys.dao.TableauAmortissementDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.pojo.ClientAcquereurRecherchPOJO;
import com.cynapsys.pojo.IdentificationPojo;
import com.cynapsys.utils.Constants;

@SuppressWarnings("serial")
@Repository("clientAcquereurDAO")
public class ClientAcquereurDAOImpl extends AbstractDAOImpl<ClientAcquereur>
		implements ClientAcquereurDAO, Serializable {

	public ClientAcquereurDAOImpl() {
		super(ClientAcquereur.class);
	}
	@Autowired
	private ContentieuxDAO contentieuxDAO;
	
	@Autowired
	private ArrangementDAO arrangementDAO;
	
	@Autowired
	private CessionDAO cessionDAO;
	
	@Autowired
	private TableauAmortissementDAO tableauAmortissementDAO;

	@Override
	public ClientAcquereur findById(String id) {

		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();
		try {
			Criteria criteria = getSession().createCriteria(ClientAcquereur.class);
			criteria.add(Restrictions.eq("codeAcquereur", id));
			list = criteria.list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (list != null && !list.isEmpty())
			return list.get(0);
		else
			return null;
		


	}


	@Override
	public List<ClientAcquereur> rechercheClientAcquereur(ClientAcquereur clientAcquereur) {
		
		try {
		
			Criteria criteria = getSession().createCriteria(ClientAcquereur.class);

			
			// clause select
//			if(clientAcquereur.getAssureur()!=null && clientAcquereur.getAssureur().getCodeassureur()!=null){
//				criteria.add(Restrictions.eq("assureur.codeassureur", clientAcquereur.getAssureur().getCodeassureur()));
//			}
			if(clientAcquereur.getGroupe()!=null && clientAcquereur.getGroupe().getCode()!=null){
				criteria.add(Restrictions.eq("groupe.code", clientAcquereur.getGroupe().getCode()));
			}
			if(clientAcquereur.getNomPrenomFr()!=null && !"".equals(clientAcquereur.getNomPrenomFr())){
				criteria.add(Restrictions.like("nomPrenomFr", "%"+clientAcquereur.getNomPrenomFr()+"%"));
			}
			if(clientAcquereur.getAdresseCorrespondance()!=null && !"".equals(clientAcquereur.getAdresseCorrespondance())){
				criteria.add(Restrictions.like("adresseCorrespondance", "%"+clientAcquereur.getAdresseCorrespondance()+"%"));
			}
//			if(clientAcquereur.getAnneebudgetaire()!=null){
//				criteria.add(Restrictions.eq("anneebudgetaire", clientAcquereur.getAnneebudgetaire()));
//			}
			
			return criteria.list();
		} catch (Exception e) {

			e.printStackTrace();
			return new ArrayList<ClientAcquereur>();
		}
	}

	@Override
	public List<ClientAcquereur> findAllDta() {
		try {
			Criteria criteria = getSession().createCriteria(ClientAcquereur.class);
			// clause select
			criteria.setProjection(
					Projections.projectionList()
							.add(Projections.alias(Projections.property("codeAcquereur"), "codeAcquereur"))
							.add(Projections.alias(Projections.property("nomPrenomFr"), "nomPrenomFr"))
							.add(Projections.alias(Projections.property("nomPrenomAr"), "nomPrenomAr"))
							.add(Projections.alias(Projections.property("compteConjoint"), "compteConjoint"))
							.add(Projections.alias(Projections.property("nomprenomconjointar"), "nomprenomconjointar"))
							.add(Projections.alias(Projections.property("dateNaissance"), "dateNaissance"))
							.add(Projections.alias(Projections.property("adresseCorrespondance"),
									"adresseCorrespondance"))
							.add(Projections.alias(Projections.property("anneebudgetaire"), "anneebudgetaire"))
							.add(Projections.alias(Projections.property("groupe"), "groupe"))
							.add(Projections.alias(Projections.property("employeur"), "employeur"))
							.add(Projections.alias(Projections.property("assureur"), "assureur"))
							.add(Projections.alias(Projections.property("assurance1"), "assurance1")).add(Projections
									.alias(Projections.property("nomPrenomConjointFr"), "nomPrenomConjointFr")));

			// Set to result transformer
			criteria.setResultTransformer(Transformers.aliasToBean(ClientAcquereur.class));

			List<ClientAcquereur> list = criteria.list();
			// ArrayList<ClientAcquereur> locatairesActifs=new
			// ArrayList<ClientAcquereur>();
			// for(Locataire l:list){
			// if(l.isEtat()){
			// locatairesActifs.add(l);
			// }
			// }
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<ClientAcquereur>();
		}
	}

	@Override
	public List<ClientAcquereur> findDTA() {
			List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();
			StringBuilder req = new StringBuilder();
			req.append("from ClientAcquereur I  "
				
					+ " left join fetch I.groupe");
			list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

			if (list != null && !(list.isEmpty()))
				return  list;
			else
				return null;
		}


	@Override
	public List<ClientAcquereur> findClients() {
		 StringBuilder req = new StringBuilder();
         req.append("from ClientAcquereur c left join fetch c.cessionList " );                                
		 List<ClientAcquereur> list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());
         return list;
}
	
	
	
	
	
	public ContentieuxDAO getContentieuxDAO() {
		return contentieuxDAO;
	}


	public void setContentieuxDAO(ContentieuxDAO contentieuxDAO) {
		this.contentieuxDAO = contentieuxDAO;
	}


	public ArrangementDAO getArrangementDAO() {
		return arrangementDAO;
	}


	public void setArrangementDAO(ArrangementDAO arrangementDAO) {
		this.arrangementDAO = arrangementDAO;
	}


	public CessionDAO getCessionDAO() {
		return cessionDAO;
	}


	public void setCessionDAO(CessionDAO cessionDAO) {
		this.cessionDAO = cessionDAO;
	}

	
	@Override
	public List<ClientAcquereur> rechercheAvancee(ClientAcquereurRecherchPOJO clientACPojo) {
		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();

		StringBuilder req = new StringBuilder();
		req.append(
				" select  distinct new ClientAcquereur(gr.code,gr.libelle,I.codeAcquereur, I.nomPrenomFr,lg.codeLogement, lg.adresseLoge, an.code,I.cin,I.dateNaissance,I.adresseCorrespondance,lg.codePostal,I.prix,I.datearchivage)from  ClientAcquereur I left join  I.anneeBudgetaire as an left join  I.groupe as gr left join I.logement as lg  ");

		if ((clientACPojo.getEmployeur() != null)) {

			req.append(" left join I.cessionClientList as f join f.cessionList as fl join fl.employeur ");
		}
		if (( clientACPojo.getAssureur() != null)) {
			req.append(" left join I.assuranceList as k join  k.assureur      ");
		}
		if ( clientACPojo.getEtatTableauAmortissemet() != null) {
			req.append(" left join I.tableauAmortissementList as w      ");
		}
		if ( clientACPojo.getCessionSalaire()!=null && clientACPojo.getCessionSalaire()==true) {
			req.append(" left join I.cessionClientList as cs     ");
			
		}

		req.append(" where 1 = 1 ");

		// ***************************** recherche par code*******************
		if (clientACPojo.getCodeAcquereur() != null) {
			req.append(" and I.codeAcquereur = like '%").append(clientACPojo.getCodeAcquereur()).append("%'");

		}
		// ****************************** recherche par
		// groupe*******************

		if (clientACPojo.getGroupe() != null && !clientACPojo.getGroupe().getCode().equals("")) {
			req.append(" and I.groupe.code ='").append(clientACPojo.getGroupe().getCode()).append("'");

		}
		// ******************************* recherche par
		// nom*********************
		if (clientACPojo.getNomPrenomFr() != null && !clientACPojo.getNomPrenomFr().equals("")) {
			//Si recherche normal
			//req.append(" and I.nomPrenomFr like '%").append(clientACPojo.getNomPrenomFr()).append("%'");
			
			//Si recherche phonétique
			req.append(" and  M_SOUNDEX_FR(I.nomPrenomFr) like ('%' || soundex_fr('").append(clientACPojo.getNomPrenomFr().toUpperCase()).append("') || '%')")  ;
		}

		// ******************************** recherhce par contentieux**********
		if ( clientACPojo.getContentieux() != null  ) {
			if (clientACPojo.getContentieux() == 1) {
				req.append(" and I.contentieux =").append(Constants.enContentieux);
			} else {
				if (clientACPojo.getContentieux() == 2) {
					req.append(" and I.contentieux =").append(Constants.pasEnContentieux);
				}
			}

		}

		// ******************************** recherche par tableau d
		// amortissement ******
		if ( clientACPojo.getEtatTableauAmortissemet() != null) {
			
			if (clientACPojo.getEtatTableauAmortissemet() == 1){
				req.append(" and  w.etat=1 ");}
			else{ if (clientACPojo.getEtatTableauAmortissemet() == 2){
				req.append(" and w.etat=0 ");}
			

		}}
		// ********************************* ayant
		// Arrangement*********************
		if ( clientACPojo.getArrongement() != null) {

			if (clientACPojo.getArrongement() == 1) {
				req.append(" and I.enArrangement=").append(Constants.ayantArrangement);

			} else if (clientACPojo.getArrongement() == 2) {
				req.append(" and I.enArrangement=").append(Constants.pasArrangement);

			}

		}
		// *********************************** recherche si cession
		// salaire*********
		if ( clientACPojo.getCessionSalaire()!=null && clientACPojo.getCessionSalaire()==true) {
		
			if (clientACPojo.getCessionActive() != null && clientACPojo.getCessionActive() == true) {
				req.append(" and cs.actif=1 ");

			} else {
				if (clientACPojo.getCessEchu() != null && clientACPojo.getCessEchu() == true) {
					req.append(" and cs.actif=0 ");
				}

			}

		}
		
//		client Archivee
		if ( clientACPojo.getArchive()!=null && clientACPojo.getArchive()==true) {
			
			if (clientACPojo.getArchiveNv() != null && clientACPojo.getArchiveNv() == true) {
				req.append(" and I.nvArchive= 1 ");

			} else {
				if (clientACPojo.getArchiveAnc() != null && clientACPojo.getArchiveAnc() == true) {
					req.append(" and I.nvArchive=0 ");
				}

			}

		}
//		***************
		// ******************************* recherche par
		// employeur*******************
		if ((clientACPojo.getEmployeur() != null)) {

			req.append(" and fl.employeur.codeEmployeur=").append(clientACPojo.getEmployeur().getCodeEmployeur());

		}
		// *********************************recherche par assureur
		if (( clientACPojo.getAssureur() != null)) {

			req.append("and  k.assureur.code=").append(clientACPojo.getAssureur().getCode());

		}
		req.append(" order by 1 ");
		list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

		// *************************resultat*************************

		if (list != null && !list.isEmpty())
			return list;
		else
			return null;

	}
	@Override	
	public  ClientAcquereur findByID(String codeAcquereur){
		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();

		StringBuilder req = new StringBuilder();
		req.append(
				"  from  ClientAcquereur I left join fetch I.anneeBudgetaire left join fetch I.groupe left join fetch I.logement k  left join fetch k.gouvernorat"
				+ " left join fetch k.localite   left join fetch k.lotissement left join fetch k.typeLogement left join fetch k.typeLogement where I.codeAcquereur= '").append(codeAcquereur).append("'");
		

		list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

		// *************************resultat*************************

		if (list != null && !list.isEmpty())
			return list.get(0);
		else
			return null;
	}


	@Override
	public IdentificationPojo findIdentifClient(ClientAcquereur clientAcquereur) {
		IdentificationPojo identificationPojo = new IdentificationPojo();
		ClientAcquereur ca = new ClientAcquereur();
		StringBuilder req = new StringBuilder();
		req.append("from ClientAcquereur ca left join fetch ca.logement l " 
//		        + "left join fetch l.codePostal "
		      
				+ "left join fetch ca.groupe "
                + " where ca.codeAcquereur=").append(clientAcquereur.getCodeAcquereur());
	            
		List<ClientAcquereur> list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());
		
		//mapping de l'objet IdentificationPojo
		if (list.size() > 0) {
			ca= list.get(0);
			String codeClient =String.valueOf(ca.getCodeAcquereur());
			identificationPojo.setCodeClient(codeClient.substring(0, codeClient.length()-1));
			identificationPojo.setAdresse(ca.getLogement().getAdresseLoge());
			identificationPojo.setCodePostal(ca.getLogement().getCodePostal());
		
			identificationPojo.setRang(codeClient.substring(codeClient.length()-1));
			identificationPojo.setGroupe(ca.getGroupe().getCode());
			identificationPojo.setNomClient(ca.getNomPrenomFr());
			identificationPojo.setNumOrdre(String.valueOf(ca.getLogement().getNumOrdre()));
			
			return identificationPojo;
		} else {
			return null;
		}
	}


	@Override
	public List<ClientAcquereur> findAllList() {
		try {
			Criteria criteria = getSession().createCriteria(ClientAcquereur.class);
			// clause select
			criteria.setProjection(
					Projections.projectionList()
							.add(Projections.alias(Projections.property("codeAcquereur"), "codeAcquereur")));

			// Set to result transformer
			criteria.setResultTransformer(Transformers.aliasToBean(ClientAcquereur.class));

			List<ClientAcquereur> list = criteria.list();

			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<ClientAcquereur>();
		}
	}


	@Override
	public List<ClientAcquereur> rechercheClientAcQEDITION() {
		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();

		StringBuilder req = new StringBuilder();
		req.append(
				" select  distinct new ClientAcquereur(gr.code,gr.libelle,I.codeAcquereur, I.nomPrenomFr,lg.codeLogement, lg.adresseLoge,lg.codePostal,I.solde)from  ClientAcquereur I left join  I.groupe as gr left join I.logement as lg  ");

		
		req.append(" order by 1 ");
		list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

		// *************************resultat*************************

		if (list != null && !list.isEmpty())
			return list;
		else
			return null;

	}

	@Override
	public List<ClientAcquereur> ayantArrEdition() {
		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();

		StringBuilder req = new StringBuilder();
		req.append(
				" select  distinct new ClientAcquereur(gr.code,gr.libelle,I.codeAcquereur, I.nomPrenomFr,lg.codeLogement, lg.adresseLoge,lg.codePostal,I.solde)from  ClientAcquereur I left join  I.groupe as gr left join I.logement as lg  ");
		req.append(" where 1 = 1 ");

		req.append(" and I.enArrangement=").append(Constants.ayantArrangement);
		req.append(" order by 1 ");
		list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

		// *************************resultat*************************

		if (list != null && !list.isEmpty())
			return list;
		else
			return null;

	}
	@Override
	public List<ClientAcquereur> enContEdition() {
		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();

		StringBuilder req = new StringBuilder();
		req.append(
				" select  distinct new ClientAcquereur(gr.code,gr.libelle,I.codeAcquereur, I.nomPrenomFr,lg.codeLogement, lg.adresseLoge,lg.codePostal,I.solde)from  ClientAcquereur I left join  I.groupe as gr left join I.logement as lg  ");
		req.append(" where 1 = 1 ");

		req.append(" and I.contentieux =").append(Constants.enContentieux);
		req.append(" order by 1 ");
		list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

		// *************************resultat*************************

		if (list != null && !list.isEmpty())
			return list;
		else
			return null;

	}
	
	@Override
	public List<ClientAcquereur> ayantPrixProvisEdition() {
		List<ClientAcquereur> list = new ArrayList<ClientAcquereur>();

		StringBuilder req = new StringBuilder();
		req.append(
				" select  distinct new ClientAcquereur(gr.code,gr.libelle,I.codeAcquereur, I.nomPrenomFr,lg.codeLogement, lg.adresseLoge,lg.codePostal,I.solde)from  ClientAcquereur I left join  I.groupe as gr left join I.logement as lg  ");
		req.append(" where 1 = 1 ");

		req.append(" and I.prixProvisoire IS NOT NULL");
		req.append(" order by 1 ");
		list = (List<ClientAcquereur>) this.getHibernateTemplate().find(req.toString());

		// *************************resultat*************************

		if (list != null && !list.isEmpty())
			return list;
		else
			return null;

	}
	

}