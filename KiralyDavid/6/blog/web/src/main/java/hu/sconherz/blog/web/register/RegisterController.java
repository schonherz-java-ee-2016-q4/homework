package hu.sconherz.blog.web.register;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

@Controller
public class RegisterController {

    private static final String SUCCESS_JSP_URL = "public/registration/success.jsp";
    // private final String UPLOAD_DIRECTORY = "C:" + File.separator +
    // "uploads";
    @Autowired
    UserService userService;

    @RequestMapping(path = "/Register", method = RequestMethod.POST)
    protected String registerUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userService.saveUser(buildUserFromRequest(request));
        return SUCCESS_JSP_URL;
    }

    private UserVO buildUserFromRequest(HttpServletRequest request) {
        UserVO user = new UserVO();
        user.setCity(request.getParameter("city"));
        user.setState(request.getParameter("state"));
        user.setStreet(request.getParameter("street"));
        user.setNameTitle(request.getParameter("title"));
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));
        user.setEmail(request.getParameter("email"));
        user.setGender(request.getParameter("gender"));
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password"));
        user.setPostcode(Integer.parseInt(request.getParameter("postcode")));
        user.setDateOfBirth(Date.valueOf(request.getParameter("birthdate")));
        user.setRegistered(Date.valueOf(LocalDate.now()));
        user.setUsername(request.getParameter("username"));
        user.setLargePic("");
        user.setMediumPic("");
        user.setThumbnailPic("");
        return user;
    }
}
