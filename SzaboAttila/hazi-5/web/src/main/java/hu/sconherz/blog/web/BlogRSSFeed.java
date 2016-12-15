package hu.sconherz.blog.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

import hu.schonherz.blog.service.BlogServiceImpl;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;
import hu.schonherz.blog.service.api.service.BlogService;

@WebServlet("/BlogRSSFeed")
public class BlogRSSFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BlogService blogService = new BlogServiceImpl();
        List<BlogPost> blogPosts = blogService.getAllBlogPostHeader();
        
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("rss_2.0");

        feed.setTitle("Blog Posts");
        String linkHome = request.getScheme() + "://" + request.getServerName() +
                    ":" + request.getServerPort() +
                    request.getContextPath() + "/index.jsp";
        feed.setLink(linkHome);
        feed.setDescription("Blog posts RSS feed.");

        List<SyndEntry> entries = new ArrayList<>();
        
        for (BlogPost blogPost : blogPosts) {
            SyndEntry entry;
    
            entry = new SyndEntryImpl();
            entry.setTitle(blogPost.getTitle());
            String url = request.getScheme() + "://" + request.getServerName() +
                    ":" + request.getServerPort() +
                    request.getContextPath() +
                    "/secured/post.jsp?id=" + blogPost.getId();
            entry.setLink(url);
            
            try {
                entry.setPublishedDate(new SimpleDateFormat("yyyy.MM.dd kk:mm").parse(blogPost.getPosted()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            entries.add(entry);
        }
        
        feed.setEntries(entries);

        SyndFeedOutput output = new SyndFeedOutput();
        String out = "";
        try {
            out = output.outputString(feed);
        } catch (FeedException e) {
            e.printStackTrace();
        }
	    
	    response.setCharacterEncoding("UTF-8");
        response.setContentType("application/rss+xml");	    
        response.getWriter().write(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
