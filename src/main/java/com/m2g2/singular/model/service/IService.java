package com.m2g2.singular.model.service;

import java.util.List;

public interface IService<T> {
	
	T create(T entity);
	
	
	T edit(T entity);

	
	T getById(Integer id);

	List<T> getAll();

	
	void delete(Integer id);
	
}
