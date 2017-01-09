package hu.schonherz.blog.web.blogpost.model;

import lombok.*;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class PostModel {
    private int id;
    private String title;
    private String body;
    private String username;
    private Date date;

}
