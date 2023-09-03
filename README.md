# Health Tourism Application

This Spring Boot-based health tourism application is designed to help patients organize their healthcare services and make travel plans for receiving medical treatment. The application is developed in the Java programming language and utilizes various Spring Boot dependencies.
The application will start, and you can access it in your web browser at http://localhost:8082.


## Dependencies

The project uses the following key dependencies:
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token) Authentication

## Project Setup

1. Clone or download the project from the GitHub repository.

2. Open the project using your preferred Integrated Development Environment (IDE), such as IntelliJ IDEA or Eclipse.

## Database Configuration

The project employs an embedded H2 database for simplicity. Database configuration can be customized in the `application.properties` file found in the `src/main/resources` directory.

## Running the Application

You can run the application using your IDE or by executing the following command in the project's root directory:

```bash
./mvnw spring-boot:run
API Documentation
The API documentation can be accessed at http://localhost:8080/swagger-ui.html. This documentation provides comprehensive details about available endpoints and how to use them.

Security
The project includes role-based access control and JWT authentication for security. You can further customize the security configuration in the SecurityConfiguration class located in the com.healthtourism.healthtourism.config package.

Additional Features
This project serves as a foundation for implementing various features, including:

Patient-doctor assignments
Patient appointment and healthcare service management
Doctor-patient examination record creation
Travel planning based on hospital and doctor appointments
Feel free to explore and enhance the project to meet specific requirements.

Please note that this README provides a simplified overview. For production-ready applications, consider including deployment instructions, production database setup, and other relevant details.

You can use this Markdown code as a README for your project. Make sure to add any 
