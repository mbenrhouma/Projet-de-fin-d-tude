package com.cynapsys.dao;

import com.cynapsys.entities.Employeur;

public interface EmployeurDAO  extends AbstractDAO<Employeur>{
	Employeur findById(String id);
}
