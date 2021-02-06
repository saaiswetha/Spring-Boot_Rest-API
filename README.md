# Spring-Boot_Rest-API
Rest API's to manage a Web based Spring Boot Application

### About
A simple Web based Spring Boot Application that implements few REST API's to manipulate the data of Employees using MongoDB.


Apart from the CRUD API's, the 2 main API's implemented are 
* #### countPost  
Whenever a new Employee is created i.e posted via the POST API, we keep a count of the number of times the POST API is hit. This is done to keep track of how many posts are created by an Employee does.
* #### addModifiedDetails 
Whenever a posted information is updated/modified via the PUT API, we store the details of the Employee who made an update and the date of modofication.
