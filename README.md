# Employee Management System

## Introduction

The Employee Management System is a Spring Boot application that allows users to manage employees. It includes functionalities to create, read, update, and delete employees. The project also integrates Swagger (OpenAPI) for interactive API documentation.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Project Setup](#project-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
- [Endpoints](#endpoints)

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building Java applications.
- **Spring Data JPA**: For database access and ORM.
- **Thymeleaf**: Template engine for rendering web pages.
- **Swagger (OpenAPI)**: For API documentation.
- **Maven**: Build automation tool.
- **MySQL**: Database.
- **HTML**: Markup language for creating web pages.
- **CSS**: Style sheet language for designing web pages.

## Prerequisites

- Java 8 or higher
- Maven 3.6.0 or higher
- Git (optional)

## Project Setup

1. **Clone the Repository** (if applicable):

    ```sh
    git clone https://github.com/your-repo/employee_management_project.git
    cd employee_management_project
    ```

2. **Import the Project into Your IDE**:

    - Open your IDE (e.g., IntelliJ IDEA, Eclipse).
    - Import the project as a Maven project.

3. **Build the Project**:

    ```sh
    mvn clean install
    ```

## Configuration

1. **Application Properties**:

   Open `src/main/resources/application.properties` and configure the database settings as per your environment:

    ```properties
    # Database Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/employee_management
    spring.datasource.username=root
    spring.datasource.password=tharu2002
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update

    # Server Configuration
    server.port=8080
    ```

   Ensure you have a MySQL database running with the name `employee_management` and update the username and password accordingly.

## Running the Application

1. **Run the Application**:

   You can run the application using your IDE or via the command line:

    ```sh
    mvn spring-boot:run
    ```

   The application will start on the port configured in `application.properties` (default is 8080).

2. **Access the Application**:

   Open your web browser and navigate to `http://localhost:8080`.

## API Documentation

This project uses Swagger (OpenAPI) for API documentation.

1. **Access Swagger UI**:

   After starting the application, you can access the Swagger UI at:

    ```sh
    http://localhost:8080/swagger-ui.html
    ```

   This provides an interactive interface to test the API endpoints.

## Endpoints

**Home**
- GET /: View home page with the list of employees.
- URL: http://localhost:8080/
- Response: Renders index.html with a list of employees.

**Employee Management**
- GET /new: Show form to create a new employee.
    - URL: http://localhost:8080/new
    - Response: Renders add-user.html.
- POST /save: Save a new or updated employee.
    - URL: http://localhost:8080/save
    - Request Body: Form data with employee details.
    - Response: Redirects to the home page.
- GET /edit/{id}: Show form to update an existing employee.
    - URL: http://localhost:8080/edit{id}
    - Path Variable: id - Employee ID.
    - Response: Renders edit-user.html with employee details.
- GET /delete/{id}: Delete an employee by ID.
    - URL: http://localhost:8080/delete/{id}
    - Path Variable: id - Employee ID.
    - Response: Redirects to the home page.
- GET /view/{id}: View details of a specific employee.
    - URL: http://localhost:8080/view/{id}
    - Path Variable: id - Employee ID.
    - Response: Renders view-user.html with employee details.

