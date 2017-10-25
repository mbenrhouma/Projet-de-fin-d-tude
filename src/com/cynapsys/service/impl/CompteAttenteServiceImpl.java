package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.CompteAttenteDAO;
import com.cynapsys.entities.CompteAttente;
import com.cynapsys.service.CompteAttenteService;
@Service("compteAttenteService")
public class CompteAttenteServiceImpl  implements CompteAttenteService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private CompteAttenteDAO compteAttenteDAO;
	
	@Override
	public Object save(CompteAttente entity) {
		return compteAttenteDAO.save(entity);
	}
	@Override
	public void flush(CompteAttente entity) {
		compteAttenteDAO.flush(entity);		
	}
	@Override
	public void update(CompteAttente entity) {
		compteAttenteDAO.update(entity);		
	}
	@Override
	public boolean delete(CompteAttente entity) throws Exception {
		return compteAttenteDAO.delete(entity);
	}
	@Override
	public CompteAttente find(Object idClass) {
		return compteAttenteDAO.find(idClass);
	}
	@Override
	public List<CompteAttente> findAll() {
		return compteAttenteDAO.findAll();
	}
	@Override
	public List<CompteAttente> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return compteAttenteDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return compteAttenteDAO.getCount(filters);
	}
	@Override
	public List<CompteAttente> findSorted(String sortField, boolean sortOrder) {
		return compteAttenteDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public CompteAttente findById(String id) {
		return compteAttenteDAO.findById(id);
	}
	public CompteAttenteDAO getCompteAttenteDAO() {
		return compteAttenteDAO;
	}
	public void setCompteAttenteDAO(CompteAttenteDAO compteAttenteDAO) {
		this.compteAttenteDAO = compteAttenteDAO;
	}
	
}
