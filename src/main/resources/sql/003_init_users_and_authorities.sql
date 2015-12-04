--liquibase formatted sql
--changeset casoc:003
INSERT INTO users(username, password, enabled) VALUES('super', '1b3231655cebb7a1f783eddf27d254ca', 1);
INSERT INTO users(username, password, enabled) VALUES('adviser', 'c0f7bbe14aaee1b771e9ea23dd7883ea', 1);
INSERT INTO authorities(username, authority) VALUES ('super', 'ROLE_SUPER');
INSERT INTO authorities(username, authority) VALUES ('adviser', 'ROLE_ADVISER');
--rollback DELETE * FROM authorities; DELETE * FROM users;