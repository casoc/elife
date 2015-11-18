--liquibase formatted sql
--changeset casoc:001
CREATE TABLE users
(
id INTEGER NOT NULL auto_increment PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(50) NOT NULL,
enabled VARCHAR(1) NOT NULL
);
--rollback DROP TABLE users;
