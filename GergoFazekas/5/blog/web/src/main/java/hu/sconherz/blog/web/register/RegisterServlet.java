package hu.sconherz.blog.web.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private static final String LOGIN_JSP_URL = "public/login.jsp";
	private static final String REGISTER_JSP_URL = "public/register.jsp";
	private static final String REGSUCCESS_JSP_URL = "secured/regsuccess.jsp";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher(REGISTER_JSP_URL).forward(request, response);
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RegisterForm registerForm = new RegisterForm(request);
	    UserVO userVO = toVO(registerForm);
	    UserService userService = new UserServiceImpl();
	    userService.add(userVO);
	    request.getSession().setAttribute("user", userVO);
        response.sendRedirect(REGSUCCESS_JSP_URL);
	}
	
	private static UserVO toVO(RegisterForm registerForm) {
	    UserVO userVO = new UserVO();
        userVO.setFirstName(registerForm.getFirstName());
        userVO.setLastName(registerForm.getLastName());
        userVO.setEmail(registerForm.getEmail());
        userVO.setUsername(registerForm.getUsername());
        userVO.setPassword(registerForm.getPassword());
        userVO.setPhone(registerForm.getPhone());
        userVO.setGender(registerForm.getGender());
        userVO.setDob(registerForm.getDob());
        userVO.setRegistered(registerForm.getRegistered());
        userVO.setPostcode(registerForm.getPostcode());
        userVO.setStreet(registerForm.getStreet());
        userVO.setState(registerForm.getState());
        userVO.setCity(registerForm.getCity());
        userVO.setLargePicture(registerForm.getLargePicture());
        userVO.setMediumPicture(registerForm.getMediumPicture());
        userVO.setThumbnail(registerForm.getThumbnail());
        return userVO;
	}

}
