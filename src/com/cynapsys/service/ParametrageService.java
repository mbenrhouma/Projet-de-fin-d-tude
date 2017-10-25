package com.cynapsys.service;



import com.cynapsys.entities.Parametrage;

public interface ParametrageService extends AbstractService<Parametrage>{
	Parametrage	findById(Integer id);
}
