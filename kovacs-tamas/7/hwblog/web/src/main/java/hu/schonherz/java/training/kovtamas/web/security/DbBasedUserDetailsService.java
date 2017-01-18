package hu.schonherz.java.training.kovtamas.web.security;

import hu.schonherz.java.training.kovtamas.serviceapi.user.exception.UserNotFoundException;
import hu.schonherz.java.training.kovtamas.serviceapi.user.service.UserService;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("dbBasedUserDetailsService")
public class DbBasedUserDetailsService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(DbBasedUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserVo userVo = userService.findUserByName(username);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            return new User(userVo.getLogin().getUsername(), userVo.getLogin().getPassword(), authorities);
        } catch (UserNotFoundException unfe) {
            String exMessage = "username '" + username + "' is not found in the database!";
            LOG.warn(exMessage, unfe);
            throw new UsernameNotFoundException(exMessage, unfe);
        }
    }

}
