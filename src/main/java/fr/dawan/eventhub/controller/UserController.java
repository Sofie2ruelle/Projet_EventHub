package fr.dawan.eventhub.controller;

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

import fr.dawan.eventhub.entities.Event;
import fr.dawan.eventhub.entities.User;
import fr.dawan.eventhub.service.UserService;
import jakarta.annotation.PostConstruct;

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
	
	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<User> findUserPerId(@PathVariable Long id) {
		User user=service.findById(id);
		if(user != null)
		{
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		try {
			service.deleteUser(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("L'utilisateur à déjà été supprimé.");
	}
	
	@PutMapping(value="/{id}", produces="application/json", consumes ="application/json")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return service.updateUser(user);
	}
	
	@PostMapping(produces="application/json", consumes="application/json")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
}
