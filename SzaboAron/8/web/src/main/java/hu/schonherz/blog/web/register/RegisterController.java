package hu.schonherz.blog.web.register;

import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;

@Controller
public class RegisterController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
    private static final String SUCCESS_JSP_URL = "public/registration/success";

    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public String registerUser(HttpServletRequest request) {
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
