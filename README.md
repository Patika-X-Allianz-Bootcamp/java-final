# Health Tourism Application

---

## Overview

---

The Health Tourism Application is a Spring Boot-based platform designed to facilitate health tourism by allowing patients to travel to different countries or regions to access healthcare services. This README provides an overview of the project, its components, and instructions for setting up and running the application.

---

### Tech Stack
 
---

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Restful API
- OpenAPI documentation
- PostgreSQL Database
- Libraries as Mapstruct,Lombok etc.


---

## Features

- **Patient Management**: Allows patients to register, view appointments, and select healthcare services.
- **Doctor Management**: Provides doctors with the ability to manage patient appointments and examinations.
- **Appointment Scheduling**: Enables patients to schedule appointments with doctors.
- **Travel Planning**: Allows patients to create travel plans based on their appointments, including flights and hotels.
- **Authentication**: Implements JWT-based authentication for users, including patients, doctors, and administrators.

---

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 17 or higher.
- Apache Maven installed.
- PostgreSQL or another compatible relational database.

### Installation

To set up the Health Tourism Application, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/health-tourism-app.git
   cd health-tourism-app
   mvn clean install
2. Swagger UI will be run on this url
   ```
   http://localhost:${PORT}/swagger-ui.html
   ```