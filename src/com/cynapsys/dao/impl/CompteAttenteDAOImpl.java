package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.CompteAttenteDAO;
import com.cynapsys.entities.CompteAttente;

@SuppressWarnings("serial")
@Repository("compteAttenteDAO")
public class CompteAttenteDAOImpl extends AbstractDAOImpl<CompteAttente>
		implements CompteAttenteDAO, Serializable {

	public CompteAttenteDAOImpl() {
		super(CompteAttente.class);
	}

	@Override
	public CompteAttente findById(String id) {
		
		List<CompteAttente> list=new ArrayList<CompteAttente>();
		try {
			Criteria criteria= getSession().createCriteria(CompteAttente.class);
			criteria.add(Restrictions.eq("numCompte", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
