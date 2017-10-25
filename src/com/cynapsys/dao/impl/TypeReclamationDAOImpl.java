package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TypeReclamationDAO;
import com.cynapsys.entities.Reclamation;
import com.cynapsys.entities.TypeReclamation;

@SuppressWarnings("serial")
@Repository("typeReclamationDAO")
public class TypeReclamationDAOImpl extends AbstractDAOImpl<TypeReclamation>
		implements TypeReclamationDAO, Serializable {

	public TypeReclamationDAOImpl() {
		super(TypeReclamation.class);
	}


		
	@Override
	public TypeReclamation findById(String id) {
		
		List<TypeReclamation> list=new ArrayList<TypeReclamation>();
		try {
			Criteria criteria= getSession().createCriteria(TypeReclamation.class);
			criteria.add(Restrictions.eq("code", new BigDecimal(id)));
			list = criteria.list();
			if(list!=null && list.size()>0)
				return list.get(0);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
