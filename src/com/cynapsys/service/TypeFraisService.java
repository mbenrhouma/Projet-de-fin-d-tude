package com.cynapsys.service;



import com.cynapsys.entities.TypeFrais;

public interface TypeFraisService extends AbstractService<TypeFrais>{
	TypeFrais	findById(Integer id);
}
