package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cynapsys.dao.CessionClientDAO;
import com.cynapsys.entities.CessionClient;
import com.cynapsys.entities.ClientAcquereur;

@SuppressWarnings("serial")
@Repository("cessionClientDAO")
public class CessionClientDAOImpl extends AbstractDAOImpl<CessionClient> implements CessionClientDAO, Serializable {

	public CessionClientDAOImpl () {
		super(CessionClient.class);
	}
	
	@Override
	public CessionClient findById(String id) {
		
		List<CessionClient> list=new ArrayList<CessionClient>();
		try {
			Criteria criteria= getSession().createCriteria(CessionClient.class);
			criteria.add(Restrictions.eq("code", id));
			 list = criteria.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list.get(0);	
		
	}
	
	@Override
	public List<CessionClient> findCessionByClientAcquereur(ClientAcquereur clientAcquereur) {
		
		StringBuilder req = new StringBuilder();
		req.append("from CessionClient C ");
		req.append("left join fetch C.clientAcquereur ");
		req.append("where C.clientAcquereur.codeAcquereur= ")
				.append(clientAcquereur.getCodeAcquereur());
		req.append("and C.actif=1 ");
		List<CessionClient> cessions=this.getHibernateTemplate().find(req.toString());
			return cessions;
	}
	
	@Override
	public List<CessionClient> findByCriteres(CessionClient cessionClient) {

		List<CessionClient> list = new ArrayList<CessionClient>();
		try {

			Criteria criteria = getSession().createCriteria(CessionClient.class);
			criteria.createAlias("clientAcquereur", "ca");

			if (cessionClient.getClientAcquereur().getNomPrenomFr() != null) {
				criteria.add(Restrictions.like("ca.nomPrenomFr", cessionClient
						.getClientAcquereur().getNomPrenomFr().toUpperCase(),
						MatchMode.START));
			}

			if (cessionClient.getClientAcquereur().getCodeAcquereur() != null) {
				criteria.add(Restrictions.eq("ca.codeAcquereur", cessionClient
						.getClientAcquereur().getCodeAcquereur()));
			}
			
			if(cessionClient.getActif() !=null) {
				criteria.add(Restrictions.eq("actif", cessionClient
						.getActif()));
			}

			list = criteria.list();
		} catch (Exception e) {

			// TODO: handle exception

			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CessionClient> findCession() {
		 StringBuilder req = new StringBuilder();
         req.append("from CessionClient c left join fetch c.cessionList " );                                
		 List<CessionClient> list = (List<CessionClient>) this.getHibernateTemplate().find(req.toString());
         return list;
}


	
}

