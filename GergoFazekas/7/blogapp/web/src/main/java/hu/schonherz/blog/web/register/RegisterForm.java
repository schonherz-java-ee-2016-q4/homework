package hu.schonherz.blog.web.register;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;

/**
 * Created by Geri on 2017. 01. 04..
 */
public class RegisterForm {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String phone;
    private String gender;
    private Date dob;
    private Date registered;
    private int postcode;
    private String street;
    private String state;
    private String city;
    private String largePicture;
    private String mediumPicture;
    private String thumbnail;

    public RegisterForm(HttpServletRequest request) {
        firstName = request.getParameter("firstname");
        lastName = request.getParameter("lastname");
        email = request.getParameter("email");
        username = request.getParameter("username");
        password = request.getParameter("password1");
        phone = "061111000001";
        gender = request.getParameter("gender");
        dob = toDobDate(request.getParameter("dob"));
        registered = new Date(Calendar.getInstance().getTime().getTime());
        postcode = Integer.parseInt(request.getParameter("postcode"));
        street = request.getParameter("street");
        state = request.getParameter("state");
        city = request.getParameter("city");
        largePicture = request.getParameter("large");
        mediumPicture = request.getParameter("medium");
        thumbnail = request.getParameter("thumbnail");
    }

    private static Date toDobDate(String date) {
        String[] tokens = date.split("/");
        String formattedDate = tokens[2].concat("-").concat(tokens[0]).concat("-").concat(tokens[1]);
        return Date.valueOf(formattedDate);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public Date getRegistered() {
        return registered;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getLargePicture() {
        return largePicture;
    }

    public String getMediumPicture() {
        return mediumPicture;
    }

    public String getThumbnail() {
        return thumbnail;
    }

}