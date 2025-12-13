package ma.enset.univ_events.repositories;

import ma.enset.univ_events.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDateTime;

// with this interface , we can perform CRUD operations on Event entity
public interface EventRepository extends JpaRepository<Event ,Long>{
    List<Event> findByDateTimeBetween(LocalDateTime start ,LocalDateTime end); // find events between two dates
    List<Event> findByTitleContainingIgnoreCase(String title); // find events by title ignoring case
    
}