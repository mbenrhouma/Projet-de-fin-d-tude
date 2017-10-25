package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.MensualiteDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.TableauAmortissement;

@SuppressWarnings("serial")
@Repository("mensualiteDAO")
public class MensualiteDAOImpl extends AbstractDAOImpl<Mensualite>
		implements MensualiteDAO, Serializable {

	public MensualiteDAOImpl() {
		super(Mensualite.class);
	}

	@Override
	public Mensualite findById(String id) {
		
		List<Mensualite> list=new ArrayList<Mensualite>();
		try {
			Criteria criteria= getSession().createCriteria(Mensualite.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<Mensualite> findByTa(TableauAmortissement ta) {
		
		List<Mensualite> list=new ArrayList<Mensualite>();
		try {
			Criteria criteria= getSession().createCriteria(Mensualite.class);
			criteria.add(Restrictions.eq("tableauAmortissement", ta));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;	
		
	}

	@Override
	public List<Mensualite> findByTabAm(TableauAmortissement tab) {
		StringBuilder req = new StringBuilder();
		req.append("from Mensualite t left join fetch t.tableauAmortissement");
		
		req.append(" where t.tableauAmortissement.id=").append(tab.getId());
				
		List<Mensualite> list=this.getHibernateTemplate().find(req.toString());
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
	}

	@Override
	public List<Mensualite> findByClientAcquereur(
			ClientAcquereur clientAcquereur) {
		StringBuilder req = new StringBuilder();
		req.append("from Mensualite m left join fetch m.tableauAmortissement t left join fetch t.clientAcquereur");
		
		req.append(" where t.etat=1 and t.clientAcquereur.codeAcquereur=").append(clientAcquereur.getCodeAcquereur());
				
		List<Mensualite> list=this.getHibernateTemplate().find(req.toString());
		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
	}
	}


