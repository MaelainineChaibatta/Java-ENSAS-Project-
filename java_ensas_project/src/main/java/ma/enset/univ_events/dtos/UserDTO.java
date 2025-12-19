package ma.enset.univ_events.dtos;

import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString, etc.
public class UserDTO  {
    private String username;
    private String email;
    private String password;
    private String role;
}
