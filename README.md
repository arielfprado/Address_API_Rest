# Address_API_Rest
## Overview
#### Project created using JAVA language / Spring Framework to manage a database (MySQL) of clients and addresses, consuming an opensource API Rest (ViaCEP) for the addresses based on the address code and using OpenAPI as UI for the application.

## Running the application
#### To run the project, the next steps are required: 
* clone this Repo into your machine;
* modify the application.properties file for your database configuration;
* run the Application main class;
* Open your browser;
* Enter the URL: "http://localhost:8080/swagger-ui/index.html"

![image](https://user-images.githubusercontent.com/95775417/179613725-bb7c6e86-dde7-442f-9c62-dea6a8b800d8.png)

## Spring Dependencies
#### The following Spring Dependencies were used in this project:
* Spring Web;
* Spring Data JPA;
* MySQL Driver;
* OpenFeign;
* Open API.

## Model
#### Model folder contains the Client (Cliente) and Address (Endereco) classes and also the repositories extending __CrudRepository__ for each one:
* Cliente (Client);
* Endereco (Address);
* ClienteRepository;
* EnderecoRepository.

## Service
#### Service folder contains the interface for the ClienteService, the interface for the ViaCepService (API Rest for the addresses information) and the implementation of these interfaces for communicating with the API and gathering this information for the application:
* ClienteService (Client Service);
* EnderecoService (Address Service);
* ClientServiceImpl (Implementation).

## Controller
#### Controller folder contains the ClientRestController which is responsible for defining the methods and actions performed by the application into the DataBase, translating the created methods into pre-set CrudRepository methods:
* ClientRestController.

## Application
#### Responsible for being the "main" class of the whole application, with the reponsabillity of making the RUN possible.

## application.properties
#### Contains the String configuration for the MySQL database access.
