package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TracabiliteDAO;
import com.cynapsys.entities.Tracabilite;

@SuppressWarnings("serial")
@Repository("tracabiliteDAO")
public class TracabiliteDAOImpl extends AbstractDAOImpl<Tracabilite>
		implements TracabiliteDAO, Serializable {

	public TracabiliteDAOImpl() {
		super(Tracabilite.class);
	}

	@Override
	public Tracabilite findById(String id) {
		
		List<Tracabilite> list=new ArrayList<Tracabilite>();
		try {
			Criteria criteria= getSession().createCriteria(Tracabilite.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
