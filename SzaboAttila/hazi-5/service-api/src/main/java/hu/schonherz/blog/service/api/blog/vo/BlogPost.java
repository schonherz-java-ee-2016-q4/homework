package hu.schonherz.blog.service.api.blog.vo;

import java.util.List;

import hu.schonherz.blog.service.api.user.vo.User;

public class BlogPost {
    private List<String> tags;
    private String text;
    private String title;
    private String posted;
    private User poster;
    
    public BlogPost() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Post [tags=");
        builder.append(tags);
        builder.append(", text=");
        builder.append(text);
        builder.append(", title=");
        builder.append(title);
        builder.append(", posted=");
        builder.append(posted);
        builder.append(", poster=");
        builder.append(poster);
        builder.append("]");
        return builder.toString();
    }
    
}
