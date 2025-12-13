# University Events Project - Progress

## Current Status: ✅ Completed & Pushed to GitHub

### Architecture Overview

The project follows a clean layered architecture:

```
┌─────────────────────────────────────┐
│  CLIENT (Frontend/Requests)         │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  CONTROLLER (Request Handler)       │
│  - Receives HTTP requests           │
│  - Routes to services               │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  SERVICE (Business Logic) ⭐        │
│  - Implements use cases             │
│  - Calls repositories               │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  REPOSITORY (Data Access)           │
│  - Queries database                 │
│  - Persists entities                │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  DATABASE (JPA/Hibernate)           │
│  - Stores all data                  │
└─────────────────────────────────────┘
```

---

## 📍 NEXT STEP TO IMPLEMENT

### Missing: `UserServiceImpl.java`

**Location:** `src/main/java/ma/enset/univ_events/services/impl/UserServiceImpl.java`

**Status:** ❌ NOT YET CREATED

Create this file with the following code:

```java
package ma.enset.univ_events.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import ma.enset.univ_events.entities.User;
import ma.enset.univ_events.repositories.UserRepository;
import ma.enset.univ_events.services.interfaces.UserService;
import ma.enset.univ_events.dtos.UserDTO;
import ma.enset.univ_events.mappers.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
```

---

## ✅ Issues Fixed in This Session

| Issue | File | Fix |
|-------|------|-----|
| Wrong package declaration | `User.java` | Removed `java.` prefix → `package ma.enset.univ_events.entities;` |
| ID auto-assignment | `UserMapper.java` | Removed `user.setId(dto.getId())` in `toEntity()` method |
| Type mismatch | `UserMapper.java` | Added `.toString()` and `valueOf()` for enum conversion |

---

## 📚 Project Structure

```
java_ensas_project/
├── src/main/java/ma/enset/univ_events/
│   ├── entities/
│   │   ├── User.java ✅
│   │   ├── Event.java
│   │   └── Participation.java
│   ├── dtos/
│   │   ├── UserDTO.java
│   │   └── EventDTO.java
│   ├── mappers/
│   │   └── UserMapper.java ✅
│   ├── repositories/
│   │   ├── UserRepository.java
│   │   ├── EventRepository.java
│   │   └── ParticipationRepository.java
│   ├── services/
│   │   ├── interfaces/
│   │   │   └── UserService.java
│   │   └── impl/
│   │       └── UserServiceImpl.java ❌ TO DO
│   └── controllers/
│       └── (controllers go here)
├── pom.xml
└── application.properties
```

---

## 🛠️ Tech Stack

- **Framework:** Spring Boot
- **Language:** Java 17+
- **Database:** JPA/Hibernate
- **Build Tool:** Maven
- **Validation:** Jakarta Validation
- **Annotations:** Lombok

---

## 🚀 Quick Start

```bash
# Clone & build
git clone https://github.com/MaelainineChaibatta/Java-ENSAS-Project-.git
cd java_ensas_project
mvn clean install

# Run
mvn spring-boot:run
```

---

**Last Updated:** December 13, 2025  
**Repository:** [GitHub](https://github.com/MaelainineChaibatta/Java-ENSAS-Project-)
