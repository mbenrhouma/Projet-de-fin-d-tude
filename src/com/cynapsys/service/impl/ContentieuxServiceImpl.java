package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.ContentieuxDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Contentieux;
import com.cynapsys.service.ContentieuxService;
@Service("contentieuxService")
public class ContentieuxServiceImpl  implements ContentieuxService,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ContentieuxDAO contentieuxDAO;

	@Override
	public Object save(Contentieux entity) {
		return contentieuxDAO.save(entity);
	}

	@Override
	public void flush(Contentieux entity) {
		contentieuxDAO.flush(entity);		
	}

	@Override
	public void update(Contentieux entity) {
		contentieuxDAO.update(entity);		
	}

	@Override
	public boolean delete(Contentieux entity) throws Exception {
		return contentieuxDAO.delete(entity);
	}

	@Override
	public Contentieux find(Object idClass) {
		return contentieuxDAO.find(idClass);
	}

	@Override
	public List<Contentieux> findAll() {
		return contentieuxDAO.findAll();
	}

	@Override
	public List<Contentieux> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return contentieuxDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}

	@Override
	public int getCount(Map<String, String> filters) {
		return contentieuxDAO.getCount(filters);
	}

	@Override
	public List<Contentieux> findSorted(String sortField, boolean sortOrder) {
		return contentieuxDAO.findSorted(sortField, sortOrder);
	}

	@Override
	public Contentieux findById(String id) {
		return contentieuxDAO.findById(id);
	}

	public ContentieuxDAO getContentieuxDAO() {
		return contentieuxDAO;
	}

	public void setContentieuxDAO(ContentieuxDAO contentieuxDAO) {
		this.contentieuxDAO = contentieuxDAO;
	}

	@Override
	public List<Contentieux> findAllDta() {
		return this.contentieuxDAO.findAllDta();
	}

	@Override
	public List<Contentieux> findByCriteres(Contentieux contentieux, Date dated,
			Date datef, String etatRelance) {
		return this.contentieuxDAO.findByCriteres(contentieux, dated, datef, etatRelance);
	}

	@Override
	public List<Contentieux> findContentieuxByClientAcquereur(ClientAcquereur clientAcquereur) {
		return this.contentieuxDAO.findContentieuxByClientAcquereur(clientAcquereur);
	}
	@Override
	public Contentieux findContentieuxByCodeClientAcquereur(String codeAcquereur) {
		return this.contentieuxDAO.findContentieuxByCodeClientAcquereur(codeAcquereur);
	}

	@Override
	public List<Contentieux> findContentieuxByClientAcquereurZ(ClientAcquereur clientAcquereur) {
		return contentieuxDAO.findContentieuxByClientAcquereurZ(clientAcquereur);
	}
}