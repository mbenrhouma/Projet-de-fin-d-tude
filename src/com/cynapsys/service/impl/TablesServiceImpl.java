package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.TablesDAO;
import com.cynapsys.entities.Tables;
import com.cynapsys.service.TablesService;
@Service("tablesService")
public class TablesServiceImpl  implements TablesService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private TablesDAO tablesDAO;
	@Override
	public Object save(Tables entity) {
		return tablesDAO.save(entity);
	}
	@Override
	public void flush(Tables entity) {
		tablesDAO.flush(entity);		
	}
	@Override
	public void update(Tables entity) {
		tablesDAO.update(entity);		
	}
	@Override
	public boolean delete(Tables entity) throws Exception {
		return tablesDAO.delete(entity);
	}
	@Override
	public Tables find(Object idClass) {
		return tablesDAO.find(idClass);
	}
	@Override
	public List<Tables> findAll() {
		return tablesDAO.findAll();
	}
	@Override
	public List<Tables> findByFilter(int first, int pageSize, String sortField,
			boolean sortOrder, Map<String, String> filters) {
		return tablesDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return tablesDAO.getCount(filters);
	}
	@Override
	public List<Tables> findSorted(String sortField, boolean sortOrder) {
		return tablesDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Tables findById(String id) {
		return tablesDAO.findById(id);
	}
	public TablesDAO getTablesDAO() {
		return tablesDAO;
	}
	public void setTablesDAO(TablesDAO tablesDAO) {
		this.tablesDAO = tablesDAO;
	}

}
