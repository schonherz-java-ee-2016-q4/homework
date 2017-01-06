package hu.sconherz.blog.web.register.validator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;

public class RegisterFormValidator {

    private final HttpServletRequest request;

    public RegisterFormValidator(HttpServletRequest request) {
        super();
        this.request = request;
    }

    public boolean isValidForm() {
        return validateUsername(request.getParameter("username"))
                && validateFirstName(request.getParameter("firstname"))
                && validateLastName(request.getParameter("lastname"))
                && validatePassword(request.getParameter("password"))
                && validateCountry(request.getParameter("country")) && validateEmail(request.getParameter("email"))
                && validateDate(request.getParameter("birthdate"));
    }

    private boolean validateDate(String birthdate) {
        DateValidator dateValidator = DateValidator.getInstance();
        try {
            if (dateValidator.validate(birthdate, "MM/dd/yyyy") != null) {
                System.out.println("ok");
                return true;
            }
            System.out.println("ok");
            return false;
        } catch (Exception e) {
            System.out.println("ok");
            return false;
        }

    }

    private boolean validateUsername(String userName) {
        return userName != null && userName.length() != 0 && userName.length() < 20;
    }

    private boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() != 0 && firstName.length() < 20;
    }

    private boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() != 0 && lastName.length() < 20;
    }

    private boolean validatePassword(String password) {
        return password != null && password.length() != 0 && password.length() < 20;
    }

    private boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    private boolean validateCountry(String country) {
        return country != null && country.length() != 0 && country.length() < 20;
    }
}
