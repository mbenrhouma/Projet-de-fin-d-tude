package com.cynapsys.service;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.Arrangement;
import com.cynapsys.entities.ClientAcquereur;

public interface ArrangementService extends AbstractService<Arrangement> {
	Arrangement findById(String id);

	List<Arrangement> findByCriteres(Arrangement arrangement,Date dateD, Date dateF);
	List<Arrangement> findArrabgementByClientAcquereur(ClientAcquereur clientAcquereur);
	List<Arrangement> findAllDta();
}
