package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.EmployeurDAO;
import com.cynapsys.entities.Employeur;
import com.cynapsys.service.EmployeurService;
@Service("employeurService")
public class EmployeurServiceImpl  implements EmployeurService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmployeurDAO employeurDAO;
	
	@Override
	public Object save(Employeur entity) {
		return employeurDAO.save(entity);
	}
	@Override
	public void flush(Employeur entity) {
		employeurDAO.flush(entity);		
	}
	@Override
	public void update(Employeur entity) {
		employeurDAO.update(entity);		
	}
	@Override
	public boolean delete(Employeur entity) throws Exception {
		return employeurDAO.delete(entity);
	}
	@Override
	public Employeur find(Object idClass) {
		return employeurDAO.find(idClass);
	}
	@Override
	public List<Employeur> findAll() {
		return employeurDAO.findAll();
	}
	@Override
	public List<Employeur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return employeurDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return employeurDAO.getCount(filters);
	}
	@Override
	public List<Employeur> findSorted(String sortField, boolean sortOrder) {
		return employeurDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Employeur findById(String id) {
		return employeurDAO.findById(id);
	}
	public EmployeurDAO getEmployeurDAO() {
		return employeurDAO;
	}
	public void setEmployeurDAO(EmployeurDAO employeurDAO) {
		this.employeurDAO = employeurDAO;
	}

}
