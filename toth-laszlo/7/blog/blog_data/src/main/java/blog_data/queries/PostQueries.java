package blog_data.queries;

public class PostQueries {

	public static final String QUERY_FIND_BY_ID = "SELECT * FROM blogapp.posts WHERE id=?;";
	public static final String QUERY_FIND_ALL = "SELECT * FROM blogapp.posts;";
	public static final String UPDATE_POST = "INSERT INTO blogapp.postss(username, title, text, tags, post_date) VALUES(?, ?, ? , ?, ?)";

}
