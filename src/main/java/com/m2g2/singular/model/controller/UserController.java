package com.m2g2.singular.model.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.m2g2.singular.model.User;
import com.m2g2.singular.model.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
	
	private final UserService service;

	@PostMapping
	public User create(@RequestBody @Valid User user) {
		log.info("Entrada do endpoint 'create' {}", user);
		user = service.create(user);
		log.info("Saida do endpoint 'create' {}", user);
		return user;
	}
	
	@GetMapping("{id}")
	public User getById(@PathVariable Integer id) {
		log.info("Entrada do endpoint 'getById' com 'id' = {}", id);
		try {
			User user = service.getById(id);
			log.info("Saida do endpoint 'getById'. Retorno: {}", user);
			return user;
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Não há registro que corresponda ao 'id'= %d passado", id));
		}
	}
	
	@GetMapping
	public List<User> getAll() {
		log.info("Entrada do endpoint 'getAll'.");
		List<User> users = service.getAll();
		log.info("Saida do endpoint 'getAll'. Retorno: {}", users);
		return users;
	}
}
