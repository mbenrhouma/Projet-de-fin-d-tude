package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.Cession;
import com.cynapsys.entities.CessionClient;
import com.cynapsys.entities.ClientAcquereur;

public interface CessionClientDAO extends AbstractDAO<CessionClient> {
	CessionClient findById(String id);

	List<CessionClient> findCessionByClientAcquereur(ClientAcquereur clientAcquereur);

	List<CessionClient> findByCriteres(CessionClient cessionClient);

	List<CessionClient> findCession();

	

}
