package com.cynapsys.service;



import com.cynapsys.entities.Tables;

public interface TablesService extends AbstractService<Tables>{
	Tables	findById(String id);
}
