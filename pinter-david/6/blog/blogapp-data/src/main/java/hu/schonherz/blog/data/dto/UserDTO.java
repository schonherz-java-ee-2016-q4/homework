/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.data.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Integer id;
    //basic info
    private String gender;
    private String titleName;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    //pic
    private String smallPicURL;
    private String mediumPicURL;
    private String largePicURL;
    
    //location
    private String nationality;
    private String stateName;
    private String city;
    private String street;
    private String postCode;
    
    //account info
    private String userName;
    private String pass;
    private Date regDate;
    
}
