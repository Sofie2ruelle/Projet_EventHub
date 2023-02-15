package fr.dawan.eventhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.dawan.eventhub.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
}
