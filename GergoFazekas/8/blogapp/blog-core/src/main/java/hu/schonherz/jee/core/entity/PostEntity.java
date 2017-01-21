package hu.schonherz.jee.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PostEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1668706297169341939L;
    
    private String title;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;
    @ManyToOne
    private UserEntity author;
    
    public PostEntity() {
        // TODO Auto-generated constructor stub
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

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
    
    

}
