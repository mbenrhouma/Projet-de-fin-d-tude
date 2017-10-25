package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.TypeLogementDAO;
import com.cynapsys.entities.TypeLogement;
import com.cynapsys.service.TypeLogementService;
@Service("typeLogementService")
public class TypeLogementServiceImpl  implements TypeLogementService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private TypeLogementDAO typeLogementDAO;
	@Override
	public Object save(TypeLogement entity) {
		return typeLogementDAO.save(entity);
	}
	@Override
	public void flush(TypeLogement entity) {
		typeLogementDAO.flush(entity);		
	}
	@Override
	public void update(TypeLogement entity) {
		typeLogementDAO.update(entity);		
	}
	@Override
	public boolean delete(TypeLogement entity) throws Exception {
		return typeLogementDAO.delete(entity);
	}
	@Override
	public TypeLogement find(Object idClass) {
		return typeLogementDAO.find(idClass);
	}
	@Override
	public List<TypeLogement> findAll() {
		return typeLogementDAO.findAll();
	}
	@Override
	public List<TypeLogement> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return typeLogementDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return typeLogementDAO.getCount(filters);
	}
	@Override
	public List<TypeLogement> findSorted(String sortField, boolean sortOrder) {
		return typeLogementDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public TypeLogement findById(String id) {
		return typeLogementDAO.findById(id);
	}
	public TypeLogementDAO getTypeLogementDAO() {
		return typeLogementDAO;
	}
	public void setTypeLogementDAO(TypeLogementDAO typeLogementDAO) {
		this.typeLogementDAO = typeLogementDAO;
	}

	
	
}
