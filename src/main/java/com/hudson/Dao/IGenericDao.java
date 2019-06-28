package com.hudson.Dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, ID extends Serializable> {
	
	void save(T object);
	
	void delete(T object);
	
	void deleteById(Long id);
	
	void deleteAll(List<T> list);
	
	T findById(Long id);
	
	List<T> findAll();
	
}
