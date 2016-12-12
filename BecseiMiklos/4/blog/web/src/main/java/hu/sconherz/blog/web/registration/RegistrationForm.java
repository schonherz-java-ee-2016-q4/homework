package hu.sconherz.blog.web.registration;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String username;
	private String password;
	private String phone;
	private String title;
	private String first;
	private String last;
	private String street;
	private String city;
	private String state;
	private String postcode;

	public RegistrationForm() {

	}

	public RegistrationForm(HttpServletRequest request) {

		email = request.getParameter("email");
		username = request.getParameter("username");
		password = request.getParameter("password");
		phone = request.getParameter("phone");
		title = request.getParameter("title");
		first = request.getParameter("first");
		last = request.getParameter("last");
		street = request.getParameter("street");
		city = request.getParameter("city");
		state = request.getParameter("state");
		postcode = request.getParameter("postcode");

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

}
