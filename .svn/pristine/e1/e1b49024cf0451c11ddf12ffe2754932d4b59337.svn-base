package com.cynapsys.dao;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mouvement;
import com.cynapsys.pojo.CalculInteretApresEcheancePojo;
import com.cynapsys.pojo.CalculInteretDeRetardPojo;

public interface MouvementDAO  extends AbstractDAO<Mouvement>{
	Mouvement findById(String id);
	 List<Mouvement> findByClient(ClientAcquereur client,Date date);
	List <Mouvement> findByClientAu(ClientAcquereur client,Date date);
	List<CalculInteretDeRetardPojo> calculeListDebitCridet(ClientAcquereur client,Date dateFin);
	List<CalculInteretApresEcheancePojo> listMvmtApresEch(ClientAcquereur client,Date dateFin);
	Integer calculeRecetteCD(ClientAcquereur client);
	
}
