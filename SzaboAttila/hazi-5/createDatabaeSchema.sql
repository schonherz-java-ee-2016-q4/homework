CREATE SCHEMA IF NOT EXISTS blog_homework;

SET SCHEMA 'blog_homework';

CREATE TABLE IF NOT EXISTS users (
	id SERIAL PRIMARY KEY,
    email VARCHAR(250) NOT NULL,
    dob DATE NOT NULL,
    registered DATE NOT NULL,
    phone VARCHAR(30) NOT NULL,
    cell VARCHAR(30) NOT NULL,
    gender VARCHAR(1) NOT NULL
);

CREATE TABLE IF NOT EXISTS location (
	user_id INTEGER NOT NULL,
	street VARCHAR(250) NOT NULL,
	city VARCHAR(150) NOT NULL,
	state VARCHAR(100) NOT NULL,
	postcode INTEGER NOT NULL,
	CONSTRAINT location_user_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS name (
	user_id INTEGER NOT NULL,
	title VARCHAR(10) NOT NULL,
    first VARCHAR(100) NOT NULL,
    last VARCHAR(100) NOT NULL,
	CONSTRAINT name_user_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS login (
	user_id INTEGER NOT NULL,
	
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    
	CONSTRAINT name_user_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS picture (
	user_id INTEGER NOT NULL,
	
	large VARCHAR(255) NOT NULL,
    medium VARCHAR(255) NOT NULL,
    thumbnail VARCHAR(255) NOT NULL,
	
	CONSTRAINT name_user_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS post_headers (
	id SERIAL PRIMARY KEY,
	user_id INTEGER NOT NULL,
	title VARCHAR(200) NOT NULL,
	posted TIMESTAMP NOT NULL,
	content VARCHAR(2000),
	
	CONSTRAINT post_user_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS post_tags (
	post_id INTEGER NOT NULL,
	tag VARCHAR(30) NOT NULL,
	CONSTRAINT post_fk
        FOREIGN KEY (post_id)
        REFERENCES post_headers(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);