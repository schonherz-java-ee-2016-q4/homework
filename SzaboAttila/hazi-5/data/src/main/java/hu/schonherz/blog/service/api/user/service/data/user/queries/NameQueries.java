package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class NameQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_homework.name WHERE user_id = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_homework.name(user_id, title, first, last)" +
            "VALUES (?,?,?,?)";
}
