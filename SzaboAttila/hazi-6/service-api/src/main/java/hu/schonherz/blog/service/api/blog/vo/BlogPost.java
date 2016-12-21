package hu.schonherz.blog.service.api.blog.vo;

import java.util.List;

import hu.schonherz.blog.service.api.user.vo.UserVo;

public class BlogPost {
    private int id;
    private List<String> tags;
    private String content;
    private String title;
    private String posted;
    private UserVo author;
    
    public BlogPost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public UserVo getAuthor() {
        return author;
    }

    public void setAuthor(UserVo author) {
        this.author = author;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BlogPost [id=");
        builder.append(id);
        builder.append(", tags=");
        builder.append(tags);
        builder.append(", content=");
        builder.append(content);
        builder.append(", title=");
        builder.append(title);
        builder.append(", posted=");
        builder.append(posted);
        builder.append(", author=");
        builder.append(author);
        builder.append("]");
        return builder.toString();
    }
    
}
