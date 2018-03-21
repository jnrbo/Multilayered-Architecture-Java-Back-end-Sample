# Multilayered Architecture - Java Back-end Sample
Just a Java architecture sample project. This project show how to integrate Java + Hibernate + Spring using Gradle.

- Controllers - contains application logic and passing user input data to service
- Services - The middleware between controller and repository. Gather data from controller, performs validation and business logic, and calling repositories for data manipulation.
- Repositories - layer for interaction with models and performing DB operations
- Models - common model files with relationships defined
