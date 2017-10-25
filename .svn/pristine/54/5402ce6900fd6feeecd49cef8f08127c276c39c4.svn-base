package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.FonctionnaliteDAO;
import com.cynapsys.entities.Fonctionnalite;
import com.cynapsys.service.FonctionnaliteService;
@Service("fonctionnaliteService")
public class FonctionnaliteServiceImpl  implements FonctionnaliteService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private FonctionnaliteDAO fonctionnaliteDAO;

	@Override
	public Object save(Fonctionnalite entity) {
		
		return fonctionnaliteDAO.save(entity);
	}

	@Override
	public void update(Fonctionnalite entity) {
		fonctionnaliteDAO.update(entity);
	}

	@Override
	public boolean delete(Fonctionnalite entity)  throws Exception {
		return fonctionnaliteDAO.delete(entity);
	}

	@Override
	public List<Fonctionnalite> findAll() {
		return fonctionnaliteDAO.findAll();
	}

	@Override
	public List<Fonctionnalite> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return fonctionnaliteDAO.findByFilter(first, pageSize, sortField, sortOrder,
				filters);
	}

	@Override
	public int getCount(Map<String, String> filters) {
		return fonctionnaliteDAO.getCount(filters);
	}

	@Override
	public Fonctionnalite findById(String id) {
		return fonctionnaliteDAO.findById(id);
	}

	public FonctionnaliteDAO getFonctionnaliteDAO() {
		return fonctionnaliteDAO;
	}

	public void setFonctionnaliteDAO(FonctionnaliteDAO fonctionnaliteDAO) {
		this.fonctionnaliteDAO = fonctionnaliteDAO;
	}

	@Override
	public void flush(Fonctionnalite entity) {
		fonctionnaliteDAO.flush(entity);
	}

	@Override
	public List<Fonctionnalite> findSorted(String sortField, boolean sortOrder) {
		return fonctionnaliteDAO.findSorted(sortField, sortOrder);
	}

	@Override
	public Fonctionnalite find(Object idClass) {
		return this.fonctionnaliteDAO.find(idClass);
	}

	


}
