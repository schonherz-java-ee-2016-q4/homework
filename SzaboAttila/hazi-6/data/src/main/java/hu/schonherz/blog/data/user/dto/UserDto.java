package hu.schonherz.blog.data.user.dto;

import java.sql.Date;

public class UserDto {
    private int id;
    private String email;
    private Date dob;
    private Date registered;
    private String phone;
    private String cell;
    private String gender;
    
    public UserDto() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserDTO [id=");
        builder.append(id);
        builder.append(", email=");
        builder.append(email);
        builder.append(", dob=");
        builder.append(dob);
        builder.append(", registered=");
        builder.append(registered);
        builder.append(", phone=");
        builder.append(phone);
        builder.append(", cell=");
        builder.append(cell);
        builder.append(", gender=");
        builder.append(gender);
        builder.append("]");
        return builder.toString();
    }
    
    
}
