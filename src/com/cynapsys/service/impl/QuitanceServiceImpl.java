package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.QuitanceDAO;
import com.cynapsys.entities.Quitance;
import com.cynapsys.service.QuitanceService;
@Service("quitanceService")
public class QuitanceServiceImpl  implements QuitanceService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private QuitanceDAO quitanceDAO;
	@Override
	public Object save(Quitance entity) {
		return quitanceDAO.save(entity);
	}
	@Override
	public void flush(Quitance entity) {
		quitanceDAO.flush(entity);		
	}
	@Override
	public void update(Quitance entity) {
		quitanceDAO.update(entity);		
	}
	@Override
	public boolean delete(Quitance entity) throws Exception {
		return quitanceDAO.delete(entity);
	}
	@Override
	public Quitance find(Object idClass) {
		return quitanceDAO.find(idClass);
	}
	@Override
	public List<Quitance> findAll() {
		return quitanceDAO.findAll();
	}
	@Override
	public List<Quitance> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return quitanceDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return quitanceDAO.getCount(filters);
	}
	@Override
	public List<Quitance> findSorted(String sortField, boolean sortOrder) {
		return quitanceDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Quitance findById(String id) {
		return quitanceDAO.findById(id);
	}
	public QuitanceDAO getQuitanceDAO() {
		return quitanceDAO;
	}
	public void setQuitanceDAO(QuitanceDAO quitanceDAO) {
		this.quitanceDAO = quitanceDAO;
	}
	@Override
	public List<Quitance> findDTA() {
		return quitanceDAO.findDTA();
	}
	@Override
	public List<Quitance> rechercheAv(Integer montantQuittanceRecheche, String numQuittancerecherche,
			Date dateversemenDe, Date DatedateversemenA, String numCompteDattenterecherche, Date dateVersement,Integer etatQuitannace) {
		return quitanceDAO.rechercheAv(montantQuittanceRecheche
				, numQuittancerecherche
				, dateversemenDe
				, DatedateversemenA
				, numCompteDattenterecherche
				, dateVersement,etatQuitannace);
	}
	
	public List<Quitance> rechercheQuitance(Quitance quitance){
		return this.quitanceDAO.rechercheQuitance(quitance);
		
	}
	

}
