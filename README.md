# Blog Application (Rumos)

The Blog Application (Rumos) is a robust backend application designed to facilitate an interactive blogging experience. This project leverages Java, Spring Boot, and PostgreSQL to create a dynamic and secure environment for users to create, manage, and interact with blog content. The project is configured as a Maven project, utilizing Docker for containerization and pgAdmin for database management.

The application has 3 types of users: Admin, Moderator and Common User. For authentication and security, the applications uses JWT Token and Spring Security. 

The application, upon starting, has a script to create 1 Admin and 1 user and those credentials can be found in this README file.
To map the objects, the project uses Modelmapper library (for the DTOs).

The project is designed based on a set of business rules that govern the behavior and interactions within the application. These rules are detailed in the  [Enunciado Projeto_versao_react.pdf](https://github.com/miguelabreu94/blog/files/14890934/Enunciado.Projeto_versao_react.pdf)

---

# Requirements

- Java 17+
- Maven
- Docker
- pgAdmin (optional for database management)

# Technology Stack
- Backend: Java, Spring Boot
- Database: PostgreSQL
- Containerization: Docker
- Database Management: pgAdmin
- Security / Authentication: Spring Security, JWT Token
- Object Mapping: ModelMapper

### How to Run the Application

1. Clone the Repository

```bash
git clone https://github.com/miguelabreu94/blog.git
```

2. Open a terminal in the root directory of the project.

```bash
cd blog
```

3. Build the project
```bash
mvn clean install
```

4. Run the following command to start the: 
- PostgreSQL database
- pgAdmin application
- Backend application

```bash
docker-compose up -d
```

---

# Swagger

The application's API can be explored and tested using Swagger, accessible at http://localhost:8080/swagger-ui/index.html

---

## User Application Credentials

| Role  | Username        | Password  |
|-------|-----------------|-----------|
| Admin | admin           | password  |
| User  | user            | password  |

---

# pgAdmin

## Database management tool.

- URL: http://localhost:5432

- Username: postgres

- Password: 12345

