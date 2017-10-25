package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.GouvernoratDAO;
import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.HuissiersNotaires;

@SuppressWarnings("serial")
@Repository("gouvernoratDAO")
public class GouvernoratDAOImpl extends AbstractDAOImpl<Gouvernorat>
		implements GouvernoratDAO, Serializable {

	public GouvernoratDAOImpl() {
		super(Gouvernorat.class);
	}

	@Override
	public Gouvernorat findById(String id) {
		
		List<Gouvernorat> list=new ArrayList<Gouvernorat>();
		try {
			Criteria criteria= getSession().createCriteria(Gouvernorat.class);
			criteria.add(Restrictions.eq("code", Integer.parseInt(id)));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
