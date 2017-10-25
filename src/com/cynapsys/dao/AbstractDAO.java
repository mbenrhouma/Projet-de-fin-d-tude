package com.cynapsys.dao;

import java.util.List;
import java.util.Map;

public interface AbstractDAO<T> {

	public Object save(T entity);
	
	public void flush(T entity);

	public void update(T entity);

	public boolean delete(T entitys) throws Exception;

	public List<T> findAll();
	
	public T find(Object idClass);

	public List<T> findByFilter(int first, int pageSize, String sortField,
			boolean sortOrder, Map<String, String> filters);

	public int getCount(Map<String, String> filters);
	public List<T> findSorted(String sortField, boolean sortOrder);
	

}
