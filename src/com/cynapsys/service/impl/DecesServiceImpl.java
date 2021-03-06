package com.cynapsys.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.DecesDAO;
import com.cynapsys.entities.Deces;
import com.cynapsys.service.DecesService;
@Service("decesService")
public class DecesServiceImpl  implements DecesService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private DecesDAO decesDAO;
	@Override
	public Object save(Deces entity) {
		return decesDAO.save(entity);
	}
	@Override
	public void flush(Deces entity) {
		decesDAO.flush(entity);		
	}
	@Override
	public void update(Deces entity) {
		decesDAO.update(entity);		
	}
	@Override
	public boolean delete(Deces entity) throws Exception {
		return decesDAO.delete(entity);
	}
	@Override
	public Deces find(Object idClass) {
		return decesDAO.find(idClass);
	}
	@Override
	public List<Deces> findAll() {
		return decesDAO.findAll();
	}
	@Override
	public List<Deces> findByFilter(int first, int pageSize, String sortField,
			boolean sortOrder, Map<String, String> filters) {
		return decesDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return decesDAO.getCount(filters);
	}
	@Override
	public List<Deces> findSorted(String sortField, boolean sortOrder) {
		return decesDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Deces findById(String id) {
		return decesDAO.findById(id);
	}
	public DecesDAO getDecesDAO() {
		return decesDAO;
	}
	public void setDecesDAO(DecesDAO decesDAO) {
		this.decesDAO = decesDAO;
	}
	
	@Override
	public List<Deces> findDta() {
		return decesDAO.findDta();
	}
	
	@Override
	public List<Deces> findDecesByClient(String id) {
		return decesDAO.findDecesByClient(id);
	}
	@Override
	public Deces findDecesByClientcust(String id) {
		return decesDAO.findDecesByClientcust(id);
	}

}
