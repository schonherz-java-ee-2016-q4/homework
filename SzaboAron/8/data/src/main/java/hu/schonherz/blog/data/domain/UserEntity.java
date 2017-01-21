package hu.schonherz.blog.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Áron on 2017. 01. 21..
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    private String email;
    @Column(name = "dateofbirth")
    private Date dateOfBirth;
    private Date registered;
    private String phone;
    private String street;
    private String city;
    private String state;
    private Integer postcode;
    @Column(name = "name_title")
    private String nameTitle;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    private String username;
    private String password;
    @Column(name = "large_pic")
    private String largePic;
    @Column(name = "medium_pic")
    private String mediumPic;
    @Column(name = "thumbnail_pic")
    private String thumbnailPic;
    @Column(name = "User_role")
    private String role;
    @Column(name = "enabled")
    private Boolean active;

}
