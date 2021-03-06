package com.cynapsys.dao;

import java.util.Date;
import java.util.List;

import com.cynapsys.entities.HuissiersNotaires;
import com.cynapsys.entities.Precontentieu;

public interface PrecontentieuDAO extends AbstractDAO<Precontentieu> {
	Precontentieu findById(String id);

	List<Precontentieu> findAllDta();
	List<Precontentieu> findByHuissierNotaire(HuissiersNotaires huissiersNotaires);
	List<Precontentieu> findByDelai(Date delai, Integer delaiJour);
}
