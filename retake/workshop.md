# ESD_Spring_framework_2022
ESDE spring framework repository Jason &amp; Marek

## Introduction

List what the structure of this workshop is going to be. 

### Overview of Spring

Spring Framework is a popular open-source framework for developing enterprise applications in Java. It provides a wide range of features and functionalities that enable developers to build robust, scalable, and secure applications.

#### Key Features

* **Dependency Injection (DI)**: Spring provides a powerful DI mechanism that makes it easy to manage dependencies between components. This results in loosely coupled code that is easier to test and maintain.
* **Aspect-Oriented Programming (AOP)**: Spring provides an AOP framework that allows developers to implement cross-cutting concerns such as logging, caching, and security.
* **Data Access**: Spring provides a powerful data access framework that makes it easy to work with databases using JDBC, JPA, or other persistence frameworks.
* **Web Development**: Spring provides a web development framework that makes it easy to build web applications using MVC or WebFlux.
* **Security**: Spring provides a comprehensive security framework that includes authentication, authorization, and secure communication.
* **Messaging**: Spring provides a messaging framework that makes it easy to build messaging applications using JMS or other messaging protocols.
* **Integration**: Spring provides integration with other frameworks such as Hibernate, Struts, and JSF, making it easy to use with existing applications.

### Why Spring


| Feature               | Spring                 | JavaFX          | Nodejs            | React            | Laravel                |
| --------------------- | ---------------------- | --------------- | ----------------- | ---------------- | ---------------------- |
| **Language**          | Java                   | Java            | Javascript        | Javascript       | PHP                    |
| **Purpose**           | Enterprise             | GUI             | Network           | UI               | Web                    |
| **Owner**             | VMware                 | Oracle          | OpenJS Foundation | Meta             | Taylor Otweil          |
| **Popularity**        | Established            | Niche           | Trendy            | Dominant         | Growing                |
| **Community Support** | Developer-backed forum | Limited support | 3rd party forums  | 3rd party forums | Developer-backed forum |
| **Documentation**     | Comprehensive          | Sparse          | Abundant          | Extensive        | Extensive              |
| **Learning Curve**    | Steep                  | Moderate        | Beginner-friendly | Moderate         | Beginner-friendly      |

Spring is a popular framework for developing enterprise applications in Java because of its modular design, robust Dependency Injection mechanism, integration with other frameworks, strong community support, and scalability. It offers a lot of features to Java developers, making it a preferred choice for many enterprise applications.

While other frameworks may excel in certain use cases, Spring still offers a wide range of features and benefits that make it a strong choice for enterprise Java development.

---

#### Performance
It's hard to measure performance of Spring compared to other frameworks. The main reason for this is that they all have different use cases. For example, nodejs is made for server side javascript. This makes nodejs very well optimised for making the backend of websites quickly, while spring is made for enterprise software and has had more of a focus on scalable applications & robust security. It's hard to comment on performance of each of the languages and it's mainly important to look at what your use case needs.

### Benefits of using Spring

1. **Modularity**: Spring has a modular design that allows developers to pick and choose the components they need, making it lightweight and more efficient.
2. **Scalability**: Spring's support for distributed systems and cloud-native architectures makes it an ideal choice for building large-scale applications that can handle high volumes of traffic.
3. **Community Support**: Spring has a large and active community of developers who contribute to the framework's development, providing support through forums, documentation, and tutorials.
4. **Easy Testing**: Spring's DI mechanism and AOP framework make it easy to write testable code, resulting in faster development cycles and more reliable applications.

## Spring Core

Overview of the key components of the Spring core, including the `ApplicationContext` and `BeanFactory`, and how they are used to manage the lifecycle of beans in a Spring-based application.

## Dependency injection

Dependency injection recap.

### Dependency injection overview

How dependency injection works in general & the different ways to implement it.

### Spring dependency injection

How spring specifically implements dependency injection.

### <span style="color:red"> Hands-on exercise 1</span>

~dictionary-with-annotations-and-stuff-included~

DI exercise `TextEditor` that contains a `SpellChecker` dependency. 

Create a class called `SpellChecker` that contains a method to check the spelling of a given word.
Configure the Spring framework to manage the lifecycle of the `TextEditor` and `SpellChecker` objects, using annotations.

Steps:
1. Make the dependency in `SpellChecker.java` injectable
2. Add spell checker using Dependency Injection in `TextEditor.java `class to utilise spell checker in `checkUsingSpellchecker` method
4. Run the DependencyInjectionApplication, launch your browser and go to localhost:8080 (by default) to confirm that the TextEditor is able to use the `SpellChecker` to check the spelling of a word
5. Bonus: Check each word in the text and return a list of incorrectly spelled words. This requires you to also alter the texteditor.html file in `main/resources/templates/`

## Spring MVC

Recap on what MVC is.

### Overview MVC

General overview of MVC in spring.

### How to use MVC in spring

Explanation of how to use MVC in spring.

### <span style="color:red"> Hands-on exercise 2</span>

Build a simple web application using spring MVC that displays a list of books and allows users to add, edit, and delete books.

Steps:
1. Create a class called Book that represents a book.
1. Create a class called BookController that will handle the HTTP requests for adding, editing, and deleting books.
1. Create JSP pages to display the list of books and a form to add, edit, or delete a book.
1. Configure the Spring framework to use Spring MVC to handle the HTTP requests and manage the lifecycle of the BookController object.
1. Test the application by adding, editing, and deleting books.

## Data Access with Spring

Overview of data access technologies supported by Spring Framework such as `JDBC`, `Hibernate`, and `JPA`.



### <span style="color:red"> Hands-on exercise 3</span>

Interaction exercise with a database.

1. Create a new Spring Boot project using start.spring.io or your preferred IDE. Include the following dependencies in your project:

* Spring Web
* Spring Data JPA
* MySQL Driver

2. Create a User entity class that represents a user in your system. The User class should have the following fields:

* id (Long)
* firstName (String)
* lastName (String)
* email (String)

Add JPA annotations to the User class to map it to a database table.

3. Create a UserRepository interface that extends the Spring Data CrudRepository interface. Add the following method to the UserRepository interface:

`List<User> findByLastName(String lastName);`

4. Create a UserController class that handles incoming HTTP requests. Add a GET endpoint that retrieves a list of all users with a specific last name. Use the UserRepository to perform the data access operations.

5. Configure your application to connect to your MySQL database. You can do this by adding the following properties to your application.properties file:

```
properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydatabase
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

Replace mydatabase, myuser, and mypassword with the appropriate values for your MySQL setup.

6. Run your application and test your GET endpoint by making a request to http://localhost:8080/users?lastName=Smith (replace Smith with a last name that exists in your database). Verify that the response includes a list of users with the specified last name.

**Bonus Exercise**

7. If you want to extend this exercise, you can add additional data access operations to your application. For example, you could add endpoints to create, update, and delete users, or you could add additional query methods to the UserRepository interface. You could also add additional entities and relationships between them to explore more advanced data access scenarios.


### <span style="color:red">Hands-on Bonus exercise</span>

////

## Conclusion

Summarise all the topics that were discussed and what we hope the reader learned from this workshop.
