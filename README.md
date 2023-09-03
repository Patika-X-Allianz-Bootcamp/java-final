# Health Tourism Agency Project

Welcome to the Health Tourism Agency project README. This Spring Boot application is designed to facilitate health tourism-related activities, with three distinct roles: Admin, User (Patient), and Doctor. This README provides an overview of the project and its functionalities.

## Table of Contents
- [Roles](#roles)
- [User (Patient)](#user-patient)
  - [Profile Creation](#profile-creation)
  - [Doctor Search](#doctor-search)
  - [Appointment Management](#appointment-management)
  - [Travel Planning](#travel-planning)
- [Doctor](#doctor)
  - [Account Creation](#account-creation)
  - [Appointment View](#appointment-view)
  - [Medical Reports](#medical-reports)

## Roles

### Admin
- Access to all endpoints
- Capable of performing CRUD operations on various data entities

### User (Patient)
- Can create a personal profile
- Search for doctors by name or hospital department
- View available doctor appointments
- Schedule appointments with doctors
- Create travel plans for medical visits
- Search for flights and add them to the travel plan
- Search for hotels and add hotels to the travel plan

### Doctor
- Can create and manage their accounts
- View their appointments
- Create medical reports
- Add medications and test results to medical reports
- Associate medical reports with patients
- Change appointment statuses (cancellation, completion)

## User (Patient)

### Doctor Search
Users can search for doctors based on their names or hospital departments. The system will return a list of doctors and their available appointments, showing occupied time slots.

### Appointment Management
Users can create new appointments with doctors of their choice, taking in consideration the occupied time slots.

### Travel Planning
- Users can create travel plans for medical visits.
- They can create a travel plan by choosing between one-way and two-way trips.
- A timer starts for one-way trips after adding the flight and for two-way trips after adding the second flight.
- If the travel plan is not completed within ten minutes, the process restarts.
- Completion involves adding a hotel to the travel plan.
- When adding the flight to the travel plan a random seat will be appointed for the user. If there are no available seats the flight will not be added.
- When adding the hotel to the travel plan a available room will be selected based on the hotel reservation dates provided by the user. Similarly if there are no available rooms the hotel will not be added.

## Doctor

### Appointment View
Doctors can view their appointments, including appointment details, patient information, and status.

### Medical Reports
- Doctors can create medical reports for patients.
- They can add medications and test results to these reports.
- Medical reports can be associated with specific patients.
- Doctors have the ability to change appointment statuses as needed (cancellation, completion).
