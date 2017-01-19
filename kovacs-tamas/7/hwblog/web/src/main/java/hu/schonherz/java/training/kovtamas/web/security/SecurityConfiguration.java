package hu.schonherz.java.training.kovtamas.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/registration").permitAll()
                .antMatchers("/*resources/css/**").permitAll()
                .antMatchers("/*resources/js/**").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .antMatchers("/secured").access("hasRole('USER')")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/secured")
                .failureUrl("/login?error")
                .permitAll();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
