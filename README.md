# swell-cause-4406
# Hindbus-- Bus Reservation System portal

> We have created REST API for Online Bus Booking Application which can be used by Customers and Admin to login into their profile, update their details and Book Nus with option to select bus type and the Bus or driver availability.<br><br>

> All this is over looked by the Admin who can access the data in the application.<br><br>

> We have implemented data and user validation at every step, for every user.<br><br>

> It has all the basic facilities that are required by an end user to have a convenient and hassle free **Online Busd Booking Experience**. <br><br>

<br>

> # *** Team Members ***

-   <a href="https://uditshetty.github.io/" target="_blank" rel="noopener noreferrer" > Nikhil Bhardwaj </a>
-   <a href="https://ninadjoshi212.github.io/" target="_blank" rel="noopener noreferrer" > Yuvraj Rajarawal </a>
-   <a href="https://github.com/potadar1999" target="_blank" rel="noopener noreferrer" > Sandhya Potadar </a>
-   <a href="https://aniket427.github.io/" target="_blank" rel="noopener noreferrer" > Dheeraj </a>

<br>

> # *** Tech Stacks ***

-   Java Core
-   Spring Data JPA
-   Spring web
-   Validation
-   Spring Boot
-   Hibernate
-   MySQL
-   Swagger UI
-   Lombok
-   Postman

<br>


> # Features

This Java based REST API project have featurs like Register, Login, Logout, Update, Booking,  canceling or deleting, giving rating
Some features describes bellow according to their role . 


> ### For Admin
- Admin can register himself.
- For doing next admin tasks with database admin should login himself".
- Adding, deleting and updating the roots.
- can view all the application anytime
- Adding, deleting and updating the bus.

> ### For Customer
- Customer can register himself.
- For booking any bus or trip he/she should login first".
- Booktrip / A bus.
- Cancel a trip / delete a trip data.
- Viweing own travel history.
- Can rate drive based on trip exxperience.
- Can find bestDriver available by rating.
- Fetching Invoice for total travel details/spends on trip.
- Updating own tripdetails before a timeperiod.
- Logout, update details, delete account.

<br>


> # *** Installation and Run ***
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per your local database config.
```
   server.port=8888
   spring.datasource.url=jdbc:mysql://localhost:3306/FlyWheeldb
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.username=**mysql username**
   spring.datasource.password=**mysql password**
   spring.jpa.hibernate.git ddl-auto=update
```

<br>

> # API / Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui/`

<br>


> # *** Swagger UI ***
# Login Controller
-Provides login and logout functionality

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/loginCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/loginCntrl.jpg?raw=true)

<br>

# Admin Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/adminCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/adminCntrl.jpg?raw=true)

<br>

# Customer Controller

[![SwaggerUI](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/CustomerCntrl.jpg?raw=true)](https://github.com/Ninadjoshi212/fanatical-building-1351/blob/main/Assest/CustomerCntrl.jpg?raw=true)

<br>

   
   

