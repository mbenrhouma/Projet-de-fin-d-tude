package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.EmployeurDAO;
import com.cynapsys.entities.Employeur;

@SuppressWarnings("serial")
@Repository("employeurDAO")
public class EmployeurDAOImpl extends AbstractDAOImpl<Employeur>
		implements EmployeurDAO, Serializable {

	public EmployeurDAOImpl() {
		super(Employeur.class);
	}

	@Override
	public Employeur findById(String id) {
		
		List<Employeur> list=new ArrayList<Employeur>();
		try {
			Criteria criteria= getSession().createCriteria(Employeur.class);
			criteria.add(Restrictions.eq("codeEmployeur", Integer.valueOf(id)));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
