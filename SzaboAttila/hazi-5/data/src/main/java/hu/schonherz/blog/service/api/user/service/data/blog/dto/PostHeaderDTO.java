package hu.schonherz.blog.service.api.user.service.data.blog.dto;

import java.sql.Date;

public class PostHeaderDTO {
    private int id;
    private int user_id;
    private String title;
    private Date posted;
    
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

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PostHeader [id=");
        builder.append(id);
        builder.append(", user_id=");
        builder.append(user_id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", posted=");
        builder.append(posted);
        builder.append("]");
        return builder.toString();
    }
    
}
