--liquibase formatted sql
--changeset casoc:001
CREATE TABLE users
(
username VARCHAR(50) NOT NULL PRIMARY KEY,
password VARCHAR(50) NOT NULL,
enabled VARCHAR(1) NOT NULL
);
--rollback DROP TABLE users;
