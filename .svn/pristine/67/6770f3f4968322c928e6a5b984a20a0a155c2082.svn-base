package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TablesDAO;
import com.cynapsys.entities.Tables;

@SuppressWarnings("serial")
@Repository("tablesDAO")
public class TablesDAOImpl extends AbstractDAOImpl<Tables>
		implements TablesDAO, Serializable {

	public TablesDAOImpl() {
		super(Tables.class);
	}

	@Override
	public Tables findById(String id) {
		
		List<Tables> list=new ArrayList<Tables>();
		try {
			Criteria criteria= getSession().createCriteria(Tables.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
