package ma.enset.univ_events.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ma.enset.univ_events.entities.Participation;
import ma.enset.univ_events.entities.User;
import ma.enset.univ_events.entities.Event;
import ma.enset.univ_events.repositories.ParticipationRepository;
import ma.enset.univ_events.repositories.UserRepository;
import ma.enset.univ_events.repositories.EventRepository;
import ma.enset.univ_events.services.interfaces.ParticipationService;
import ma.enset.univ_events.dtos.ParticipationDTO;
import ma.enset.univ_events.mappers.ParticipationMapper;

@Service
@RequiredArgsConstructor
public class ParticipationServiceImpl implements ParticipationService {
    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public ParticipationDTO participate(Long userId, Long eventId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with"));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with"));

        if (participationRepository.existsByUser_IdAndEvent_Id(userId, eventId)) {
            throw new RuntimeException("User already participated in this event");
        }

        Participation participation = Participation.builder()
                .user(user)
                .event(event)
                .build();
        return ParticipationMapper.toDTO(
                participationRepository.save(participation));
    }
}
