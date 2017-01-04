package hu.schonherz.blog.data.user.queries;

public class PictureQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_homework.picture WHERE user_id = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_homework.picture(user_id, large, medium, thumbnail)" +
            "VALUES (?,?,?,?)";
}
