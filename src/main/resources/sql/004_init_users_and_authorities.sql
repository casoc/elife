--liquibase formatted sql
--changeset casoc:004
INSERT INTO users(username, password, enabled) VALUES('super', '1b3231655cebb7a1f783eddf27d254ca', 1);
INSERT INTO users(username, password, enabled) VALUES('adviser', 'c0f7bbe14aaee1b771e9ea23dd7883ea', 1);
INSERT INTO authorities(authority, comment, enabled) VALUES ('ROLE_SUPER', 'Super Administrator', 1);
INSERT INTO authorities(authority, comment, enabled) VALUES ('ROLE_ADVISER', 'Normal User', 1);
INSERT INTO user_authority(user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority(user_id, authority_id) VALUES (2, 2);
--rollback DELETE * FROM authorities; DELETE * FROM users; DELETE * FROM user_authority;