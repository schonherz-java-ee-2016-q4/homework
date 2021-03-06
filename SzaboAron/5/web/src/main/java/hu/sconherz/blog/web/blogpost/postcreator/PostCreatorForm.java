package hu.sconherz.blog.web.blogpost.postcreator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hu.schonherz.blog.service.api.user.vo.UserVO;

public class PostCreatorForm {
    private String title;

    private String body;

    private List<String> labels;

    private UserVO owner;

    public PostCreatorForm(HttpServletRequest request) {
        this.title = request.getParameter("title");
        this.body = request.getParameter("body");
        this.labels = new ArrayList<>();
        // labels.addAll(Arrays.asList(request.getParameter("labels").split(";")));
        owner = (UserVO) request.getSession().getAttribute("user");
        System.out.println(owner);
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

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "PostCreatorForm [title=" + title + ", body=" + body + ", labels=" + labels + ", owner=" + owner + "]";
    }

}
