package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.MainleveeDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.ClientLocataire;
import com.cynapsys.entities.Mainlevee;

@SuppressWarnings("serial")
@Repository("mainleveeDAO")
public class MainleveeDAOImpl extends AbstractDAOImpl<Mainlevee>
		implements MainleveeDAO, Serializable {

	public MainleveeDAOImpl() {
		super(Mainlevee.class);
	}

	@Override
	public Mainlevee findById(String id) {
		
		List<Mainlevee> list=new ArrayList<Mainlevee>();
		try {
			Criteria criteria= getSession().createCriteria(Mainlevee.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}
	@Override
	public Mainlevee findByClientLoc(ClientAcquereur client){
		List<Mainlevee> list = new ArrayList<Mainlevee>();
		StringBuilder req= new StringBuilder();
		req.append("from Mainlevee I where I.clientAcquereur.codeAcquereur= ").append(client.getCodeAcquereur());
		list = (List<Mainlevee>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !(list.isEmpty()))
			return  list.get(0);
		else
			return null;
		
		
	}
}
