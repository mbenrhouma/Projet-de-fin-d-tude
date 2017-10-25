package com.cynapsys.service;

import java.util.List;

import com.cynapsys.entities.AncienneQuittance;


public interface AncienneQuittanceService  extends AbstractService<AncienneQuittance>{
	AncienneQuittance	findById(String id);
	List<AncienneQuittance> findDTA();
	
}
