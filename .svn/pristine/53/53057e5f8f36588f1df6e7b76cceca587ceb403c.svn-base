package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.ReclamationDAO;
import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.Reclamation;
import com.cynapsys.service.ReclamationService;
@Service("reclamationService")
public class ReclamationServiceImpl  implements ReclamationService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ReclamationDAO reclamationDAO;
	@Override
	public Object save(Reclamation entity) {
		return reclamationDAO.save(entity);
	}
	@Override
	public void flush(Reclamation entity) {
		reclamationDAO.flush(entity);		
	}
	@Override
	public void update(Reclamation entity) {
		reclamationDAO.update(entity);		
	}
	@Override
	public boolean delete(Reclamation entity) throws Exception {
		return reclamationDAO.delete(entity);
	}
	@Override
	public Reclamation find(Object idClass) {
		return reclamationDAO.find(idClass);
	}
	@Override
	public List<Reclamation> findAll() {
		return reclamationDAO.findAll();
	}
	@Override
	public List<Reclamation> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return reclamationDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return reclamationDAO.getCount(filters);
	}
	@Override
	public List<Reclamation> findSorted(String sortField, boolean sortOrder) {
		return reclamationDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Reclamation findById(String id) {
		return reclamationDAO.findById(id);
	}
	public ReclamationDAO getReclamationDAO() {
		return reclamationDAO;
	}
	public void setReclamationDAO(ReclamationDAO reclamationDAO) {
		this.reclamationDAO = reclamationDAO;
	}
	
	@Override
	public List<Reclamation> findByCriteres(Reclamation rechRreclamation, String rechCodeClientAcquereur,
			String rechNomFRClientAcquereur, String rechNomARClientAcquereur, String rechAbreviationAssureur,
			String rechLibelleGroupe, String rechObjetReclamation, Date rechDateDebEnv, Date rechDateDebRec, Date rechDateDebRep,
			Date rechDateFinEnv, Date rechDateFinRec, Date rechDateFinRep) {
		// TODO Auto-generated method stub
		return reclamationDAO.findByCriteres(rechRreclamation, rechCodeClientAcquereur,
			rechNomFRClientAcquereur, rechNomARClientAcquereur, rechAbreviationAssureur,
			rechLibelleGroupe, rechObjetReclamation, rechDateDebEnv, rechDateDebRec, rechDateDebRep,
			rechDateFinEnv, rechDateFinRec, rechDateFinRep);
	}
	
}
