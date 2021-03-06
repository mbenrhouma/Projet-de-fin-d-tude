package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ArrangementDAO;
import com.cynapsys.entities.Arrangement;
import com.cynapsys.entities.Cession;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Contentieux;
import com.cynapsys.entities.Impayee;
import com.cynapsys.entities.Precontentieu;

@SuppressWarnings("serial")
@Repository("arrangementDAO")
public class ArrangementDAOImpl extends AbstractDAOImpl<Arrangement>
		implements ArrangementDAO, Serializable {

	public ArrangementDAOImpl() {
		super(Arrangement.class);
	}

	@Override
	public Arrangement findById(String id) {
		
		List<Arrangement> list=new ArrayList<Arrangement>();
		try {
			Criteria criteria= getSession().createCriteria(Arrangement.class);
			criteria.add(Restrictions.eq("id", new Integer(id)));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<Arrangement> findAllDta() {
		try {
			Criteria criteria = getSession().createCriteria(Arrangement.class);
			// clause select
			criteria.setProjection(Projections
					.projectionList()
					.add(Projections.alias(Projections.property("id"),
							"id"))
					.add(Projections.alias(Projections.property("duree"),
							"duree"))
					.add(Projections.alias(Projections.property("montantArrieres"),
							"montantArrieres"))
					.add(Projections.alias(Projections.property("dateDebut"),
							"dateDebut"))
					.add(Projections.alias(Projections.property("dateFin"),
							"dateFin"))
					.add(Projections.alias(Projections.property("precontentieu"),
							"precontentieu"))
					.add(Projections.alias(Projections.property("nombreMensualite"),
							"nombreMensualite"))
					);

			// Set to result transformer
			criteria.setResultTransformer(Transformers
					.aliasToBean(Arrangement.class));
			
			List<Arrangement> list = criteria.list();
			
//			for(Locataire l:list){
//				if(l.isEtat()){		
//					locatairesActifs.add(l);
//				}
//			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Arrangement>();
		}
	}

	@Override
	public List<Arrangement> findByCriteres(Arrangement arrangement,Date dateD, Date dateF) {
			List<Arrangement> list=new ArrayList<Arrangement>();
			System.out.println(arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getCodeAcquereur());
 		
 		try {
 			Criteria criteria = getSession().createCriteria(Arrangement.class);
			// clause select
 			
// 			criteria.createAlias("clientAcquereur", "ca");
// 			criteria.createAlias("ca.groupe", "caf");
 			
 			criteria.createAlias("precontentieu", "p");
 			criteria.createAlias("p.impayee", "pi");
 			criteria.createAlias("pi.clientAcquereur", "pic");
 			criteria.createAlias("pic.groupe", "picg");
 			
 			if(arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getCodeAcquereur()!=null){
 				
 					criteria.add(Restrictions.eq("pic.codeAcquereur", arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getCodeAcquereur()));
 				
 			}
 			if(arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getGroupe()!=null){
 				criteria.add(Restrictions.like("picg.libelle", arrangement.getPrecontentieu().getImpayee().getClientAcquereur().getGroupe().getLibelle(),MatchMode.ANYWHERE));
 			}
 			
 			
 			if(dateD!=null && dateF!=null && dateF.compareTo(dateD)>0){
 				System.out.println("resultat date"+dateF.compareTo(dateD));
 				criteria.add(Restrictions.between("dateDebut", dateD, dateF));
 			}
 			
 			if(dateD!=null && dateF==null){
 				criteria.add(Expression.ge("dateDebut",dateD));
 			}
 			
 			if(dateD==null && dateF!=null){
 				criteria.add(Expression.le("dateDebut",dateF));
 			}
 			
 			
 			
			
			
			
			
			
			
 			 list = criteria.list();
 			
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}
 		System.out.println("recherche arra, taille de la liste : "+list.size());
 		return list;
	}

	@Override
	public List<Arrangement> findArrabgementByClientAcquereur(ClientAcquereur clientAcquereur) {
		
		StringBuilder req = new StringBuilder();
		req.append("from Arrangement a ");
		req.append("left join fetch a.precontentieu as pr"
				+ " left join fetch pr.impayee as im"
				+ " left join fetch im.clientAcquereur as ca ");
		req.append("where ca.codeAcquereur= '")
				.append(clientAcquereur.getCodeAcquereur()).append("'");
		List<Arrangement> arrangements=this.getHibernateTemplate().find(req.toString());
			return arrangements;
	}
	
	

}
