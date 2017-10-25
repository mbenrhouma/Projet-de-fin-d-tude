package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.DecompteDAO;
import com.cynapsys.entities.Decompte;
import com.cynapsys.service.DecompteService;

@Service("decompteService")
public class DecompteServiceImpl implements DecompteService, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private DecompteDAO decomptetDAO;
	@Override
	public Object save(Decompte entity) {
		return decomptetDAO.save(entity);
	}
	@Override
	public void flush(Decompte entity) {
		decomptetDAO.flush(entity);		
	}
	@Override
	public void update(Decompte entity) {
		decomptetDAO.update(entity);		
	}
	@Override
	public boolean delete(Decompte entity) throws Exception {
		return decomptetDAO.delete(entity);
	}
	@Override
	public Decompte find(Object idClass) {
		return decomptetDAO.find(idClass);
	}
	@Override
	public List<Decompte> findAll() {
		return decomptetDAO.findAll();
	}
	@Override
	public List<Decompte> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return decomptetDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return decomptetDAO.getCount(filters);
	}
	@Override
	public List<Decompte> findSorted(String sortField, boolean sortOrder) {
		return decomptetDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Decompte findById(Integer id) {
		return decomptetDAO.findById(id);
	}
	public DecompteDAO getDecomptetDAO() {
		return decomptetDAO;
	}
	public void setDecomptetDAO(DecompteDAO decomptetDAO) {
		this.decomptetDAO = decomptetDAO;
	}



}
