package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TypeMainleveeDAO;
import com.cynapsys.entities.TypeMainlevee;

@SuppressWarnings("serial")
@Repository("typeMainleveeDAO")
public class TypeMainleveeDAOImpl extends AbstractDAOImpl<TypeMainlevee>
		implements TypeMainleveeDAO, Serializable {

	public TypeMainleveeDAOImpl() {
		super(TypeMainlevee.class);
	}

	@Override
	public TypeMainlevee findById(String id) {
		
		List<TypeMainlevee> list=new ArrayList<TypeMainlevee>();
		try {
			Criteria criteria= getSession().createCriteria(TypeMainlevee.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
