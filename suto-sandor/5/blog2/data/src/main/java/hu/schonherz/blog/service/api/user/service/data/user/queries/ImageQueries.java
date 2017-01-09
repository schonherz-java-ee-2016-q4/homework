package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class ImageQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_database.imageinfo WHERE user_id = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_database.imageinfo(user_id, large, medium, thumbnail)" + "VALUES (?,?,?,?)";
}
