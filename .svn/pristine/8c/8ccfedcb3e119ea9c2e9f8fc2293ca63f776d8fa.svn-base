package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.CelluleDAO;
import com.cynapsys.entities.Cellule;

@SuppressWarnings("serial")
@Repository("celluleDAO")
public class CelluleDAOImpl extends AbstractDAOImpl<Cellule>
		implements CelluleDAO, Serializable {

	public CelluleDAOImpl() {
		super(Cellule.class);
	}

	@Override
	public Cellule findById(String id) {
		
		List<Cellule> list=new ArrayList<Cellule>();
		try {
			Criteria criteria= getSession().createCriteria(Cellule.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
