package com.cynapsys.service;

import java.util.List;
import java.util.Map;

public interface AbstractService<T> {

	public Object save(T entity);
	public void flush(T entity);
	
	public void update(T entity);

	public boolean delete(T entity) throws Exception ;
	public T find(Object idClass);
	public List<T> findAll();	

	public List<T> findByFilter(int first, int pageSize, String sortField,
			boolean sortOrder, Map<String, String> filters);

	public int getCount(Map<String, String> filters);
	
	public List<T> findSorted(String sortField, boolean sortOrder);

}
