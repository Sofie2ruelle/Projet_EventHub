package fr.dawan.eventhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.eventhub.entities.Event;
import fr.dawan.eventhub.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("/api/events")
public class EventController {
	
	@Autowired
	private EventService service;

	// Trouver tout les événements.
	@GetMapping(produces="application/json")
	public List<Event> findAll(){
		return service.findAll();
	}
	
	// Trouver un événement par son id.
	@GetMapping(value="/{id}", produces = "application/json")
	public ResponseEntity<Event> findEventPerId(@PathVariable Long id) {
		Event event=service.findById(id);
		if(event != null)
		{
			return ResponseEntity.ok(event);
		}
		return ResponseEntity.notFound().build();	
	}
	
	// Trouver tous les événements d'un utilisateur.
	@GetMapping(value="/events-by-user/{id}", produces = "application/json")
	public ResponseEntity<List<Event>> findAllEventsByIdUser(@PathVariable Long id){
		List<Event> events=service.findAllEventsByIdUser(id);
		if(events != null) {
			return ResponseEntity.ok(events);
		}
		return ResponseEntity.notFound().build();
	}
	
	// Supprimer un événement
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable long id){
		try {
			service.deleteEvent(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok("L'evenement à déjà été supprimé");
	}
	
	// Edition d'un événement.
	@PostMapping(value="/{id}", produces="application/json", consumes ="application/json")
	public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
		return service.updateEvent(event);
	}
	
	// Création d'un événemnet.
	@PostMapping(produces="application/json", consumes="application/json")
	public Event createEvent(@RequestBody Event event) {
		System.out.println("Je suis dans création d'événement");
		return service.createEvent(event);
	}
}
