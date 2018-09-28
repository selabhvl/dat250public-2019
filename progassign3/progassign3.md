# DAT250: Programming Assignment 3
## EJBs, SOAP and JMS

In this assignment you will implement the business logic of the auction application developed in assignment 1 and 2. In addition, you will implement web services in the application using the SOAP protocol, and a messaging system using JMS.

## Part 1 - EJBs

Implement the business logic of the application using EJB session beans. Use entity classes created in assignment 2 to interact with the database.
This is covered in the textbook, chapters 7-9.

## Part 2 - SOAP

After implementing the business logic, you will extend your application of with further functionality by letting the application expose information as a SOAP web service.
The SOAP-based web service should retrieve information about auctions providing the following
operations:
• A service which returns a representation of the auction identified by id.
• A service which creates a bid with a specified amount in the auction identified by id and returns a representation of the bid.

You should also develop a client application to check that the service is working.
SOAP web services are covered in the textbook chapter 14.



