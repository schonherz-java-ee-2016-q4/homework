package hu.schonherz.blog.service.api.user.queries;

public class PostQueries {
    public static final String QUERY_INSERT_POST =
            "INSERT INTO public.blogpost(name,title,textarea)"
                    + "VALUES(?,?,?)";

    public static final String QUERY_FIND_ALL_POST
            ="SELECT * FROM public.blogpost;";
}
