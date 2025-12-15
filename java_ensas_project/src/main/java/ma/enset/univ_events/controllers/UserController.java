package ma.enset.univ_events.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import ma.enset.univ_events.services.interfaces.UserService;
import ma.enset.univ_events.dtos.UserDTO;

import java.util.List;

 // Indicates that this class is a REST controller
@RestController
// Base URL for user-related endpoints
@RequestMapping("/api/users")
 // Automatically generates a constructor with required arguments (final fields)  
@RequiredArgsConstructor  
// Controller class to handle HTTP requests related to users
public class UserController { 
    private final UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id); 
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    
}
