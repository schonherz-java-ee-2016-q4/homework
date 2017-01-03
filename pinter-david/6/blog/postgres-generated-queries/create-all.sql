-- SCHEMA: blog_app

-- DROP SCHEMA blog_app ;

CREATE SCHEMA blog_app
    AUTHORIZATION postgres;
	
-- Table: blog_app.users

-- DROP TABLE blog_app.users;

CREATE TABLE blog_app.users
(
    id SERIAL PRIMARY KEY,
    gender character varying COLLATE pg_catalog."default" NOT NULL,
    title_name character varying COLLATE pg_catalog."default" NOT NULL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    date_of_birth date NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    small_pic_url character varying(100) COLLATE pg_catalog."default",
    medium_pic_url character varying(100) COLLATE pg_catalog."default",
    large_pic_url character varying(100) COLLATE pg_catalog."default",
    nationality character varying COLLATE pg_catalog."default" NOT NULL,
    state_name character varying COLLATE pg_catalog."default" NOT NULL,
    city character varying COLLATE pg_catalog."default" NOT NULL,
    street character varying COLLATE pg_catalog."default" NOT NULL,
    post_code character varying COLLATE pg_catalog."default" NOT NULL,
    user_name character varying COLLATE pg_catalog."default" NOT NULL,
    pass character varying COLLATE pg_catalog."default" NOT NULL,
    register_date date NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE blog_app.users
    OWNER to postgres;
		

-- Table: blog_app.posts

-- DROP TABLE blog_app.posts;

CREATE TABLE blog_app.posts
(
    id SERIAL PRIMARY KEY,
    user_id integer NOT NULL,
    title character varying COLLATE pg_catalog."default" NOT NULL,
    content character varying COLLATE pg_catalog."default" NOT NULL,
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE blog_app.posts
    OWNER to postgres;
	
-- Table: blog_app.tags

-- DROP TABLE blog_app.tags;

CREATE TABLE blog_app.tags
(
	id SERIAL PRIMARY KEY,
    name character varying COLLATE pg_catalog."default" NOT NULL,

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE blog_app.tags
    OWNER to postgres;	

-- Table: blog_app.conn_posts_tags

-- DROP TABLE blog_app.conn_posts_tags;

CREATE TABLE blog_app.conn_posts_tags
(
    post_id integer NOT NULL,
    tag_id integer NOT NULL,
    CONSTRAINT conn_posts_users_post_fk FOREIGN KEY (post_id)
        REFERENCES blog_app.posts (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT conn_posts_users_tag_fk FOREIGN KEY (tag_id)
        REFERENCES blog_app.tags (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
	PRIMARY KEY(post_id, tag_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE blog_app.conn_posts_tags
    OWNER to postgres;
	
-- Table: blog_app.conn_posts_users

-- DROP TABLE blog_app.conn_posts_users;

CREATE TABLE blog_app.conn_posts_users
(
    post_id integer NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT conn_posts_users_post_fk FOREIGN KEY (post_id)
        REFERENCES blog_app.posts (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT conn_posts_users_user_fk FOREIGN KEY (user_id)
        REFERENCES blog_app.users (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
	PRIMARY KEY(post_id, user_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE blog_app.conn_posts_users
    OWNER to postgres;
	

