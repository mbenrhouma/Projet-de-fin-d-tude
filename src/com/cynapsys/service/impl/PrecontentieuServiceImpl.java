package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.PrecontentieuDAO;
import com.cynapsys.entities.HuissiersNotaires;
import com.cynapsys.entities.Precontentieu;
import com.cynapsys.service.PrecontentieuService;
@Service("precontentieuService")
public class PrecontentieuServiceImpl  implements PrecontentieuService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private PrecontentieuDAO precontentieuDAO;
	@Override
	public Object save(Precontentieu entity) {
		return precontentieuDAO.save(entity);
	}
	@Override
	public void flush(Precontentieu entity) {
		precontentieuDAO.flush(entity);		
	}
	@Override
	public void update(Precontentieu entity) {
		precontentieuDAO.update(entity);		
	}
	@Override
	public boolean delete(Precontentieu entity) throws Exception {
		return precontentieuDAO.delete(entity);
	}
	@Override
	public Precontentieu find(Object idClass) {
		return precontentieuDAO.find(idClass);
	}
	@Override
	public List<Precontentieu> findAll() {
		return precontentieuDAO.findAll();
	}
	@Override
	public List<Precontentieu> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return precontentieuDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return precontentieuDAO.getCount(filters);
	}
	@Override
	public List<Precontentieu> findSorted(String sortField, boolean sortOrder) {
		return precontentieuDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Precontentieu findById(String id) {
		return precontentieuDAO.findById(id);
	}
	public PrecontentieuDAO getPrecontentieuDAO() {
		return precontentieuDAO;
	}
	public void setPrecontentieuDAO(PrecontentieuDAO precontentieuDAO) {
		this.precontentieuDAO = precontentieuDAO;
	}
	@Override
	public List<Precontentieu> findAllDta() {
		return this.precontentieuDAO.findAllDta();
	}
	@Override
	public List<Precontentieu>  findByHuissierNotaire(HuissiersNotaires huissiersNotaires) {
		return this.precontentieuDAO.findByHuissierNotaire(huissiersNotaires);
	}
	@Override
	public List<Precontentieu> findByDelai(Date delai, Integer delaiJour) {
		return this.precontentieuDAO.findByDelai(delai, delaiJour);
	}

}
