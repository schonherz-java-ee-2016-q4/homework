package hu.sconherz.blog.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import hu.sconherz.blog.web.blogpost.postcreator.validator.PostCreatorFormValidator;

@WebFilter(filterName = "POstCreatorFilter", urlPatterns = "/PostCreator")
public class PostCreatorFilter implements Filter {

    private static final String INDEX_JSP_URL = "index.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        PostCreatorFormValidator validator = new PostCreatorFormValidator((HttpServletRequest) request);
        if (!validator.isValidForm()) {
            request.setAttribute("error", "Incorrect data");
            request.getRequestDispatcher(INDEX_JSP_URL).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
