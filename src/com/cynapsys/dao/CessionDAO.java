package com.cynapsys.dao;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.Cession;
import com.cynapsys.entities.CessionClient;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Employeur;

public interface CessionDAO  extends AbstractDAO<Cession>{
	Cession findById(String id);
	List<Cession> findAllDta();
	List<Cession> findByCriteres(Cession cession);
	List<Cession> findCessionByClientAcquereur(ClientAcquereur clientAcquereur);
	List<Cession> findCessionByCessionClient (CessionClient cessionClient);
	List<Cession> findCessionbyDate(Date dd, Date df , Employeur emp);
	List<Cession> findCessionByClientAcquereurpasConj(ClientAcquereur clientAcquereur);

	List<Cession> findCessionByClientAcquereurConjoint(ClientAcquereur clientAcquereur);
	List<Cession>ayantCessionDelegation();
	List<Cession> findCessionByClientAcquereurEdition(String code);
	List<Cession> findCessionByClientAcquereurEditionCDActive();
	List<Cession> findCessionByClientAcquereurEditionCDEchuNonArchive() ;
	
}
