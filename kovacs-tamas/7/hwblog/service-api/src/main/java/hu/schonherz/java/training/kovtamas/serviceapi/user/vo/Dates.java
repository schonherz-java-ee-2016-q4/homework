package hu.schonherz.java.training.kovtamas.serviceapi.user.vo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Dates {

    private Date birth;
    private Date registration;
    private int age;

    public Dates() {
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;

        LocalDate birthDay = birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.age = Period.between(birthDay, LocalDate.now()).getYears();
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public int getAge() {
        return age;
    }

}
