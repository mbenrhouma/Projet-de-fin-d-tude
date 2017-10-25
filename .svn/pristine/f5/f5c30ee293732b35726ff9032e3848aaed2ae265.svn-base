package com.cynapsys.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cynapsys.dao.LotissementDAO;
import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Lotissement;

@SuppressWarnings("serial")
@Repository("lotissementDAO")
public class LotissementDAOImpl extends AbstractDAOImpl<Lotissement>
		implements LotissementDAO, Serializable {

	public LotissementDAOImpl() {
		super(Lotissement.class);
	}

	@Override
	public Lotissement findById(String id) {
		
		StringBuilder req = new StringBuilder();

		req.append(
				"from Lotissement b left join fetch b.localite  where  b.code='").append(id).append("'");
				
		List<Lotissement> loc = (List<Lotissement>) this.getHibernateTemplate().find(req.toString());
		if ((loc != null)&&(!(loc.isEmpty()))) {
			return loc.get(0);
		}else{

		return null;
		}
	}
	public List<Lotissement> finddta() {
		
		StringBuilder req = new StringBuilder();

		req.append(
				"from Lotissement b left join fetch b.localite");
				
		List<Lotissement> loc = (List<Lotissement>) this.getHibernateTemplate().find(req.toString());
		if ((loc != null)&&(!(loc.isEmpty()))) {
			return loc;
		}else{

		return null;
		}
	}

	@Override
	public List<Lotissement> findLotissemByLocalite(Localite loc) {
		StringBuilder req = new StringBuilder();

		req.append(
				"from Lotissement b left join fetch b.localite where b.localite.code= '").append(loc.getCode())
		.append("'");
				
		List<Lotissement> loc1 = (List<Lotissement>) this.getHibernateTemplate().find(req.toString());
		
		if ((loc1 != null)&&(!(loc1.isEmpty()))) {
			return loc1;
		}else{

		return null;
		}
	

}
}