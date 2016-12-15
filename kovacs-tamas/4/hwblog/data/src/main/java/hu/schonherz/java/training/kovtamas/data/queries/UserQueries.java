package hu.schonherz.java.training.kovtamas.data.queries;

public class UserQueries {

    private UserQueries() {
    }

    public static final String INSERT_USER = "INSERT INTO blog.USER"
            + "(USERNAME, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, POST_CODE, CITY, STREET, EMAIL, DATE_OF_BIRTH,"
            + "REGISTERED, PHONE, PIC_URL)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

}
