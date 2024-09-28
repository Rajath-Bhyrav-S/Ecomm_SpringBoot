
# Ecomm Project Using SpringBoot

This Spring Boot application is designed with a clean architecture, separating the concerns into different layers for better maintainability and scalability. The app is built with a layered approach that follows the standard practice of MVC (Model-View-Controller) design pattern, with the following components:

## Overview

The application allows a client to interact with an H2 in-memory database by sending API requests, which are processed by the different layers within the Spring Boot application. These layers include:

* Control Layer (Controller): The entry point for client requests. The client sends HTTP requests to this layer. The controller handles the requests, delegating business logic to the service layer.
* Service Layer: Contains the core business logic of the application. It serves as an intermediary between the controller and repository layers, ensuring the control flow of data and operations.
* Repository Layer (Repo): Responsible for interacting with the H2 database. It handles data access and database operations, translating business objects to database entities and vice versa.
## Architecture flow 
* Client Interaction: The client sends API requests to the application, such as data retrieval or modification operations.

* Control Layer: Upon receiving the client’s API requests, the Controller in the Control Layer processes the input and forwards the request to the Service Layer for further business processing.

* Service Layer: This layer handles the business logic and may perform data manipulations, computations, or validations. It then communicates with the Repository Layer to fetch or update the required data.

* Repository Layer: The Repository Layer interacts with the H2 database for any data-related operations. It sends queries to the database and returns the results to the Service Layer.

* Database: The H2 in-memory database stores the data, which is used and managed by the repository.

* Response: The results from the Repository Layer flow back to the Service Layer, which then passes it to the Controller. The Controller prepares the response and sends it back to the client.
## Tech Stack

**BackEnd:** Java - SpringBoot

**DataBase:** H2 DataBase

