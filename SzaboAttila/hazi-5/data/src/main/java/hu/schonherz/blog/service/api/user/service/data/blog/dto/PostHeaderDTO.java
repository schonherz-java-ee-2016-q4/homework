package hu.schonherz.blog.service.api.user.service.data.blog.dto;

import java.sql.Timestamp;

public class PostHeaderDTO {
    private int id;
    private int user_id;
    private String title;
    private Timestamp posted;
    private String content;

    public PostHeaderDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getPosted() {
        return posted;
    }

    public void setPosted(Timestamp posted) {
        this.posted = posted;
    }

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PostHeaderDTO [id=");
        builder.append(id);
        builder.append(", user_id=");
        builder.append(user_id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", posted=");
        builder.append(posted);
        builder.append(", content=");
        builder.append(content);
        builder.append("]");
        return builder.toString();
    }

}
