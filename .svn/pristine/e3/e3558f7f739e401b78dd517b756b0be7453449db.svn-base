package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cynapsys.dao.HistoriqueClientLocDAO;
import com.cynapsys.entities.HistoriqueClientLoc;

@SuppressWarnings("serial")
@Repository("historiqueClientLocDAO")
public class HistoriqueClientLocDAOImpl extends AbstractDAOImpl<HistoriqueClientLoc>
		implements HistoriqueClientLocDAO, Serializable {

	public HistoriqueClientLocDAOImpl() {
		super(HistoriqueClientLoc.class);
	}

	@Override
	public HistoriqueClientLoc findById(String id) {
		
		List<HistoriqueClientLoc> list = new ArrayList<HistoriqueClientLoc>();
		StringBuilder req = new StringBuilder();
		req.append("from HistoriqueClientLoc I left join fetch I.logement k  I left join fetch I.clientLocataire  where I.hisCode= ").append(id);
		list = (List<HistoriqueClientLoc>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty())
			return  list.get(0);
		else
			return null;
	
		
	}
	
	@Override
	public List<HistoriqueClientLoc> findDTA() {
		List<HistoriqueClientLoc> list = new ArrayList<HistoriqueClientLoc>();
		StringBuilder req = new StringBuilder();
		req.append("from HistoriqueClientLoc I left join fetch I.logement k  I left join fetch I.clientLocataire ");
		list = (List<HistoriqueClientLoc>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty())
			return  list;
		else
			return null;
	}

	@Override
	public HistoriqueClientLoc findByClientLocataire(Integer id) {
		List<HistoriqueClientLoc> list = new ArrayList<HistoriqueClientLoc>();
		StringBuilder req = new StringBuilder();
		req.append("from HistoriqueClientLoc I left join fetch I.logement k  I left join fetch I.clientLocataire K wher K.codeLocataire=").append(id);
		list = (List<HistoriqueClientLoc>) this.getHibernateTemplate().find(req.toString());

		if (list != null && !list.isEmpty())
			return  list.get(0);
		else
			return null;
	}	
	}

