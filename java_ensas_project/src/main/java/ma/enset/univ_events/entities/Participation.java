package ma.enset.univ_events.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "participations",
       uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "event_id"}))
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Participation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id")
    private Event event;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        REGISTERED,
        CANCELED
    }
}
