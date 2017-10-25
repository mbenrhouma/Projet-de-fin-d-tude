package com.cynapsys.service;



import com.cynapsys.entities.TypeReclamation;

public interface TypeReclamationService extends AbstractService<TypeReclamation>{
	TypeReclamation	findById(String id);
}
