package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class LoginQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_homework.login WHERE user_id = ?";
    public static final String QUERY_FIND_BY_USERNAME = "SELECT * FROM blog_homework.login WHERE username = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_homework.login(user_id, username, password)" +
            "VALUES (?,?,?)";
}
