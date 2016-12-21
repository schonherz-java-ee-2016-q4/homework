package hu.schonherz.blog.web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVo;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        UserVo user;
        try {
            user = userService.findUserByUsername(username);
            
            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            List<GrantedAuthority> authorities = buildUserAuthority(user);
            return buildUserForAuthentication(user, authorities);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    private User buildUserForAuthentication(UserVo user,
            List<GrantedAuthority> authorities) {
        return new User(user.getLogin().getUsername(), user.getLogin().getPassword(), authorities);
    }
    
    private List<GrantedAuthority> buildUserAuthority(UserVo user) {
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
    	
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (String userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
                setAuths);

        return Result;
    }
}