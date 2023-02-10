package fr.dawan.eventhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.eventhub.entities.User;
import fr.dawan.eventhub.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(produces="application/json")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value="/admin", produces="application/json")
	public List<User> findAllAdmin(){
		return service.findAllAdmin();
	}

}
