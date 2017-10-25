package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.TypeReclamationDAO;
import com.cynapsys.entities.TypeReclamation;
import com.cynapsys.service.TypeReclamationService;
@Service("typeReclamationService")
public class TypeReclamationServiceImpl  implements TypeReclamationService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private TypeReclamationDAO typeReclamationDAO;
	@Override
	public Object save(TypeReclamation entity) {
		return typeReclamationDAO.save(entity);
	}
	@Override
	public void flush(TypeReclamation entity) {
		typeReclamationDAO.flush(entity);		
	}
	@Override
	public void update(TypeReclamation entity) {
		typeReclamationDAO.update(entity);		
	}
	@Override
	public boolean delete(TypeReclamation entity) throws Exception {
		return typeReclamationDAO.delete(entity);
	}
	@Override
	public TypeReclamation find(Object idClass) {
		return typeReclamationDAO.find(idClass);
	}
	@Override
	public List<TypeReclamation> findAll() {
		return typeReclamationDAO.findAll();
	}
	@Override
	public List<TypeReclamation> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return typeReclamationDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return typeReclamationDAO.getCount(filters);
	}
	@Override
	public List<TypeReclamation> findSorted(String sortField, boolean sortOrder) {
		return typeReclamationDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public TypeReclamation findById(String id) {
		return typeReclamationDAO.findById(id);
	}
	public TypeReclamationDAO getTypeReclamationDAO() {
		return typeReclamationDAO;
	}
	public void setTypeReclamationDAO(TypeReclamationDAO typeReclamationDAO) {
		this.typeReclamationDAO = typeReclamationDAO;
	}

}
