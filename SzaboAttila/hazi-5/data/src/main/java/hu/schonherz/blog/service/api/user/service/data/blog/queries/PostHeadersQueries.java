package hu.schonherz.blog.service.api.user.service.data.blog.queries;

public class PostHeadersQueries {
    public static final String QUERY_FIND_ALL = "SELECT * FROM blog_homework.post_headers";
    public static final String QUERY_SAVE = "INSERT INTO blog_homework.post_headers(user_id, title, posted)"
            + "VALUES (?, ?, ?)";
}
