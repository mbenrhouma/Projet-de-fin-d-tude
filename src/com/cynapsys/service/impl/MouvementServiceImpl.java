package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.MouvementDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.pojo.CalculInteretApresEcheancePojo;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;
import com.cynapsys.service.MouvementService;
@Service("mouvementService")
public class MouvementServiceImpl  implements MouvementService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private MouvementDAO mouvementDAO;
	@Override
	public Object save(Mouvement entity) {
		return mouvementDAO.save(entity);
	}
	@Override
	public void flush(Mouvement entity) {
		mouvementDAO.flush(entity);		
	}
	@Override
	public void update(Mouvement entity) {
		mouvementDAO.update(entity);		
	}
	@Override
	public boolean delete(Mouvement entity) throws Exception {
		return mouvementDAO.delete(entity);
	}
	@Override
	public Mouvement find(Object idClass) {
		return mouvementDAO.find(idClass);
	}
	@Override
	public List<Mouvement> findAll() {
		return mouvementDAO.findAll();
	}
	@Override
	public List<Mouvement> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return mouvementDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return mouvementDAO.getCount(filters);
	}
	@Override
	public List<Mouvement> findSorted(String sortField, boolean sortOrder) {
		return mouvementDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public Mouvement findById(String id) {
		return mouvementDAO.findById(id);
	}
	public MouvementDAO getMouvementDAO() {
		return mouvementDAO;
	}
	public void setMouvementDAO(MouvementDAO mouvementDAO) {
		this.mouvementDAO = mouvementDAO;
	}
	@Override
	public List<Mouvement> findByClient(ClientAcquereur client, Date date) {
		return mouvementDAO.findByClient(client, date);
	}
	@Override
	public List<Mouvement> findByClientAu(ClientAcquereur client, Date date) {
		return mouvementDAO.findByClientAu(client, date);
	}
	@Override
	public List<CalculInteretDeRetardPojo> calculeListDebitCridet(ClientAcquereur client ,Date dateFin) {
		return mouvementDAO.calculeListDebitCridet(client,dateFin);
	}
	@Override
	public List<CalculInteretApresEcheancePojo> listMvmtApresEch(
			ClientAcquereur client, Date dateFin) {
		return mouvementDAO.listMvmtApresEch(client, dateFin);
	}
	@Override
	public Integer calculeRecetteCD(ClientAcquereur client) {
		return mouvementDAO.calculeRecetteCD(client);
	}

	
	
}
