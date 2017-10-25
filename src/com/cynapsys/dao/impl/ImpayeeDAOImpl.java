package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ImpayeeDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Impayee;

@SuppressWarnings("serial")
@Repository("impayeeDAO")
public class ImpayeeDAOImpl extends AbstractDAOImpl<Impayee>
		implements ImpayeeDAO, Serializable {

	public ImpayeeDAOImpl() {
		super(Impayee.class);
	}

	@Override
	public Impayee findById(String id) {
		
		List<Impayee> list=new ArrayList<Impayee>();
		try {
			Criteria criteria= getSession().createCriteria(Impayee.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<Impayee> findAllDta() {
		try {
			Criteria criteria = getSession().createCriteria(Impayee.class);
			// clause select
			criteria.setProjection(Projections
					.projectionList()
					.add(Projections.alias(Projections.property("id"),
							"id"))
					.add(Projections.alias(Projections.property("soldeDebiteur"),
							
							
							"soldeDebiteur"))
					.add(Projections.alias(Projections.property("dateRelance"),
							"dateRelance"))
					.add(Projections.alias(Projections.property("clientAcquereur"),
							"clientAcquereur"))
					.add(Projections.alias(Projections.property("precontentieu"),
							"precontentieu")));

			// Set to result transformer
			criteria.setResultTransformer(Transformers
					.aliasToBean(Impayee.class));
			
			List<Impayee> list = criteria.list();
			ArrayList<Impayee> locatairesActifs=new ArrayList<Impayee>(); 
//			for(Locataire l:list){
//				if(l.isEtat()){		
//					locatairesActifs.add(l);
//				}
//			}
			if (!list.isEmpty()) {
			    Collections.sort(list, new Comparator<Impayee>() {
			        @Override
			        public int compare(Impayee c1, Impayee c2) {
			            //You should ensure that list doesn't contain null values!
			            return c1.getClientAcquereur().getGroupe().getLibelle().compareTo(c2.getClientAcquereur().getGroupe().getLibelle());
			        }
			       });
			   }
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Impayee>();
		}
	}

	@Override
	public List<Impayee> findByCriteres(Impayee impayee, String mode) {
List<Impayee> list=new ArrayList<Impayee>();
 		System.out.println(impayee.getSoldeDebiteur() +",,,,," );
 		try {
 			Criteria criteria = getSession().createCriteria(Impayee.class);
			// clause select
 			
 			criteria.createAlias("clientAcquereur", "ca");
 			criteria.createAlias("ca.groupe", "caf");
 			
 			if(impayee.getSoldeDebiteur()!=null){
 				if(mode.equals("i")){
 					criteria.add(Restrictions.le("soldeDebiteur", impayee.getSoldeDebiteur()));
 				}
 				if(mode.equals("s")){
 					criteria.add(Restrictions.ge("soldeDebiteur", impayee.getSoldeDebiteur()));
 				}
 				if(mode.equals("e")){
 					criteria.add(Restrictions.like("soldeDebiteur", impayee.getSoldeDebiteur()));
 				}
 			}
 			
 			
 			
 			if(impayee.getClientAcquereur().getGroupe()!=null){
 				criteria.add(Restrictions.like("caf.libelle", impayee.getClientAcquereur().getGroupe().getLibelle(),MatchMode.ANYWHERE));
 			}
 			
 			
 			
 			
			
			
			
			
			
			
 			 list = criteria.list();
 			
 		} catch (Exception e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}
 		System.out.println("recherche impayee, taille de la liste : "+list.size());
 		
 		
 		if (!list.isEmpty()) {
		    Collections.sort(list, new Comparator<Impayee>() {
		        @Override
		        public int compare(Impayee c1, Impayee c2) {
		            //You should ensure that list doesn't contain null values!
		            return c1.getClientAcquereur().getGroupe().getLibelle().compareTo(c2.getClientAcquereur().getGroupe().getLibelle());
		        }
		       });
		   }
 		
 		
 		
 		
 		
 		return list;
	}

	@Override
	public List<Impayee> findImpayeByClientAcquereur(
			ClientAcquereur clientAcquereur) {
		
		StringBuilder req = new StringBuilder();
		req.append("from Impayee i ");
		req.append("left join fetch i.precontentieu ");
		req.append("where i.clientAcquereur.codeAcquereur= ")
				.append(clientAcquereur.getCodeAcquereur());
		List<Impayee> impayees=this.getHibernateTemplate().find(req.toString());
			return impayees;
	}

}
