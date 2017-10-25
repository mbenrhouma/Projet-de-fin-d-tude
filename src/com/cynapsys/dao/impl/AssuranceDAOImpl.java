package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.AssuranceDAO;
import com.cynapsys.entities.Assurance;

@SuppressWarnings("serial")
@Repository("assuranceDAO")
public class AssuranceDAOImpl extends AbstractDAOImpl<Assurance> implements AssuranceDAO, Serializable {

	public AssuranceDAOImpl() {
		super(Assurance.class);
	}

	@Override
	public Assurance findById(String id) {

		List<Assurance> list = new ArrayList<Assurance>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Assurance I left join fetch I.clientAcquereur "
				+ "k  left join fetch k.groupe left join fetch I.assureur where I.id=")
				.append(Integer.parseInt(id));
		list = (List<Assurance>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assurance> findAssuranceByClient(String id) {
		List<Assurance> list = new ArrayList<Assurance>();
		StringBuilder req = new StringBuilder();
		req.append("from Assurance A  " 
		        + "left join fetch A.clientAcquereur C "
				+ "left join fetch C.groupe " 
				+ "left join fetch A.assureur where C.codeAcquereur=").append(id);
		list = (List<Assurance>) this.getHibernateTemplate().find(req.toString());

			return list;
		
//		List<Assurance> list ;
//		try {
//			Criteria criteria = getSession().createCriteria(Assurance.class);
//			criteria.createAlias("clientAcquereur", "C");
//			criteria.createAlias("assureur", "A");
//			  criteria.add(Restrictions.eq("C.codeAcquereur", new BigDecimal(id)));
//				list = criteria.list();
//			return list;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
	}
	
	@Override
	public List<Assurance> findAllDta() {
		List<Assurance> list = new ArrayList<Assurance>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Assurance I left join fetch I.clientAcquereur k  left join fetch k.groupe left join fetch I.assureur");
		list = (List<Assurance>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
	}
	@Override
	public List<Assurance> findAllAssureur() {
		List<Assurance> list ;
		StringBuilder req = new StringBuilder();
		req.append(
				"from Assurance I left join fetch I.assureur");
		list = (List<Assurance>) this.getHibernateTemplate().find(req.toString());

		return list;

		}
	
	@Override
	public Assurance findAssuranceInCodeClient(BigDecimal id) {
		
		List<Assurance> list;
		StringBuilder req = new StringBuilder();
		req.append(
				"from Assurance I left join fetch I.clientAcquereur K where K.codeAcquereur=")
				.append(id);
		list = (List<Assurance>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Assurance findAssuranceInCodeConjoint(BigInteger id) {
		List<Assurance> list;
		StringBuilder req = new StringBuilder();
		req.append(
				"from Assurance I left join fetch I.clientAcquereur K where K.compteConjoint=")
				.append(id);
		list = (List<Assurance>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Assurance findAssuranceByCodeConjoint(Assurance assurance) {
		List<Assurance> list;
		try {
			Criteria criteria = getSession().createCriteria(Assurance.class);
			criteria.createAlias("clientAcquereur", "ca");
		    criteria.add(Restrictions.eq("ca.compteConjoint", assurance.getClientAcquereur().getCompteConjoint()));
			list = criteria.list();
			
			
			return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Assurance> findAssuranceByCodeClient(Assurance assurance) {
		List<Assurance> list ;
		try {
			Criteria criteria = getSession().createCriteria(Assurance.class);
			criteria.createAlias("clientAcquereur", "ca");
				criteria.add(Restrictions.eq("ca.codeAcquereur", assurance.getClientAcquereur().getCodeAcquereur()));
				list = criteria.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	}
