package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mensualite;
import com.cynapsys.entities.TableauAmortissement;

public interface MensualiteDAO  extends AbstractDAO<Mensualite>{
	Mensualite findById(String id);
	List<Mensualite> findByTa(TableauAmortissement ta);
	List<Mensualite> findByTabAm(TableauAmortissement tab);
	List<Mensualite> findByClientAcquereur(ClientAcquereur clientAcquereur);
}
