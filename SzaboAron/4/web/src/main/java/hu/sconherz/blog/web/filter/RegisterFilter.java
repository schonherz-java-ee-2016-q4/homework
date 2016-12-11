package hu.sconherz.blog.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;


import hu.sconherz.blog.web.register.RegisterFormValidator;

@WebFilter(filterName="RegisterFilter", urlPatterns = "/Register")
public class RegisterFilter implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Filtered");
        RegisterFormValidator validator = new RegisterFormValidator((HttpServletRequest) request);

        if (validator.isValidForm()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response)
                    .sendRedirect(request.getServletContext().getContextPath() + "/public/registration/register.jsp");
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
