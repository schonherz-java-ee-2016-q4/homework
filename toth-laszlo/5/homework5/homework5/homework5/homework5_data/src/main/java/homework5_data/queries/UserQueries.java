package homework5_data.queries;

public class UserQueries {

    public static final String QUERY_FIND_ALL
    ="SELECT * FROM blog.test;";
    
    public static final String QUERY_FIND_BY_NAME 
    = "SELECT * FROM blog.test where username=(?);";
    
    public static final String QUERY_INSERT =
            "INSERT INTO blog.test(gender,title,first_name,last_name, street,city,state,postcode,email,username,password,salt,md5,sha1,sha256,dob,registered,phone,cell,  id_name,id_value,  pic_large,pic_medium,pic_thumbnail,nat) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
