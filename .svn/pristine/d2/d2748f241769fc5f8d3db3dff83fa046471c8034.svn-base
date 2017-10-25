package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.QuitanceEmployeurDAO;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.QuitanceEmployeur;
import com.cynapsys.service.QuitanceEmployeurService;

@Service("quitanceEmployeurService")
public class QuitanceEmployeurServiceImpl  implements QuitanceEmployeurService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private QuitanceEmployeurDAO quitanceEmployeurDAO;
	
	@Override
	public Object save(QuitanceEmployeur entity) {
		return quitanceEmployeurDAO.save(entity);
	}
	
	@Override
	public void flush(QuitanceEmployeur entity) {
		quitanceEmployeurDAO.flush(entity);		
	}
	@Override
	public void update(QuitanceEmployeur entity) {
		quitanceEmployeurDAO.update(entity);		
	}
	@Override
	public boolean delete(QuitanceEmployeur entity) throws Exception {
		return quitanceEmployeurDAO.delete(entity);
	}
	@Override
	public QuitanceEmployeur find(Object idClass) {
		return quitanceEmployeurDAO.find(idClass);
	}
	@Override
	public List<QuitanceEmployeur> findAll() {
		return quitanceEmployeurDAO.findAll();
	}
	@Override
	public List<QuitanceEmployeur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return quitanceEmployeurDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return quitanceEmployeurDAO.getCount(filters);
	}
	@Override
	public List<QuitanceEmployeur> findSorted(String sortField, boolean sortOrder) {
		return quitanceEmployeurDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public QuitanceEmployeur findById(String id) {
		return quitanceEmployeurDAO.findById(id);
	}
	public QuitanceEmployeurDAO getQuitanceEmployeurDAO() {
		return quitanceEmployeurDAO;
	}
	public void setQuitanceEmployeurDAO(QuitanceEmployeurDAO quitanceEmployeurDAO) {
		this.quitanceEmployeurDAO = quitanceEmployeurDAO;
	}
	
	@Override
	public List<Long>sommeQuittanceEmployeur (QuitanceEmployeur quittance , Employeur emp) {
		return quitanceEmployeurDAO.sommeQuittanceEmployeur(quittance, emp);
	}


}
