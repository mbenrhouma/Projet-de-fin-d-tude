package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.LocaliteDAO;
import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.Localite;
import com.cynapsys.service.LocaliteService;
@Service("localiteService")
public class LocaliteServiceImpl  implements LocaliteService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private LocaliteDAO localiteDAO;
	@Override
	public Object save(Localite entity) {
		return localiteDAO.save(entity);
	}
	@Override
	public void flush(Localite entity) {
		localiteDAO.flush(entity);		
	}
	@Override
	public void update(Localite entity) {
		localiteDAO.update(entity);		
	}
	@Override
	public boolean delete(Localite entity) throws Exception {
		return localiteDAO.delete(entity);
	}
	@Override
	public Localite find(Object idClass) {
		return localiteDAO.find(idClass);
	}
	@Override
	public List<Localite> findAll() {
		return localiteDAO.findAll();
	}
	@Override
	public List<Localite> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return localiteDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return localiteDAO.getCount(filters);
	}
	@Override
	public List<Localite> findSorted(String sortField, boolean sortOrder) {
		return localiteDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Localite findById(String id) {
		return localiteDAO.findById(id);
	}
	public LocaliteDAO getLocaliteDAO() {
		return localiteDAO;
	}
	public void setLocaliteDAO(LocaliteDAO localiteDAO) {
		this.localiteDAO = localiteDAO;
	}
	@Override
	public List<Localite> finddta() {
		return localiteDAO.finddta();
	}
	@Override
	public List<Localite> finlocaliteByGov(Gouvernorat gov) {
		return localiteDAO.finlocaliteByGov(gov);
	}

}
