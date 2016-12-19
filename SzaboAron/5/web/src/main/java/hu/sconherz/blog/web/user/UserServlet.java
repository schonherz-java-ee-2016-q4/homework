package hu.sconherz.blog.web.user;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hu.schonherz.blog.service.UserServiceImpl;
import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 7157138471151322569L;
    private final UserService userService = new UserServiceImpl();
    private final Gson GSON = new Gson();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserVO> users = userService.findAllUser();
        if (!request.getParameterMap().isEmpty()) {
            users = scanUserList(request, users);
        }
        String resultJson = GSON.toJson(users);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(resultJson);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    private List<UserVO> scanUserList(HttpServletRequest request, List<UserVO> userList) {
        if (!"".equals(request.getParameter("email"))) {
            userList = userList.stream().filter(user -> user.getEmail().equals(request.getParameter("email")))
                    .collect(Collectors.toList());
        }
        if (!"".equals(request.getParameter("city"))) {
            userList = userList.stream().filter(user -> user.getCity().equals(request.getParameter("city")))
                    .collect(Collectors.toList());
        }
        return userList;
    }
}
