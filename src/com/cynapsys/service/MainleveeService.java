package com.cynapsys.service;



import com.cynapsys.entities.ClientAcquereur;
import com.cynapsys.entities.Mainlevee;

public interface MainleveeService extends AbstractService<Mainlevee>{
	Mainlevee	findById(String id);
	Mainlevee findByClientLoc(ClientAcquereur client);
}
