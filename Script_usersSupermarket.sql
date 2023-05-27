CREATE DATABASE db_supermarket;
USE db_supermarket;

CREATE TABLE users(
	usertype VARCHAR(20) NOT NULL,
	fullname VARCHAR(20) NOT NULL,
    id INT NOT NULL PRIMARY KEY,
    birthday VARCHAR(20),
    points VARCHAR(5)
);

SELECT * FROM users;

INSERT INTO users VALUES ("Cliente_regular", "Juan", "123132", "12-05-1995","0");