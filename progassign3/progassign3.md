# DAT250: Programming Assignment 3
## EJBs, SOAP and JMS

In this assignment you will implement the business logic of the auction application developed in assignment 1 and 2. In addition, you will implement web services in the application using the SOAP protocol, and a messaging system using JMS.

## Part 1 - EJBs

Implement the business logic of the application using EJB session beans. Use entity classes created in assignment 2 to interact with the database.

## Part 2 - SOAP

In order to test the implementation of the RESTful web services in Part 3, you should populate your database with some test data.

This can be done either by writing an SQL script to the load the data (see Page 120 in the Java EE book) or using a single Enterprise Java Bean executed at startup to programmatically persist data into the database (see the slides from the lecture on Friday 7/9).

## Part 3 - JMS

You are required to use the JAX-RS API to implement RESTful web services which make it possible to access the auction application using HTTP.

Implementation of RESTful web services using Java EE is explained in Chapter 15 of the Java EE book.

The following web services should at least be supported:

    GET <app-path>/rest/auctions - which should return a representation with references to all current auctions (ongoing/completed) in the system.
    GET <app-path>/res/auctions/{id} - which should return a representation of the auction identified by id
    GET <app-path>/res/auctions/{id}/bids/ - which should return a representation with reference to all current bids in the auction identified by id
    GET <app-path>/res/auctions/{aid}/bids/{bid} - which should return a representation of the given bid within the auction identified by aid
    POST <app-path>/res/auction/{id}/bids - which creates a bid with a specified amount in the auction identified by id and returns a representation of the bid. The amount should be contained in the payload of the request (or optionally as a query parameter).

The RESTful web services are required to support both XML and JSON formats as representation of resources. The underlying business methods that provide the services can be implemented using stateless enterprise beans. In addition, you need to use an entity manager to persist and retrieve data from the database.

Test the RESTful services by running HTTP requests against them and inspecting the results. For testing you may use

    A web browser
    A Java program implemented using the JAX-RS Client API.
    Curl
    Postman

Part 4 - Setup Connection to PostgreSQL database server

Until now you have used the local Derby database server on your PC for the persistent data of your application. For the auction assignment you will use a PostgreSQL database server that has been setup as HVL.

Go through the instructions for PostgreSQL configuration. Your group will need a username and password from the instructor (Alex or Fernando).

Test that your application correctly stores data in the PostgreSQL database.
