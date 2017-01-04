SET SCHEMA 'blog_app';
CREATE TABLE IF NOT EXISTS tags(
	id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS conn_posts_users(
	post_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT conn_posts_users_post_fk
        FOREIGN KEY (post_id)
        REFERENCES posts(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT conn_posts_users_user_fk
        FOREIGN KEY (user_id)
        REFERENCES users(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS conn_posts_tags(
    post_id INTEGER NOT NULL,
    tag_id INTEGER NOT NULL,
    CONSTRAINT conn_posts_users_post_fk
        FOREIGN KEY (post_id)
        REFERENCES posts(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT conn_posts_users_tag_fk
        FOREIGN KEY (tag_id)
        REFERENCES tags(id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);