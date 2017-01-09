package hu.schonherz.blog.web.register;

import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping(path = "/registration")
public class RegisterController {

    private static final String SUCCESS_JSP_URL = "public/registration/success";
    private static final String REGISTER_JSP_URL = "public/registration/register";
    // private final String UPLOAD_DIRECTORY = "C:" + File.separator +
    // "uploads";
    @Autowired
    UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String registerPage() {
        return REGISTER_JSP_URL;

    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request) throws ServletException, IOException {
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
