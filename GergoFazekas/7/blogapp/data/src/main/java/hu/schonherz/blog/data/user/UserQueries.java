package hu.schonherz.blog.data.user;

/**
 * Created by Geri on 2017. 01. 03..
 */
public class UserQueries {

    public static final String QUERY_FROM_ALL = "SELECT * FROM blog.users";

    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog.users"
            + " where id = ?";

    public static final String QUERY_INSERT = "INSERT INTO blog.users("
            + "first_name, last_name, email, username, password, "
            + "phone, gender, dob, registered, postcode, street, state, city,"
            + "large_picture, medium_picture, thumbnail)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_CHANGE_STATUS = "UPDATE blog.users" +
            " SET active = not active" +
            " WHERE id = ?";
}

