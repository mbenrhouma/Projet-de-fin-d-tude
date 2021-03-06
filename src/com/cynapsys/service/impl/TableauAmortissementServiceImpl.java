package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.TableauAmortissementDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.TableauAmortissement;
import com.cynapsys.service.TableauAmortissementService;
@Service("tableauAmortissementService")
public class TableauAmortissementServiceImpl  implements TableauAmortissementService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private TableauAmortissementDAO tableauAmortissementDAO;
	@Override
	public Object save(TableauAmortissement entity) {
		return tableauAmortissementDAO.save(entity);
	}
	@Override
	public void flush(TableauAmortissement entity) {
		tableauAmortissementDAO.flush(entity);		
	}
	@Override
	public void update(TableauAmortissement entity) {
		tableauAmortissementDAO.update(entity);		
	}
	@Override
	public boolean delete(TableauAmortissement entity) throws Exception {
		return tableauAmortissementDAO.delete(entity);
	}
	@Override
	public TableauAmortissement find(Object idClass) {
		return tableauAmortissementDAO.find(idClass);
	}
	@Override
	public List<TableauAmortissement> findAll() {
		return tableauAmortissementDAO.findAll();
	}
	@Override
	public List<TableauAmortissement> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return tableauAmortissementDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return tableauAmortissementDAO.getCount(filters);
	}
	@Override
	public List<TableauAmortissement> findSorted(String sortField,
			boolean sortOrder) {
		return tableauAmortissementDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public TableauAmortissement findById(String id) {
		return tableauAmortissementDAO.findById(id);
	}
	@Override
	public List<TableauAmortissement> findAmortissementClientAcquereur(ClientAcquereur clientAcquereur) {
		return tableauAmortissementDAO.findAmortissementClientAcquereur(clientAcquereur);
	}
	@Override
	public TableauAmortissement findByClientEtat(ClientAcquereur client) {
		return tableauAmortissementDAO.findByClientEtat(client);
	}
	@Override
	public List<TableauAmortissement> findAmortissementActif() {
		return tableauAmortissementDAO.findAmortissementActif();
	}
	public TableauAmortissementDAO getTableauAmortissementDAO() {
		return tableauAmortissementDAO;
	}
	public void setTableauAmortissementDAO(
			TableauAmortissementDAO tableauAmortissementDAO) {
		this.tableauAmortissementDAO = tableauAmortissementDAO;
	}



}
