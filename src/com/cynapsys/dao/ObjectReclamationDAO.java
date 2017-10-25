package com.cynapsys.dao;

import com.cynapsys.entities.TypeReclamation;

public interface ObjectReclamationDAO extends AbstractDAO<TypeReclamation> {
	TypeReclamation findById(Integer id);
}
