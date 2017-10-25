package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.LogementDAO;
import com.cynapsys.entities.Logement;
import com.cynapsys.service.LogementService;
@Service("logementService")
public class LogementServiceImpl  implements LogementService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private LogementDAO logementDAO;

	@Override
	public Object save(Logement entity) {
		return logementDAO.save(entity);
	}
	@Override
	public void flush(Logement entity) {
		logementDAO.flush(entity);		
	}
	@Override
	public void update(Logement entity) {
		logementDAO.update(entity);		
	}
	@Override
	public boolean delete(Logement entity) throws Exception {
		return logementDAO.delete(entity);
	}
	@Override
	public Logement find(Object idClass) {
		return logementDAO.find(idClass);
	}
	@Override
	public List<Logement> findAll() {
		return logementDAO.findAll();
	}
	@Override
	public List<Logement> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return logementDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return logementDAO.getCount(filters);
	}
	@Override
	public List<Logement> findSorted(String sortField, boolean sortOrder) {
		return logementDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Logement findById(String id) {
		return logementDAO.findById(id);
	}
	
	public LogementDAO getLogementDAO() {
		return logementDAO;
	}
	public void setLogementDAO(LogementDAO logementDAO) {
		this.logementDAO = logementDAO;
	}
	@Override
	public List<Logement> finAllJoinLibre() {
		return logementDAO.finAllJoinLibre();
	}
	@Override
	public List<Logement> finDTA() {
		return logementDAO.finDTA();
	}
}
