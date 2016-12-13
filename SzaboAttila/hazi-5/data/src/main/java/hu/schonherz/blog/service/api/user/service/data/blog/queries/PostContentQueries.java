package hu.schonherz.blog.service.api.user.service.data.blog.queries;

public class PostContentQueries {
    public static final String QUERY_FIND_BY_POST_ID = "SELECT * FROM blog_homework.post_contents WHERE post_id=?";
    public static final String QUERY_SAVE = "INSERT INTO blog_homework.post_contents(user_id, text)"
            + "VALUES (?, ?)";
}
