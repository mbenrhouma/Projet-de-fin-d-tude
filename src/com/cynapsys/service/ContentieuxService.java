package com.cynapsys.service;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Contentieux;

public interface ContentieuxService extends AbstractService<Contentieux> {
	Contentieux findById(String id);
	List<Contentieux> findByCriteres(Contentieux contentieux, Date dated,
			Date datef, String etatRelance);
	
	List<Contentieux> findAllDta();
	List<Contentieux> findContentieuxByClientAcquereur(ClientAcquereur clientAcquereur);
	Contentieux findContentieuxByCodeClientAcquereur(String codeAcquereur);
//	debut zied
	List<Contentieux> findContentieuxByClientAcquereurZ(ClientAcquereur clientAcquereur);
}
