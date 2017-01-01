CREATE TABLE blog_app.users(
	id INTEGER PRIMARY KEY,
    -- basic user info
   	gender VARCHAR(10),
    title_name VARCHAR(10),
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    date_of_birth DATE,
    email VARCHAR(50),
    -- pic
    small_pic_url VARCHAR(100),
    medium_pic_url VARCHAR(100),
    large_pic_url VARCHAR(100),
    -- location info
    nationality VARCHAR(3),
    state_name VARCHAR(40),
    city VARCHAR(30),
    street VARCHAR(100),
    post_code VARCHAR(10),
    
    -- account information
    user_name VARCHAR(20),
    pass VARCHAR(30),
    register_date DATE
)
-- forgot to create auto incrementation for id
CREATE SEQUENCE id_seq START WITH 1; -- replace 12345 with max above
ALTER TABLE  blog_app.users ALTER COLUMN id SET DEFAULT nextval('id_seq');
