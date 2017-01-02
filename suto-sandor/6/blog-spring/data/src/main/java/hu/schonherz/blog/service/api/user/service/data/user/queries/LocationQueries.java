package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class LocationQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_database.locationinfo WHERE user_id = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_database.locationinfo(user_id, street, city, state, postcode)" + "VALUES (?,?,?,?,?)";
}
