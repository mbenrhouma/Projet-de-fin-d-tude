package com.cynapsys.service;



import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.pojo.ClientAcquereurRecherchPOJO;
import com.cynapsys.pojo.IdentificationPojo;

public interface ClientAcquereurService extends AbstractService<ClientAcquereur>{
	ClientAcquereur findById(String id);

	List<ClientAcquereur> rechercheClientAcquereur(ClientAcquereur clientAcquereur);

	List<ClientAcquereur> findAllDta();

	List<ClientAcquereur> findDTA();

	List<ClientAcquereur> findClients();

	IdentificationPojo findIdentifClient(ClientAcquereur clientAcquereur);
	List<ClientAcquereur> findAllList();

	List<ClientAcquereur> rechercheAvancee(ClientAcquereurRecherchPOJO clientACPojo);

	ClientAcquereur findByID(String codeAcquereur);
	List<ClientAcquereur> rechercheClientAcQEDITION();
	List<ClientAcquereur> ayantArrEdition();
	 List<ClientAcquereur> enContEdition();
	 List<ClientAcquereur> ayantPrixProvisEdition();
}
