package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Impayee;

public interface ImpayeeDAO  extends AbstractDAO<Impayee>{
	Impayee findById(String id);
	List<Impayee> findAllDta();
	List<Impayee> findByCriteres(Impayee impayee, String mode);
	List<Impayee> findImpayeByClientAcquereur(ClientAcquereur clientAcquereur);
}
