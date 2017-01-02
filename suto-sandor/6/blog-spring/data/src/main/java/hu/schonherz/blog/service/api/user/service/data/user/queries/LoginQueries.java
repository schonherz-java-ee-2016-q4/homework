package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class LoginQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_database.logininfo WHERE user_id = ?";
    public static final String QUERY_FIND_BY_USERNAME = "SELECT * FROM blog_database.logininfo WHERE username = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_database.logininfo(user_id, username, password)" + "VALUES (?,?,?)";
}
