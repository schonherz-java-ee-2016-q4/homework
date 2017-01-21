package hu.schonherz.jee.web.security.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.schonherz.jee.service.client.api.service.user.UserServiceRemote;
import hu.schonherz.jee.service.client.api.vo.Role;
import hu.schonherz.jee.service.client.api.vo.User;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @EJB
    UserServiceRemote userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        User user;
        try {
            user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

            return buildUserForAuthentication(user, authorities);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}