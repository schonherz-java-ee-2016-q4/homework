CREATE SCHEMA IF NOT EXISTS blog_homework_jpa;

SET SCHEMA 'blog_homework_jpa';

CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE IF NOT EXISTS users (
	id SERIAL PRIMARY KEY,
    email VARCHAR(250) NOT NULL,
    dob DATE NOT NULL,
    registered DATE NOT NULL,
    phone VARCHAR(30) NOT NULL,
    cell VARCHAR(30) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    role VARCHAR(20) DEFAULT 'user',
    active BOOLEAN DEFAULT TRUE,
	
	title VARCHAR(10) NOT NULL,
    first VARCHAR(100) NOT NULL,
    last VARCHAR(100) NOT NULL,
	
	street VARCHAR(250) NOT NULL,
	city VARCHAR(150) NOT NULL,
	state VARCHAR(100) NOT NULL,
	postcode INTEGER NOT NULL,

    username VARCHAR(50) NOT NULL,
    password VARCHAR(64) NOT NULL,
	
	large_image VARCHAR(255) NOT NULL,
    medium_image VARCHAR(255) NOT NULL,
    thumbnail_image VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS blogposts (
	id SERIAL PRIMARY KEY,
	title VARCHAR(200) NOT NULL,
	content VARCHAR(2000),
	posted TIMESTAMP NOT NULL,
	user_id INTEGER REFERENCES users(id)	
);

CREATE TABLE IF NOT EXISTS posttags (
	id SERIAL PRIMARY KEY,
	blogpost_id INTEGER REFERENCES blogposts(id),
	tag VARCHAR(30) NOT NULL
);