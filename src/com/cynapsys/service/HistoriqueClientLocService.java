package com.cynapsys.service;



import java.util.List;

import com.cynapsys.entities.HistoriqueClientLoc;

public interface HistoriqueClientLocService extends AbstractService<HistoriqueClientLoc>{
	HistoriqueClientLoc	findById(String id);
	 List<HistoriqueClientLoc> findDTA() ;
	 HistoriqueClientLoc findByClientLocataire(Integer id);
}
