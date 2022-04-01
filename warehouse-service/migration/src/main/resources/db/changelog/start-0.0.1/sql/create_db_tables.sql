CREATE TABLE IF NOT EXISTS category (
    id BIGINT  PRIMARY KEY,
    name VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS pos (
    id BIGINT generated always as identity PRIMARY KEY ,
    name VARCHAR(255) UNIQUE,
    price BIGINT,
    amount BIGINT,
    category_id BIGINT REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS supply (
    id BIGINT generated always as identity PRIMARY KEY,
    position_name VARCHAR(255) REFERENCES pos(name),
    amount BIGINT,
    arr_date DATE,
    exp_date DATE
);

CREATE TABLE IF NOT EXISTS sale (
    id BIGINT generated always as identity PRIMARY KEY,
    position_name VARCHAR(255) REFERENCES pos(name),
    dt DATE,
    amount BIGINT,
    money_spent BIGINT
);

CREATE TABLE IF NOT EXISTS log_entity (
    id BIGINT generated always as identity PRIMARY KEY,
    action_time TIMESTAMP,
    method_name VARCHAR(255),
    class_name VARCHAR(255),
    user_name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS role (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS role_users (
    role_id BIGINT REFERENCES role(id),
    user_id BIGINT REFERENCES users(id)
);

INSERT INTO role VALUES (1,'ROLE_OWNER'),(2,'ROLE_ADMIN'),(3,'ROLE_BUYER');

INSERT INTO category  VALUES (1, 'fruits'),(2, 'vegetables'),(3, 'meat');
INSERT INTO pos (name,price,amount,category_id) VALUES ('buba',100,10,1),('pika',20,5,2),('aboba',25,34,3);