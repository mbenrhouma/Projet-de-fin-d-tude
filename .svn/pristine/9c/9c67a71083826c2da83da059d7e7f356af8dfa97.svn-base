package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TableauAmortissementDAO;
import com.cynapsys.entities.Cession;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.TableauAmortissement;

@SuppressWarnings("serial")
@Repository("tableauAmortissementDAO")
public class TableauAmortissementDAOImpl extends AbstractDAOImpl<TableauAmortissement>
		implements TableauAmortissementDAO, Serializable {

	public TableauAmortissementDAOImpl() {
		super(TableauAmortissement.class);
	}

	@Override
	public TableauAmortissement findById(String id) {
		
		List<TableauAmortissement> list=new ArrayList<TableauAmortissement>();
		try {
			Criteria criteria= getSession().createCriteria(TableauAmortissement.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<TableauAmortissement> findAmortissementClientAcquereur(ClientAcquereur clientAcquereur) {
		
		StringBuilder req = new StringBuilder();
		req.append("from TableauAmortissement t ");
		
		req.append(" where t.clientAcquereur.codeAcquereur= ")
				.append(clientAcquereur.getCodeAcquereur());
		List<TableauAmortissement> cessions=this.getHibernateTemplate().find(req.toString());
			return cessions;
	}

	@Override
	public TableauAmortissement findByClientEtat(ClientAcquereur client) {
		StringBuilder req = new StringBuilder();
		req.append("from TableauAmortissement t left join fetch t.clientAcquereur");
		
		req.append(" where t.etat=1  and  t.clientAcquereur.codeAcquereur= ")
				.append(client.getCodeAcquereur());
		List<TableauAmortissement> tabl=this.getHibernateTemplate().find(req.toString());
		if (tabl != null && !tabl.isEmpty())
			return tabl.get(0);
		else
			return null;
		
	}

	@Override
	public List<TableauAmortissement> findAmortissementActif() {
		
		List<TableauAmortissement> list=new ArrayList<TableauAmortissement>();
		try {
			Criteria criteria= getSession().createCriteria(TableauAmortissement.class);
			criteria.add(Restrictions.eq("etat", 1));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;	
		
	}

}
