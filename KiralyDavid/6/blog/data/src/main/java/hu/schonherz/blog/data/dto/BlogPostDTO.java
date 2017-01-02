package hu.schonherz.blog.data.dto;

import java.sql.Date;

public class BlogPostDTO {
    private int id;
    private String postTitle;
    private String postBody;
    private Date postPublishTime;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getPostPublishTime() {
        return postPublishTime;
    }

    public void setPostPublishTime(Date postPublishTime) {
        this.postPublishTime = postPublishTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BlogPostDTO [id=");
        builder.append(id);
        builder.append(", postTitle=");
        builder.append(postTitle);
        builder.append(", postBody=");
        builder.append(postBody);
        builder.append(", postPublishTime=");
        builder.append(postPublishTime);
        builder.append(", userId=");
        builder.append(userId);
        builder.append("]");
        return builder.toString();
    }
}
