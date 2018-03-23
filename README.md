# Multilayered Architecture - Java Back-end Sample
Just a Java architecture sample project.<br>
This project show how to integrate Java + Hibernate + Spring using Gradle.


- Controllers - Contains basic application logic, url mapping and send data to the service
- Services - The middleware between controller and repository. Receives data from controller, performs validations and business logic, and calls repositories for data manipulation.
- Repositories - Layer for interaction with models and perform DB operations
- Models - Common model files with relationships defined (POJOs)


<br>
### TODO LIST

- [x] Basic code
- [ ] Complete tests
- [ ] Finish Todo list