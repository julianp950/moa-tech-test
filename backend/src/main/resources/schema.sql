/* Restart Hibernate sequence for id */
DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence
	START WITH 1
	INCREMENT BY 1;

/* TABLES */

DROP TABLE IF EXISTS role CASCADE;
CREATE TABLE role (
	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	permission_create BOOLEAN DEFAULT false,
	permission_update BOOLEAN DEFAULT false,
	permission_delete BOOLEAN DEFAULT false
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(128) NOT NULL,
	age INTEGER,
	phone VARCHAR(255),
	address VARCHAR(255),
	email VARCHAR(255),
	user_name VARCHAR(255),
	password VARCHAR(255),
	role_id INTEGER,
	FOREIGN KEY (role_id) REFERENCES role(id)
);

