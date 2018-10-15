# DAT250: Programming Assignment 4
## Front-end and security

In this assignment you will implement the front-end of the auction application developed in the previous assignments.
You will also implement security mechanisms such as proper user authentication and a system for access control to the different parts of the application with an appropriate authorization scheme.
Finally, you will implement a messaging service in the application that make use of the JMS technology.

## Part 1 - User interface
Implement the user interface of the auction application using the JSF framework with Facelets.

## Part 2 - Security
Using the standard security features of the Java EE framework, implement a working solution for authentication and access control / authorization in the application. This must include a secure login mechanism using password and username, and the solution should use database storage of the user credentials. In the application, there should be at least two different roles with corresponding access rights. Finally, all communication between clients and the server should be protected by using the https protocol.

## Part 3 - JMS
When a customer submit the request to place a bid or wins a bid, there are several subsystems that
need to be notified. For this task, you must setup a JMS topic where you publish this information.
Two separate subsystems (clients) that subscribe to this topic should be implemented:

(a) The first sub-system “NotifyBuyer” should be implemented as a message-driven bean. The
message-driven bean should sent a message to dweet.io via REST similar to the functionality of the Tweet example application.


(b) The second subsystem is a small Enterprise Application Client.
When the application starts, it initially retrieves the information about active auctions via
the SOAP web service of assignment 2. The list is updated if an auction
is won by some customer. This part needs to be implemented via JMS (the application gets
information about winning bids by subscribing to a topic). The Enterprise Application Client
can place a new bid (preferably by pressing a button), which invokes the SOAP web service
to place the bid.
