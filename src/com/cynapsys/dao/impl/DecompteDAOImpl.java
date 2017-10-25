package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.DecompteDAO;
import com.cynapsys.entities.Decompte;

@SuppressWarnings("serial")
@Repository("decompteDAO")
public class DecompteDAOImpl extends AbstractDAOImpl<Decompte>
		implements DecompteDAO, Serializable {

	public DecompteDAOImpl() {
		super(Decompte.class);
	}

	@Override
	public Decompte findById(Integer id) {
		
		List<Decompte> list=new ArrayList<Decompte>();
		try {
			Criteria criteria= getSession().createCriteria(Decompte.class);
			criteria.add(Restrictions.eq("idDecompte", new Integer(id)));
			 list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(0);	
		
	}


}
