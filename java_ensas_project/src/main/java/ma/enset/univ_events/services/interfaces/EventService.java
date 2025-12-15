
package ma.enset.univ_events.services.interfaces;

import ma.enset.univ_events.dtos.EventDTO;
import java.util.List;

// interface defining the contract for event-related operations
public interface EventService {

    EventDTO createEvent(EventDTO eventDTO);
    List<EventDTO> getAllEvents();
    EventDTO getEventById(Long id);
    EventDTO updateEvent(Long id ,EventDTO eventDTO);
    void deleteEvent(Long id);
}