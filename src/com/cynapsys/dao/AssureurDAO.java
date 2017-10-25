package com.cynapsys.dao;

import com.cynapsys.entities.Assureur;

public interface AssureurDAO  extends AbstractDAO<Assureur>{
	Assureur findById(String id);
}
