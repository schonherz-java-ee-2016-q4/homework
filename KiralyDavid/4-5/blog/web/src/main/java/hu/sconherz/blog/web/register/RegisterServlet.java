package hu.sconherz.blog.web.register;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.UserVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String REGISTRATION_JSP_URL = "public/registration.jsp";
    private static final String SUCCESS_JSP_URL = "public/registration/success.jsp";
    private UserVO vo = new UserVO();
    private UserService userService = new UserServiceImpl();

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RegistrationForm regForm = new RegistrationForm(request);

        if (regForm.getEmail() == "") {
            request.setAttribute("error", "Email cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getUsername() == "") {
            request.setAttribute("error", "Username cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getPassword() == "") {
            request.setAttribute("error", "Password cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getPhone() == "") {
            request.setAttribute("error", "Phone cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getEmail() == "") {
            request.setAttribute("error", "Email cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }


        if (regForm.getFirstName() == "") {
            request.setAttribute("error", "First name cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getLastName() == "") {
            request.setAttribute("error", "Last name cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getLocation() == "") {
            request.setAttribute("error", "Location cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        if (regForm.getImg() == "") {
            request.setAttribute("error", "Image link cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }

        vo.setEmail(regForm.getEmail());
        vo.setUsername(regForm.getUsername());
        vo.setPassword(regForm.getPassword());
        vo.setPhone(regForm.getPhone());
        vo.setFirstName(regForm.getFirstName());
        vo.setLastName(regForm.getLastName());
        vo.setGender(regForm.getGender());
        vo.setDate_of_birth(regForm.getDate_of_birth());
        vo.setLocation(regForm.getLocation());
        vo.setImg(regForm.getImg());

        userService.save(vo);
        response.sendRedirect(SUCCESS_JSP_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}