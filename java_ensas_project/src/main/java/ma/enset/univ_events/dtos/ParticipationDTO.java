package ma.enset.univ_events.dtos;

import lombok.Data;

@Data // Lombok annotation to generate getters, setters, and other methods
public class ParticipationDTO { // data transfer object for Participation entity
    private Long id;
    private Long eventId;
    private Long userId;
}

