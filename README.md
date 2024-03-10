# SpringBoot Microservice Architecture Prototype

This project is a Spring Boot microservice architecture prototype designed for handling AWS Athena queries. The application consists of a backend implemented in Java using Spring Boot, and a frontend implemented in React. The goal is to facilitate the execution of Athena queries through a user-friendly web interface.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-17.0.2-blue.svg)](https://reactjs.org/)
[![AWS SDK for Java](https://img.shields.io/badge/AWS%20SDK%20for%20Java-2.17.112-orange.svg)](https://aws.amazon.com/sdk-for-java/)
[![Coverage Status](https://coveralls.io/repos/github/your-username/your-repo/badge.svg?branch=main)](https://coveralls.io/github/your-username/your-repo?branch=main)
[![Maintainability](https://api.codeclimate.com/v1/badges/your-badge-token/maintainability)](https://codeclimate.com/github/your-username/your-repo/maintainability)



## Backend

### ConfigFileRelated Package

#### Config Class

The `Config` class is responsible for holding configuration properties such as access key, secret key, database name, and output location. The class provides getter and setter methods for these properties.

#### ConfigReader Class

The `ConfigReader` class manages the reading and creation of the configuration file. It reads configuration properties from the `config.txt` file located in the `src/configFile` directory. If the file or directory does not exist, it creates a new configuration file with default values.

### AthenaService Class

The `AthenaService` class is a Spring service responsible for executing Athena queries. It uses the AWS SDK for Java to interact with Athena. The class contains methods to execute a query, monitor its execution status, and retrieve the query results.

### FormController Class

The `FormController` class is a Spring MVC controller that handles HTTP requests related to the form submission. It interacts with the `AthenaService` to execute Athena queries based on user input.

### TestSpringbootBackendApplication Class

The `TestSpringbootBackendApplication` class is the main class that runs the Spring Boot application.

## Frontend

### React Components

The frontend is implemented in React and consists of two components:

#### App Component

The `App` component defines the main routing structure using React Router. It includes routes for the query form and the query response.

#### QueryForm Component

The `QueryForm` component is a form that allows users to input parameters for an Athena query. It communicates with the backend to execute the query and redirects to the query response page.

#### QueryResponse Component

The `QueryResponse` component displays the results of the executed Athena query. Users can navigate back to the query form from this page.

### CSS Styles

The project includes CSS files (`QueryForm.css` and `QueryResponse.css`) for styling the components.

## How to Run

1. Clone the repository.
2. Set up the backend in your preferred Java IDE.
3. Run the `TestSpringbootBackendApplication` class.
4. Set up the frontend using a tool like `create-react-app`.
5. Run the React application.

Make sure to configure the AWS credentials and other parameters in the `config.txt` file before running the application.

## Dependencies

- Spring Boot
- React
- AWS SDK for Java

## Acknowledgments

This project was created for the purpose of demonstrating a Spring Boot microservice architecture for executing AWS Athena queries. Feel free to explore, modify, and use it as a foundation for your own projects.
