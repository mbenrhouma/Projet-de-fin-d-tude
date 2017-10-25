package com.cynapsys.dao;

import com.cynapsys.entities.HuissiersNotaires;

public interface HuissiersNotairesDAO  extends AbstractDAO<HuissiersNotaires>{
	HuissiersNotaires findById(String id);
}
