package fr.dawan.eventhub.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.eventhub.entities.User;
import fr.dawan.eventhub.form.LoginForm;
import fr.dawan.eventhub.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm){
		User user = userService.findByEmail(loginForm.getEmail());
		
		Map<String, Object> response = new HashMap<>();

		
		if(user == null) {
			response.put("succes", false);
			response.put("message", "Email incorrect.");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
		
		if(!user.getPassword().equals(loginForm.getPassword())) {
			response.put("succes", false);
			response.put("message", "Mot de passe incorrect.");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
		
		response.put("succes", true);
		response.put("message", "Authentification reussite !");		
		response.put("user",user);
		
		
		
		return ResponseEntity.ok(response);
		
	}

}
