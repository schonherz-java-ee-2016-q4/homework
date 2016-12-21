package hu.schonherz.blog.web.post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.schonherz.blog.service.api.user.vo.UserVo;

public class CreatePostForm {

    private String title;
    private String content;
    private List<String> tags;
    private UserVo author;
    
    public CreatePostForm(HttpServletRequest request, UserVo user) {
        title = fixInjections(request.getParameter("title"));
        
        content = fixInjections(request.getParameter("content"));
        tags = new ArrayList<>();
        String[] plainTags = request.getParameter("tags").split(",");
        for (String tag : plainTags) {
            tags.add(fixInjections(tag.trim()));
        }
        author = user;
    }
    
    private String fixInjections(String in) {
        return in.replace("<", "&lt;").replaceFirst(">", "&gt;");
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<String> getTags() {
        return tags;
    }

    public UserVo getAuthor() {
        return author;
    }


}
