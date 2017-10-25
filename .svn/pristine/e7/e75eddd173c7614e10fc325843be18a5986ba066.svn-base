package com.cynapsys.service;



import java.util.Date;
import java.util.List;

import com.cynapsys.entities.Quitance;

public interface QuitanceService extends AbstractService<Quitance>{
	Quitance	findById(String id);
	List<Quitance> findDTA();
	List<Quitance> rechercheAv(Integer montantQuittanceRecheche
			,String numQuittancerecherche
			,Date dateversemenDe
			, Date DatedateversemenA,
			String numCompteDattenterecherche
			, Date dateVersement,Integer etatQuitannace);
	public List<Quitance> rechercheQuitance(Quitance quitance);
}
