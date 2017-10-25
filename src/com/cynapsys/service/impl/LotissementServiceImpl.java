package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.LotissementDAO;
import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Lotissement;
import com.cynapsys.service.LotissementService;
@Service("lotissementService")
public class LotissementServiceImpl  implements LotissementService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private LotissementDAO lotissementDAO;
	@Override
	public Object save(Lotissement entity) {
		return lotissementDAO.save(entity);
	}
	@Override
	public void flush(Lotissement entity) {
		lotissementDAO.flush(entity);		
	}
	@Override
	public void update(Lotissement entity) {
		lotissementDAO.update(entity);		
	}
	@Override
	public boolean delete(Lotissement entity) throws Exception {
		return lotissementDAO.delete(entity);
	}
	@Override
	public Lotissement find(Object idClass) {
		return lotissementDAO.find(idClass);
	}
	@Override
	public List<Lotissement> findAll() {
		return lotissementDAO.findAll();
	}
	@Override
	public List<Lotissement> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return lotissementDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return lotissementDAO.getCount(filters);
	}
	@Override
	public List<Lotissement> findSorted(String sortField, boolean sortOrder) {
		return lotissementDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Lotissement findById(String id) {
		return lotissementDAO.findById(id);
	}
	public LotissementDAO getLotissementDAO() {
		return lotissementDAO;
	}
	public void setLotissementDAO(LotissementDAO lotissementDAO) {
		this.lotissementDAO = lotissementDAO;
	}
	@Override
	public List<Lotissement> finddta() {
		return lotissementDAO.finddta();
	}
	@Override
	public List<Lotissement> findLotissemByLocalite(Localite loc) {
		return lotissementDAO.findLotissemByLocalite(loc);
	}

}
