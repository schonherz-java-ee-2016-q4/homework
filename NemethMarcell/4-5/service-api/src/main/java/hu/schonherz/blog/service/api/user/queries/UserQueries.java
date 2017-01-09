package hu.schonherz.blog.service.api.user.queries;

public class UserQueries {

    public static final String QUERY_FIND_BY_USER_NANE
    = "SELECT * FROM public.member where username=(?);";
    
    public static final String QUERY_FIND_ALL
    ="SELECT * FROM public.member;";
    
    public static final String QUERY_INSERT =
            "INSERT INTO public.member(first_name,last_name,username,email,"
            + "password,gender,date_of_birth,location,phone) VALUES(?,?,?,?,?,?,?,?,?)";
    
    public static final String QUERY_INSERT_POST =
   "INSERT INTO public.blogpost(name,title,textarea)"
   + "VALUES(?,?,?)";
    
    public static final String QUERY_FIND_ALL_POST 
    ="SELECT * FROM public.blogpost;";
    
    
}
