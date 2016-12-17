package hu.schonherz.blog.data.user.queries;

public class UserQueries {
    public static final String QUERY_FIND_ALL = "SELECT * FROM blog_homework.users";
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_homework.users WHERE id=?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_homework.users(email, dob, registered, phone, cell, gender)" +
            "VALUES (?,?,?,?,?,?)";
}
