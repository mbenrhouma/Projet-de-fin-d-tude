package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.GouvernoratDAO;
import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.service.GouvernoratService;
@Service("gouvernoratService")
public class GouvernoratServiceImpl  implements GouvernoratService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private GouvernoratDAO gouvernoratDAO;
	
	@Override
	public Object save(Gouvernorat entity) {
		return gouvernoratDAO.save(entity);
	}
	@Override
	public void flush(Gouvernorat entity) {
		gouvernoratDAO.flush(entity);		
	}
	@Override
	public void update(Gouvernorat entity) {
		gouvernoratDAO.update(entity);		
	}
	@Override
	public boolean delete(Gouvernorat entity) throws Exception {
		return gouvernoratDAO.delete(entity);
	}
	@Override
	public Gouvernorat find(Object idClass) {
		return gouvernoratDAO.find(idClass);
	}
	@Override
	public List<Gouvernorat> findAll() {
		return gouvernoratDAO.findAll();
	}
	@Override
	public List<Gouvernorat> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return gouvernoratDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return gouvernoratDAO.getCount(filters);
	}
	@Override
	public List<Gouvernorat> findSorted(String sortField, boolean sortOrder) {
		return gouvernoratDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Gouvernorat findById(String id) {
		return gouvernoratDAO.findById(id);
	}
	public GouvernoratDAO getGouvernoratDAO() {
		return gouvernoratDAO;
	}
	public void setGouvernoratDAO(GouvernoratDAO gouvernoratDAO) {
		this.gouvernoratDAO = gouvernoratDAO;
	}


}
