package hu.schonherz.blog.service.api.user.vo;

import java.sql.Date;

import hu.schonherz.blog.data.dto.UserDTO;

public class UserVO {
    private int id;
    private String email;
    private Date dateOfBirth;
    private Date registered;
    private String phone;
    private String street;
    private String city;
    private String state;
    private Integer postcode;
    private String nameTitle;
    private String firstName;
    private String lastName;
    private String gender;
    private String username;
    private String password;
    private String largePic;
    private String mediumPic;
    private String thumbnailPic;

    public static UserVO toVO(UserDTO userDTO) {
        UserVO user = new UserVO();
        user.setCity(userDTO.getCity());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setGender(userDTO.getGender());
        user.setId(userDTO.getId());
        user.setLargePic(userDTO.getLargePic());
        user.setLastName(userDTO.getLastName());
        user.setMediumPic(userDTO.getMediumPic());
        user.setNameTitle(userDTO.getNameTitle());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setPostcode(userDTO.getPostcode());
        user.setRegistered(userDTO.getRegistered());
        user.setState(userDTO.getState());
        user.setStreet(userDTO.getStreet());
        user.setThumbnailPic(userDTO.getThumbnailPic());
        user.setUsername(userDTO.getUsername());
        return user;
    }

    public static UserDTO toDTO(UserVO userVO) {
        UserDTO user = new UserDTO();
        user.setCity(userVO.getCity());
        user.setDateOfBirth(userVO.getDateOfBirth());
        user.setEmail(userVO.getEmail());
        user.setFirstName(userVO.getFirstName());
        user.setGender(userVO.getGender());
        user.setId(userVO.getId());
        user.setLargePic(userVO.getLargePic());
        user.setLastName(userVO.getLastName());
        user.setMediumPic(userVO.getMediumPic());
        user.setNameTitle(userVO.getNameTitle());
        user.setPassword(userVO.getPassword());
        user.setPhone(userVO.getPhone());
        user.setPostcode(userVO.getPostcode());
        user.setRegistered(userVO.getRegistered());
        user.setState(userVO.getState());
        user.setStreet(userVO.getStreet());
        user.setThumbnailPic(userVO.getThumbnailPic());
        user.setUsername(userVO.getUsername());
        return user;
    }

    public UserVO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getLargePic() {
        return largePic;
    }

    public void setLargePic(String largePic) {
        this.largePic = largePic;
    }

    public String getMediumPic() {
        return mediumPic;
    }

    public void setMediumPic(String mediumPic) {
        this.mediumPic = mediumPic;
    }

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserVO [id=");
        builder.append(id);
        builder.append(", email=");
        builder.append(email);
        builder.append(", dateOfBirth=");
        builder.append(dateOfBirth);
        builder.append(", registered=");
        builder.append(registered);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", street=");
        builder.append(street);
        builder.append(", city=");
        builder.append(city);
        builder.append(", state=");
        builder.append(state);
        builder.append(", postcode=");
        builder.append(postcode);
        builder.append(", nameTitle=");
        builder.append(nameTitle);
        builder.append(", firstName=");
        builder.append(firstName);
        builder.append(", lastName=");
        builder.append(lastName);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", largePic=");
        builder.append(largePic);
        builder.append(", mediumPic=");
        builder.append(mediumPic);
        builder.append(", thumbnailPic=");
        builder.append(thumbnailPic);
        builder.append("]");
        return builder.toString();
    }

}
