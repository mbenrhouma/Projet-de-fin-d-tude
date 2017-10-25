package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.ImpayeeDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Impayee;
import com.cynapsys.service.ImpayeeService;
@Service("impayeeService")
public class ImpayeeServiceImpl  implements ImpayeeService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ImpayeeDAO impayeeDAO;
	@Override
	public Object save(Impayee entity) {
		return impayeeDAO.save(entity);
	}
	@Override
	public void flush(Impayee entity) {
		impayeeDAO.flush(entity);		
	}
	@Override
	public void update(Impayee entity) {
		impayeeDAO.update(entity);		
	}
	@Override
	public boolean delete(Impayee entity) throws Exception {
		return impayeeDAO.delete(entity);
	}
	@Override
	public Impayee find(Object idClass) {
		return impayeeDAO.find(idClass);
	}
	@Override
	public List<Impayee> findAll() {
		return impayeeDAO.findAll();
	}
	@Override
	public List<Impayee> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return impayeeDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return getCount(filters);
	}
	@Override
	public List<Impayee> findSorted(String sortField, boolean sortOrder) {
		return impayeeDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Impayee findById(String id) {
		return impayeeDAO.findById(id);
	}
	public ImpayeeDAO getImpayeeDAO() {
		return impayeeDAO;
	}
	public void setImpayeeDAO(ImpayeeDAO impayeeDAO) {
		this.impayeeDAO = impayeeDAO;
	}
	@Override
	public List<Impayee> findAllDta() {
		return impayeeDAO.findAllDta();
	}
	@Override
	public List<Impayee> findByCriteres(Impayee impayee, String mode) {
		return impayeeDAO.findByCriteres(impayee, mode);
	}
	@Override
	public List<Impayee> findImpayeByClientAcquereur(
			ClientAcquereur clientAcquereur) {
		return impayeeDAO.findImpayeByClientAcquereur(clientAcquereur);
	}
	

}
