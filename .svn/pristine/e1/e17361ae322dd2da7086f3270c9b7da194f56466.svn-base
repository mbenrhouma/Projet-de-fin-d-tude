package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.GroupeDAO;
import com.cynapsys.entities.Groupe;
import com.cynapsys.service.GroupeService;
@Service("groupeService")
public class GroupeServiceImpl  implements GroupeService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private GroupeDAO groupeDAO;
	@Override
	public Object save(Groupe entity) {
		return groupeDAO.save(entity);
	}
	@Override
	public void flush(Groupe entity) {
		groupeDAO.flush(entity);		
	}
	@Override
	public void update(Groupe entity) {
		groupeDAO.update(entity);		
	}
	@Override
	public boolean delete(Groupe entity) throws Exception {
		return groupeDAO.delete(entity);
	}
	@Override
	public Groupe find(Object idClass) {
		return groupeDAO.find(idClass);
	}
	@Override
	public List<Groupe> findAll() {
		return groupeDAO.findAll();
	}
	@Override
	public List<Groupe> findByFilter(int first, int pageSize, String sortField,
			boolean sortOrder, Map<String, String> filters) {
		return groupeDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return groupeDAO.getCount(filters);
	}
	@Override
	public List<Groupe> findSorted(String sortField, boolean sortOrder) {
		return groupeDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Groupe findById(String id) {
		return groupeDAO.findById(id);
	}
	public GroupeDAO getGroupeDAO() {
		return groupeDAO;
	}
	public void setGroupeDAO(GroupeDAO groupeDAO) {
		this.groupeDAO = groupeDAO;
	}
	
	
	
}
