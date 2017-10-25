package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.GroupeDAO;
import com.cynapsys.entities.Groupe;

@SuppressWarnings("serial")
@Repository("groupeDAO")
public class GroupeDAOImpl extends AbstractDAOImpl<Groupe>
		implements GroupeDAO, Serializable {

	public GroupeDAOImpl() {
		super(Groupe.class);
	}

	@Override
	public Groupe findById(String id) {
		
		List<Groupe> list=new ArrayList<Groupe>();
		try {
			Criteria criteria= getSession().createCriteria(Groupe.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
