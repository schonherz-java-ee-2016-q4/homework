package hu.schonherz.blog.service.api.user.queries;

public final class UserQueries {
    private UserQueries(){}

    public static final String QUERY_FIND_BY_USER_NAME =
            "SELECT * FROM blog.members WHERE username=(?);";

    public static  final String QUERY_FIND_ALL =
            "SELECT * FROM blog.members;";

    public static final String QUERY_INSERT =
            "INSERT INTO blog.members (firstName, lastName, username, password, email, " +
                    "gender, date_of_birth, location, phone, imh) VALUES (?,?,?,?,?,?,?,?,?,?)";

}
