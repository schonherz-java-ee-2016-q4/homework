package hu.sconherz.blog.web.register;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    private static final long serialVersionUID = 1L;
    private static final String LOGIN_JSP_URL = "public/login.jsp";
    private static final String INDEX_JSP_URL = "index.jsp";
    private static final String SUCCESS_JSP_URL = "public/registration/success.jsp";
    private final String UPLOAD_DIRECTORY = "C:" + File.separator + "uploads";

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        userService.saveUser(buildUserFromRequest(request));
        response.sendRedirect(SUCCESS_JSP_URL);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
