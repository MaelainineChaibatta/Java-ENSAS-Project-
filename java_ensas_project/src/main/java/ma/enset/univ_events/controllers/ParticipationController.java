package ma.enset.univ_events.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ma.enset.univ_events.services.interfaces.ParticipationService;
import ma.enset.univ_events.dtos.ParticipationDTO;


@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/participations") // Base URL for participation-related endpoints
@RequiredArgsConstructor // Lombok annotation to generate a constructor with required arguments
public class ParticipationController { // Controller class to handle participation-related HTTP requests
    private final ParticipationService participationService;

    @PostMapping
    public ParticipationDTO participate(@RequestParam Long userId ,
                                        @RequestParam Long eventId) {
        return participationService.participate(userId, eventId);
    }





}
