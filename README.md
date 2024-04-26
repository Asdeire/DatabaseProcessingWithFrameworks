# Database Processing With Frameworks
## Objective
The objective of this practical work is to implement CRUD operations using three different frameworks: Spring JDBC Template, Lombok, and Hibernate Validator, while managing dependencies with Maven/Gradle.

## Overview
This practical work focuses on rapid application development with frameworks to streamline database processing tasks. By leveraging Spring JDBC Template, Lombok, and Hibernate Validator, we aim to enhance efficiency and maintainability in developing robust database-driven applications.

Service Layer:
The service layer acts as an intermediary between the presentation layer (UI/Controllers) and the data access layer (Repositories). It encapsulates business logic, promoting separation of concerns and facilitating modular development.

## Tasks
1. Set up a Maven project in IntelliJ IDEA and integrate Spring JDBC Template, Lombok, and Hibernate Validator.
2. Define at least 4 tables, including one-to-many relationships. Optionally, implement many-to-many relationships.
3. Configure Spotless via Maven to enforce Google code style conventions.
4. Create entity classes using Lombok annotations and implement validation using Hibernate Validator. Integrate them with Spring JDBC Template.
5. Implement Data Access Objects (DAO) for all entities with CRUD methods (findById, findAll, persist/save, update, delete) using Spring JDBC Template.
6. Optionally, demonstrate the functionality using test classes or a JavaFX application.

## Usage
- Clone the repository.
- Navigate to the project directory.
- Execute the validation script.
- Follow the instructions provided to input data and observe the validation process.

## Contribution Guidelines
Contributions to the development of the Database Processing With Authorisation Service system are welcome. To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature/new-feature`.
3. Make changes and commit them: `git commit -m "Add new feature"`.
4. Push changes to your fork: `git push origin feature/new-feature`.
5. Open a pull request.

## License
This project is licensed under the [MIT License](LICENSE).
