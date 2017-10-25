package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.LogementDAO;
import com.cynapsys.entities.Logement;
import com.cynapsys.entities.NoteDebit;
import com.cynapsys.utils.Constants;

@SuppressWarnings("serial")
@Repository("logementDAO")
public class LogementDAOImpl extends AbstractDAOImpl<Logement>
		implements LogementDAO, Serializable {

	public LogementDAOImpl() {
		super(Logement.class);
	}

	@Override
	public Logement findById(String id) {
		List<Logement> list = new ArrayList<Logement>();
		StringBuilder req = new StringBuilder();
		req.append(
				"select  distinct new Logement(I.codeLogement,I.codePostal,I.adresseLoge,I.prixLog,I.numOrdre,gov.code,gov.libelle,typ.codeType,typ.libelle,lot.code,lot.libelleFr,loc.id,loc.libelleFr,loc.codePostal)from Logement I "
			
				+ " left join I.typeLogement as typ"
				+ " left join I.gouvernorat as gov"
				
				+ " left join I.lotissement as lot"
				+ " left join I.localite as loc where I.codeLogement='").append(id).append("'");
		list = (List<Logement>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;

		}
		
	}
	
	@Override
	public List<Logement>finDTA(){
		List<Logement> list = new ArrayList<Logement>();
		StringBuilder req = new StringBuilder();
		req.append(
				" select  distinct new Logement(I.codeLogement,I.codePostal,I.adresseLoge,I.prixLog,gov.code,gov.libelle,typ.codeType,typ.libelle)from Logement I "
				+ " left join I.typeLogement as typ "
				+ " left join I.gouvernorat as gov "
				+ " left join I.localite "
				
				
				);
		list = (List<Logement>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
		
		
	}
	
	@Override
	public List<Logement> finAllJoinLibre() {
		List<Logement> list = new ArrayList<Logement>();
		StringBuilder req = new StringBuilder();
		req.append(
				"from Logement I "
				+ " left join fetch I.typeLogement "
				+ " left join fetch I.gouvernorat"
			
				+ " left join fetch I.lotissement"
				+ " left join fetch I.localite where I.etatLog=").append(Constants.logementLibre);
		list = (List<Logement>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty()) {
			return list;
		} else {
			return null;

		}
	}

}
