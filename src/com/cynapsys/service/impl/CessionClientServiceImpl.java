package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.CessionClientDAO;
import com.cynapsys.entities.Cession;
import com.cynapsys.entities.CessionClient;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.service.CessionClientService;

@Service("cessionClientService")
public class CessionClientServiceImpl  implements CessionClientService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private CessionClientDAO cessionClientDAO;
	
	@Override
	public Object save(CessionClient entity) {
		return cessionClientDAO.save(entity);
	}
	
	@Override
	public void flush(CessionClient entity) {
		cessionClientDAO.flush(entity);		
	}
	@Override
	public void update(CessionClient entity) {
		cessionClientDAO.update(entity);		
	}
	@Override
	public boolean delete(CessionClient entity) throws Exception {
		return cessionClientDAO.delete(entity);
	}
	@Override
	public CessionClient find(Object idClass) {
		return cessionClientDAO.find(idClass);
	}
	@Override
	public List<CessionClient> findAll() {
		return cessionClientDAO.findAll();
	}
	@Override
	public List<CessionClient> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return cessionClientDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return cessionClientDAO.getCount(filters);
	}
	@Override
	public List<CessionClient> findSorted(String sortField, boolean sortOrder) {
		return cessionClientDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public CessionClient findById(String id) {
		return cessionClientDAO.findById(id);
	}
	public CessionClientDAO getCessionClientDAO() {
		return cessionClientDAO;
	}
	public void setCessionClientDAO(CessionClientDAO cessionClientDAO) {
		this.cessionClientDAO = cessionClientDAO;
	}
	
	@Override
	public List<CessionClient> findCessionByClientAcquereur(ClientAcquereur clientAcquereur){
		 return cessionClientDAO.findCessionByClientAcquereur(clientAcquereur);
	}
	
	public List<CessionClient> findByCriteres(CessionClient cessionClient) {
		return cessionClientDAO.findByCriteres(cessionClient);
	}
	@Override
	public List<CessionClient> findCession() {
		return cessionClientDAO.findCession();
	}

}
