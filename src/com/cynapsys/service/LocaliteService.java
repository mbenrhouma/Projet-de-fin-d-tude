package com.cynapsys.service;



import java.util.List;

import com.cynapsys.entities.Gouvernorat;
import com.cynapsys.entities.Localite;

public interface LocaliteService extends AbstractService<Localite>{
	Localite	findById(String id);
	List<Localite> finddta();
	List<Localite> finlocaliteByGov(Gouvernorat gov);
}
