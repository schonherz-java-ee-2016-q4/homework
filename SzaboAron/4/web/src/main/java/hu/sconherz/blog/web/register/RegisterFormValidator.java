package hu.sconherz.blog.web.register;

import org.apache.commons.validator.routines.EmailValidator;

public class RegisterFormValidator {

    private final RegisterForm registerForm;

    public RegisterFormValidator(RegisterForm registerForm) {
        super();
        this.registerForm = registerForm;
    }

    public boolean validateForm() {
        return validateUsername(registerForm.getUsername()) && validateFirstName(registerForm.getFirstname())
                && validateLastName(registerForm.getLastname()) && validateCountry(registerForm.getCountry())
                && validateEmail(registerForm.getEmail());
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
