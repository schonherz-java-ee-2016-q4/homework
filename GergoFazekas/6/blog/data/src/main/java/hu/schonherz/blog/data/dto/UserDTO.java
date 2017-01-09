package hu.schonherz.blog.data.dto;

import java.sql.Date;

public class UserDTO {
    
    private int id;
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
    
    public UserDTO() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getLargePicture() {
        return largePicture;
    }

    public void setLargePicture(String largePicture) {
        this.largePicture = largePicture;
    }

    public String getMediumPicture() {
        return mediumPicture;
    }

    public void setMediumPicture(String mediumPicture) {
        this.mediumPicture = mediumPicture;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDTO [id=");
        builder.append(id);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", email=");
        builder.append(email);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", dob=");
        builder.append(dob);
        builder.append(", registered=");
        builder.append(registered);
        builder.append(", postcode=");
        builder.append(postcode);
        builder.append(", street=");
        builder.append(street);
        builder.append(", state=");
        builder.append(state);
        builder.append(", city=");
        builder.append(city);
        builder.append(", largePicture=");
        builder.append(largePicture);
        builder.append(", mediumPicture=");
        builder.append(mediumPicture);
        builder.append(", thumbnail=");
        builder.append(thumbnail);
        builder.append("]");
        return builder.toString();
    }
    
    
}
