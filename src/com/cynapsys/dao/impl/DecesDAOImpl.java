package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.DecesDAO;
import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.Deces;
import com.cynapsys.entities.Reclamation;

@SuppressWarnings("serial")
@Repository("decesDAO")
public class DecesDAOImpl extends AbstractDAOImpl<Deces>
		implements DecesDAO, Serializable {

	public DecesDAOImpl() {
		super(Deces.class);
	}

	@Override
	public Deces findById(String id) {
		
//		List<Deces> list=new ArrayList<Deces>();
//		try {
//			Criteria criteria= getSession().createCriteria(Deces.class);
//			criteria.add(Restrictions.eq("codeDeces", id));
//			 list = criteria.list();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return list.get(0);	
		
		List<Deces> list = new ArrayList<Deces>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Deces D left join fetch D.clientAcquereur k  left join fetch k.groupe left join fetch D.assurance A left join fetch A.assureur where D.id=")
				.append(id);
		list = (List<Deces>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public List<Deces> findDta() {
		
		List<Deces> list = new ArrayList<Deces>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Deces D "
				+ "left join fetch D.assurance A "
				+ "left join fetch A.assureur "
				+ "left join fetch A.clientAcquereur C "
				+ "left join fetch C.groupe" );
		list = (List<Deces>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<Deces> findDecesByClient(String id) {
		List<Deces> list = new ArrayList<Deces>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Deces D left join fetch D.assurance A left join fetch A.assureur left join fetch A.clientAcquereur K  left join fetch K.groupe  where K.codeAcquereur='")
				.append(id).append("'");
		list = (List<Deces>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return list;
		}
	}
	
	
	@Override
	public Deces findDecesByClientcust(String id){
		List<Deces> list = new ArrayList<Deces>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Deces D left join fetch D.assurance A left join fetch A.assureur left join fetch A.clientAcquereur K  left join fetch K.groupe  where K.codeAcquereur='")
				.append(id).append("'");
		list = (List<Deces>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
		
	}
}

	


