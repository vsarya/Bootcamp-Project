CREATE TABLE T_EMPLOYEE
(
id int NOT NULL PRIMARY KEY,
first_name varchar(64) NOT NULL,
last_name varchar(64) NOT NULL,
email varchar(64) NOT NULL,
salary decimal(16, 2) NOT NULL,
role varchar(64) NOT NULL
);

CREATE TABLE T_PROJECT
(
id int NOT NULL PRIMARY KEY,
name varchar(64) NOT NULL,
client_name varchar(64) NOT NULL
);

CREATE TABLE T_MANAGES
(
project_id int NOT NULL,
manager_id int NOT NULL
);

CREATE TABLE T_WORKS_ON
(
project_id int NOT NULL,
employee_id int NOT NULL
);