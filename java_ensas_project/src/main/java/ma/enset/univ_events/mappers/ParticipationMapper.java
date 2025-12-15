package ma.enset.univ_events.mappers;

import ma.enset.univ_events.dtos.ParticipationDTO;
import ma.enset.univ_events.entities.Participation;

// Mapper class to convert between Participation entity and ParticipationDTO
public class ParticipationMapper {
    public static ParticipationDTO toDTO(Participation p) {
        ParticipationDTO dto = new ParticipationDTO();
        dto.setId(p.getId());
        dto.setUserId(p.getUser().getId());
        dto.setEventId(p.getEvent().getId());
        return dto;
    }
}
