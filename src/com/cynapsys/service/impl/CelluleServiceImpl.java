package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.CelluleDAO;
import com.cynapsys.entities.Cellule;
import com.cynapsys.service.CelluleService;
@Service("celluleService")
public class CelluleServiceImpl  implements CelluleService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private CelluleDAO celluleDAO;
	@Override
	public Object save(Cellule entity) {
		return celluleDAO.save(entity);
	}
	@Override
	public void flush(Cellule entity) {
		celluleDAO.flush(entity);		
	}
	@Override
	public void update(Cellule entity) {
		celluleDAO.update(entity);		
	}
	@Override
	public boolean delete(Cellule entity) throws Exception {
		return celluleDAO.delete(entity);
	}
	@Override
	public Cellule find(Object idClass) {
		return celluleDAO.find(idClass);
	}
	@Override
	public List<Cellule> findAll() {
		return celluleDAO.findAll();
	}
	@Override
	public List<Cellule> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return celluleDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return celluleDAO.getCount(filters);
	}
	@Override
	public List<Cellule> findSorted(String sortField, boolean sortOrder) {
		return celluleDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Cellule findById(String id) {
		return celluleDAO.findById(id);
	}
	public CelluleDAO getCelluleDAO() {
		return celluleDAO;
	}
	public void setCelluleDAO(CelluleDAO celluleDAO) {
		this.celluleDAO = celluleDAO;
	}



}
