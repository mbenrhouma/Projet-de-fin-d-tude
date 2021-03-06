package com.cynapsys.dao;

import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mainlevee;

public interface MainleveeDAO  extends AbstractDAO<Mainlevee>{
	Mainlevee findById(String id);
	Mainlevee findByClientLoc(ClientAcquereur client);
}
