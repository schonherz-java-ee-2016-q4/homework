package hu.schonherz.blog.web.configuration;

import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserVO user = service.findUserByName(username);
        System.out.println("user: " + user.getFirstName());
        System.out.println("service: " + service == null ? "null" : "not null");
        List<GrantedAuthority> authorities = buildUserAuthority(user);
        return buildUserForAuthentication(user, authorities);

    }

    private User buildUserForAuthentication(UserVO user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(UserVO user) {
        List<String> userRoles = new ArrayList<>();

        if ("user".equals(user.getRole())) {
            userRoles.add("ROLE_USER");
        }
        if ("moderator".equals(user.getRole())) {
            userRoles.add("ROLE_USER");
            userRoles.add("ROLE_MOD");
        }
        if ("admin".equals(user.getRole())) {

            userRoles.add("ROLE_USER");
            userRoles.add("ROLE_MOD");
            userRoles.add("ROLE_ADMIN");
        }
        Set<GrantedAuthority> setAuths = new HashSet<>();

        for (String userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole));
        }

        List<GrantedAuthority> result = new ArrayList<>(setAuths);

        return result;
    }
}
