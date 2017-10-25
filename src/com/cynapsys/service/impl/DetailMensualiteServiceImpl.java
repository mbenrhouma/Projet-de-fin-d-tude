package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.DetailMensualiteDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.DetailMensualite;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;
import com.cynapsys.service.DetailMensualiteService;
@Service("detailMensualiteService")
public class DetailMensualiteServiceImpl  implements DetailMensualiteService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private DetailMensualiteDAO detailMensualiteDAO;
	@Override
	public Object save(DetailMensualite entity) {
		return detailMensualiteDAO.save(entity);
	}
	@Override
	public void flush(DetailMensualite entity) {
		detailMensualiteDAO.flush(entity);		
	}
	@Override
	public void update(DetailMensualite entity) {
		detailMensualiteDAO.update(entity);		
	}
	@Override
	public boolean delete(DetailMensualite entity) throws Exception {
		return detailMensualiteDAO.delete(entity);
	}
	@Override
	public DetailMensualite find(Object idClass) {
		return detailMensualiteDAO.find(idClass);
	}
	@Override
	public List<DetailMensualite> findAll() {
		return detailMensualiteDAO.findAll();
	}
	@Override
	public List<DetailMensualite> findByFilter(int first, int pageSize, String sortField,
			boolean sortOrder, Map<String, String> filters) {
		return detailMensualiteDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return detailMensualiteDAO.getCount(filters);
	}
	@Override
	public List<DetailMensualite> findSorted(String sortField, boolean sortOrder) {
		return detailMensualiteDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public DetailMensualite findById(Integer id) {
		return detailMensualiteDAO.findById(id);
	}
	public DetailMensualiteDAO getDetailMensualiteDAO() {
		return detailMensualiteDAO;
	}
	public void setDetailMensualiteDAO(DetailMensualiteDAO detailMensualiteDAO) {
		this.detailMensualiteDAO = detailMensualiteDAO;
	}
	@Override
	public List<DetailMensualite> findbyMensualite(Mensualite mens) {
		return detailMensualiteDAO.findbyMensualite(mens);
	}
	@Override
	public List<DetailMensualite> findbymensDateAu(Mensualite mens, Date date) {
		// TODO Auto-generated method stub
		return detailMensualiteDAO.findbymensDateAu(mens, date);
	}
	@Override
	public List<DetailMensualite> findbymensDateDe(Mensualite mens, Date date) {
		return detailMensualiteDAO.findbymensDateDe(mens, date);
	}
	@Override
	public List<CalculInteretDeRetardPojo> findMensualiteByClient(
			ClientAcquereur client) {
		return detailMensualiteDAO.findMensualiteByClient(client);
	}
	@Override
	public List<DetailMensualite> findAllMensualiteByClient(
			ClientAcquereur client) {
		return detailMensualiteDAO.findAllMensualiteByClient(client);
	}

}
