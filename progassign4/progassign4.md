# DAT250: Programming Assignment 4
## Front-end and security

In this assignment you will implement the front-end of the auction application developed in the previous assignments.
You will also implement security mechanisms such as proper user authentication and a system for access control to the different parts of the application with an appropriate authorization scheme.
Finally, you will implement a messaging service in the application that make use of the JMS technology.

## Part 1 - User interface
Implement the user interface of the auction application as designed in assignment 1 using the JSF framework with Facelets. Y

## Part 2 - Security
Using the standard security features of the Java EE framework, implement a working solution for authentication and access control / authorization in the application. This must include a secure login mechanism using password and username, and the solution should use database storage of the user credentials. In the application, there should be at least two different roles with corresponding access rights. Finally, all communication between clients and the server should be protected by using the https protocol.

## Part 3 - JMS

When a customer (user) wins an auction, the application needs to send a message to a Notify-subsystem implemented as a message-driven bean. You should add a JMS topic to your application in which this information can be published and received by a subscribing message-driven bean. The message-driven bean should sent a message to dweet.io via REST similar to the functionality of the advanced tweet example application.
