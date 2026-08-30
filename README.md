# Library Management REST API

A RESTful API for managing a library's book inventory, built with Java and Spring Boot. Supports full CRUD operations, request validation, centralized exception handling, and comes pre-seeded with sample data for quick testing.

## Features

- Create, read, update, and delete book records
- Field-level validation on required attributes (title, author)
- Centralized exception handling with meaningful HTTP status codes
- Auto-seeded sample data (25 books) on application startup
- In-memory H2 database with a browser-based console for inspecting data
- Layered architecture separating HTTP handling, business logic, and data access

## Tech Stack

| Category         | Technology              |
|-------------------|--------------------------|
| Language           | Java 17                 |
| Framework          | Spring Boot 3           |
| Data Access        | Spring Data JPA / Hibernate |
| Database           | H2 (in-memory)          |
| Build Tool         | Maven                   |
| Validation         | Jakarta Bean Validation |
| Boilerplate Reduction | Lombok               |
| API Testing        | Postman                 |

## Project Structure

```
src/main/java/com/example/library/
├── LibraryApplication.java        # Application entry point
├── DataSeeder.java                # Seeds sample data on startup
├── model/
│   └── Book.java                  # JPA entity representing a book
├── repository/
│   └── BookRepository.java        # Spring Data JPA repository interface
├── service/
│   └── BookService.java           # Business logic layer
├── controller/
│   └── BookController.java        # REST endpoints
└── exception/
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java # Centralized exception handling
```

This follows a standard layered architecture:

**Controller** → receives HTTP requests and returns responses
**Service** → contains business logic, coordinates between controller and repository
**Repository** → handles data persistence via Spring Data JPA
**Model** → defines the data structure and validation rules
**Exception** → intercepts errors and converts them into clean, consistent API responses

## Getting Started

### Prerequisites

- Java 17 or later
- Maven (or use the included Maven Wrapper — no separate install needed)

### Running the application

Clone the repository and navigate into the project folder, then run:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application starts on `http://localhost:8080`. On startup, 25 sample books are automatically inserted into the database.

### Accessing the H2 Console

While the app is running, open `http://localhost:8080/h2-console` in a browser.

- JDBC URL: `jdbc:h2:mem:librarydb`
- Username: `sa`
- Password: *(leave blank)*

## API Endpoints

| Method | Endpoint             | Description                  |
|--------|-----------------------|-------------------------------|
| POST   | `/api/books`           | Add a new book                |
| GET    | `/api/books`           | Retrieve all books            |
| GET    | `/api/books/{id}`      | Retrieve a book by ID         |
| PUT    | `/api/books/{id}`      | Update an existing book       |
| DELETE | `/api/books/{id}`      | Delete a book                 |

### Example: Add a book

**Request**
```http
POST /api/books
Content-Type: application/json

{
  "title": "Atomic Habits",
  "author": "James Clear",
  "isbn": "9780735211292"
}
```

**Response — `201 Created`**
```json
{
  "id": 1,
  "title": "Atomic Habits",
  "author": "James Clear",
  "isbn": "9780735211292",
  "available": true
}
```

### Example: Book not found

**Request**
```http
GET /api/books/999
```

**Response — `404 Not Found`**
```
Book not found: 999
```

### Example: Validation failure

**Request**
```http
POST /api/books
Content-Type: application/json

{
  "author": "Someone"
}
```

**Response — `400 Bad Request`**

Returned when a required field (`title`) is missing, enforced by Jakarta Bean Validation (`@NotBlank`) on the `Book` entity.

## Design Notes

- **Constructor injection** is used throughout (e.g., `BookService`, `BookController`) rather than field injection, making dependencies explicit and the classes easier to unit test.
- **`ResourceNotFoundException`** is an unchecked exception, allowing it to propagate cleanly up to a single `@RestControllerAdvice` handler instead of requiring try/catch blocks in every controller method.
- **H2** was chosen for zero-setup, in-memory persistence suited to development and demonstration; the JPA/Hibernate layer means swapping in PostgreSQL or MySQL for production would only require a configuration change, not a code change.

## Possible Improvements

- Introduce DTOs to decouple the API contract from the JPA entity
- Add pagination and sorting to `GET /api/books`
- Add unit and integration tests (JUnit, Mockito, `@SpringBootTest`)
- Replace H2 with a persistent database for non-development environments

## License

This project was built for educational purposes.
