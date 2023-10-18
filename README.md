# <h1 align="center">Doctor App - Patient Appointment Booking System</h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
  </a>
  <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
  </a>
   <img alt = "GPL v3" src="https://img.shields.io/badge/License-GPLv3-blue.svg" />
</p>

<p align="left">

# Patient Appointment Booking System

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Data Flow Diagram](#data-flow-diagram)
  - [Installation](#installation)
  - [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication](#authentication)
  - [Token-based Authentication](#token-based-authentication)
  - [User Roles and Permissions](#user-roles-and-permissions)
- [Flow Explanation](#flow-explanation)
- [Sample Requests and Responses](#sample-requests-and-responses)
    - [Admin Controller](#admin-controller)
    - [Patient Controller](#patient-controller)
    - [Doctor Controller](#doctor-controller)
- [Testing](#testing)
- [Contributing](#contributing)
- [Swagger Configuration](#swagger-configuration)
- [Contact Information](#ontact-information)


## Introduction

The Patient Appointment Booking System is a Java Spring Boot application designed to facilitate the process of scheduling medical appointments for patients. This system provides healthcare facilities with a user-friendly interface to manage appointments, and patients can easily book appointments with healthcare providers.

## Features

- **User Roles**: The system supports multiple user roles such as patients and healthcare providers.

- **Appointment Management**: Patients can view available appointments, schedule new appointments, and cancel appointments.

- **Provider Availability**: Healthcare providers can set their availability, and patients can book appointments during those times.

- **Notifications**: Patients receive confirmation and reminder notifications for their appointments.

- **Token-based Authentication**: Secure user authentication and authorization using JSON Web Tokens (JWT).

- **API Integration**: Provides RESTful APIs for seamless integration with other systems.

## Prerequisites

Before getting started, ensure you have the following installed on your system:

- Java Development Kit (JDK) 8 or higher
- Spring Boot
- MySQL Database
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Data Flow Diagram



                             ┌─────────────────────────┐
                             │         APIs            │
                             └───────────┬─────────────┘
                                         │
                                         ▼
                             ┌─────────────────────────┐
                             │       Controllers       │
                             └───────────┬─────────────┘
                                         │                                  ▼
                             ┌─────────────────────────┐
                             │     Authentication      │
                             └───────────┬─────────────┘
                                         |
                                         ▼
                             ┌─────────────────────────┐
                             │       Services          │
                             └───────────┬─────────────┘
                                         │
                                         ▼
                             ┌─────────────────────────┐
                             │       Repositories      │
                             └───────────┬─────────────┘
                                         │
                                         ▼
                             ┌─────────────────────────┐
                             │       Database          │
                             └─────────────────────────┘


## Getting Started

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your/repo.git
2. Open the project in your preferred IDE.

3. Configure your MySQL database settings in src/main/resources/application.properties.

4. Build and run the application.


## Configuration
Before running the application, make sure to configure the database and other settings in the application.properties file. Example:

```
spring.datasource.url=jdbc:mysql://localhost:3306/appointment_db
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## Usage

Once the application is up and running, you can access the user interface and API endpoints. Here's how to use the system:

- **Patient Registration**: Patients can sign up for an account.

- **Healthcare Provider Registration**: Healthcare providers can create accounts and specify their availability.

- **View Appointments**: Patients can view available appointments.

- **Book Appointments**: Patients can book appointments with available healthcare providers.

- **Cancel Appointments**: Patients can cancel appointments they've scheduled.

- **Provider Availability**: Healthcare providers can manage their availability.

## API Endpoints
#### Access the Application

The application will be available at  
```
http://localhost:8080
```


## Authentication
## Token-based Authentication
The system employs token-based authentication for user access. Here's how it works:

- **User Registration**:
  - Users (patients and providers) register their accounts.
  - Upon successful registration, a JWT token is issued.

- **User Login**:
  - Users log in with their credentials.
  - A new JWT token is generated and provided to the user.

- **Accessing Protected Resources**:
  - For every API request, the user must include the JWT token in the Authorization header.

- **Token Validation and Authorization**:
  - The server validates the token on each request.
  - The token is checked for expiration and integrity.
  - The user's role and permissions are verified.

- **Access Control**:
  - Users are only allowed to access resources and perform actions permitted by their role.

- **Token Renewal**:
  - Tokens may have a limited lifespan.
  - Users must refresh their tokens to continue accessing the system.


 ## User Roles and Permissions

The Patient Appointment Booking System employs a role-based access control system to manage user roles and permissions. Roles are assigned to users to determine what actions they can perform within the system. Here are the main user roles and their associated permissions:

#### Patient (ROLE_PATIENT)

- View Available Appointments: Patients can view the list of available appointments.
- Book Appointments: Patients can schedule new appointments with healthcare providers.
- Cancel Appointments: Patients can cancel appointments they've scheduled.

#### Doctor (ROLE_PROVIDER)

- Set Availability: Providers can specify their availability, indicating when they are open for appointments.
- View Appointment Requests: Providers can view appointment requests from patients.

#### Admin (ROLE_ADMIN)
Administrators have full access and control over the system and its users. They have the following permissions:

- Manage Users: Administrators can create, modify, and delete user accounts.

- Manage Appointments: Administrators have the authority to manage appointments, including creating, modifying, and canceling appointments.

- Manage Availability: Administrators can configure and adjust the availability of healthcare providers.

- System Configuration: Administrators can modify system-wide configurations and settings.

Please note that the system ensures that users can only access resources and perform actions that are permitted by their assigned roles. This role-based access control mechanism helps maintain data security and control in the system.
 

## Flow Explanation

To provide a more detailed explanation of the flow:

1. **User Registration**:
   - Users (patients and providers) register their accounts.
   - Upon successful registration, a JWT token is issued.

2. **User Login**:
   - Users log in with their credentials.
   - A new JWT token is generated and provided to the user.

3. **Accessing Protected Resources**:
   - For every API request, the user must include the JWT token in the Authorization header.

4. **Token Validation and Authorization**:
   - The server validates the token on each request.
   - The token is checked for expiration and integrity.
   - The user's role and permissions are verified.

5. **Access Control**:
   - Users are only allowed to access resources and perform actions permitted by their role.

6. **Token Renewal**:
   - Tokens may have a limited lifespan.
   - Users must refresh their tokens to continue accessing the system.



## Sample Requests and Responses
To better understand how to interact with the API, see the Sample Requests and Responses document for detailed examples.

### Admin Controller

This controller handles doctor-related operations in the Patient Appointment Booking System.

### Endpoints

### Get All Patients 
```
GET /patients
```

Allows users to retrieve a list of all patients in the system.

- Response:
  - Example Response:
    ```json
    [
      {
        "patientId": "789012",
        "name": "Alice Johnson",
        "bloodGroup": "A+",
        "email": "alice@example.com"
      },
      {
        "patientId": "456789",
        "name": "Bob Smith",
        "bloodGroup": "B-",
        "email": "bob@example.com"
      }
    ]
    ```

### Add Doctor 
```
POST /doctor
```

Enables users to add a new doctor to the system.

- Request:
  - **Body**: Doctor information.
  - Example Request Body:
    ```json
    {
      "name": "Dr. Sarah Brown",
      "qualification": "MBBS",
      "specialization": "Dermatology"
    }
    ```

- Response:
  - Example Response:
    ```json
    {
      "message": "Doctor added successfully.",
      "doctorId": "987654"
    }
    ```

### Get Patients by Blood Group 
```
GET /patients/bloodGroup/{bloodGroup}
```

Allows users to retrieve a list of patients with a specific blood group.

- Request:
  - **Path Parameter**: `bloodGroup` (e.g., "A+").
  
- Response:
  - Example Response:
    ```json
    [
      {
        "patientId": "789012",
        "name": "Alice Johnson",
        "bloodGroup": "A+",
        "email": "alice@example.com"
      },
      {
        "patientId": "123456",
        "name": "David Lee",
        "bloodGroup": "A+",
        "email": "david@example.com"
      }
    ]
    ```

These API explanations help users understand how to interact with the `DoctorController` for retrieving patient information, adding doctors, and searching for patients by blood group within the system.


### Patient Controller

This controller manages patient-related operations and interactions with the Patient Appointment Booking System.

### Endpoints

### Sign Up  
```
POST /patient/signUp
```

Allows patients to register an account in the system.

- Request:
  - **Body**: Patient information.
  - Example Request Body:
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "johndoe@example.com",
      "password": "securePassword"
    }
    ```

- Response:
  - Example Response:
    ```json
    {
      "message": "Patient account created successfully.",
      "userId": "123456"
    }
    ```

### Sign In  
```
POST /patient/signIn
```

Enables patients to log in with their credentials and obtain an authentication token.

- Request:
  - **Body**: Sign-in information.
  - Example Request Body:
    ```json
    {
      "email": "johndoe@example.com",
      "password": "securePassword"
    }
    ```

- Response:
  - Example Response:
    ```json
    {
      "message": "Patient signed in successfully.",
      "token": "your-jwt-token"
    }
    ```

### Sign Out  
```
DELETE /patient/signOut
```

Allows patients to log out of the system.

- Request:
  - **Body**: Authentication information.

- Response:
  - Example Response:
    ```json
    {
      "message": "Patient signed out successfully."
    }
    ```

### Schedule Appointment 
```
POST /patient/appointment/schedule
```

Enables patients to schedule an appointment with a healthcare provider.

- Request:
  - **Body**: Appointment information.
  - Example Request Body:
    ```json
    {
      "authInfo": {
        "token": "your-jwt-token"
      },
      "appointment": {
        "doctorId": "456789",
        "appointmentDate": "2023-11-15T10:00:00",
        "reason": "Follow-up checkup"
      }
    }
    ```

- Response:
  - Example Response:
    ```json
    {
      "message": "Appointment scheduled successfully.",
      "appointmentId": "7890123"
    }
    ```

### Cancel Appointment  
```
DELETE /patient/appointment/{appointmentId}/cancel
```

Allows patients to cancel a previously scheduled appointment.

- Request:
  - **Body**: Authentication information.
  - **Path Parameter**: `appointmentId` (the ID of the appointment to be canceled).

- Response:
  - Example Response:
    ```json
    {
      "message": "Appointment with ID 7890123 canceled successfully."
    }
    ```

### Get Doctors by Qualification or Specialization  
```
GET /doctors/qualification/{qual}/or/specialization/{spec}
```

Enables patients to search for doctors based on qualification or specialization.

- Request:
  - **Body**: Authentication information.
  - **Path Parameters**:
    - `qual` (desired qualification, e.g., "MD")
    - `spec` (desired specialization, e.g., "Cardiology")

- Response:
  - Example Response:
    ```json
    [
      {
        "doctorId": "456789",
        "name": "Dr. John Smith",
        "qualification": "MD",
        "specialization": "Cardiology"
      },
      {
        "doctorId": "123456",
        "name": "Dr. Jane Doe",
        "qualification": "MS",
        "specialization": "Orthopedics"
      }
    ]
    ```

### Doctor Controller

This controller handles doctor-related operations in the Patient Appointment Booking System.

### Endpoints

### Get All Doctors 
```
GET /doctors
```

Allows users to retrieve a list of all doctors in the system.

- Request:
  - **Body**: Authentication information.
  - Example Request Body:
    ```json
    {
      "token": "your-jwt-token"
    }
    ```

- Response:
  - Example Response:
    ```json
    [
      {
        "doctorId": "456789",
        "name": "Dr. John Smith",
        "qualification": "MD",
        "specialization": "Cardiology"
      },
      {
        "doctorId": "123456",
        "name": "Dr. Jane Doe",
        "qualification": "MS",
        "specialization": "Orthopedics"
      }
    ]
    ```

### Get Doctor by ID  
```
GET /doctor/{id}
```

Allows users to retrieve information about a specific doctor by their ID.

- Request:
  - **Path Parameter**: `id` (the unique ID of the doctor).
  
- Response:
  - Example Response:
    ```json
    {
      "doctorId": "456789",
      "name": "Dr. John Smith",
      "qualification": "MD",
      "specialization": "Cardiology"
    }
    ```

These API explanations help users understand how to interact with the `DoctorController` and retrieve information about doctors within the system.




## Testing
Unit tests and integration tests are provided within the project. You can run tests using your IDE or with Gradle or Maven.


## Contributing
Contributions to this project are welcome. If you have any suggestions, improvements, or feature requests, please create a pull request or open an issue.

Thank you for considering this backend design as a starting point for your Patient Appointment Booking System. Good luck with your project!



## Swagger Configuration
```
http://localhost:8080/swagger-ui/index.html#/
```
## Contact Information

If you have any questions, issues, or need further assistance related to the  Model-Based CRUD Operations Portal project, feel free to contact us. We are here to help!

- **Raj Anand**
  - Email: rajanandirctc@gmail.com
  - LinkedIn: [Raj Anand's LinkedIn Profile]()
  - GitHub: [Raj Anand's GitHub Profile]()


Please don't hesitate to reach out if you have any inquiries or need assistance with any aspect of the project. Your feedback and questions are important to us.



