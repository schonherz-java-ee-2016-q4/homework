package hu.schonherz.blog.data.querys;

public final class UserQuerys {
    private UserQuerys() {
    }

    public static final String QUERY_FIND_ALL = "SELECT * FROM blog.users;";

    public static final String QUERY_INSERT = "INSERT INTO blog.users("
            + "email,dateofbirth,registered,phone,street,city,state,postcode,name_title,"
            + "first_name,last_name,gender,username,password,large_pic,medium_pic,thumbnail_pic,user_role,enabled)"
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String QUERY_FIND_BY_ID = "SELECT * FROM blog.users where id=(?);";
    public static final String QUERY_FIND_BY_USERNAME = "SELECT * FROM blog.users where username=?;";
}
