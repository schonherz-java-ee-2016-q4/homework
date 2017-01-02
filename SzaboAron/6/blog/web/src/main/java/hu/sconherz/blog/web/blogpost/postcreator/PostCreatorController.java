package hu.sconherz.blog.web.blogpost.postcreator;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.schonherz.blog.service.api.blogpost.service.BlogPostService;
import hu.schonherz.blog.service.api.blogpost.vo.BlogPostVO;
import hu.schonherz.blog.service.api.user.vo.UserVO;

@Controller
public class PostCreatorController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PostCreatorController.class);

    private static final String INDEX_JSP_URL = "index.jsp";

    @Autowired
    private BlogPostService service;

    @RequestMapping(path = "/PostCreator", method = RequestMethod.POST)
    public String createNewPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LOGGER.info(((UserVO) request.getSession().getAttribute("user")).getId() + "");
        request.setCharacterEncoding("UTF-8");
        LOGGER.info(request.getParameter("title"));
        LOGGER.info(request.getParameter("body"));
        service.savePost(formToVO(new PostCreatorForm(request)));
        return INDEX_JSP_URL;
    }

    private static BlogPostVO formToVO(PostCreatorForm form) {
        BlogPostVO vo = new BlogPostVO();
        vo.setPostBody(form.getBody());
        vo.setPostTitle(form.getTitle());
        vo.setPostPublishTime(Date.valueOf(LocalDate.now()));
        vo.setOwner(form.getOwner());
        System.out.println(vo.getOwner());
        return vo;
    }

}
