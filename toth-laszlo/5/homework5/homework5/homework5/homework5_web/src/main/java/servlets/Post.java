package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework5_service.services.PostService;
import homework5_service.vo.PostVO;

/**
 * Servlet implementation class Post
 */
public class Post extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Post() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostVO postVO = new PostVO();
        PostService service = new PostService();
        postVO.setHeader(request.getParameter("header"));
        postVO.setText(request.getParameter("text"));
        postVO.setUsername((String)request.getSession().getAttribute("user"));
        Date date = new Date();
        postVO.setDate(date.toString());
        String tags=(String)request.getParameter("tags");
        postVO.setTags(tags.split(","));
        service.save(postVO);
        response.sendRedirect(request.getServletContext().getContextPath()+"/index.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
