package com.cynapsys.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.cynapsys.dao.GroupeUtilisateurDAO;
import com.cynapsys.entities.GroupeUtilisateur;

@SuppressWarnings("serial")
@Repository("groupeUtilisateurDAO")
public class GroupeUtilisateurDAOImpl extends AbstractDAOImpl<GroupeUtilisateur> implements GroupeUtilisateurDAO, Serializable {

	public GroupeUtilisateurDAOImpl() {
		super(GroupeUtilisateur.class);
	}

	@Override
	public GroupeUtilisateur findById(String id) {
		return (GroupeUtilisateur) this.getHibernateTemplate().get(GroupeUtilisateur.class, id);
	}

}
