package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cynapsys.dao.NoteDebitDAO;
import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Groupe;
import com.cynapsys.entities.NoteDebit;

@SuppressWarnings("serial")
@Repository("noteDebitDAO")
public class NoteDebitDAOImpl extends AbstractDAOImpl<NoteDebit>
		implements NoteDebitDAO, Serializable {

	public NoteDebitDAOImpl() {
		super(NoteDebit.class);
	}

	@Override
	public NoteDebit findById(String id) {
		

		List<NoteDebit> list = new ArrayList<NoteDebit>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from NoteDebit I left join fetch I.clientAcquereur k  left join fetch k.groupe left join fetch I.typeFrais left join fetch I.clientLocataire Z "
				+ " left join fetch Z.groupe  where I.id = '").append(id)
		.append("'");
		list = (List<NoteDebit>) this.getHibernateTemplate().find(req.toString());

		return list.get(0);
		
	}

	@Override
	public List<NoteDebit> recherchAv(Date dateDebitRechercheDe, Date dateDebitRechercheA, Double montantRechercheDE,
			Double montantRechercheA, Groupe groupeRecherche) {
		
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		List<NoteDebit> list = new ArrayList<NoteDebit>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from NoteDebit I left join fetch I.clientAcquereur k  left join fetch k.groupe left join fetch I.typeFrais left join fetch I.clientLocataire Z"
				+ " left join fetch Z.groupe  where 1 = 1");
	
		if (groupeRecherche != null && groupeRecherche.getCode()!=null) {
			req.append(" and I.clientAcquereur.groupe ='").append(groupeRecherche.getCode()).append("'");
		}
		if(dateDebitRechercheDe!=null){
			req.append(" and I.datedebit >= to_date('").append(format.format(dateDebitRechercheDe)).append("','dd/MM/yyyy')");
		}
			if(dateDebitRechercheA!=null){	
			req.append(" and I.datedebit <= to_date('").append(format.format(dateDebitRechercheA)).append("','dd/MM/yyyy')");
		}
		if(dateDebitRechercheDe!=null){
			req.append(" and I.montant >=").append(dateDebitRechercheDe);
		}
			
		if(dateDebitRechercheA!=null){	
			req.append(" and I.montant <=").append(dateDebitRechercheA);
		
		

		}
	
		list = (List<NoteDebit>) this.getHibernateTemplate().find(req.toString());

		return list;
	}

	@Override
	public List<NoteDebit> findDTA() {
		List<NoteDebit> list = new ArrayList<NoteDebit>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from NoteDebit I left join fetch I.clientAcquereur k  left join fetch k.groupe left join fetch I.typeFrais left join fetch I.clientLocataire Z"
				+ " left join fetch Z.groupe ");
		list = (List<NoteDebit>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
	}

	@Override
	public List<NoteDebit> fraisContentieuxByClientAcquereur(
			ClientAcquereur clientAcquereur) {
		StringBuilder req = new StringBuilder();
		List<NoteDebit> list = new ArrayList<NoteDebit>();
		req.append("from NoteDebit nb left join fetch nb.clientAcquereur  left join fetch nb.typeFrais");
		
		req.append(" where nb.typeFrais.id=4 and nb.clientAcquereur.codeAcquereur=").append(clientAcquereur.getCodeAcquereur());
				
		list=this.getHibernateTemplate().find(req.toString());
			return list;
	}
	}





