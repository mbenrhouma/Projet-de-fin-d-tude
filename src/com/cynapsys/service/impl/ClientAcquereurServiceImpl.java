package com.cynapsys.service.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.ClientAcquereurDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.pojo.ClientAcquereurRecherchPOJO;
import com.cynapsys.pojo.IdentificationPojo;
import com.cynapsys.service.ClientAcquereurService;
@Service("clientAcquereurService")
public class ClientAcquereurServiceImpl  implements ClientAcquereurService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private ClientAcquereurDAO clientAcquereurDAO;
	
	@Override
	public Object save(ClientAcquereur entity) {
		return clientAcquereurDAO.save(entity);
	}
	@Override
	public void flush(ClientAcquereur entity) {
		clientAcquereurDAO.flush(entity);		
	}
	@Override
	public void update(ClientAcquereur entity) {
		clientAcquereurDAO.update(entity);		
	}
	
	@Override
	public boolean delete(ClientAcquereur entity) throws Exception {
		return clientAcquereurDAO.delete(entity);
	}
	@Override
	public ClientAcquereur find(Object idClass) {
		return clientAcquereurDAO.find(idClass);
	}
	@Override
	public List<ClientAcquereur> findAll() {
		return clientAcquereurDAO.findAll();
	}
	@Override
	public List<ClientAcquereur> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return clientAcquereurDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return clientAcquereurDAO.getCount(filters);
	}
	@Override
	public List<ClientAcquereur> findSorted(String sortField, boolean sortOrder) {
		return clientAcquereurDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public ClientAcquereur findById(String id) {
		return clientAcquereurDAO.findById(id);
	}
	
	@Override
	public List<ClientAcquereur> rechercheClientAcquereur(
			ClientAcquereur clientAcquereur) {
		return clientAcquereurDAO.rechercheClientAcquereur(clientAcquereur);
	}
	
	public ClientAcquereurDAO getClientAcquereurDAO() {
		return clientAcquereurDAO;
	}
	public void setClientAcquereurDAO(ClientAcquereurDAO clientAcquereurDAO) {
		this.clientAcquereurDAO = clientAcquereurDAO;
	}
	@Override
	public List<ClientAcquereur> findAllDta() {
		return this.clientAcquereurDAO.findAllDta();
	}
	
	@Override
	public List<ClientAcquereur> findDTA() {
		return clientAcquereurDAO.findDTA();
	}
	@Override
	public List<ClientAcquereur> findClients() {
		return clientAcquereurDAO.findClients();
	}
	@Override
	public IdentificationPojo findIdentifClient(ClientAcquereur clientAcquereur) {
		return clientAcquereurDAO.findIdentifClient(clientAcquereur);
	}
	@Override
	public List<ClientAcquereur> rechercheAvancee(ClientAcquereurRecherchPOJO clientACPojo) {
		
		return clientAcquereurDAO.rechercheAvancee(clientACPojo);
	}
	@Override
	public List<ClientAcquereur> findAllList() {
		return clientAcquereurDAO.findAllList();
	}
	@Override
	public ClientAcquereur findByID(String codeAcquereur) {
		return clientAcquereurDAO.findByID(codeAcquereur);
	}
	@Override
	public List<ClientAcquereur> rechercheClientAcQEDITION() {
		
		return clientAcquereurDAO.rechercheClientAcQEDITION();
	}
	@Override
	public List<ClientAcquereur> ayantArrEdition() {
		return clientAcquereurDAO.ayantArrEdition();
	}
	@Override
	public List<ClientAcquereur> enContEdition() {
		return clientAcquereurDAO.enContEdition();
	}
	@Override
	public List<ClientAcquereur> ayantPrixProvisEdition() {
		
		return clientAcquereurDAO.ayantPrixProvisEdition();
	}
	

}
