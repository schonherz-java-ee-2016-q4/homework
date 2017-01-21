package hu.schonherz.blog.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "blogpost",schema = "public")
public class PostEntity extends BaseEntity {
    private String name;
    private String title;
    @Column(name = "textarea")
    private String textArea;
    @Column(name = "my_date")
    private Date date;
}
