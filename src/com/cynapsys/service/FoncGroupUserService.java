package com.cynapsys.service;

import com.cynapsys.entities.FoncGroupUser;

public interface FoncGroupUserService extends AbstractService<FoncGroupUser>{
	FoncGroupUser	findById(String id);
}
