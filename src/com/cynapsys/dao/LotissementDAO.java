package com.cynapsys.dao;

import java.util.List;

import com.cynapsys.entities.Localite;
import com.cynapsys.entities.Lotissement;

public interface LotissementDAO  extends AbstractDAO<Lotissement>{
	Lotissement findById(String id);
	List<Lotissement> finddta();
	List<Lotissement> findLotissemByLocalite(Localite loc);
}
