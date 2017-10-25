package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.TableauAmortissement;

public interface TableauAmortissementDAO extends AbstractDAO<TableauAmortissement> {
	TableauAmortissement findById(String id);
	List<TableauAmortissement> findAmortissementClientAcquereur(ClientAcquereur clientAcquereur);
	TableauAmortissement findByClientEtat(ClientAcquereur client);
	List<TableauAmortissement> findAmortissementActif();
}
