package com.cynapsys.service;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.Assurance;
import com.cynapsys.entities.Assureur;
import com.cynapsys.entities.Reclamation;

public interface ReclamationService extends AbstractService<Reclamation>{
	Reclamation findById(String id);

	List<Reclamation> findAll();
	List<Reclamation> findByCriteres(Reclamation rechRreclamation, String rechCodeClientAcquereur,
			String rechNomFRClientAcquereur, String rechNomARClientAcquereur, String rechAbreviationAssureur,String rechLibelleGroupe,
			String rechObjetReclamation, Date rechDateDebEnv, Date rechDateDebRec, Date rechDateDebRep,
			Date rechDateFinEnv, Date rechDateFinRec, Date rechDateFinRep);

	
}