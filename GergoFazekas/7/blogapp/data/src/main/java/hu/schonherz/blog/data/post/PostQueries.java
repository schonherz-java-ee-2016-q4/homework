package hu.schonherz.blog.data.post;

/**
 * Created by Geri on 2017. 01. 03..
 */
public class PostQueries {
    public static final String QUERY_FROM_ALL = "SELECT * FROM blog.posts";

    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog.posts"
            + " where id = ?";

    public static final String QUERY_INSERT = "INSERT INTO blog.posts("
            + "title, content, published, user_id)"
            + " VALUES (?, ?, ?, ?)";
}

