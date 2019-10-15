package com.hudson.generics;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IGenericDao<T, ID extends Serializable> {
	
	void save(T object);
	
	void delete(T object);
	
	void deleteById(Long id);
	
	void deleteAll(List<T> list);
	
	Optional<T> findById(Long id);
	
	List<T> findAll();
	
}
