package com.m2g2.singular.model.service;

import org.springframework.stereotype.Service;

import com.m2g2.singular.model.User;
import com.m2g2.singular.model.repository.UserRepository;

@Service
public class UserService extends AbstractService<User> {

	public UserService(UserRepository repository) {
		super(repository);
	}
	
}
