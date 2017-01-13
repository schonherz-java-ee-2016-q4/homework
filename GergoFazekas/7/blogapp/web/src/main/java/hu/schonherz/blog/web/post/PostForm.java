package hu.schonherz.blog.web.post;

import hu.schonherz.blog.service.user.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Geri on 2017. 01. 04..
 */
public class PostForm {

    private String title;
    private String content;
    private Date published;
    private int authorID;

    public PostForm(HttpServletRequest req) {
        title = req.getParameter("title");
        content = req.getParameter("content");
        published = new Date(Calendar.getInstance().getTime().getTime());
        HttpSession session = req.getSession(true);
        UserVO userVO = (UserVO)session.getAttribute("user");
        authorID = userVO.getId();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPublished() {
        return published;
    }

    public int getAuthorID() {
        return authorID;
    }
}
