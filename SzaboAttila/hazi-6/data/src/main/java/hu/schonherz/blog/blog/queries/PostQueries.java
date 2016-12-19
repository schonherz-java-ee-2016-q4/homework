package hu.schonherz.blog.blog.queries;

public class PostQueries {
    public static final String QUERY_FIND_ALL_HEADERS = "SELECT id, user_id, title, posted, content FROM blog_homework.posts ORDER BY posted DESC";
    public static final String QUERY_FIND_BY_POST_ID = "SELECT * FROM blog_homework.posts WHERE id=?";
    public static final String QUERY_SAVE = "INSERT INTO blog_homework.posts(user_id, title, posted, content)"
            + "VALUES (?, ?, ?, ?)";
}
