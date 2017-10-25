package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.AncienneQuittanceDAO;
import com.cynapsys.entities.AncienneQuittance;
import com.cynapsys.entities.Quitance;

@SuppressWarnings("serial")
@Repository("ancienneQuittanceDAO")
public class AncienneQuittanceDAOImpl extends AbstractDAOImpl<AncienneQuittance>
		implements AncienneQuittanceDAO, Serializable {

	public AncienneQuittanceDAOImpl() {
		super(AncienneQuittance.class);
	}

	@Override
	public AncienneQuittance findById(String code) {
		
		List<AncienneQuittance> list=new ArrayList<AncienneQuittance>();
		try {
			Criteria criteria= getSession().createCriteria(AncienneQuittance.class);
			criteria.add(Restrictions.eq("numQuittance", code));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}

	@Override
	public List<AncienneQuittance> findDTA() {
		List<AncienneQuittance> list = new ArrayList<AncienneQuittance>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from AncienneQuittance I left join fetch I.clientAcquereur A left join fetch A.groupe  ");
		list = (List<AncienneQuittance>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
	}
}
