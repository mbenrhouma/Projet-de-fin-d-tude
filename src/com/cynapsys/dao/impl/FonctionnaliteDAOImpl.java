package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cynapsys.dao.FonctionnaliteDAO;
import com.cynapsys.entities.Fonctionnalite;

@SuppressWarnings("serial")
@Repository("fonctionnaliteDAO")
public class FonctionnaliteDAOImpl extends AbstractDAOImpl<Fonctionnalite>
		implements FonctionnaliteDAO, Serializable {

	public FonctionnaliteDAOImpl() {
		super(Fonctionnalite.class);
	}

	@Override
	public Fonctionnalite findById(String id) {
		StringBuilder req = new StringBuilder();
		req.append("from Fonctionnalite ");
		req.append("where idFonctionnalite= ").append(id);
		List<Fonctionnalite> list = this.getHibernateTemplate().find(
				req.toString());
		if (list != null && !list.isEmpty())
			return (Fonctionnalite) list.get(0);
		else
			return null;
	}

}
