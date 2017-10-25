package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.FoncGroupUserDAO;
import com.cynapsys.entities.FoncGroupUser;
import com.cynapsys.service.FoncGroupUserService;
@Service("foncGroupUserService")
public class FoncGroupUserServiceImpl  implements FoncGroupUserService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private FoncGroupUserDAO foncGroupUserDAO;
	
	@Override
	public Object save(FoncGroupUser entity) {
		return foncGroupUserDAO.save(entity);
	}
	@Override
	public void flush(FoncGroupUser entity) {
		foncGroupUserDAO.flush(entity);		
	}
	@Override
	public void update(FoncGroupUser entity) {
		foncGroupUserDAO.update(entity);		
	}
	@Override
	public boolean delete(FoncGroupUser entity) throws Exception {
		return foncGroupUserDAO.delete(entity);
	}
	@Override
	public FoncGroupUser find(Object idClass) {
		return foncGroupUserDAO.find(idClass);
	}
	@Override
	public List<FoncGroupUser> findAll() {
		return foncGroupUserDAO.findAll();
	}
	@Override
	public List<FoncGroupUser> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return foncGroupUserDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return foncGroupUserDAO.getCount(filters);
	}
	@Override
	public List<FoncGroupUser> findSorted(String sortField, boolean sortOrder) {
		return foncGroupUserDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public FoncGroupUser findById(String id) {
		return foncGroupUserDAO.findById(id);
	}
	public FoncGroupUserDAO getFoncGroupUserDAO() {
		return foncGroupUserDAO;
	}
	public void setFoncGroupUserDAO(FoncGroupUserDAO foncGroupUserDAO) {
		this.foncGroupUserDAO = foncGroupUserDAO;
	}

}
