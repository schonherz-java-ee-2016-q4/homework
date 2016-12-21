package hu.schonherz.blog.service.api.blogpost.vo;

import java.sql.Date;

public class BlogPostVO {
    private int id;
    private String postTitle;
    private String postBody;
    private Date postPublishTime;
    private int userId;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
}
