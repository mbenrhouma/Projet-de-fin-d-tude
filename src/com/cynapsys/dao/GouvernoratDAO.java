package com.cynapsys.dao;

import com.cynapsys.entities.Gouvernorat;

public interface GouvernoratDAO  extends AbstractDAO<Gouvernorat>{
	Gouvernorat findById(String id);
}
