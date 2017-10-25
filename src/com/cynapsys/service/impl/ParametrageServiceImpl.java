package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.ParametrageDAO;
import com.cynapsys.entities.Parametrage;
import com.cynapsys.service.ParametrageService;
@Service("parametrageService")
public class ParametrageServiceImpl  implements ParametrageService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ParametrageDAO parametrageDAO;
	
	@Override
	public Object save(Parametrage entity) {
		return parametrageDAO.save(entity);
	}
	
	@Override
	public void flush(Parametrage entity) {
		parametrageDAO.flush(entity);		
	}
	@Override
	public void update(Parametrage entity) {
		parametrageDAO.update(entity);		
	}
	@Override
	public boolean delete(Parametrage entity) throws Exception {
		return parametrageDAO.delete(entity);
	}
	@Override
	public Parametrage find(Object idClass) {
		return parametrageDAO.find(idClass);
	}
	@Override
	public List<Parametrage> findAll() {
		return parametrageDAO.findAll();
	}
	@Override
	public List<Parametrage> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return parametrageDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return parametrageDAO.getCount(filters);
	}
	@Override
	public List<Parametrage> findSorted(String sortField, boolean sortOrder) {
		return parametrageDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Parametrage findById(Integer id) {
		return parametrageDAO.findById(id);
	}
	public ParametrageDAO getParametrageDAO() {
		return parametrageDAO;
	}
	public void setParametrageDAO(ParametrageDAO parametrageDAO) {
		this.parametrageDAO = parametrageDAO;
	}


}
