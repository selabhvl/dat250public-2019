# DAT250: Programming Assignment 3

## User Interface and Business Logic

In this assignment you will implement the front-end and the business logic of the application that was partly developed in assignments 2. You will also implement security mechanisms such as proper user authentication and a system for access control to the different parts of the application with an appropriate authorization scheme. Finally, you will implement a messaging service in the application that make use of the JMS technology.

## Part 1 - User interface

Implement the user interface of the application as designed in assignment 1 using the JSF framework with Facelets. Y

## Part 2 - Enterprise Java Beans (EJBs)

Implement the business logic of the application using EJB session beans. Use the entity classes and the database access objects created in assignment 2 to interact with the database. This is covered in chapters 7-9 in the JAVA EE textbook.

You will typically need EJBs covering the use cases that you identified as part of assignment 1 and which is able to service the user interface.

## Part 3 - Security

Using the standard security features of the Java EE framework, implement a working solution for authentication and access control / authorization in the application. This must include a secure login mechanism using password and username, and the solution should use database storage of the user credentials. In the application, there should be at least two different roles with corresponding access rights. Finally, all communication between clients and the server should be protected by using the https protocol.

## Part 4 - JMS

When a user is approved to use a registered device, the application needs to send a message to a Notify-subsystem implemented as a message-driven bean. You should add a JMS topic to your application in which this information can be published and received by a subscribing message-driven bean. The message-driven bean should sent a message to dweet.io via REST similar to the functionality of the advanced tweet example application.
