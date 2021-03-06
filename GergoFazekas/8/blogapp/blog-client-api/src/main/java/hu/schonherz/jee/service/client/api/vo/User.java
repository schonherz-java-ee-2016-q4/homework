package hu.schonherz.jee.service.client.api.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User extends BaseVo implements Serializable{
    
    private static final long serialVersionUID = -4915018191349852312L;

    private String firstName;
    private String lastName;
    private String gender;
    private String nationality;
    private String img;
//    Dates
    private Date dob;
    private Date registered;
//    Login
    private String email;
    private String username;
    private String password;
    private List<Role> roles;
    
    
    public User() {
        // TODO Auto-generated constructor stub
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getNationality() {
        return nationality;
    }


    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public String getImg() {
        return img;
    }


    public void setImg(String img) {
        this.img = img;
    }


    public Date getDob() {
        return dob;
    }


    public void setDob(Date dob) {
        this.dob = dob;
    }


    public Date getRegistered() {
        return registered;
    }


    public void setRegistered(Date registered) {
        this.registered = registered;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoles() {
        return roles;
    }


    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
   
}
