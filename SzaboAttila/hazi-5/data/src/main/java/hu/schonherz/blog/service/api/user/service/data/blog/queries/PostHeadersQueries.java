package hu.schonherz.blog.service.api.user.service.data.blog.queries;

public class PostHeadersQueries {
    public static final String QUERY_FIND_ALL_HEADERS = "SELECT id, user_id, title, posted, content FROM blog_homework.post_headers ORDER BY posted DESC";
    public static final String QUERY_FIND_BY_POST_ID = "SELECT * FROM blog_homework.post_headers WHERE id=?";
    public static final String QUERY_SAVE = "INSERT INTO blog_homework.post_headers(user_id, title, posted, content)"
            + "VALUES (?, ?, ?, ?)";
}
