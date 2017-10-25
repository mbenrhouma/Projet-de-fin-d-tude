package com.cynapsys.dao;

import java.util.Date;
import java.util.List;



import com.cynapsys.entities.Quitance;

public interface QuitanceDAO  extends AbstractDAO<Quitance>{
	Quitance findById(String id);
	List<Quitance> findDTA();
	List<Quitance> rechercheAv(Integer montantQuittanceRecheche
			,String numQuittancerecherche
			,Date dateversemenDe
			, Date DatedateversemenA,
			String numCompteDattenterecherche
			, Date dateVersement,
			Integer etatQuitannace);
	public List<Quitance> rechercheQuitance(Quitance quitance);
}
