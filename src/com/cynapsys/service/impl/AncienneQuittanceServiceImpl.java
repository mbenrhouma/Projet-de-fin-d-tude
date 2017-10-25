package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.AncienneQuittanceDAO;
import com.cynapsys.entities.AncienneQuittance;
import com.cynapsys.service.AncienneQuittanceService;
@Service("ancienneQuittanceService")
public class AncienneQuittanceServiceImpl  implements AncienneQuittanceService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AncienneQuittanceDAO ancienneQuittanceDAO;
	
	@Override
	public Object save(AncienneQuittance entity) {
		return ancienneQuittanceDAO.save(entity);
	}
	
	@Override
	public void flush(AncienneQuittance entity) {
		ancienneQuittanceDAO.flush(entity);		
	}
	@Override
	public void update(AncienneQuittance entity) {
		ancienneQuittanceDAO.update(entity);		
	}
	@Override
	public boolean delete(AncienneQuittance entity) throws Exception {
		return ancienneQuittanceDAO.delete(entity);
	}
	@Override
	public AncienneQuittance find(Object idClass) {
		return ancienneQuittanceDAO.find(idClass);
	}
	@Override
	public List<AncienneQuittance> findAll() {
		return ancienneQuittanceDAO.findAll();
	}
	@Override
	public List<AncienneQuittance> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return ancienneQuittanceDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return ancienneQuittanceDAO.getCount(filters);
	}
	@Override
	public List<AncienneQuittance> findSorted(String sortField, boolean sortOrder) {
		return ancienneQuittanceDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public AncienneQuittance findById(String code) {
		return ancienneQuittanceDAO.findById(code);
	}
	public AncienneQuittanceDAO getAncienneQuittanceDAO() {
		return ancienneQuittanceDAO;
	}
	public void setAncienneQuittanceDAO(AncienneQuittanceDAO ancienneQuittanceDAO) {
		this.ancienneQuittanceDAO = ancienneQuittanceDAO;
	}

	@Override
	public List<AncienneQuittance> findDTA() {
		
		return ancienneQuittanceDAO.findDTA() ;
	}


}
