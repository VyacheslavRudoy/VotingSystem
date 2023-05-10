DELETE
FROM user_roles;
DELETE
FROM restaurant;
DELETE
FROM dish;
DELETE
FROM vote;
DELETE
FROM users;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password)
VALUES ('User1', 'user1@mail.ru', '{noop}password'),
       ('Admin', 'admin@mail.ru', '{noop}password'),
       ('User2', 'user2@mail.ru', '{noop}password');

INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_USER', 1000),
       ('ROLE_ADMIN', 1001),
       ('ROLE_USER', 1001),
       ('ROLE_USER', 1002);

INSERT INTO restaurant (name)
VALUES ('Restaurant1'),
       ('Restaurant2'),
       ('Restaurant3');

INSERT INTO dish (name, date, restaurant_id, price)
VALUES ('Dish1(Rest1)', '2023-05-01', 1003, 750),
       ('Dish2(Rest1)', '2023-05-01', 1003, 500),
       ('Dish3(Rest1)', '2023-05-01', 1003, 1200),
       ('Dish4(Rest2)', CURRENT_DATE, 1004, 345),
       ('Dish5(Rest2)', CURRENT_DATE, 1004, 399),
       ('Dish6(Rest3)', CURRENT_DATE, 1005, 678),
       ('Dish7(Rest3)', CURRENT_DATE, 1005, 270);

INSERT INTO vote (date, user_id, restaurant_id)
VALUES ('2023-05-01', 1000, 1004),
       ('2023-05-01', 1001, 1004),
       ('2023-05-02', 1000, 1003),
       ('2023-05-02', 1001, 1003),
       (now, 1000, 1003),
       (now, 1001, 1004);