package hu.schonherz.blog.data.post;

import java.sql.Date;

/**
 * Created by Geri on 2017. 01. 03..
 */
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private Date published;
    private int authorID;

    public PostDTO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PostDTO [id=");
        builder.append(id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", content=");
        builder.append(content);
        builder.append(", published=");
        builder.append(published);
        builder.append(", authorID=");
        builder.append(authorID);
        builder.append("]");
        return builder.toString();
    }

}