package com.cynapsys.dao;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.NoteDebit;

public interface NoteDebitDAO  extends AbstractDAO<NoteDebit>{
	NoteDebit findById(String id);
	List<NoteDebit> recherchAv(Date dateDebitRechercheDe,Date dateDebitRechercheA, Double montantRechercheDE
			, Double montantRechercheA,Groupe groupeRecherche);
	List<NoteDebit> findDTA();
	List<NoteDebit> fraisContentieuxByClientAcquereur(ClientAcquereur clientAcquereur);
}
