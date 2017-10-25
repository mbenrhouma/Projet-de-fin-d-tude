package com.cynapsys.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynapsys.dao.NoteDebitDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.NoteDebit;
import com.cynapsys.service.NoteDebitService;
@Service("noteDebitService")
public class NoteDebitServiceImpl  implements NoteDebitService,Serializable {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private NoteDebitDAO noteDebitDAO;
	@Override
	public Object save(NoteDebit entity) {
		return noteDebitDAO.save(entity);
	}
	@Override
	public void flush(NoteDebit entity) {
		noteDebitDAO.flush(entity);		
	}
	@Override
	public void update(NoteDebit entity) {
		noteDebitDAO.update(entity);		
	}
	@Override
	public boolean delete(NoteDebit entity) throws Exception {
		return noteDebitDAO.delete(entity);
	}
	@Override
	public NoteDebit find(Object idClass) {
		return noteDebitDAO.find(idClass);
	}
	@Override
	public List<NoteDebit> findAll() {
		return noteDebitDAO.findAll();
	}
	@Override
	public List<NoteDebit> findByFilter(int first, int pageSize,
			String sortField, boolean sortOrder, Map<String, String> filters) {
		return noteDebitDAO.findByFilter(first, pageSize, sortField, sortOrder, filters);
	}
	@Override
	public int getCount(Map<String, String> filters) {
		return noteDebitDAO.getCount(filters);
	}
	@Override
	public List<NoteDebit> findSorted(String sortField, boolean sortOrder) {
		return noteDebitDAO.findSorted(sortField, sortOrder);
	}
	@Override
	public NoteDebit findById(String id) {
		return noteDebitDAO.findById(id);
	}
	public NoteDebitDAO getNoteDebitDAO() {
		return noteDebitDAO;
	}
	public void setNoteDebitDAO(NoteDebitDAO noteDebitDAO) {
		this.noteDebitDAO = noteDebitDAO;
	}
	@Override
	public List<NoteDebit> recherchAv(Date dateDebitRechercheDe, Date dateDebitRechercheA, Double montantRechercheDE,
			Double montantRechercheA, Groupe groupeRecherche) {
		return noteDebitDAO.recherchAv(dateDebitRechercheDe, dateDebitRechercheA, montantRechercheDE, montantRechercheA, groupeRecherche);
	}
	@Override
	public List<NoteDebit> findDTA() {
		return noteDebitDAO.findDTA();
	}
	@Override
	public List<NoteDebit> fraisContentieuxByClientAcquereur(
			ClientAcquereur clientAcquereur) {
		return noteDebitDAO.fraisContentieuxByClientAcquereur(clientAcquereur);
	}

}
