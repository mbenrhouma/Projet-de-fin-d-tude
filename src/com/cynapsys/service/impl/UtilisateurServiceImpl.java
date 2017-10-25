package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.UtilisateurDAO;
import com.cynapsys.entities.Utilisateur;
import com.cynapsys.service.UtilisateurService;
@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private UtilisateurDAO utilisateurDAO;

	@Override
	public Object save(Utilisateur entity) {
		utilisateurDAO.save(entity);
		return null;
	}

	@Override
	public void update(Utilisateur entity) {
		utilisateurDAO.update(entity);
	}

	@Override
	public boolean delete(Utilisateur entity) throws Exception {
		return utilisateurDAO.delete(entity);
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurDAO.findAll();
	}

	@Override
	public List<Utilisateur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return utilisateurDAO.findByFilter(first, pageSize, sortField,
				sortOrder, filters);
	}

	@Override
	public int getCount(Map<String, String> filters) {
		return utilisateurDAO.getCount(filters);
	}

	public UtilisateurDAO getUtilisateurDAO() {
		return utilisateurDAO;
	}

	public void setUtilisateurDAO(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public Utilisateur findByUtilisateur(String id, String password) {
		return utilisateurDAO.findByUtilisateur(id, password);
	}

	@Override
	public void flush(Utilisateur entity) {

	}

	@Override
	public List<Utilisateur> findSorted(String sortField, boolean sortOrder) {
		return utilisateurDAO.findSorted(sortField, sortOrder);
	}

	@Override
	public List<String> findValideurs(Integer codeGestion) {
		return utilisateurDAO.findValideurs(codeGestion);
	}

	@Override
	public Utilisateur findById(Integer identifiant) {
		return utilisateurDAO.findById(identifiant);
	}

	@Override
	public Utilisateur findByemail(String email) {
		return utilisateurDAO.findByemail(email);
	}

	@Override
	public Utilisateur find(Object idClass) {
		return this.utilisateurDAO.find(idClass);
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return this.utilisateurDAO.findByLogin(login);
	}

}
