package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.TypeLogementDAO;
import com.cynapsys.entities.Localite;
import com.cynapsys.entities.TypeLogement;

@SuppressWarnings("serial")
@Repository("typeLogementDAO")
public class TypeLogementDAOImpl extends AbstractDAOImpl<TypeLogement>
		implements TypeLogementDAO, Serializable {

	public TypeLogementDAOImpl() {
		super(TypeLogement.class);
	}

	@Override
	public TypeLogement findById(String id) {

		StringBuilder req = new StringBuilder();

		req.append("from TypeLogement B  where B.codeType='").append(id).append("'");

		List<TypeLogement> loc = (List<TypeLogement>) this.getHibernateTemplate().find(req.toString());
		if ((loc != null) && (!(loc.isEmpty()))) {
			return loc.get(0);
		} else {

			return null;
		}
	}

}
