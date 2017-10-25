package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.FoncGroupUserDAO;
import com.cynapsys.entities.FoncGroupUser;

@SuppressWarnings("serial")
@Repository("foncGroupUserDAO")
public class FoncGroupUserDAOImpl extends AbstractDAOImpl<FoncGroupUser>
		implements FoncGroupUserDAO, Serializable {

	public FoncGroupUserDAOImpl() {
		super(FoncGroupUser.class);
	}

	@Override
	public FoncGroupUser findById(String id) {
		
		List<FoncGroupUser> list=new ArrayList<FoncGroupUser>();
		try {
			Criteria criteria= getSession().createCriteria(FoncGroupUser.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
