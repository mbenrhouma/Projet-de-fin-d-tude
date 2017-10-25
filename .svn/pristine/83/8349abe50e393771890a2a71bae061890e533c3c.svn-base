package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.ColonneDAO;
import com.cynapsys.entities.Colonne;
import com.cynapsys.service.ColonneService;
@Service("colonneService")
public class ColonneServiceImpl  implements ColonneService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ColonneDAO colonneDAO;
	@Override
	public Object save(Colonne entity) {
		return colonneDAO.save(entity);
	}
	@Override
	public void flush(Colonne entity) {
		colonneDAO.flush(entity);		
	}
	@Override
	public void update(Colonne entity) {
		colonneDAO.update(entity);		
	}
	@Override
	public boolean delete(Colonne entity) throws Exception {
		return colonneDAO.delete(entity);
	}
	@Override
	public Colonne find(Object idClass) {
		return colonneDAO.find(idClass);
	}
	@Override
	public List<Colonne> findAll() {
		return colonneDAO.findAll();
	}
	@Override
	public List<Colonne> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return colonneDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return colonneDAO.getCount(filters);
	}
	@Override
	public List<Colonne> findSorted(String sortField, boolean sortOrder) {
		return colonneDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Colonne findById(String id) {
		return colonneDAO.findById(id);
	}
	public ColonneDAO getColonneDAO() {
		return colonneDAO;
	}
	public void setColonneDAO(ColonneDAO colonneDAO) {
		this.colonneDAO = colonneDAO;
	}
	
}
