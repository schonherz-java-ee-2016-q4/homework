package hu.sconherz.blog.web.login;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.Id;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String REGISTER_JSP_URL = "public/register.jsp";
    private static final String REGISTER_SUCC_JSP_URL = "secured/register_succes.jsp";
    private static final String SAVE_DIR = "Files";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegisterForm registerForm = new RegisterForm(request);
        String username = registerForm.getUsername();
        UserService userService = new UserServiceImpl();
        User user = null;
        
        try {
            userService.findUserByName(username);
            request.setAttribute("error", "This username already exists!");
            request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
        } catch (UserNotFoundException e) {
            user = createUser(registerForm, userService);
            userService.addNewUser(user);
            
            request.getSession().setAttribute("user", user);
            response.sendRedirect(REGISTER_SUCC_JSP_URL);
        }

    }

    private User createUser(RegisterForm registerForm, UserService userService) {
        User user = new User();
        
        Login login = new Login();
        login.setUsername(registerForm.getUsername());
        login.setPassword(registerForm.getPassword());
        user.setEmail(registerForm.getEmail());
        user.setLogin(login);
        
        Name name = new Name();
        name.setTitle(registerForm.getTitle());
        name.setFirst(registerForm.getFirstname());
        name.setLast(registerForm.getLastname());
        user.setName(name);
        user.setGender(registerForm.getGender());
        user.setDob(registerForm.getDob() + " 00:00:00");
        
        Location location = new Location();
        location.setState(registerForm.getState());
        location.setPostcode(registerForm.getPostcode());
        location.setCity(registerForm.getCity());
        location.setStreet(registerForm.getStreet());
        user.setLocation(location);
        
        user.setPhone(registerForm.getPhone());
        user.setCell(registerForm.getCell());
        user.setRegistered(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
        
        Picture picture = new Picture();
        picture.setLarge(registerForm.getImageurllarge());
        picture.setMedium(registerForm.getImageurlmedium());
        picture.setThumbnail(registerForm.getImageurlthumbnail());
        user.setPicture(picture);
        
        Id id = new Id();
        id.setName("");
        id.setValue("");
        user.setId(id);
        
        user.setNat("");
        
        return user;
    }

}
