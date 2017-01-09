package blog_data.queries;

public final class UserQueries {
	public static final String QUERY_FIND_BY_USERNAME = "SELECT * FROM blogapp.users WHERE username=?;";
	public static final String QUERY_FIND_ALL = "SELECT * FROM blogapp.users;";
	public static final String UPDATE_REGISTER = "INSERT INTO blogapp.users(username, password, email, picture, registration_date, birth_date) VALUES(?, ?, ? , ? , ?, ?)";
}
