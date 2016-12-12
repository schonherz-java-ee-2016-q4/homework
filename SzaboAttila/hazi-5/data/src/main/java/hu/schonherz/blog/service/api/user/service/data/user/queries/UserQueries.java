package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class UserQueries {
    public static final String QUERY_FIND_ALL = "SELECT * FROM blog_homework.users";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_homework.users(email, dob, registered, phone, cell, gender)" +
            "VALUES (?,?,?,?,?,?)";
}
