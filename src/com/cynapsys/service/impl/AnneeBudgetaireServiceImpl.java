package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.AnneeBudgetaireDAO;
import com.cynapsys.entities.AnneeBudgetaire;
import com.cynapsys.service.AnneeBudgetaireService;
@Service("anneeBudgetaireService")
public class AnneeBudgetaireServiceImpl  implements AnneeBudgetaireService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AnneeBudgetaireDAO anneeBudgetaireDAO;
	
	@Override
	public Object save(AnneeBudgetaire entity) {
		return anneeBudgetaireDAO.save(entity);
	}
	
	@Override
	public void flush(AnneeBudgetaire entity) {
		anneeBudgetaireDAO.flush(entity);		
	}
	@Override
	public void update(AnneeBudgetaire entity) {
		anneeBudgetaireDAO.update(entity);		
	}
	@Override
	public boolean delete(AnneeBudgetaire entity) throws Exception {
		return anneeBudgetaireDAO.delete(entity);
	}
	@Override
	public AnneeBudgetaire find(Object idClass) {
		return anneeBudgetaireDAO.find(idClass);
	}
	@Override
	public List<AnneeBudgetaire> findAll() {
		return anneeBudgetaireDAO.findAll();
	}
	@Override
	public List<AnneeBudgetaire> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return anneeBudgetaireDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return anneeBudgetaireDAO.getCount(filters);
	}
	@Override
	public List<AnneeBudgetaire> findSorted(String sortField, boolean sortOrder) {
		return anneeBudgetaireDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public AnneeBudgetaire findById(String code) {
		return anneeBudgetaireDAO.findById(code);
	}
	public AnneeBudgetaireDAO getAnneeBudgetaireDAO() {
		return anneeBudgetaireDAO;
	}
	public void setAnneeBudgetaireDAO(AnneeBudgetaireDAO anneeBudgetaireDAO) {
		this.anneeBudgetaireDAO = anneeBudgetaireDAO;
	}


}