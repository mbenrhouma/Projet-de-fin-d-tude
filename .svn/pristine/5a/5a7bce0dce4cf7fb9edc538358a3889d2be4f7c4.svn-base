package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.QuitanceEmployeurDAO;
import com.cynapsys.entities.Cession;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.QuitanceEmployeur;

@SuppressWarnings("serial")
@Repository("quitanceEmployeurDAO")
public class QuitanceEmployeurDAOImpl extends AbstractDAOImpl<QuitanceEmployeur> implements QuitanceEmployeurDAO, Serializable {

	public QuitanceEmployeurDAOImpl () {
		super(QuitanceEmployeur.class);
	}
	
	@Override
	public QuitanceEmployeur findById(String id) {
		
		List<QuitanceEmployeur> list=new ArrayList<QuitanceEmployeur>();
		try {
			Criteria criteria= getSession().createCriteria(QuitanceEmployeur.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}
	
	public List<Long> sommeQuittanceEmployeur (QuitanceEmployeur quittance , Employeur emp){
		
		
		List<Long> list = new ArrayList<Long>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder req = new StringBuilder();
		req.append(" select sum(montantEnc) from QuitanceEmployeur q where q.dateDeb = '"+ format.format(quittance.getDateDeb())+"' and q.dateFin ='"+ format.format(quittance.getDateFin())+"' and q.employeur = "+emp.getCodeEmployeur()+"");
		
		list = (List<Long>) this.getHibernateTemplate().find(req.toString());
		return list ;
		
	}

	
}
