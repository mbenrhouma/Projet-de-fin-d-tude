package com.cynapsys.dao;

import com.cynapsys.entities.TypeLogement;

public interface TypeLogementDAO  extends AbstractDAO<TypeLogement>{
	TypeLogement findById(String id);
}
