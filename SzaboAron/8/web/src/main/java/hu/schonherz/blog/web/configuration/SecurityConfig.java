package hu.schonherz.blog.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/public/login/login.jsp").loginProcessingUrl("/login").defaultSuccessUrl
                ("/index.jsp").failureUrl("/public/login/login.jsp?error=true")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/public/login/login.jsp?logout=true")
                .and()
                .exceptionHandling().accessDeniedPage("/public/login/denied.jsp")
                .and()
                .csrf().disable();

        http.authorizeRequests()
                .antMatchers("/secured/**").access("hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/public/login/login.jsp").loginProcessingUrl("/login").defaultSuccessUrl
                ("/index.jsp").failureUrl("/public/login/login.jsp?error=true")
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/public/login/login.jsp?logout=true")
                .and()
                .exceptionHandling().accessDeniedPage("/public/login/denied.jsp")
                .and()
                .csrf().disable();
    }
}

