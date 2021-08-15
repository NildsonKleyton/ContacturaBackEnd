package com.contactura.contactura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactura.contactura.model.ContacturaUser;
import com.contactura.contactura.repository.ContacturaUserRepository;

@RestController
@RequestMapping({"/contacturauser"})//http://localhost:8095/contacturauser
public class ContacturaUserController {

	@Autowired
	private ContacturaUserRepository repository;
	
//  List All - //http://localhost:8095/contacturauser
	@GetMapping
	public List<?> findAll() {
		return repository.findAll();
	}
	
//  Find By Id - //http://localhost:8095/contacturauser/{id}
	@GetMapping(value = "{id}")
	public ResponseEntity<?> findById(@PathVariable long id){
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
//  Create - //http://localhost:8095/contacturauser
	@PostMapping
	public ContacturaUser create(@RequestBody ContacturaUser contacturaUser) {
		return repository.save(contacturaUser);
	}

//  Update - //http://localhost:8095/contacturauser/{id}
	@PutMapping(value = "{id}")
	public ResponseEntity<?> update (@PathVariable long id, @RequestBody ContacturaUser contacturaUser){
		return repository.findById(id)
				.map(record -> {
					record.setName(contacturaUser.getName());
					record.setUserName(contacturaUser.getUserName());
					record.setPassword(contacturaUser.getPassword());
					record.setAdmin(contacturaUser.isAdmin());
					ContacturaUser update = repository.save(record);
					return ResponseEntity.ok().body(update);
				}).orElse(ResponseEntity.notFound().build());
	}
	
//  Delete = //http://localhost:8095/contactura/{id}
	@DeleteMapping (path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable long id){
		return repository.findById(id)
				.map(record ->{
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}