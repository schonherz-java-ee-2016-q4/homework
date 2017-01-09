package hu.schonherz.blog.service.api.user.service.data.user.queries;

public class ContactQueries {
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog_database.contactinfo WHERE user_id = ?";
    public static final String QUERY_SAVE =
            "INSERT INTO blog_database.contactinfo(user_id, email, phone, cell)" + "VALUES (?,?,?,?)";
}
