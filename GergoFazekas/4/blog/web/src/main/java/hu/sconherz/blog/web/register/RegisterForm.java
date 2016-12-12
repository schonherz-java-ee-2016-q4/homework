package hu.sconherz.blog.web.register;

import javax.servlet.http.HttpServletRequest;

import hu.schonherz.blog.service.api.user.vo.Id;
import hu.schonherz.blog.service.api.user.vo.Location;
import hu.schonherz.blog.service.api.user.vo.Login;
import hu.schonherz.blog.service.api.user.vo.Name;
import hu.schonherz.blog.service.api.user.vo.Picture;
import hu.schonherz.blog.service.api.user.vo.User;


public class RegisterForm {
    
    private User user;
    
    private Name name;
    private Id id;
    private Login login;
    private Location location;
    private Picture picture;
    
    public RegisterForm(HttpServletRequest request) {
        
        user = new User();
        name = new Name();
        id = new Id();
        login = new Login();
        location = new Location();
        picture = new Picture();
        user.setGender(request.getParameter("gender"));
        user.setEmail(request.getParameter("email"));
        user.setDob(request.getParameter("dob"));
        user.setPhone("-");
        user.setCell("-");
        user.setNat("-");
        user.setRegistered("-");
        name.setFirst(request.getParameter("firstname"));
        name.setLast(request.getParameter("lastname"));
        name.setTitle("-");
        user.setName(name);
        id.setName("-");
        id.setValue("-");
        user.setId(id);
        login.setMd5("-");
        login.setPassword(request.getParameter("password1"));
        login.setSalt("-");
        login.setSha1("-");
        login.setSha256("-");
        login.setUsername(request.getParameter("username"));
        user.setLogin(login);
        location.setCity(request.getParameter("city"));
        location.setPostcode(Integer.parseInt(request.getParameter("postcode")));
        location.setState(request.getParameter("state"));
        location.setStreet(request.getParameter("street"));
        user.setLocation(location);
        picture.setLarge(request.getParameter("large"));
        picture.setMedium(request.getParameter("medium"));
        picture.setThumbnail(request.getParameter("thumbnail"));
        user.setPicture(picture);
        
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
}
