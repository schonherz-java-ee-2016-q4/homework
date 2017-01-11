package hu.schonherz.blog.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posttags")
public class PostTagEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name="blogpost_id" /*referencedColumnName="CUST_ID"*/)
    private BlogPostEntity blogPost;

    @Basic private String tag;
}
