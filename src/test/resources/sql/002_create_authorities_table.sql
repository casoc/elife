--liquibase formatted sql
--changeset casoc:002
CREATE TABLE authorities
(
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL,
constraint fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);
CREATE UNIQUE index ix_auth_username ON authorities(username,authority);
--rollback DROP TABLE authorities;