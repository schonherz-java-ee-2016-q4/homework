package hu.schonherz.blog.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity {
    @Basic private String email;
    @Basic private Date dob;
    @Basic private Date registered;
    @Basic private String phone;
    @Basic private String cell;
    @Basic private String gender;
    @Basic private String role;
    @Basic private boolean active;

    @Basic private String title;
    @Basic private String first;
    @Basic private String last;

    @Basic private String street;
    @Basic private String city;
    @Basic private String state;
    @Basic private int postcode;

    @Basic private String username;
    @Basic private String password;

    @Column(name = "large_image") private String largeImage;
    @Column(name = "medium_image") private String mediumImage;
    @Column(name = "thumbnail_image") private String thumbnailImage;

}
