package hu.schonherz.java.training.kovtamas.data.queries;

public class UserQueries {

    private UserQueries() {
    }

    public static final String FIND_ALL_USER = "SELECT * FROM blog.USER";

    public static final String FIND_USER_BY_ID = "SELECT * FROM blog.USER "
            + "WHERE ID = ?";

    public static final String FIND_USER_BY_USERNAME = "SELECT * FROM blog.USER "
            + "WHERE USERNAME = ?";

    public static final String FIND_USER_BY = "SELECT * FROM blog.USER "
            + "WHERE ? = ?";

    public static final String INSERT_USER = "INSERT INTO blog.USER"
            + "(USERNAME, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, POST_CODE, CITY, STREET, EMAIL, DATE_OF_BIRTH,"
            + "REGISTERED, PHONE, PIC_URL)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_ROLE = "UPDATE blog.USER"
            + " SET ROLE_OF_USER = ?"
            + " WHERE ID = ?";

}
