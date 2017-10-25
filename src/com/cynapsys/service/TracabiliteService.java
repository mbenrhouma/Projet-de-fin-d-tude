package com.cynapsys.service;



import com.cynapsys.entities.Tracabilite;

public interface TracabiliteService extends AbstractService<Tracabilite>{
	Tracabilite	findById(String id);
}
