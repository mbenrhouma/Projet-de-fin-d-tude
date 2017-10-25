package com.cynapsys.service;

import com.cynapsys.entities.Decompte;

public interface DecompteService extends AbstractService<Decompte> {
	Decompte findById(Integer id);

}
