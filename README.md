# University Events Project - Notices and structure

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



## Notice : 
public static EventDTO toDTO(Event event)

**What it does:** Converts database object to user-friendly object

**When to use:** When reading data FROM database TO send to user

**Flow:**

Database (Event) → Mapper → User (EventDTO)


## next step test using swagger!