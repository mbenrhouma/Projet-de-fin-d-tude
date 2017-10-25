package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ColonneDAO;
import com.cynapsys.entities.Colonne;

@SuppressWarnings("serial")
@Repository("colonneDAO")
public class ColonneDAOImpl extends AbstractDAOImpl<Colonne>
		implements ColonneDAO, Serializable {

	public ColonneDAOImpl() {
		super(Colonne.class);
	}

	@Override
	public Colonne findById(String id) {
		
		List<Colonne> list=new ArrayList<Colonne>();
		try {
			Criteria criteria= getSession().createCriteria(Colonne.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
