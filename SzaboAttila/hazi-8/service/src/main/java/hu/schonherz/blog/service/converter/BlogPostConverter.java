package hu.schonherz.blog.service.converter;

import hu.schonherz.blog.data.domain.BlogPostEntity;
import hu.schonherz.blog.data.domain.PostTagEntity;
import hu.schonherz.blog.data.domain.UserEntity;
import hu.schonherz.blog.service.api.blog.vo.BlogPost;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BlogPostConverter {

    public static BlogPost toVO(BlogPostEntity entity) {
        String posted = entity.getPosted().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy.MM.dd kk:mm"));
        BlogPost blogPost = new BlogPost();

        blogPost.setId(entity.getId());
        blogPost.setTitle(entity.getTitle());
        blogPost.setContent(entity.getContent());
        blogPost.setPosted(posted);
        blogPost.setAuthor(UserConverter.toVO(entity.getAuthor()));
        blogPost.setTags(convertTagsToVO(entity));
        return blogPost;
    }

    public static List<BlogPost> toVO(List<BlogPostEntity> entities) {
        List<BlogPost> back = new ArrayList<>();
        for (BlogPostEntity entity : entities) {
            back.add(toVO(entity));
        }
        return back;
    }

    public static BlogPostEntity toEntity(BlogPost blogPost, UserEntity author) throws ParseException {
        Timestamp posted = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm").parse(blogPost.getPosted()).getTime());

        return BlogPostEntity.builder()
                .title(blogPost.getTitle())
                .content(blogPost.getContent())
                .posted(posted)
                .author(author)
                .postTags(convertTagsToEntity(blogPost))
                .build();
    }

    private static Collection<PostTagEntity> convertTagsToEntity(BlogPost blogPost) {
        List<PostTagEntity> tags = new ArrayList<>();
        for (String s : blogPost.getTags()) {
            tags.add(PostTagEntity.builder()
                .tag(s)
                .build());
        }
        return tags;
    }

    private static List<String> convertTagsToVO(BlogPostEntity entity) {
        List<String> tags = new ArrayList<>();
        for (PostTagEntity postTag : entity.getPostTags()) {
            tags.add(postTag.getTag());
        }
        return tags;
    }
}
