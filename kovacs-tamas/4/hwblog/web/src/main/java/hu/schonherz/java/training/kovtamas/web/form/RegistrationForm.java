package hu.schonherz.java.training.kovtamas.web.form;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;

    private String gender;
    private String dob;

    private String title;

    private String state;
    private String postCode;
    private String city;
    private String street;

    private String phone;
    private String cell;

    private String imageUrl;

    private RegistrationForm() {
    }

    public static RegistrationForm fromRequest(HttpServletRequest request) {
        RegistrationForm form = new RegistrationForm();
        form.username = request.getParameter("username");
        form.password = request.getParameter("password");
        form.firstName = request.getParameter("firstName");
        form.lastName = request.getParameter("lastName");
        form.email = request.getParameter("email");
        form.title = request.getParameter("title");
        form.gender = request.getParameter("gender");
        form.dob = request.getParameter("dob");
        form.state = request.getParameter("state");
        form.postCode = request.getParameter("postCode");
        form.city = request.getParameter("city");
        form.street = request.getParameter("street");
        form.phone = request.getParameter("phone");
        form.cell = request.getParameter("cell");
        form.imageUrl = request.getParameter("imageUrl");

        return form;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getState() {
        return state;
    }

    public String getPostcode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public String getImageurl() {
        return imageUrl;
    }

}
