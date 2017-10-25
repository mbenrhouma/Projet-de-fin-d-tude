package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.TypeMainleveeDAO;
import com.cynapsys.entities.TypeMainlevee;
import com.cynapsys.service.TypeMainleveeService;
@Service("typeMainleveeService")
public class TypeMainleveeServiceImpl  implements TypeMainleveeService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private TypeMainleveeDAO typeMainleveeDAO;
	
	@Override
	public Object save(TypeMainlevee entity) {
		return typeMainleveeDAO.save(entity);
	}
	
	@Override
	public void flush(TypeMainlevee entity) {
		typeMainleveeDAO.flush(entity);		
	}
	@Override
	public void update(TypeMainlevee entity) {
		typeMainleveeDAO.update(entity);		
	}
	@Override
	public boolean delete(TypeMainlevee entity) throws Exception {
		return typeMainleveeDAO.delete(entity);
	}
	@Override
	public TypeMainlevee find(Object idClass) {
		return typeMainleveeDAO.find(idClass);
	}
	@Override
	public List<TypeMainlevee> findAll() {
		return typeMainleveeDAO.findAll();
	}
	@Override
	public List<TypeMainlevee> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return typeMainleveeDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return typeMainleveeDAO.getCount(filters);
	}
	@Override
	public List<TypeMainlevee> findSorted(String sortField, boolean sortOrder) {
		return typeMainleveeDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public TypeMainlevee findById(String id) {
		return typeMainleveeDAO.findById(id);
	}
	public TypeMainleveeDAO getTypeMainleveeDAO() {
		return typeMainleveeDAO;
	}
	public void setTypeMainleveeDAO(TypeMainleveeDAO typeMainleveeDAO) {
		this.typeMainleveeDAO = typeMainleveeDAO;
	}


}
