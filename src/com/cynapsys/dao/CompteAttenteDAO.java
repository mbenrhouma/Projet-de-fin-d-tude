package com.cynapsys.dao;

import com.cynapsys.entities.CompteAttente;

public interface CompteAttenteDAO  extends AbstractDAO<CompteAttente>{
	CompteAttente findById(String id);
}
