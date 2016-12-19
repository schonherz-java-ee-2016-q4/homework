package hu.schonherz.java.training.kovtamas.serviceapi.user.oldvo;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class User {

    @Expose
    private String gender;
    @Expose
    private Name name;
    @Expose
    private Location location;
    @Expose
    private String email;
    @Expose
    private Login login;
    @Expose
    private String dob;
    @Expose
    private String registered;
    @Expose
    private String phone;
    @Expose
    private String cell;
    @Expose
    private Id id;
    @Expose
    private Picture picture;
    @Expose
    private String nat;

    private User(String gender, Name name, Location location, String email, Login login,
            String dob, String registered, String phone, String cell, Id id, Picture picture, String nat) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.id = id;
        this.picture = picture;
        this.nat = nat;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    /**
     * Builder for the User VO
     */
    public static class UserBuilder {

        private String gender = null;
        private Name name = null;
        private Location location = null;
        private String email = null;
        private Login login = null;
        private String dob = null;
        private String registered = null;
        private String phone = null;
        private String cell = null;
        private Id id = null;
        private Picture picture = null;
        private String nat = null;

        private UserBuilder() {
        }

        public UserBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder name(Name name) {
            this.name = name;
            return this;
        }

        public UserBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder login(Login login) {
            this.login = login;
            return this;
        }

        public UserBuilder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public UserBuilder registered(String registered) {
            this.registered = registered;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder cell(String cell) {
            this.cell = cell;
            return this;
        }

        public UserBuilder Id(Id id) {
            this.id = id;
            return this;
        }

        public UserBuilder picture(Picture picture) {
            this.picture = picture;
            return this;
        }

        public UserBuilder nat(String nat) {
            this.nat = nat;
            return this;
        }

        public User build() {
            return new User(gender, name, location, email, login, dob, registered, phone, cell, id, picture, nat);
        }
    }

    /**
     *
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return The name
     */
    public Name getName() {
        return name;
    }

    /**
     *
     * @param name The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     *
     * @return The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return The login
     */
    public Login getLogin() {
        return login;
    }

    /**
     *
     * @param login The login
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     *
     * @return The dob
     */
    public String getDob() {
        return dob;
    }

    /**
     *
     * @param dob The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     *
     * @return The registered
     */
    public String getRegistered() {
        return registered;
    }

    /**
     *
     * @param registered The registered
     */
    public void setRegistered(String registered) {
        this.registered = registered;
    }

    /**
     *
     * @return The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return The cell
     */
    public String getCell() {
        return cell;
    }

    /**
     *
     * @param cell The cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    /**
     *
     * @return The id
     */
    public Id getId() {
        return id;
    }

    /**
     *
     * @param id The id
     */
    public void setId(Id id) {
        this.id = id;
    }

    /**
     *
     * @return The picture
     */
    public Picture getPicture() {
        return picture;
    }

    /**
     *
     * @param picture The picture
     */
    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    /**
     *
     * @return The nat
     */
    public String getNat() {
        return nat;
    }

    /**
     *
     * @param nat The nat
     */
    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public String toString() {
        return "User{" + "gender=" + gender + ", name=" + name + ", location=" + location + ", email=" + email + ", login=" + login + ", dob=" + dob + ", registered=" + registered + ", phone=" + phone + ", cell=" + cell + ", id=" + id + ", picture=" + picture + ", nat=" + nat + '}';
    }

}
