package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ParametrageDAO;
import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Parametrage;

@SuppressWarnings("serial")
@Repository("parametrageDAO")
public class ParametrageDAOImpl extends AbstractDAOImpl<Parametrage>
		implements ParametrageDAO, Serializable {

	public ParametrageDAOImpl() {
		super(Parametrage.class);
	}

	@Override
	public Parametrage findById(Integer id) {
		
		StringBuilder req = new StringBuilder();

		req.append(
				"from Parametrage b  b.id=").append(id);
				
		List<Parametrage> param = (List<Parametrage>) this.getHibernateTemplate().find(req.toString());
		if ((param != null)&&(!(param.isEmpty()))) {
			return param.get(0);
		}else{

		return null;
		}
		
	}

}
