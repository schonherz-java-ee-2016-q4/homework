package hu.schonherz.blog.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogposts")
@Builder
public class BlogPostEntity extends BaseEntity {

    @Basic private String title;
    @Basic private String content;
    @Basic private Timestamp posted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity author;

    @OneToMany(mappedBy="blogPost", fetch = FetchType.EAGER)
    private Collection<PostTagEntity> postTags;
}
