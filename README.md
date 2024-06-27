# Blog Application (Rumos)

The Blog project is a backend application with the porpuse of making an interactive blog. The project is using Java, Spring Boot and SQL (Postgres as Database).

This Maven project uses PostgreSQL as Database and can be managed through docker and pgAdmin.

The application has 3 types of users: Admin, Moderator and Common User. For authentication and security, the applications uses JWT Token and Spring Security. 

The application, upon starting, has a script to create 1 Admin and 1 user and those credentials can be found in this README file.
To map the objects, the project uses Modelmapper library (for the DTOs).

The project was based on several business model rules that can be found here:  [Enunciado Projeto_versao_react.pdf](https://github.com/miguelabreu94/blog/files/14890934/Enunciado.Projeto_versao_react.pdf)

---

# Requirements

- Java 21
- Maven

### How to Run the Application

1. Open a terminal in the root directory of the project.

2. Run the following command to start the: 
- PostgreSQL database
- pgAdmin application
- Backend application

```bash
docker-compose up
```

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

