package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.pojo.ClientAcquereurRecherchPOJO;
import com.cynapsys.pojo.IdentificationPojo;

public interface ClientAcquereurDAO extends AbstractDAO<ClientAcquereur> {
	ClientAcquereur findById(String id);
	List<ClientAcquereur> findClients ();
	List<ClientAcquereur> rechercheClientAcquereur(ClientAcquereur clientAcquereur);
	List<ClientAcquereur> findDTA();
	List<ClientAcquereur> findAllDta();
	
	List <ClientAcquereur> rechercheAvancee(ClientAcquereurRecherchPOJO clientACPojo);
	 ClientAcquereur findByID(String codeAcquereur);
	IdentificationPojo findIdentifClient(ClientAcquereur clientAcquereur);
	List<ClientAcquereur> findAllList();
	List<ClientAcquereur> rechercheClientAcQEDITION();
	List<ClientAcquereur> ayantArrEdition();
	 List<ClientAcquereur> enContEdition();
	 List<ClientAcquereur> ayantPrixProvisEdition();
}


          