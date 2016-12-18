package hu.schonherz.blog.web.login;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegisterForm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String username;
    private String email;
    private String password;
    
    private String title;
    private String firstname;
    private String lastname;
    private String gender;
    private String dob;
    
    private String state;
    private String postcode;
    private String city;
    private String street;
    private String phone;
    private String cell;
    
    private String imageurl;

    public RegisterForm(HttpServletRequest request) {
        username = request.getParameter("username");
        email = request.getParameter("email");
        password = request.getParameter("password");
        
        title = request.getParameter("title");
        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        gender = request.getParameter("gender");
        dob = request.getParameter("dob");
        
        state = request.getParameter("state");
        postcode = request.getParameter("postcode");
        city = request.getParameter("city");
        street = request.getParameter("street");
        phone = request.getParameter("phone");
        cell = request.getParameter("cell");
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
    
    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
