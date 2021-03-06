package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.Localite;

public interface LocaliteDAO  extends AbstractDAO<Localite>{
	Localite findById(String id);
	List<Localite> finddta();
	List<Localite> finlocaliteByGov(Gouvernorat gov);
}
