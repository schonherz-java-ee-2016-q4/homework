package hu.sconherz.blog.web.post;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.schonherz.blog.service.api.user.vo.User;

public class CreatePostForm {

    private String title;
    private String text;
    private List<String> tags;
    private User user;
    
    public CreatePostForm(HttpServletRequest request) {
        title = fixInjections(request.getParameter("title"));
        
        text = fixInjections(request.getParameter("content"));
        tags = new ArrayList<>();
        String[] plainTags = request.getParameter("tags").split(",");
        for (String tag : plainTags) {
            tags.add(fixInjections(tag.trim()));
        }
        user = (User)request.getSession().getAttribute("user");
    }
    
    private String fixInjections(String in) {
        return in.replace("<", "&lt;").replaceFirst(">", "&gt;");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
