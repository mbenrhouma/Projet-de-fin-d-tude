package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.DetailQuittanceEmployeurDAO;
import com.cynapsys.entities.DetailQuittanceEmployeur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.QuitanceEmployeur;
import com.cynapsys.pojo.DetailCession;

@SuppressWarnings("serial")
@Repository("detailQuittanceEmployeurDAO")
public class DetailQuittanceEmployeurDAOImpl extends AbstractDAOImpl<DetailQuittanceEmployeur>
		implements DetailQuittanceEmployeurDAO, Serializable {

	public DetailQuittanceEmployeurDAOImpl() {
		super(DetailQuittanceEmployeur.class);
	}

	@Override
	public DetailQuittanceEmployeur findById(String id) {
		
		List<DetailQuittanceEmployeur> list=new ArrayList<DetailQuittanceEmployeur>();
		try {
			Criteria criteria= getSession().createCriteria(DetailQuittanceEmployeur.class);
			criteria.add(Restrictions.eq("id", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}
	
	public List<DetailCession> calculeSommeDQ (QuitanceEmployeur quittance , Employeur emp) {
		
		List<DetailCession> list = new ArrayList<DetailCession>();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder req = new StringBuilder();
		
		req.append("select new DetailCession (cession.id as cession,sum(montantrecu)) from DetailQuittanceEmployeur d  where d.quittanceEmployeur in "
				+ "(select numQuittance from QuitanceEmployeur  q where q.dateDeb = '"+ format.format(quittance.getDateDeb())+"' and q.dateFin ='"+ format.format(quittance.getDateFin())+"' and q.employeur = "+emp.getCodeEmployeur()+"  ) group by cession");
		list = (List<DetailCession>) this.getHibernateTemplate().find(req.toString());
		return list ;
	}

}
