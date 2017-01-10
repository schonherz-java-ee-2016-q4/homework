package hu.schonherz.blog.web;

import hu.schonherz.blog.service.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.user.service.UserService;
import hu.schonherz.blog.service.user.vo.UserVO;
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

/**
 * Created by Geri on 2017. 01. 08..
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserVO userVO;
        try {
            userVO = userService.findByUsername(username);
            List<GrantedAuthority> authorities = buildUserAuthority(userVO);
            return buildUserForAuthentication(userVO, authorities);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

    }

    private User buildUserForAuthentication(UserVO userVO, List<GrantedAuthority> authorities) {
        return new User(userVO.getUsername(), userVO.getPassword(), userVO.getActive(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(UserVO userVO) {
        List<String> userRoles = new ArrayList<>();
        if ("user".equals(userVO.getRole())) {
            userRoles.add("ROLE_USER");
        }
        if ("admin".equals(userVO.getRole())) {
            userRoles.add("ROLE_USER");
            userRoles.add("ROLE_ADMIN");
        }
        Set<GrantedAuthority> setAuths = new HashSet<>();
        for(String userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole));
        }
        return new ArrayList<>(setAuths);
    }
}
