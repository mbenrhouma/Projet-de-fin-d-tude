package com.cynapsys.service;

import com.cynapsys.entities.Employeur;

public interface EmployeurService extends AbstractService<Employeur>{
	Employeur	findById(String id);
}
