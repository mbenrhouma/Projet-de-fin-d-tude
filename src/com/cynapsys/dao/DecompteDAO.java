package com.cynapsys.dao;

import com.cynapsys.entities.Decompte;


public interface DecompteDAO extends AbstractDAO<Decompte> {
	Decompte findById(Integer id);
}
