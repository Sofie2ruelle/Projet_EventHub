package fr.dawan.eventhub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.dawan.eventhub.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	@Query("FROM Event e WHERE e.user.id=:id")
	List<Event> findAllEventByIdUser(@Param("id") Long id);
}
