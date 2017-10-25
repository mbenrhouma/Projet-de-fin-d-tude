package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.DetailQuittanceEmployeurDAO;
import com.cynapsys.entities.DetailQuittanceEmployeur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.QuitanceEmployeur;
import com.cynapsys.pojo.DetailCession;
import com.cynapsys.service.DetailQuittanceEmployeurService;
@Service("detailQuittanceEmployeurService")
public class DetailQuittanceEmployeurServiceImpl  implements DetailQuittanceEmployeurService,Serializable {
	                                                       
	private static final long serialVersionUID = 1L;
	@Autowired
	private DetailQuittanceEmployeurDAO detailQuittanceEmployeurDAO;
	
	@Override
	public Object save(DetailQuittanceEmployeur entity) {
		return detailQuittanceEmployeurDAO.save(entity);
	}         
	@Override
	public void flush(DetailQuittanceEmployeur entity) {
		detailQuittanceEmployeurDAO.flush(entity);		
	}
	@Override
	public void update(DetailQuittanceEmployeur entity) {
		detailQuittanceEmployeurDAO.update(entity);		
	}
	@Override
	public boolean delete(DetailQuittanceEmployeur entity) throws Exception {
		return detailQuittanceEmployeurDAO.delete(entity);
	}
	@Override
	public DetailQuittanceEmployeur find(Object idClass) {
		return detailQuittanceEmployeurDAO.find(idClass);
	}
	@Override
	public List<DetailQuittanceEmployeur> findAll() {
		return detailQuittanceEmployeurDAO.findAll();
	}
	@Override
	public List<DetailQuittanceEmployeur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return detailQuittanceEmployeurDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return detailQuittanceEmployeurDAO.getCount(filters);
	}
	@Override
	public List<DetailQuittanceEmployeur> findSorted(String sortField, boolean sortOrder) {
		return detailQuittanceEmployeurDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public DetailQuittanceEmployeur findById(String id) {
		return detailQuittanceEmployeurDAO.findById(id);
	}
	public DetailQuittanceEmployeurDAO getDetailQuittanceEmployeurDAO() {
		return detailQuittanceEmployeurDAO;
	}
	public void setDetailQuittanceEmployeurDAO(DetailQuittanceEmployeurDAO detailQuittanceEmployeurDAO) {
		this.detailQuittanceEmployeurDAO = detailQuittanceEmployeurDAO;
	}
	
	@Override
	public List<DetailCession> calculeSommeDQ (QuitanceEmployeur quittance , Employeur emp){
		return detailQuittanceEmployeurDAO.calculeSommeDQ(quittance, emp);
	}
	
}
