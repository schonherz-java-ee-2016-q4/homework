package homework5_data.queries;

public class PostQueries {
    public static final String QUERY_FIND_ALL
    ="SELECT * FROM blog.posts;";
    
    public static final String QUERY_FIND_BY_ID 
    = "SELECT * FROM blog.posts where id=(?) ORDER BY date";
    
    public static final String QUERY_INSERT =
            "INSERT INTO blog.posts(header, text, username, date, tags) "
            + "VALUES(?,?,?,?,?)";
}
