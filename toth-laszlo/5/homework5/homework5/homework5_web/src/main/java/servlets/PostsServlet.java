package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import homework5_service.services.PostService;
import homework5_service.vo.PostVO;

/**
 * Servlet implementation class PostsServlet
 */
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PostService service = new PostService();
        Collection<PostVO> posts = new ArrayList<>();
        PrintWriter out = response.getWriter();
        PostVO vo = new PostVO();
        if(request.getParameter("post_id")==null){
            posts= service.findAll();
            Gson gson = new Gson();
            String results=gson.toJson(posts);
        
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(results);
        }
        else{
            vo=service.findById(Integer.valueOf(request.getParameter("post_id")));
            out.write("<h1 align=\"center\">"+vo.getHeader()+"</h1>");
            out.write("<h2 align=\"center\">"+vo.getText()+"</h2>");
            out.write("<h2 align=\"center\">"+vo.getDate()+"</h2>");
            out.write("<h2 align=\"center\">"+vo.getUsername()+"</h2>");
            out.write("<h3 align=\"center\">");
            for(String tag : vo.getTags()){
                out.write(tag + " ");
            }
            out.write("</h3>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
