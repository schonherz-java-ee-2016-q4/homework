CREATE TABLE blog_app.posts (
	id INTEGER PRIMARY KEY,
    user_id INTEGER,
    title VARCHAR(20),
    content VARCHAR(500)
)