package hu.sconherz.blog.web.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String REGISTRATION_JSP_URL = "public/registration.jsp";

    public RegistrationServlet() {
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
        
        if (regForm.getTitle() == "") {
            request.setAttribute("error", "Title cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
        
        if (regForm.getFirst() == "") {
            request.setAttribute("error", "First name cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
        
        if (regForm.getLast() == "") {
            request.setAttribute("error", "Last name cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
        
        if (regForm.getStreet() == "") {
            request.setAttribute("error", "Street cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
        
        if (regForm.getCity() == "") {
            request.setAttribute("error", "City cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
        
        if (regForm.getState() == "") {
            request.setAttribute("error", "State cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
        
        if (regForm.getPostcode() == "") {
            request.setAttribute("error", "Postcode cannot be blank!");
            request.getRequestDispatcher(REGISTRATION_JSP_URL).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
