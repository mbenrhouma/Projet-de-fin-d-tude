package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.HistoriqueClientLocDAO;
import com.cynapsys.entities.HistoriqueClientLoc;
import com.cynapsys.service.HistoriqueClientLocService;
@Service("historiqueClientLocService")
public class HistoriqueClientLocServiceImpl  implements HistoriqueClientLocService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private HistoriqueClientLocDAO historiqueClientLocDAO;
	@Override
	public Object save(HistoriqueClientLoc entity) {
		return historiqueClientLocDAO.save(entity);
	}
	@Override
	public void flush(HistoriqueClientLoc entity) {
		historiqueClientLocDAO.flush(entity);		
	}
	@Override
	public void update(HistoriqueClientLoc entity) {
		historiqueClientLocDAO.update(entity);		
	}
	@Override
	public boolean delete(HistoriqueClientLoc entity) throws Exception {
		return historiqueClientLocDAO.delete(entity);
	}
	@Override
	public HistoriqueClientLoc find(Object idClass) {
		return historiqueClientLocDAO.find(idClass);
	}
	@Override
	public List<HistoriqueClientLoc> findAll() {
		return historiqueClientLocDAO.findAll();
	}
	@Override
	public List<HistoriqueClientLoc> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return historiqueClientLocDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return historiqueClientLocDAO.getCount(filters);
	}
	@Override
	public List<HistoriqueClientLoc> findSorted(String sortField, boolean sortOrder) {
		return historiqueClientLocDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public HistoriqueClientLoc findById(String id) {
		return historiqueClientLocDAO.findById(id);
	}
	public HistoriqueClientLocDAO getHistoriqueClientLocDAO() {
		return historiqueClientLocDAO;
	}
	public void setHistoriqueClientLocDAO(HistoriqueClientLocDAO historiqueClientLocDAO) {
		this.historiqueClientLocDAO = historiqueClientLocDAO;
	}
	@Override
	public List<HistoriqueClientLoc> findDTA() {
		return historiqueClientLocDAO.findDTA();
	}
	@Override
	public HistoriqueClientLoc findByClientLocataire(Integer id) {
		return historiqueClientLocDAO.findByClientLocataire(id);
	}


}
