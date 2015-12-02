--liquibase formatted sql
--changeset casoc:003
CREATE TABLE user_authority(
id INTEGER NOT NULL auto_increment PRIMARY KEY,
user_id INTEGER NOT NULL,
authority_id INTEGER NOT NULL,
UNIQUE INDEX (id, user_id)
)
--rollback DROP TABLE user_authority;