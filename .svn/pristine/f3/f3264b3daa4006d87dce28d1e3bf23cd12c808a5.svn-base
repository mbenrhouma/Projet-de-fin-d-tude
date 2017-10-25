package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.AssureurDAO;
import com.cynapsys.entities.Assureur;

@SuppressWarnings("serial")
@Repository("assureurDAO")
public class AssureurDAOImpl extends AbstractDAOImpl<Assureur>
		implements AssureurDAO, Serializable {

	public AssureurDAOImpl() {
		super(Assureur.class);
	}

	@Override
	public Assureur findById(String id) {
		
		List<Assureur> list=new ArrayList<Assureur>();
		try {
			Criteria criteria= getSession().createCriteria(Assureur.class);
			criteria.add(Restrictions.eq("code", Integer.valueOf(id)));
			 list = criteria.list();
			 return list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
			
		
	}

}
