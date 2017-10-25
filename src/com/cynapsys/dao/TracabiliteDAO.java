package com.cynapsys.dao;

import com.cynapsys.entities.Tracabilite;

public interface TracabiliteDAO  extends AbstractDAO<Tracabilite>{
	Tracabilite findById(String id);
}
