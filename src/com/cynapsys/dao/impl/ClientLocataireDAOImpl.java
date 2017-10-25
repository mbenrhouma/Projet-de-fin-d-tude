package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cynapsys.dao.ClientLocataireDAO;
import com.cynapsys.entities.ClientLocataire;

@SuppressWarnings("serial")
@Repository("clientLocataireDAO")
public class ClientLocataireDAOImpl extends AbstractDAOImpl<ClientLocataire>
		implements ClientLocataireDAO, Serializable {

	public ClientLocataireDAOImpl() {
		super(ClientLocataire.class);
	}

	@Override
	public ClientLocataire findById(String id) {
		
		List<ClientLocataire> list = new ArrayList<ClientLocataire>();
		StringBuilder req = new StringBuilder();
		req.append("from ClientLocataire I left join fetch I.groupe left join fetch I.logement k   where I.codeLocataire= ").append(id);
		list = (List<ClientLocataire>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty())
			return  list.get(0);
		else
			return null;
	
		
	}
	
	@Override
	public List<ClientLocataire> findDTA() {
		List<ClientLocataire> list = new ArrayList<ClientLocataire>();
		StringBuilder req = new StringBuilder();
		req.append("from ClientLocataire I   left join fetch I.groupe left join fetch I.logement k  ");
		list = (List<ClientLocataire>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty())
			return  list;
		else
			return null;
	}
}
