package hu.schonherz.blog.web.blogpost.createform;

import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.api.user.vo.UserVO;

import java.sql.Date;
import java.time.LocalDate;

public class PostCreatorForm {
    private String title;

    private String body;

    private UserVO owner;

    public PostCreatorForm(String title, String body, UserVO owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public PostCreatorForm() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) {
        this.owner = owner;
    }

    public BlogPostVO toVO() {
        BlogPostVO vo = new BlogPostVO();
        vo.setPostTitle(title);
        vo.setPostBody(body);
        vo.setPostPublishTime(Date.valueOf(LocalDate.now()));
        vo.setOwner(owner);
        return vo;
    }

    @Override
    public String toString() {
        return "PostCreatorForm [title=" + title + ", body=" + body + ", labels=" + ", owner=" + owner + "]";
    }

}
