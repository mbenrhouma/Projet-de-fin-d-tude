package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.TracabiliteDAO;
import com.cynapsys.entities.Tracabilite;
import com.cynapsys.service.TracabiliteService;
@Service("tracabiliteService")
public class TracabiliteServiceImpl  implements TracabiliteService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private TracabiliteDAO tracabiliteDAO;
	@Override
	public Object save(Tracabilite entity) {
		return tracabiliteDAO.save(entity);
	}
	@Override
	public void flush(Tracabilite entity) {
		tracabiliteDAO.flush(entity);		
	}
	@Override
	public void update(Tracabilite entity) {
		tracabiliteDAO.update(entity);		
	}
	@Override
	public boolean delete(Tracabilite entity) throws Exception {
		return tracabiliteDAO.delete(entity);
	}
	@Override
	public Tracabilite find(Object idClass) {
		return tracabiliteDAO.find(idClass);
	}
	@Override
	public List<Tracabilite> findAll() {
		return tracabiliteDAO.findAll();
	}
	@Override
	public List<Tracabilite> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return tracabiliteDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return tracabiliteDAO.getCount(filters);
	}
	@Override
	public List<Tracabilite> findSorted(String sortField, boolean sortOrder) {
		return tracabiliteDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Tracabilite findById(String id) {
		return tracabiliteDAO.findById(id);
	}
	public TracabiliteDAO getTracabiliteDAO() {
		return tracabiliteDAO;
	}
	public void setTracabiliteDAO(TracabiliteDAO tracabiliteDAO) {
		this.tracabiliteDAO = tracabiliteDAO;
	}
	

}
