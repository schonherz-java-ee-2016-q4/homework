package hu.schonherz.blog.service.api.user.service.data.blog.queries;

public class PostBlogQueries {
	public static final String QUERY_FIND_ALL
    ="SELECT * FROM blog_database.blogs;";
    
    public static final String QUERY_FIND_BY_ID 
    = "SELECT * FROM blog_database.blogs where id=(?);";
    
    public static final String QUERY_INSERT =
            "INSERT INTO blog_database.blogs(username, title, content, created, tags) "
            + "VALUES(?,?,?,?,?)";
}
