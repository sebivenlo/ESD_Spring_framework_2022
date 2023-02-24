# ESD_Spring_framework_2022
ESDE spring framework retake repository by Jason &amp; Marek

## Introduction

In this document, you'll find information about the Spring Framework, with a brief overview of the key concepts of Spring, including but not limited to Dependency Injection, MVC, and Data Access. You will also find a small comparison between spring and other frameworks. After giving a brief overview of the concepts you'll have the opportunity to do an hands-on exercise for each topic to get a better grasp of the concepts. Lastly you'll also see a conclusion where we will summarise everything discussed.

Since Spring is a huge framework, we unfortunately can't go into everything, if you want more information about certain features, at the end of the document there are some sources listed you can use to get a better and deeper understanding of other features in Spring.

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

Spring Core is a lightweight container that provides the fundamental infrastructure for creating and managing Spring-based applications. It is the core module of the Spring Framework and provides a framework for implementing the Dependency Injection (DI) design pattern. 

Even though Spring Core is not covered thoroughly in our exercises, it is the underlying infrastructure that enables us to use the design patterns mentioned in our exercises.

## Dependency injection

Dependency injection is a programming technique where we inject objects into other objects or dependencies. 

You might recognise it from Java. since it is not specific to the Spring framework and can be implemented in various ways in Java too. Let's have a quick look at how it works in java:

Suppose we have two classes, `UserService` and `UserRepository`, where `UserService` depends on `UserRepository` to retrieve user data from a database. We can use dependency injection to inject an instance of `UserRepository` into `UserService`.

```
public class UserService {
    private UserRepository userRepository;
    
    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
}

public class UserRepository {
    public User getUserById(int id) {
        // Retrieve user data from database
    }
}
```

Now, when we create an instance of UserService, we pass in an instance of UserRepository to its constructor:

```
UserRepository userRepository = new UserRepository();
UserService userService = new UserService(userRepository);
```

By doing this, we have achieved dependency injection, where `UserService` is dependent on `UserRepository`, but we are not creating a new instance of `UserRepository` within `UserService`. Instead, we are injecting an instance of `UserRepository` into `UserService`, which makes `UserService` more modular and easier to test.

### Spring dependency injection

In the Spring framework, dependency injection is achieved through the use of an inversion of control (IoC) container. The IoC container is responsible for managing the creation and lifecycle of objects within the application and injecting dependencies into those objects.

Let's make a quick showcase. We have two classes, `UserController` and `UserService`, where `UserController` depends on `UserService` to retrieve user data from a database. We can use dependency injection to inject an instance of `UserService` into `UserController` using the `@Autowired` annotation.

```
@Component
public class UserService {
    public User getUserById(int id) {
        // Retrieve user data from database
    }
}
```
In the `UserService` class, we define a method `getUserById` that retrieves user data from a database. We annotate the class with `@Component` to mark it as a Spring bean that can be injected into other classes.
```
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }
}
```
In the `UserController` class, we define a field `userService` and annotate it with `@Autowired`. This tells Spring to inject an instance of `UserService` into `UserController`.

We also define a `getUserById` method that retrieves a user by ID and adds it to the Model object. This method uses the injected `userService` to retrieve the user.


### <span style="color:red"> Hands-on exercise 1</span>

This exercise is a spell checker. You have a file which is the controller of the website, and a dependency which has a method to check if words are spelled correctly. The goal of this exercise is to inject the `SpellChecker.java` dependency into `TextEditor.java`. 

#### Optional Docker setup
If you want to run the program in a Docker environment, go to the root directory of the exercise, open a terminal and enter `docker build -t fontys/dep-inj .` After that, enter `docker run -p 8080:8080 fontys/dep-inj` and you should be set up.

#### Steps:
1. Make the dependency in `SpellChecker.java` injectable
2. Add spell checker using Dependency Injection in `TextEditor.java `class to utilise spell checker in `checkUsingSpellchecker` method
4. Run the DependencyInjectionApplication, launch your browser and go to localhost:8080 (by default) to confirm that the TextEditor is able to use the `SpellChecker` to check the spelling of a word
5. Bonus: Check each word in the text and return a list of incorrectly spelled words. This requires you to also alter the texteditor.html file in `main/resources/templates/`

## Spring MVC

Spring MVC is a module of the Spring framework dealing with the Model-View-Controller or MVC pattern for building web applications in Java. It combines all the advantages of the MVC pattern with the convenience of Spring.

### Overview MVC

The Spring MVC architecture separates an application into three main components: the Model, View, and Controller. The Model represents the data and business logic of the application, the View displays the data to the user, and the Controller receives and processes user requests and updates the Model and View as needed.

