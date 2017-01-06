package hu.schonherz.blog.service.api.blogpost.vo;

import hu.schonherz.blog.data.dto.BlogPostDTO;
import hu.schonherz.blog.data.dto.UserDTO;
import hu.schonherz.blog.service.api.user.vo.UserVO;

import java.sql.Date;

public class BlogPostVO {
    private int id;
    private String postTitle;
    private String postBody;
    private Date postPublishTime;
    private UserVO owner;

    public static BlogPostVO toVO(BlogPostDTO blogPostdto, UserDTO userDTO) {
        BlogPostVO post = new BlogPostVO();
        post.setId(blogPostdto.getId());
        post.setOwner(UserVO.toVO(userDTO));
        post.setPostBody(blogPostdto.getPostBody());
        post.setPostPublishTime(blogPostdto.getPostPublishTime());
        post.setPostTitle(blogPostdto.getPostTitle());
        return post;
    }

    public static BlogPostDTO toDTO(BlogPostVO blogPostVO) {
        BlogPostDTO post = new BlogPostDTO();
        post.setId(blogPostVO.getId());
        post.setUserId(blogPostVO.getOwner().getId());
        post.setPostBody(blogPostVO.getPostBody());
        post.setPostPublishTime(blogPostVO.getPostPublishTime());
        post.setPostTitle(blogPostVO.getPostTitle());
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Date getPostPublishTime() {
        return postPublishTime;
    }

    public void setPostPublishTime(Date postPublishTime) {
        this.postPublishTime = postPublishTime;
    }

    public UserVO getOwner() {
        return owner;
    }

    public void setOwner(UserVO owner) {
        this.owner = owner;
    }

}
