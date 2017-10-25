package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.HuissiersNotairesDAO;
import com.cynapsys.entities.HuissiersNotaires;
import com.cynapsys.service.HuissiersNotairesService;
@Service("huissiersNotairesService")
public class HuissiersNotairesServiceImpl  implements HuissiersNotairesService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private HuissiersNotairesDAO huissiersNotairesDAO;
	@Override
	public Object save(HuissiersNotaires entity) {
		return huissiersNotairesDAO.save(entity);
	}
	@Override
	public void flush(HuissiersNotaires entity) {
		huissiersNotairesDAO.flush(entity);		
	}
	@Override
	public void update(HuissiersNotaires entity) {
		huissiersNotairesDAO.update(entity);		
	}
	@Override
	public boolean delete(HuissiersNotaires entity) throws Exception {
		return huissiersNotairesDAO.delete(entity);
	}
	@Override
	public HuissiersNotaires find(Object idClass) {
		return huissiersNotairesDAO.find(idClass);
	}
	@Override
	public List<HuissiersNotaires> findAll() {
		return huissiersNotairesDAO.findAll();
	}
	@Override
	public List<HuissiersNotaires> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return huissiersNotairesDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return huissiersNotairesDAO.getCount(filters);
	}
	@Override
	public List<HuissiersNotaires> findSorted(String sortField,
			boolean sortOrder) {
		return huissiersNotairesDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public HuissiersNotaires findById(String id) {
		return huissiersNotairesDAO.findById(id);
	}
	public HuissiersNotairesDAO getHuissiersNotairesDAO() {
		return huissiersNotairesDAO;
	}
	public void setHuissiersNotairesDAO(HuissiersNotairesDAO huissiersNotairesDAO) {
		this.huissiersNotairesDAO = huissiersNotairesDAO;
	}
	

}
