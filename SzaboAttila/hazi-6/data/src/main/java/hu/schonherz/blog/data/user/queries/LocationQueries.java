package hu.schonherz.blog.data.user.queries;

public class LocationQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_homework.location WHERE user_id = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_homework.location(user_id, street, city, state, postcode)" +
            "VALUES (?,?,?,?,?)";
}
