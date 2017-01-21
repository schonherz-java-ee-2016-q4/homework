package hu.schonherz.blog.web.register;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class RegisterForm {

    private String firstName;
    private String LastName;
    private String username;
    private String password;
    private String email;
    private String gender;
    private String date_of_birth;
    private String location;
    private String phone;

    public RegisterForm(HttpServletRequest request){
        
        firstName = request.getParameter("first_name");
        LastName = request.getParameter("last_name");
        username = request.getParameter("user_name");
        password = request.getParameter("password");
        email = request.getParameter("email");
        
        gender = request.getParameter("sex");
        date_of_birth =request.getParameter("date");
        location = request.getParameter("address");
        phone = request.getParameter("phone");
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
