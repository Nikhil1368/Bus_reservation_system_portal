# REST API for Bus Reservation System Portal 

* We have developed this REST API for a Bus Reservation System Portal Application. This API performs all the fundamental CRUD operations of any Bus Reservation Application platform with user validation at every step.
* This project is developed by team of 5 Back-end Developers during project week in Masai School. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Login, Logout Module
* Admin Module
* User Module
* Route Module
* Bus Module
* Reservation Module
* Feedback Module

## Features

* User and Admin authentication & validation with session uuid.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete route and bus from main database
    * Admin can access the details of different users and reservations.
* User Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available buses and booking a reservation
    * Only logged in user can access his reservations, profile updation and other features.

## Contributors

* Nikhil Bhardwaj
* Sandhya Potadar
* Yuvraj Rajarawal
* Dheeraj Pandey

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/BusReservationSystemPortal/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/busdb
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`


## API Module Endpoints

### Login Module

* `POST //login/admin` : Admin can login with mobile number and password provided at the time of registation
<!--
### User Module


* `POST /customer/login` : Logging in customer with valid mobile number & password
* `GET /customer/availablecabs` : Getting the list of all the available cabs
* `GET /customers/cabs` : Getting All the cabs
* `GET /customers/checkhistory` : Getting the history of completed tr
* `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
* `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
* `POST /customer/booktrip` : Customer can book a cab
* `POST /customer/updatetrip` : Customer can modify or update the trip
* `POST /customer/logout` : Logging out customer based on session token
* `DELETE /customer/delete` : Deletes logged in user 
* `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid 
* `DELETE /customer/canceltrip` : Cancel the trip with the given tripid   


### Admin Module

* `POST /admin/register` : Register a new admin with proper data validation and admin session
* `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
* `GET /admin/logout` : Logging out admin based on session token
* `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
* `GET /admin/listoftrips` : Get list of trips of all the trips
* `GET /admin/listocustomers` : Get list of all the customers
* `GET /admin/listodrivers` : Get list of all the drivers
* `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
* `DELETE /admin/delete` : Deletes the admin with passed id   -->


### Sample API Response for Admin Login

`POST   localhost:8888/login/admin`

* Request Body

```
    {
        "mobileNo": "8651060999",
        "password": "Clickme@007"
    }
```

* Response

```
   CurrentAdminSession( adminId=10, uuid=ZaVLaK,localDatetime=2022-10-01 12:29:52.376508)
   
```
 
### E-R Diagram Of Bus Application
---

![Bus Reservation System Portal ER Diagram](https://user-images.githubusercontent.com/101393405/193448015-c00c2fe3-f836-4812-ac6a-10965cb4bbec.png)

---

### Swagger UI

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/AllController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### User and User Login Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/User%26UserLoginController.jpg" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Admin and Admin Login Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/admin%26adminlogincontroller.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Bus Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/BusController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Reservation Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/ReservationController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Route Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/RouteController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---

### Feedback Controller

---

<img src="https://github.com/vinaykumar2n/succinct-wrench-1095/blob/main/Images/FeedbackController.jpg?raw=true" style="max-width: 100%; display: inline-block;" data-target="animated-image.originalImage">

---


# THANK YOU EVERYONE FOR VISITING OUR PROJECT

---
