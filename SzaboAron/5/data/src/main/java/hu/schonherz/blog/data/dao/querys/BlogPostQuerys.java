package hu.schonherz.blog.data.dao.querys;

public final class BlogPostQuerys {
    private BlogPostQuerys() {
    }

    public static final String QUERY_FIND_ALL = "SELECT * FROM blog.blog_posts;";

    public static final String QUERY_INSERT = "INSERT INTO blog.blog_posts(post_title, post_body,post_publish_time,user_id)"
            + "VALUES(?,?,?,?)";

    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog.blog_posts where id=(?);";
}
