package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.Type;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.DetailMensualiteDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.DetailMensualite;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.pojo.CalculInteretApresEcheancePojo;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;

@SuppressWarnings("serial")
@Repository("detailMensualiteDAO")
public class DetailMensualiteDAOImpl extends AbstractDAOImpl<DetailMensualite>
		implements DetailMensualiteDAO, Serializable {

	public DetailMensualiteDAOImpl() {
		super(DetailMensualite.class);
	}

	@Override
	public DetailMensualite findById(Integer id) {
		
		List<DetailMensualite> list=new ArrayList<DetailMensualite>();
		try {
			Criteria criteria= getSession().createCriteria(DetailMensualite.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<DetailMensualite> findbyMensualite(Mensualite mens) {
		StringBuilder req = new StringBuilder();
		req.append("from DetailMensualite t left join fetch t.mensualite");
		
		req.append(" where t.mensualite.id=").append(mens.getId());
				
		List<DetailMensualite> list=this.getHibernateTemplate().find(req.toString());
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
	}

	@Override
	public List<DetailMensualite> findbymensDateAu(Mensualite mens, Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder req = new StringBuilder();
		req.append("from DetailMensualite t left join fetch t.mensualite");
		
		req.append(" where t.mensualite.id=").append(mens.getId());
		req.append(" and t.dateFin <= to_date('").append(format.format(date)).append("','dd/MM/yyyy')");
				
		List<DetailMensualite> list=this.getHibernateTemplate().find(req.toString());
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
	}
	
	@Override
	public List<DetailMensualite> findbymensDateDe(Mensualite mens, Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder req = new StringBuilder();
		req.append("from DetailMensualite t left join fetch t.mensualite");
		
		req.append(" where t.mensualite.id=").append(mens.getId());
		req.append(" and to_char( t.dateFin , 'YYYY' )  = '").append(date.getYear()).append("'");
				
		List<DetailMensualite> list=this.getHibernateTemplate().find(req.toString());
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
	}

	@Override
	public List<CalculInteretDeRetardPojo> findMensualiteByClient(
			ClientAcquereur client) {
		
		List<CalculInteretDeRetardPojo> results = new ArrayList<CalculInteretDeRetardPojo>();
		try {
		
			Criteria criteria = getSession().createCriteria(DetailMensualite.class,"dm")
					.createAlias("mensualite", "m").createAlias("m.tableauAmortissement", "ta");
			
			criteria.add(Restrictions.eq("ta.clientAcquereur", client));
			criteria.add(Restrictions.eq("ta.etat", 1));
			
			// clause select
		criteria.setProjection(Projections.projectionList()
					.add(Projections.alias(Projections.sqlProjection("to_number(to_char(this_.date_Deb,'yyyy')) as y0_ ", new String[] {"y0_"},
							new Type[] {Hibernate.INTEGER}),"date"))

							.add(Projections.alias(Projections.sqlProjection("(this_.annuite +this_.ASSURANCE_ANNUELLE +this_.TAXE_ASSURANCE) as y1_ ", new String[] {"y1_"},
							new Type[] {Hibernate.INTEGER}),"debit")));	
		criteria.addOrder(Order.asc("dm.dateDeb"));

		criteria.setResultTransformer(Transformers.aliasToBean(CalculInteretDeRetardPojo.class));
			results = criteria.list();
			

			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<CalculInteretDeRetardPojo>();
		}
	}

	
	@Override
	public List<DetailMensualite> findAllMensualiteByClient(ClientAcquereur client) {
		
		List<DetailMensualite> results = new ArrayList<DetailMensualite>();
		try {
		
			Criteria criteria = getSession().createCriteria(DetailMensualite.class,"dm")
					.createAlias("mensualite", "m").createAlias("m.tableauAmortissement", "ta");
			
			criteria.add(Restrictions.eq("ta.clientAcquereur", client));
			criteria.add(Restrictions.eq("ta.etat", 1));
			
			// clause select

		criteria.addOrder(Order.asc("dm.dateDeb"));

		criteria.setResultTransformer(Transformers.aliasToBean(DetailMensualite.class));
			results = criteria.list();

			return results;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<DetailMensualite>();
		}
	}
	
}