![Model/View/Controller](https://i.imgur.com/BNozpWG.png)

### How to use MVC in spring

1. **Define the Model**: In Spring MVC, the Model represents the data and business logic of the application. You can define the Model using Java classes or Spring Beans.
2. **Define the Controller**: The Controller receives and processes user requests, updates the Model as needed, and selects the appropriate View to display to the user. In Spring MVC, Controllers are typically defined as Spring Beans.
3. **Define the View**: The View is responsible for displaying the data to the user. In Spring MVC, the View can be implemented using a variety of technologies, including JSP, Thymeleaf, and others.
4. **Implement request handling methods in the Controller**: The Controller handles incoming requests from the client and updates the Model as needed. You can implement request handling methods using Spring annotations, such as @RequestMapping.
5. **Implement the View**: Finally, you'll need to implement the View to display the data to the user. You can use a variety of technologies to implement the View, including JSP, Thymeleaf, and others. To integrate the View with Spring MVC, you'll need to define a ViewResolver that maps logical view names to actual View implementations.


### <span style="color:red"> Hands-on exercise 2</span>

Build a simple web application using spring MVC that displays a list of books and allows users to add, edit, and delete books.

#### Optional Docker Setup

If you want to run the program in a Docker environment, go to the root directory of the exercise, open a terminal and enter `docker build -t fontys/spring-mvc .` After that, enter `docker run -p 8080:8080 fontys/spring-mvc` and you should be set up.

#### Steps:
1. Implement the methods and the appropriate method annotations in a class called `BookController` that will handle the HTTP requests for adding, editing, and deleting books.
2. Run the application and confirm everything works (open localhost in browser).
3. Test the application by adding, editing, and deleting books.

## Data Access with Spring

Overview of data access technologies supported by Spring Framework such as `JDBC`, `Hibernate`, and `JPA`.

### JDBC
JDBC (Java Database Connectivity) is a standard API that provides a uniform interface for accessing relational databases. Spring provides excellent support for JDBC through its JDBC template. The JDBC template provides a simple and efficient way to perform common database operations such as querying, updating, and executing stored procedures.
### Hibernate
Hibernate is an object-relational mapping (ORM) framework that provides a way to map Java objects to relational databases. Hibernate provides a powerful query language called Hibernate Query Language (HQL) and supports multiple database platforms. Spring provides excellent integration with Hibernate, allowing developers to take advantage of Hibernate's advanced features while still leveraging Spring's transaction management and other features.
### JPA
JPA (Java Persistence API) is a standard specification for ORM in Java. It defines a set of interfaces and annotations that provide a consistent way to access and manipulate data in relational databases. Spring provides comprehensive support for JPA through its Spring Data JPA module. This module provides a set of utilities and abstractions that simplify the process of working with JPA. We will be utilising JPA in our exercise.

### <span style="color:red"> Hands-on exercise 3</span>

Interaction exercise with a database including CRUD functionality for a User entity.

#### Optional Docker Setup

To run this docker container, you'll have to navigate to the directory of the project in your terminal and type `docker-compose up -d --build`. 

To restart the docker container completely, including resetting the database, you can use `docker-compose down -v` to remove the container, and afterwards `docker-compose up -d --build` to rebuild it again.

#### Steps:


1. Implement the appropriate annotations for the `User` class
2. Make the `UserRepositoryInterface` a proper repository for CRUD tasks by implement either the `CrudRepository` or `JPARepository`
3. Add the required annotations to `UserServiceImpl` to implement it as a service, and add code to make the methods work. HINT: ||You can use the repository here.||
4. Implement methods and controller for the crud tasks, it is highly recommended to use a rest controller here. You can choose the tasks yourself. I recommend doing one for each of the following tasks: Save user, update user, delete user, fetch all users and fetch user by id
5. Test the methods through an application through your preferred interface. It is recommended to use something like postman or cURL.

## Conclusion

With Dependency Injection, we have learned how to configure the Spring framework to manage the lifecycle of objects and how to use Dependency Injection to inject dependencies into classes. We have also applied our knowledge in a hands-on exercise, where we created a `TextEditor` class that utilized a `SpellChecker` dependency. 

Next, we learned about Spring MVC. Spring MVC is a powerful framework for building web applications in Java that follows the Model-View-Controller pattern. It provides a convenient way to separate an application into three main components: the Model, View, and Controller, allowing developers to build more modular and maintainable applications. Through a hands-on exercise, we have learned how to use Spring MVC to create a simple web application that displays a list of books and allows users to add, edit, and delete books. We have implemented methods in a `BookController` class using appropriate annotations to handle HTTP requests and have tested the application by performing CRUD operations.

Lastly, we learned about how Spring handles Data Access. Spring Data Access is a powerful module of the Spring framework that simplifies the process of interacting with databases in Java. Through a hands-on exercise, we have learned how to use Spring Data Access to create a simple CRUD (Create, Read, Update, Delete) application that interacts with a database. We have implemented appropriate annotations for the `User` class, made the `UserRepositoryInterface` a proper repository for CRUD tasks using either `CrudRepository` or `JPARepository`, implemented `UserServiceImpl` as a service, and added code to make the methods work. We have also implemented methods and a controller for CRUD tasks, and tested the methods through an application using Postman or cURL.

## Sources / Documentation

The main sources used to get a better understanding were the Spring website for documentation, and Baeldung for specific concepts.

When going more in-depth with Spring, we recommend to mostly stick with the websites listed below, since they provide well written guides with good documentation and proper coding practices to interact with Spring.
#### Dependency Injection
https://www.baeldung.com/spring-autowire

https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring
#### MVC
https://www.geeksforgeeks.org/spring-mvc-framework/

https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping/

https://www.javatpoint.com/spring-mvc-tutorial

https://spring.io/guides/gs/serving-web-content/

https://www.baeldung.com/spring-mvc-static-resources
#### Data Access
https://www.geeksforgeeks.org/spring-boot-crudrepository-with-example/

https://spring.io/guides/gs/accessing-data-jpa/

### Docker

https://spring.io/guides/topicals/spring-boot-docker/
