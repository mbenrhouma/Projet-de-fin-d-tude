package com.cynapsys.service;



import com.cynapsys.entities.HuissiersNotaires;

public interface HuissiersNotairesService extends AbstractService<HuissiersNotaires>{
	HuissiersNotaires	findById(String id);
}
