package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class UserQueries {
    public static final String QUERY_FIND_ALL = "SELECT * FROM blog_database.userinfo";
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_database.userinfo WHERE id=?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_database.userinfo(title, first, last, dob, registered, gender)" + "VALUES (?,?,?,?,?,?)";
}
