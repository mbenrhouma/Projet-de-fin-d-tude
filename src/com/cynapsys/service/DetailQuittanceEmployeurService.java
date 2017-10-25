package com.cynapsys.service;



import java.util.List;

import com.cynapsys.entities.DetailQuittanceEmployeur;
import com.cynapsys.entities.Employeur;
import com.cynapsys.entities.QuitanceEmployeur;
import com.cynapsys.pojo.DetailCession;

public interface DetailQuittanceEmployeurService extends AbstractService<DetailQuittanceEmployeur>{
	DetailQuittanceEmployeur	findById(String id);
	public List<DetailCession> calculeSommeDQ (QuitanceEmployeur quittance , Employeur emp);
}
