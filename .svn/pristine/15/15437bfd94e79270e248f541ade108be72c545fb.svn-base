package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cynapsys.dao.GroupeUtilisateurDAO;
import com.cynapsys.entities.GroupeUtilisateur;
import com.cynapsys.service.GroupeUtilisateurService;

public class GroupeUtilisateurServiceImpl implements GroupeUtilisateurService, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private GroupeUtilisateurDAO groupeUtilisateurDAO;
	
	
	@Override
	public Object save(GroupeUtilisateur entity) {
		return groupeUtilisateurDAO.save(entity);
	}
	@Override
	public void flush(GroupeUtilisateur entity) {
		groupeUtilisateurDAO.flush(entity);		
	}
	@Override
	public void update(GroupeUtilisateur entity) {
		groupeUtilisateurDAO.update(entity);		
	}
	@Override
	public boolean delete(GroupeUtilisateur entity) throws Exception {
		return groupeUtilisateurDAO.delete(entity);
	}
	@Override
	public GroupeUtilisateur find(Object idClass) {
		return groupeUtilisateurDAO.find(idClass);
	}
	@Override
	public List<GroupeUtilisateur> findAll() {
		return groupeUtilisateurDAO.findAll();
	}
	@Override
	public List<GroupeUtilisateur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return groupeUtilisateurDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return groupeUtilisateurDAO.getCount(filters);
	}
	@Override
	public List<GroupeUtilisateur> findSorted(String sortField,
			boolean sortOrder) {
		return groupeUtilisateurDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public GroupeUtilisateur findById(String id) {
		return groupeUtilisateurDAO.findById(id);
	}
	public GroupeUtilisateurDAO getGroupeUtilisateurDAO() {
		return groupeUtilisateurDAO;
	}
	public void setGroupeUtilisateurDAO(GroupeUtilisateurDAO groupeUtilisateurDAO) {
		this.groupeUtilisateurDAO = groupeUtilisateurDAO;
	}
	
	
	
}
