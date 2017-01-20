package hu.schonherz.blog.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "member", schema = "public")
public class UserEntity extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String gender;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    private String location;
    private String phone;
    private String img;
}