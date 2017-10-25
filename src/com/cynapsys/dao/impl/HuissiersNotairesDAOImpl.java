package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.HuissiersNotairesDAO;
import com.cynapsys.entities.HuissiersNotaires;

@SuppressWarnings("serial")
@Repository("huissiersNotairesDAO")
public class HuissiersNotairesDAOImpl extends AbstractDAOImpl<HuissiersNotaires>
		implements HuissiersNotairesDAO, Serializable {

	public HuissiersNotairesDAOImpl() {
		super(HuissiersNotaires.class);
	}

	@Override
	public HuissiersNotaires findById(String id) {
		
		List<HuissiersNotaires> list=new ArrayList<HuissiersNotaires>();
		try {
			Criteria criteria= getSession().createCriteria(HuissiersNotaires.class);
			criteria.add(Restrictions.eq("id", Integer.parseInt(id)));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
