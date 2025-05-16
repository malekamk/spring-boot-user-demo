# Spring Boot User Management API

This project is a Spring Boot-based user management system that demonstrates the core principles of layered architecture using service and repository layers. It provides basic user operations such as adding, retrieving, and deleting users with an in-memory mock repository for simplicity and testability.

## Overview

The API supports the following core functionalities:

-   **Add User:** Create and store a new user if the user ID does not already exist.
-   **Get User by ID:** Retrieve user information based on the user’s unique identifier.
-   **Delete User by ID:** Remove a user record by its unique identifier.
-   **List All Users:** Fetch a collection of all registered users.

The architecture cleanly separates business logic from data persistence concerns. The service layer handles the logic while the repository interface abstracts the data source.
## Project Structure
This project follows a clean layered architecture:

- Model: Contains domain objects such as the User class representing user data.

- Repository: Abstracts data access with interfaces, enabling easy swapping of implementations.

- Service: Contains business logic, validating and processing data before interacting with the repository.

- Controller: (Optional extension) Handles HTTP requests to expose REST endpoints.

- Tests: Unit tests focus on the service layer with mocking of dependencies to isolate functionality.
## Technologies and Tools

-   **Java 17+** – Language version for development.
-   **Spring Boot** – Framework for building the RESTful service.
-   **Mockito** – Used for mocking dependencies in unit tests.
-   **JUnit 5** – Testing framework for unit and integration tests.
-   **Gradle** – Build automation tool managing dependencies and running tests.

## Getting Started

### Prerequisites

-   JDK 17 or above installed on your machine.
-   Gradle installed or use the Gradle Wrapper included (`./gradlew` or `gradlew.bat`).
-   An IDE of your choice (IntelliJ IDEA, Eclipse, VS Code) recommended for development.


## Coding Standards and Best Practices
#### The project is developed following professional coding standards, including:

- Clean Code Principles: Code is modular, readable, and maintainable.

- Dependency Injection: Spring's @Autowired is used for loose coupling.

- Use of Interfaces: Service and repository layers are defined as interfaces for flexibility.

- Unit Testing: Comprehensive unit tests using JUnit 5 and Mockito to ensure reliability.

- Exception Handling: Service methods handle invalid states gracefully.

- Logging: Key operations provide informative logs to facilitate debugging (can be enhanced by integrating a logging framework).

- Documentation: Classes and methods are documented with Javadocs (can be extended for better API documentation).


### Building the Project

Clone the repository:

```bash
git clone [https://github.com/your-username/spring-boot-user-demo.git](https://github.com/your-username/spring-boot-user-demo.git)
cd spring-boot-user-demo
Build the project and download dependencies:./gradlew build
Running TestsRun unit tests with:./gradlew test
Test reports will be generated at:build/reports/tests/test/index.html


