package hu.sconherz.blog.web.registration;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String gender;
	private String date_of_birth;
	private String location;
	private String phone;
	private String img;

	public RegistrationForm() {}

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public RegistrationForm(HttpServletRequest request) {

		email = request.getParameter("email");
		username = request.getParameter("username");
		password = request.getParameter("password");
		phone = request.getParameter("phone");
		firstName = request.getParameter("first");
		lastName = request.getParameter("last");
		gender = request.getParameter("gender");
        date_of_birth = request.getParameter("date_of_birth");
        location = request.getParameter("location");
        img = request.getParameter("img");

	}

}
