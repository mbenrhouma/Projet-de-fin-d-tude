package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.MouvementDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.pojo.CalculInteretApresEcheancePojo;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;
import com.cynapsys.pojo.RecapPojo;

@SuppressWarnings("serial")
@Repository("mouvementDAO")
public class MouvementDAOImpl extends AbstractDAOImpl<Mouvement>
		implements MouvementDAO, Serializable {

	public MouvementDAOImpl() {
		super(Mouvement.class);
	}

	@Override
	public Mouvement findById(String id) {
		
		List<Mouvement> list=new ArrayList<Mouvement>();
		try {
			Criteria criteria= getSession().createCriteria(Mouvement.class);
			criteria.add(Restrictions.eq("codeMv", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<Mouvement> findByClient(ClientAcquereur client,Date date) {
		StringBuilder req = new StringBuilder();
		   Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        int result = cal.get(Calendar.YEAR);
		req.append("from Mouvement t left join fetch t.clientAcquereur");
		
		req.append(" where t.clientAcquereur.codeAcquereur=").append(client.getCodeAcquereur());
		req.append(" and to_char( t.dateMv , 'YYYY' )  = '").append(result).append("'");
				
		List<Mouvement> list=this.getHibernateTemplate().find(req.toString());
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
	}

	@Override
	public List<Mouvement> findByClientAu(ClientAcquereur client, Date date) {
	
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			
			StringBuilder req = new StringBuilder();
			req.append("from Mouvement t left join fetch t.clientAcquereur");
			
			req.append(" where t.clientAcquereur.codeAcquereur=").append(client.getCodeAcquereur());
			req.append(" and t.dateMv <= to_date('").append(format.format(date)).append("','dd/MM/yyyy')");
					
			List<Mouvement> list=this.getHibernateTemplate().find(req.toString());
			if (list != null && !list.isEmpty()) {
				return list;
			} else {
				return null;

			}
		
			
			
	
		
	}

	@Override
	public List<CalculInteretDeRetardPojo> calculeListDebitCridet(ClientAcquereur client,Date dateFin) {
		
		List<CalculInteretDeRetardPojo> results = new ArrayList<CalculInteretDeRetardPojo>();
		try {
		
			Criteria criteria = getSession().createCriteria(Mouvement.class,"mvt")
					.createAlias("catRecette", "catRecette");
			
			criteria.add(Restrictions.eq("mvt.clientAcquereur", client));
			criteria.add(Restrictions.eq("catRecette.decompteVal", 1));
			criteria.add(Restrictions.lt("mvt.dateMv", dateFin));
			// clause select
			criteria.setProjection(Projections.projectionList()
					.add(Projections.alias(Projections.groupProperty("mvt.annee"),"date"))
							
					.add(Projections.alias(Projections.sum("mvt.montantCredit"),"credit"))
							
					.add(Projections.alias(Projections.sum("mvt.montantDebit"),"debit")));

			criteria.addOrder(Order.asc("mvt.annee"));
			// Set to result transformer
			criteria.setResultTransformer(Transformers.aliasToBean(CalculInteretDeRetardPojo.class));
			
			results = criteria.list();
			

			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<CalculInteretDeRetardPojo>();
		}
	}

	@Override
	public List<CalculInteretApresEcheancePojo> listMvmtApresEch(ClientAcquereur client, Date date) {
		
		List<CalculInteretApresEcheancePojo> results = new ArrayList<CalculInteretApresEcheancePojo>();
		try {
		
			Criteria criteria = getSession().createCriteria(Mouvement.class,"mvt");
			//		.createAlias("catRecette", "catRecette");
			
			criteria.add(Restrictions.eq("mvt.clientAcquereur", client));
//			criteria.add(Restrictions.eq("catRecette.decompteVal", 1));
			criteria.add(Restrictions.ge("mvt.dateMv", date));
			criteria.add(Restrictions.isNotNull("mvt.montantCredit"));
			// clause select
			criteria.setProjection(Projections.projectionList()
					.add(Projections.alias(Projections.property("mvt.dateMv"),"date"))
							
					.add(Projections.alias(Projections.property("mvt.montantCredit"),"montant")));

			criteria.addOrder(Order.asc("mvt.dateMv"));
			// Set to result transformer
			criteria.setResultTransformer(Transformers.aliasToBean(CalculInteretApresEcheancePojo.class));
			
			results = criteria.list();
			

			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<CalculInteretApresEcheancePojo>();
		}
	}

	@Override
	public Integer calculeRecetteCD(ClientAcquereur client) {
		


		Integer recetteCD=0;
		try {
			List<RecapPojo> results = new ArrayList<RecapPojo>();

			Criteria criteria = getSession().createCriteria(Mouvement.class,"mvt")
					.createAlias("catRecette", "catRecette");
			
			criteria.add(Restrictions.eq("mvt.clientAcquereur", client));
			criteria.add(Restrictions.eq("catRecette.code", "02"));
			// clause select
			criteria.setProjection(Projections.projectionList()
							
					.add(Projections.alias(Projections.sum("mvt.montantCredit"),"recetteCD")));

			// Set to result transformer
			criteria.setResultTransformer(Transformers.aliasToBean(RecapPojo.class));
			results = criteria.list();
			if(results!=null && results.size()>0 && results.get(0).getRecetteCD()!=null){
				recetteCD = results.get(0).getRecetteCD();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return recetteCD ;
	}
	}


