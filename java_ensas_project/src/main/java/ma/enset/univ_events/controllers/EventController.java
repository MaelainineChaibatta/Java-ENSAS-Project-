package ma.enset.univ_events.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ma.enset.univ_events.services.interfaces.EventService;
import ma.enset.univ_events.dtos.EventDTO;

import java.util.List;



@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/events") // Base URL for event-related endpoints
@RequiredArgsConstructor // Automatically generates a constructor with required arguments (final fields)
public class EventController {
    private final EventService eventService;

    @PostMapping
    public EventDTO createEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createEvent(eventDTO);
    }

    @GetMapping
    public List<EventDTO> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public EventDTO getEvent(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PutMapping("/{id}")
    public EventDTO updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        return eventService.updateEvent(id, eventDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

}
