package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.AssureurDAO;
import com.cynapsys.entities.Assureur;
import com.cynapsys.service.AssureurService;
@Service("assureurService")
public class AssureurServiceImpl  implements AssureurService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AssureurDAO assureurDAO;
	@Override
	public Object save(Assureur entity) {
		return assureurDAO.save(entity);
	}
	@Override
	public void flush(Assureur entity) {
		assureurDAO.flush(entity);		
	}
	@Override
	public void update(Assureur entity) {
		assureurDAO.update(entity);		
	}
	@Override
	public boolean delete(Assureur entity) throws Exception {
		return assureurDAO.delete(entity);
	}
	@Override
	public Assureur find(Object idClass) {
		return assureurDAO.find(idClass);
	}
	@Override
	public List<Assureur> findAll() {
		return assureurDAO.findAll();
	}
	@Override
	public List<Assureur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return assureurDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return assureurDAO.getCount(filters);
	}
	@Override
	public List<Assureur> findSorted(String sortField, boolean sortOrder) {
		return assureurDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Assureur findById(String id) {
		return assureurDAO.findById(id);
	}
	public AssureurDAO getAssureurDAO() {
		return assureurDAO;
	}
	public void setAssureurDAO(AssureurDAO assureurDAO) {
		this.assureurDAO = assureurDAO;
	}


}
