package hu.schonherz.jee.service.start;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import hu.schonherz.jee.service.client.api.service.role.RoleServiceRemote;
import hu.schonherz.jee.service.client.api.vo.Role;

@Startup
@Singleton
public class StartUpBean {
    
    private static final String ROLE_USER = "ROLE_USER";
    
    @EJB
    RoleServiceRemote roleServiceRemote;
    
    @PostConstruct
    public void init() {
        Role role = roleServiceRemote.findByName(ROLE_USER);
        if (role == null) {
            Role userRole = new Role();
            userRole.setName(ROLE_USER);
            roleServiceRemote.save(userRole);
        }
    }
}
