# DAT250: Programming Assignment 3
## Enterprise Java Beans and SOAP

In this assignment you will implement the business logic of the auction application partly developed in assignment 1 and 2. In addition, you will implement two SOAP web services to be provided by the application

## Part 1 - Enterprise Java Beans

Implement the business logic of the auction application using EJB session beans. Use the entity classes and the database access objects created in assignment 2 to interact with the database. This is covered in chapters 7-9 in the JAVA EE textbook.

You will typically need session beans corresponding to the use cases that you identfifed as part of assignment 1.

## Part 2 - SOAP web service

After implementing the business logic, you will extend your application with further functionality by providing access to the business logic by means of a SOAP web service. SOAP web services are covered in chapter 14 of the Java EE textbook.

The SOAP-based web service provide the following operations:

- a method which returns a representation of the auction identified by an id
- a method which returns a representation of the auctions that the customer can still bid for
- a method which places a bid of a given amount in an auction and informs as to it is currently the highest bid

To test the SOAP service you may either_
- Develop a test client application
- use [Postman](https://www.getpostman.com), [SoapUI](https://www.soapui.org) or similar.





