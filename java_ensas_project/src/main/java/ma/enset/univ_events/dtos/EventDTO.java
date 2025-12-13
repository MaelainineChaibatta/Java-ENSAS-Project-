package ma.enset.univ_events.dtos;

import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String date;
    private String location;
    
}
