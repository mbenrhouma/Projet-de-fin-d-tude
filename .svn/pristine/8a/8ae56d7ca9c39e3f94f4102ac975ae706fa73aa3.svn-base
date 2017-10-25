package com.cynapsys.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.AssuranceDAO;
import com.cynapsys.entities.Assurance;
import com.cynapsys.service.AssuranceService;
@Service("assuranceService")
public class AssuranceServiceImpl  implements AssuranceService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private AssuranceDAO assuranceDAO;
	
	@Override
	public Object save(Assurance entity) {
		return assuranceDAO.save(entity);
	}
	@Override
	public void flush(Assurance entity) {
		assuranceDAO.flush(entity);		
	}
	@Override
	public void update(Assurance entity) {
		assuranceDAO.update(entity);		
	}
	@Override
	public boolean delete(Assurance entity) throws Exception {
		return assuranceDAO.delete(entity);
	}
	@Override
	public Assurance find(Object idClass) {
		return assuranceDAO.find(idClass);
	}
	@Override
	public List<Assurance> findAll() {
		return assuranceDAO.findAll();
	}
	@Override
	public List<Assurance> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return assuranceDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return assuranceDAO.getCount(filters);
	}
	@Override
	public List<Assurance> findSorted(String sortField, boolean sortOrder) {
		return assuranceDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Assurance findById(String id) {
		return assuranceDAO.findById(id);
	}
	public AssuranceDAO getAssuranceDAO() {
		return assuranceDAO;
	}
	public void setAssuranceDAO(AssuranceDAO assuranceDAO) {
		this.assuranceDAO = assuranceDAO;
	}
	
	@Override
	public List<Assurance> findAssuranceByCodeClient(Assurance assurance) {
		return assuranceDAO.findAssuranceByCodeClient(assurance);
	}
	
	@Override
	public Assurance findAssuranceByCodeConjoint(Assurance assurance){
		return assuranceDAO.findAssuranceByCodeConjoint(assurance);
	}
	
	@Override
	public Assurance findAssuranceInCodeClient(BigDecimal id) {
		return assuranceDAO.findAssuranceInCodeClient(id);
	}
	
	@Override
	public Assurance findAssuranceInCodeConjoint(BigInteger id) {
		return assuranceDAO.findAssuranceInCodeConjoint(id);
	}
	@Override
	public List<Assurance> findAllDta() {
		return assuranceDAO.findAllDta();
		
	}
	@Override
	public List<Assurance> findAllAssureur() {
		// TODO Auto-generated method stub
		return assuranceDAO.findAllAssureur();
	}

	@Override
	public 	List<Assurance> findAssuranceByClient(String id){
		return assuranceDAO.findAssuranceByClient(id);
	}

	

}
