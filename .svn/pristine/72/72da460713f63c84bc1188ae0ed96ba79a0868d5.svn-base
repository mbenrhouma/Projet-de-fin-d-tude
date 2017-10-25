package com.cynapsys.service;



import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.TableauAmortissement;

public interface MensualiteService extends AbstractService<Mensualite>{
	Mensualite	findById(String id);
	List<Mensualite> findByTabAm(TableauAmortissement tab);
	List<Mensualite> findByTa(TableauAmortissement ta);
	List<Mensualite> findByClientAcquereur(ClientAcquereur clientAcquereur);
}
