package hu.sconherz.blog.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "RegisterFilter", urlPatterns = "/Register")
public class RegisterFilter implements Filter {

    private static final String REGISTER_JSP_URL = "public/registration/register.jsp";

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // RegisterFormValidator validator = new
        // RegisterFormValidator((HttpServletRequest) request);
        //
        // if (validator.isValidForm()) {
        // chain.doFilter(request, response);
        // } else {
        // request.setAttribute("error", "Incorrect data");
        // request.getRequestDispatcher(REGISTER_JSP_URL).forward(request,
        // response);
        // }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
