package ma.enset.univ_events.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ma.enset.univ_events.services.interfaces.EventService;
import ma.enset.univ_events.repositories.EventRepository;
import ma.enset.univ_events.entities.Event;
import ma.enset.univ_events.dtos.EventDTO;
import ma.enset.univ_events.mappers.EventMapper;

import java.util.List;
import java.util.stream.Collectors;





@Service // Indicates that this class is a service component in Spring
@RequiredArgsConstructor // Automatically generates a constructor with required arguments (final fields)
public class EventServiceImpl implements EventService { // Implementation of EventService interface to handle event-related operations

    private final EventRepository eventRepository;

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        return EventMapper.toDTO(eventRepository.save(event));
    }

    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(EventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Event not found"));
        return EventMapper.toDTO(event);
    }

    @Override
    public EventDTO updateEvent(Long id , EventDTO dto) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        existingEvent.setTitle(dto.getTitle());
        existingEvent.setDescription(dto.getDescription());
        existingEvent.setDateTime(java.time.LocalDateTime.parse(dto.getDate()));
        existingEvent.setLocation(dto.getLocation());

        Event updatedEvent = eventRepository.save(existingEvent);
        return EventMapper.toDTO(updatedEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }



    
}
