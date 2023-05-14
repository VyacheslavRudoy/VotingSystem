# Voting System for restaurants

Design and implement a REST API using Hibernate/Spring/SpringMVC (Spring-Boot preferred!) **without frontend**.

The task is:
Build a voting system for deciding where to have lunch.

* 2 types of users: admin and regular users
* Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
* Menu changes each day (admins do the updates)
* Users can vote for a restaurant they want to have lunch at today
* Only one vote counted per user
* If user votes again the same day:
    - If it is before 11:00 we assume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides a new menu each day.

---
## Curl:


### *Admin role for users:*
#### Get all Users:
 http://localhost:8080/voting/rest/admin/users -- admin@mail.ru:password

#### Get User 1000:
 http://localhost:8080/voting/rest/admin/users/1000 -- admin@mail.ru:password

#### Get User by specific email (user2@mail.ru):
 http://localhost:8080/voting/rest/admin/users/by?email=user2@mail.ru -- admin@mail.ru:password

---

### *User role for users:*
#### Get profile:
 http://localhost:8080/voting/rest/profile -- user2@mail.ru:password

---

### *Admin role for restaurants:*
#### Get Restaurants:
 http://localhost:8080/voting/rest/admin/restaurants -- admin@mail.ru:password

---

### *User role for restaurants:*
#### Get all Restaurants, where you can eat today:
 http://localhost:8080/voting/rest/restaurants -- user1@mail.ru:password

#### Get all Restaurants for the random date (2023-05-01):
 http://localhost:8080/voting/rest/restaurants?date=2023-05-01 -- user1@mail.ru:password

---

### *Dish with the Admin role:*
#### Get all Dishes for the Restaurant 1005:
 http://localhost:8080/voting/rest/admin/restaurants/1005/dishes -- admin@mail.ru:password

#### Get Dish 1011 from the Restaurant 1005:
 http://localhost:8080/voting/rest/admin/restaurants/1005/dishes/1011 -- admin@mail.ru:password

---

### *Voting with the Admin role:*
#### Get all Votes for today:
 http://localhost:8080/voting/rest/admin/users/votes/ -- admin@mail.ru:password

---

### *Voting with the User role:*
#### Vote for the Restaurant 1005:
 http://localhost:8080/voting/rest/votes -- user1@mail.ru:password

#### Get Votes for today for the User:
 http://localhost:8080/voting/rest/votes/ -- user1@mail.ru:password
