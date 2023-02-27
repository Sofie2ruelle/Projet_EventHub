package fr.dawan.eventhub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.eventhub.entities.Event;
import fr.dawan.eventhub.repositories.EventRepository;
import fr.dawan.eventhub.service.EventService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public Event findById(Long id) {
		return eventRepository.findById(id).get();
	}
	
	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

	@Override
	public Event createEvent(Event Event) {
		return eventRepository.save(Event);
	}

	@Override
	public Event updateEvent(Event Event) {
		return eventRepository.save(Event);
	}
	
	@Override 
	public List<Event> findAllEventsByIdUser(Long id){
		return eventRepository.findAllEventByIdUser(id);
	}

}
