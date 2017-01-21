package hu.schonherz.jee.web.view;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hu.schonherz.jee.service.client.api.service.user.UserServiceRemote;
import hu.schonherz.jee.service.client.api.vo.User;

@ManagedBean(name="registrationView")
@ViewScoped
public class RegistrationView {
    
    @EJB
    UserServiceRemote userServiceRemote;
    
    private User user;

    @PostConstruct
    public void init() {
        user = new User();
    }
    
    public void registration() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        try {
            User check = userServiceRemote.findByUsername(user.getUsername());
            if (check != null) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Registration!"));
            } else {
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String encryptedPass = bCryptPasswordEncoder.encode(user.getPassword());
                user.setPassword(encryptedPass);
                userServiceRemote.registrationUser(user);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Registration!"));
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error!", "Registration!"));
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserServiceRemote getUserServiceRemote() {
        return userServiceRemote;
    }

    public void setUserServiceRemote(UserServiceRemote userServiceRemote) {
        this.userServiceRemote = userServiceRemote;
    }
    
    
    
    
}
