package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TypeFraisDAO;
import com.cynapsys.entities.TypeFrais;

@SuppressWarnings("serial")
@Repository("typeFraisDAO")
public class TypeFraisDAOImpl extends AbstractDAOImpl<TypeFrais>
		implements TypeFraisDAO, Serializable {

	public TypeFraisDAOImpl() {
		super(TypeFrais.class);
	}

	@Override
	public TypeFrais findById(Integer id) {
		
		List<TypeFrais> list=new ArrayList<TypeFrais>();
		try {
			Criteria criteria= getSession().createCriteria(TypeFrais.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
