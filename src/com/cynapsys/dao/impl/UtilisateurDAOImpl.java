package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.UtilisateurDAO;
import com.cynapsys.entities.Utilisateur;

@SuppressWarnings("serial")
@Repository("utilisateurDAO")
public class UtilisateurDAOImpl extends AbstractDAOImpl<Utilisateur> implements
		UtilisateurDAO, Serializable {
	public UtilisateurDAOImpl() {
		super(Utilisateur.class);
	}

	@Override
	public Utilisateur findByUtilisateur(String id, String password) {
		StringBuilder req = new StringBuilder();
		req.append("from Utilisateur ");
		req.append("where nom= ").append("'" + id + "'")
				.append("and motPasse=").append("'" + password + "'");
		List<Utilisateur> list = this.getHibernateTemplate().find(
				req.toString());

		if (list != null && !list.isEmpty())
			return (Utilisateur) list.get(0);
		else
			return null;
	}

	@Override
	public Utilisateur findByemail(String email) {
		StringBuilder req = new StringBuilder();
		req.append("from Utilisateur ");
		req.append("where email= ").append("'" + email + "'");
		List<Utilisateur> list = this.getHibernateTemplate().find(
				req.toString());

		if (list != null && !list.isEmpty())
			return (Utilisateur) list.get(0);
		else
			return null;
	}

	@Override
	public List<String> findValideurs(Integer codeGestion) {
		// TODO Auto-generated method stub
		try {
			StringBuilder req = new StringBuilder();
			req.append("select distinct agent.nom from Utilisateur u left join u.matricule as agent");
			req.append(" where u.codeGestion='" + codeGestion + "'");
			List<String> list = this.getHibernateTemplate()
					.find(req.toString());

			return list;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>();
		}

	}

	@Override
	public Utilisateur findById(Integer identifiant) {

		StringBuilder req = new StringBuilder();
		req.append("from Utilisateur ");
		req.append("where identifiant= ").append("'" + identifiant + "'");
		List<Utilisateur> list = this.getHibernateTemplate().find(
				req.toString());
		if (list != null && !list.isEmpty())
			return (Utilisateur) list.get(0);
		else
			return null;

	}

	@Override
	public Utilisateur findByLogin(String login) {
		String query ="from Utilisateur where login=?" ;
		List<Utilisateur> list = this.getHibernateTemplate().find(query,login);

		if (list != null && !list.isEmpty())
			return (Utilisateur) list.get(0);
		else
			return null;
	}
	
	

}
