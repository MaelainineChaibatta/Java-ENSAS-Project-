package ma.enset.univ_events.services.interfaces;

import ma.enset.univ_events.dtos.UserDTO;
import java.util.List;

// Service interface for User entity its role is to define the operations that can be performed on User
public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    void deleteUser(Long id);
    
}
