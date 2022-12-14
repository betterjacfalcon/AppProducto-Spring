package com.product.categoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.categoria.entities.Users;
import com.product.categoria.services.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@PostMapping
	public ResponseEntity<Users> createUser(@RequestBody Users users){
		
		return new ResponseEntity<Users>(usersService.createUser(users), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{userId}")
	public ResponseEntity<Users> updateUser(@PathVariable("userId") Integer userId, @RequestBody Users users){
		
		return new ResponseEntity<Users>(usersService.updateUser(userId, users), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer userId){
		usersService.deleteUser(userId);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
