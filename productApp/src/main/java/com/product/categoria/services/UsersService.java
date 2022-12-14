package com.product.categoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.product.categoria.entities.Users;
import com.product.categoria.repositories.UsersRepository;

import java.util.Optional;


@Service
public class UsersService {
	
	@Autowired
	private UsersRepository repository;	
	
	public Users createUser(Users users) {		
		return repository.save(users);
	}
	
	public Users updateUser(Integer userId, Users users) {
		Optional<Users> result = repository.findById(userId);		
		if(result.isPresent()) {
			return repository.save(users);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id %d doesn't exists", userId));
		}
	}
	
	public void deleteUser(Integer userId) {
		Optional<Users> result = repository.findById(userId);		
		if(result.isPresent()) {
			 repository.delete(result.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User id %d doesn't exists", userId));
		}
		
	}
	
	
	

}
