--liquibase formatted sql
--changeset casoc:002
CREATE TABLE authorities
(
id INTEGER NOT NULL auto_increment PRIMARY KEY,
authority VARCHAR(50) NOT NULL,
enabled VARCHAR(1) NOT NULL,
comment VARCHAR(100)
);
--rollback DROP TABLE authorities;