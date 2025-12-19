package ma.enset.univ_events.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.enset.univ_events.services.interfaces.UserService;
import ma.enset.univ_events.repositories.UserRepository;
import ma.enset.univ_events.entities.User;
import ma.enset.univ_events.dtos.UserDTO;
import ma.enset.univ_events.mappers.UserMapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


    // Implementation of UserService interface its role is to handle user-related operations
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override 
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override 
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        return UserMapper.toDTO(user);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}