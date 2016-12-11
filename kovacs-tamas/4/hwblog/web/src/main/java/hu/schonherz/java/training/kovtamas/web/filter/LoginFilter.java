package hu.schonherz.java.training.kovtamas.web.filter;

import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/resources/pages/secure/*")
public class LoginFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig fc) throws ServletException {
        log.debug("Initializing login filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("user");
        if (user == null) {
            log.debug("User tried to proceed to the secure pages without logging in");
            ((HttpServletResponse) response).sendRedirect("resources/pages/public/login.jsp");
        } else {
            log.debug("User {} is logged in, access granted to proceed to the secure pages", user.getLogin().getUsername());
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        log.debug("Destroying login filter");
    }

}
