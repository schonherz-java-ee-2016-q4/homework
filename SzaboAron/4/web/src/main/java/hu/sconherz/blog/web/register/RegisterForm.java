package hu.sconherz.blog.web.register;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

public class RegisterForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String country;

    private String email;

    private LocalDate birthDate;

    public RegisterForm() {

    }

    public RegisterForm(HttpServletRequest request) {
        username = request.getParameter("username");
        password = request.getParameter("password");
        firstname = request.getParameter("firstname");
        lastname = request.getParameter("lastname");
        country = request.getParameter("country");
        email = request.getParameter("email");
        final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        birthDate = LocalDate.parse(request.getParameter("birthdate"), dateFormatter);
        System.out.println(birthDate);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

}
