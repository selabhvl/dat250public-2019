# DAT250: Programming Assignment 2

## Java Persistence Architecture and REST web services

In this assignment you are required to implement the domain model for the application developed as part of the high-level design in assignment 1. This assignment is the first step towards implementing the full application using Java EE.

You must use the Java Persistence Architecture (JPA) to define the entity classes required in order to store information about users, devices, and registrations in a database. In addition, you must implement a RESTful API using JAX-RS that exposes part of the application as a web service.

You can start the development by either setting up a new Java EE project in Eclipse as explained in the [project setup tutorial](https://github.com/selabhvl/dat250public/wiki/Creating-a-new-Java-EE-application-project) or you can adapt the existing [advanced tweet application](https://github.com/selabhvl/dat250public/wiki/Running-an-advanced-Java-EE-application) which includes most of the Java EE frameworks that you will also need for the application.

### Part 1 - Entity classes and ORM

Implement the classes, attributes, and relations from your open IoT exchange domain model in Java. Use JPA to define the entity classes required in order to store information about devices, registrations, users etc. in a database. The information stored in the database must also capture the relations (associations) between the classes. 

As part of the this, you also have to define the persistence unit for your application. It might be a good idea to start adding one class to the application and check that corresponding database table is created (see below). Gradually, more entity classes can then be added.

Persistence units and object-relational mapping (ORM) are explained in Chapters 4 and 5 of the Java EE book.

After having deployed the application on the application server you should [inspect the database](https://github.com/selabhvl/dat250public/wiki/Debug-and-Database-inspection-in-Eclipse) and check that the correct tables have been generated by JPA.

### Part 2 - Loading data into the database

In order to test the implementation of the RESTful web services in Part 3, you should populate your database with some test data.

This can be done either by writing an SQL script to the load the data (see Page 120 in the Java EE book) or using a single Enterprise Java Bean executed at startup to programmatically persist data into the database (see the slides from the lectures on JPA).

### Part 3 - Data Access Objects (DAO)

Implement a number of DAO classes which encapsulates the typical operations required to store and retrieve data from the database. You should implement the methods which you find are required in order to cover the use cases that you have defined for your application. The DAO classes can be implemented as stateless Enterprise Java Beans (EJBs). In addition, you need to use an entity manager to persist and retrieve data from the database.

### Part 4 - RESTful web services

You are required to use the JAX-RS API to implement RESTful web services which make it possible to access the auction application using HTTP.

Implementation of RESTful web services using Java EE is explained in Chapter 15 of the Java EE book.

The following web services should at least be supported:

- GET `<app-path>/rest/devices` - which should return a representation with references to all devices currently registered in the system.
- GET `<app-path>/rest/devices/{id}` - which should return a representation of the device identified by `id`
- GET `<app-path>/rest/devices/{id}/registrations/` - which should return a representation with reference to all current registrations of the device identified by `id`
- GET `<app-path>/rest/devices/{id}/registration/{rid}` - which should return a representation of the given rid for the device identified by `id`
- POST `<app-path>/rest/devices/{id}/` - which creates a registration for a specified `user` for the device identified by `id` and returns a representation of the registration. The `user` should be contained in the payload of the request (or optionally as a query parameter).

The RESTful web services are required to support both XML and JSON formats as representation of resources. The underlying business methods that provide the services can be implemented using stateless enterprise beans and use the DAO classes defined in Part 3.

Test the RESTful services by running HTTP requests against them and inspecting the results. For testing you may use

- A web browser
- A Java program implemented using the JAX-RS Client API.
- [Curl](https://curl.haxx.se)
- [Postman](https://learning.getpostman.com/?_ga=2.261200462.231504413.1536569579-264554042.1522913654)

### Part 5 - Setup Connection to PostgreSQL database server

Until now you have used the local Derby database server on your PC for the persistent data of your application. For the assignment you will use a PostgreSQL database server that has been setup as HVL.

Go through the [instructions for PostgreSQL](https://github.com/selabhvl/dat250public/wiki/PostgreSQL-database-server-configuration) configuration. Your group will need a username and password from the course instructors.

Test that your application correctly stores data in the PostgreSQL database.
