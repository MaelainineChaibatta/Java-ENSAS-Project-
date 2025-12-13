package ma.enset.univ_events.repositories;

import ma.enset.univ_events.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// with this interface , we can perform CRUD operations on User entity
public interface UserRepository extends JpaRepository<User ,Long> {
    Optional<User> findByUsername(String username); // generate query to find user by username
    boolean existsByUsername(String username); // check if a user with the given username exists
    boolean existsByEmail(String email); // check if a user with the given email exists
}
