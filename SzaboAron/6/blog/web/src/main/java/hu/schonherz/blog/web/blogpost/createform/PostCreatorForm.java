package hu.schonherz.blog.web.blogpost.createform;

import hu.schonherz.blog.service.api.user.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

public class PostCreatorForm {
    private String title;

    private String body;

    private UserVO owner;

    public PostCreatorForm(HttpServletRequest request) {
        this.title = request.getParameter("title");
        this.body = request.getParameter("body");

        owner = (UserVO) request.getSession().getAttribute("user");
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

    @Override
    public String toString() {
        return "PostCreatorForm [title=" + title + ", body=" + body + ", labels=" + ", owner=" + owner + "]";
    }

}
