package hu.schonherz.blog.web.register;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Date;

public class RegisterForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String firstname;

    private String title;

    private String lastname;

    private String password;

    private String phone;

    private String state;

    private String city;

    private String street;

    private int postcode;

    private String email;

    private Date birthDate;

    private String gender;

    public RegisterForm(HttpServletRequest request) {
        username = request.getParameter("username");
        password = request.getParameter("password");
        title = request.getParameter("title");
        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        state = request.getParameter("state");
        city = request.getParameter("city");
        street = request.getParameter("street");
        postcode = Integer.parseInt(request.getParameter("postcode"));
        email = request.getParameter("email");
        phone = request.getParameter("phone");
        birthDate = Date.valueOf(request.getParameter("date"));

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
