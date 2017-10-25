package com.cynapsys.dao;

import com.cynapsys.entities.Cellule;

public interface CelluleDAO  extends AbstractDAO<Cellule>{
	Cellule findById(String id);
}
