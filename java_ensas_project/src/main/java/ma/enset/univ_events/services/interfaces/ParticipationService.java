package ma.enset.univ_events.services.interfaces;

import ma.enset.univ_events.dtos.ParticipationDTO;

// Service interface for managing participations
public interface ParticipationService {
    ParticipationDTO participate(Long userId ,Long eventId);
}













