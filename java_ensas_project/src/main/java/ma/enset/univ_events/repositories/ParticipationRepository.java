package ma.enset.univ_events.repositories;

import ma.enset.univ_events.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.enset.univ_events.entities.Participation;
import ma.enset.univ_events.entities.Event;

import java.util.List;
import java.util.Optional;

// with this interface , we can perform CRUD operations on Participation entity
public interface ParticipationRepository extends JpaRepository<Participation ,Long> {
    List<Participation> findByUser(User user); // find participations by user
    List<Participation> findByEvent(Event event); // find participations by event
    Optional<Participation> findByUserAndEvent(User user, Event event); // find participation by user and event
}