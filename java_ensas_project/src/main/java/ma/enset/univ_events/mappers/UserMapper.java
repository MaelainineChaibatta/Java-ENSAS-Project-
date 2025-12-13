package ma.enset.univ_events.mappers;

import ma.enset.univ_events.dtos.UserDTO;
import ma.enset.univ_events.entities.User;

// Mapper class to convert between User entity and UserDTO its role is to separate the entity layer from the DTO layer 
public class UserMapper {
    // convert User entity to UserDTO
    public static UserDTO toDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole().toString());
        return dto;
    }
    // convert UserDTO to User entity
    public static User toEntity(UserDTO dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setRole(User.Role.valueOf(dto.getRole()));
        return user;
    }
    
}
