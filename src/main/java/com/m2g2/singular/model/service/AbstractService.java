package com.m2g2.singular.model.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractService<T> {

	private final JpaRepository<T, Integer> repository;
	
	public AbstractService(JpaRepository<T, Integer> repository) {
		this.repository = repository;
	}
	
	public T create(T entity) {
		return repository.save(entity);
	}
	
	public T edit(T entity) {
		return repository.save(entity);
	}
	
	public T getById(Integer id) {
		return repository.findById(id).orElseThrow();
	}
	
	public List<T> getAll() {
		return repository.findAll();
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
