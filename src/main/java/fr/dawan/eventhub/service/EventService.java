package fr.dawan.eventhub.service;

import java.util.List;

import fr.dawan.eventhub.entities.Event;

public interface EventService {
	
	Event findById(Long id);
	List<Event> findAll();
	void deleteEvent(Long id);
	Event createEvent(Event event);
	Event updateEvent(Event event);
}
