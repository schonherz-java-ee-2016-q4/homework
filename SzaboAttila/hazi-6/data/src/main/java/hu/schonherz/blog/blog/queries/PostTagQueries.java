package hu.schonherz.blog.blog.queries;

public class PostTagQueries {
    public static final String QUERY_FIND_BY_POST_ID = "SELECT * FROM blog_homework.post_tags WHERE post_id=?";
    public static final String QUERY_SAVE = "INSERT INTO blog_homework.post_tags(post_id, tag) VALUES (?, ?)";
}
