package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.HistoriqueClientLoc;

public interface HistoriqueClientLocDAO  extends AbstractDAO<HistoriqueClientLoc>{
	HistoriqueClientLoc findById(String id);
	 List<HistoriqueClientLoc> findDTA() ;
	 HistoriqueClientLoc findByClientLocataire(Integer id);
}
