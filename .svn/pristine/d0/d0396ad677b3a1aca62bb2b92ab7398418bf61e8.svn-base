package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.AnneeBudgetaireDAO;
import com.cynapsys.entities.AnneeBudgetaire;

@SuppressWarnings("serial")
@Repository("anneeBudgetaireDAO")
public class AnneeBudgetaireDAOImpl extends AbstractDAOImpl<AnneeBudgetaire>
		implements AnneeBudgetaireDAO, Serializable {

	public AnneeBudgetaireDAOImpl() {
		super(AnneeBudgetaire.class);
	}

	@Override
	public AnneeBudgetaire findById(String code) {
		
		List<AnneeBudgetaire> list=new ArrayList<AnneeBudgetaire>();
		try {
			Criteria criteria= getSession().createCriteria(AnneeBudgetaire.class);
			criteria.add(Restrictions.eq("code", code));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

}
