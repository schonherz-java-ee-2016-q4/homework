package hu.schonherz.java.training.kovtamas.web.form;

import javax.servlet.http.HttpServletRequest;

public class RegistrationForm {

    private String username;
    private String password;
    private String confirmPassword;

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

    private RegistrationForm() {
    }

    public static RegistrationForm fromRequest(HttpServletRequest request) {
        RegistrationForm form = new RegistrationForm();
        form.username = request.getParameter("username");
        form.password = request.getParameter("password");
        form.confirmPassword = request.getParameter("confirmPassword");
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

        return form;
    }

    public boolean hasNullOrEmpty() {
        if (hasNull()) {
            return true;
        }

        return username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0
                || firstName.length() == 0 || lastName.length() == 0 || email.length() == 0
                || title.length() == 0 || gender.length() == 0 || dob.length() == 0
                || state.length() == 0 || postCode.length() == 0 || city.length() == 0
                || street.length() == 0 || phone.length() == 0 || cell.length() == 0;
    }

    private boolean hasNull() {
        return username == null || password == null || confirmPassword == null || firstName == null
                || lastName == null || email == null || title == null || gender == null || dob == null
                || state == null || postCode == null || city == null || street == null || phone == null || cell == null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
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

    @Override
    public String toString() {
        return "RegistrationForm{" + "username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", dob=" + dob + ", title=" + title + ", state=" + state + ", postCode=" + postCode + ", city=" + city + ", street=" + street + ", phone=" + phone + ", cell=" + cell + '}';
    }

}
