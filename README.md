# Health Tourism Spring Boot Project

This Java Spring Boot project is about health tourism which customers go to cities or countries for doctor examinations in hospitals. According to that, they reserve airplane flight seats and hotel rooms to manage their travel plans.

## Programs and Tools

Spring Boot: The project is built using the Spring Boot framework, which simplifies the development of Java applications.

Spring Security: For user authentication and authorization.

Spring Data JPA: For data access and database management

Hibernate: Object-Relational Mapping (ORM) tool for working with the database.

PostgreSQL: The relational database management system

Maven: Project build tool and dependency manager

MapStruct: Java Bean mapper to convert Java bean types 

IDE: IntelliJ IDEA

## Entity Classes

### Base Entities
- BaseEntity: All entities extends it, contains ID, UUID etc
- CompanyEntity: Contains company's building and bank account informations
- PersonEntity: Contains person identification informations such as goverment ID 

### Entities
Sub-entities of CompanyEntity:
- AirportEntity
- HospitalEntity
- HotelEntity

Sub-entities of PersonEntity:
- CustomerEntity
- DoctorEntity

For reservations and appointments:
- RoomReservationEntity
- SeatReservationEntity
- ExaminationEntity

Security Entities:
- RoleEntity
- UserEntity

Others:
- AddressEntity
- BankAccountEntity
- ExaminationCardEntity
- FlightEntity
- HotelRoomEntity
- MedicalDepartmentEntity
- PlaneEntity
- PlaneSeatEntity
- SalaryEntity

## Generic Classes

- BaseController: Creates endpoints for CRUD operations, extendable and overrideable for customized endpoints
- BaseService: Serve methods for CRUD operations, extendable and overrideable for customized methods
- BaseMapper: Main mapper for almost every entity and DTO conversions, only MapStruct used for UserEntity and related DTO classes. BaseMapper is also extendable and overrideable for customized mapping methods

## Installation
* Clone the repository

* Import the project into your IDE

* Configure your database connection in the IDE and .properties files according to the environment as you wish

* Build and run the project

## Usage
- Access the application through your web browser http://localhost:8082, also:
  - For development environment: http://localhost:8080
  - For test environment: http://localhost:8081

- Register for an account or log in if you already have one.

- Explore available medical services, book appointments, and reserve hospital rooms.

- Manage your travel plans and payments.

- Administrators can access the admin dashboard by logging in with administrative credentials to manage users, services, appointments, and reservations.