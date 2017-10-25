package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ReclamationDAO;
import com.cynapsys.entities.Reclamation;
import com.cynapsys.entities.Reclamation;
import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.NoteDebit;
import com.cynapsys.entities.Reclamation;
import com.cynapsys.entities.TypeReclamation;

@SuppressWarnings("serial")
@Repository("reclamationDAO")
public class ReclamationDAOImpl extends AbstractDAOImpl<Reclamation> implements ReclamationDAO, Serializable {

	public ReclamationDAOImpl() {
		super(Reclamation.class);
	}

	@Override
	public Reclamation findById(String id) {

		List<Reclamation> list = new ArrayList<Reclamation>();
		StringBuilder req = new StringBuilder();
		req.append("from Reclamation R left join fetch R.assurance A" + "left join fetch A.clientAcquereur K"
				+ "left join fetch K.groupe " + "left join fetch A.assureur where R.id=").append(new BigDecimal(id));
		list = (List<Reclamation>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<Reclamation> findAll() {
		List<Reclamation> list = new ArrayList<Reclamation>();
		StringBuilder req = new StringBuilder();
		req.append("from Reclamation R left join fetch R.typeReclamation T " + "left join fetch R.assurance A "
				+ "left join fetch A.clientAcquereur K " + "left join fetch K.groupe " + "left join fetch A.assureur");
		list = (List<Reclamation>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	
	

	// @Override
	// public List<Reclamation> findByCriteres(Reclamation reclamation, Date
	// rechDateDebRec, Date rechDateFinRec,
	// Date rechDateDebEnv, Date rechDateFinEnv, Date rechDateDebRep, Date
	// rechDateFinRep) {
	// List<Reclamation> list = new ArrayList<Reclamation>();
	// try {
	// Criteria criteria = getSession().createCriteria(Reclamation.class);
	// // clause select
	//
	// // criteria.createAlias("clientAcquereur", "ca");
	// // criteria.createAlias("ca.groupe", "caf");
	//
	// criteria.createAlias("typeReclamation", "tR");
	// criteria.createAlias("clientAcquereur", "ca");
	//
	// if (reclamation.getClientAcquereur().getCodeAcquereur() != null) {
	// criteria.add(Restrictions.eq("ca.codeAcquereur",
	// reclamation.getClientAcquereur().getCodeAcquereur()));
	//
	// }
	// //
	// if(arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getGroupe()!=null){
	// // criteria.add(Restrictions.like("picg.libelle",
	// //
	// arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getGroupe().getLibelle(),MatchMode.ANYWHERE));
	// // }
	// //
	// //
	// // if(dateD!=null && dateF!=null && dateF.compareTo(dateD)>0){
	// // System.out.println("resultat date"+dateF.compareTo(dateD));
	// // criteria.add(Restrictions.between("datedebut", dateD, dateF));
	// // }
	// //
	// // if(dateD!=null && dateF==null){
	// // criteria.add(Expression.ge("datedebut",dateD));
	// // }
	// //
	// // if(dateD==null && dateF!=null){
	// // criteria.add(Expression.le("datedebut",dateF));
	// // }
	// //
	// //
	//
	// list = criteria.list();
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// }
	// System.out.println("recherche arra, taille de la liste : " +
	// list.size());
	// return list;
	// }

	public List<Reclamation> findByCriteres(Reclamation rechRreclamation, String rechCodeClientAcquereur,
			String rechNomFRClientAcquereur, String rechNomARClientAcquereur, String rechAbreviationAssureur,
			String rechLibelleGroupe, String rechObjetReclamation, Date rechDateDebEnv, Date rechDateDebRec,
			Date rechDateDebRep, Date rechDateFinEnv, Date rechDateFinRec, Date rechDateFinRep) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		List<Reclamation> list = new ArrayList<Reclamation>();
		StringBuilder req = new StringBuilder();
		req.append("from Reclamation R left join fetch R.typeReclamation T " + "left join fetch R.assurance A "
				+ "left join fetch A.clientAcquereur K " + "left join fetch K.groupe G "
				+ "left join fetch A.assureur U where 1 = 1");

		if (rechCodeClientAcquereur != null) {
			req.append(" and K.codeAcquereur ='").append(rechCodeClientAcquereur).append("'");
		}

		if (rechLibelleGroupe != null) {
			req.append(" and G.libelle ='").append(rechLibelleGroupe).append("'");
		}

		if (rechNomFRClientAcquereur != null) {
			req.append(" and K.nomPrenomFr ='").append(rechNomFRClientAcquereur).append("'");
		}
		if (rechNomARClientAcquereur != null) {
			req.append(" and K.nomPrenomAr ='").append(rechNomARClientAcquereur).append("'");
		}

		if (rechObjetReclamation != null) {
			req.append(" and T.objetReclamation ='").append(rechObjetReclamation).append("'");
		}

		if (rechAbreviationAssureur != null) {
			req.append(" and U.abreviation ='").append(rechAbreviationAssureur).append("'");
		}
		// *******************************Date Recherche Reclamation
		

		if (rechDateDebRec != null) {

			req.append(" and R.dateReclamation >= to_date('").append(format.format(rechDateDebRec))
					.append("','dd/MM/yyyy')");
		}

		if (rechDateFinRec != null) {

			req.append(" and R.dateReclamation <= to_date('").append(format.format(rechDateFinRec))
					.append("','dd/MM/yyyy')");
		}

		/// *******************************Date Recherche Envoie
		

		if (rechDateDebEnv != null) {

			req.append(" and R.dateEnvoie >= to_date('").append(format.format(rechDateDebEnv))
					.append("','dd/MM/yyyy')");
		}

		if (rechDateFinEnv != null) {

			req.append(" and R.dateEnvoie <= to_date('").append(format.format(rechDateFinEnv))
					.append("','dd/MM/yyyy')");
		}

		// *******************************Date Recherche Reponse
		
		if (rechDateDebRep != null) {

			req.append(" and R.dateReponse >= to_date('").append(format.format(rechDateDebRep))
					.append("','dd/MM/yyyy')");
		}

		if (rechDateFinRep != null) {

			req.append(" and R.dateReponse <= to_date('").append(format.format(rechDateFinRep))
					.append("','dd/MM/yyyy')");
		}

		list = (List<Reclamation>) this.getHibernateTemplate().find(req.toString());

		return list;

	}

	
}
