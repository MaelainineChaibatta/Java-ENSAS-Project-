package ma.enset.univ_events.mappers;

import ma.enset.univ_events.dtos.EventDTO;
import ma.enset.univ_events.entities.Event;

import java.time.LocalDateTime;

// Mapper class to convert between Event entity and EventDTO
public class EventMapper {

    public static EventDTO toDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setTitle(event.getTitle());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setDate(event.getDateTime().toString());
        eventDTO.setLocation(event.getLocation());
        return eventDTO;
    }

    public static Event toEntity(EventDTO dto) {
        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setDateTime(LocalDateTime.parse(dto.getDate()));
        event.setLocation(dto.getLocation());
        return event;
    }


    
}
