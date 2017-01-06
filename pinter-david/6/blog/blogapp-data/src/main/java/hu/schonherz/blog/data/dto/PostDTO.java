/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDTO {
    private int id;
    private UserDTO user;
    private String title;
    private String content;
}
