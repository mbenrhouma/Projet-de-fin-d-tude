package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.LocaliteDAO;
import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.Localite;

@SuppressWarnings("serial")
@Repository("localiteDAO")
public class LocaliteDAOImpl extends AbstractDAOImpl<Localite>
		implements LocaliteDAO, Serializable {

	public LocaliteDAOImpl() {
		super(Localite.class);
	}

	@Override
	public Localite findById(String id) {
		
		StringBuilder req = new StringBuilder();

		req.append(
				"from Localite b left join fetch b.gouvernorat  where  b.code='").append(id).append("'");
				
		List<Localite> loc = (List<Localite>) this.getHibernateTemplate().find(req.toString());
		if ((loc != null)&&(!(loc.isEmpty()))) {
			return loc.get(0);
		}else{

		return null;
		}
	}
	public List<Localite> finddta() {
		
		StringBuilder req = new StringBuilder();

		req.append(
				"from Localite b left join fetch b.gouvernorat");
				
		List<Localite> loc = (List<Localite>) this.getHibernateTemplate().find(req.toString());
		if ((loc != null)&&(!(loc.isEmpty()))) {
			return loc;
		}else{

		return null;
		}
	}

	@Override
	public List<Localite> finlocaliteByGov(Gouvernorat gov) {
	StringBuilder req =new StringBuilder();
	req.append(
			"from Localite b left join fetch b.gouvernorat where b.gouvernorat.code=").append(gov.getCode());
	List<Localite> loc = (List<Localite>) this.getHibernateTemplate().find(req.toString());
	if ((loc != null)&&(!(loc.isEmpty()))) {
		return loc;
	}else{

	return null;
	}
	
	}
	

}
