package hu.schonherz.blog.data.blog.dto;

public class PostTagDto {
    private int post_id;
    private String tag;
    
    public PostTagDto() {
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PostTagDTO [post_id=");
        builder.append(post_id);
        builder.append(", tag=");
        builder.append(tag);
        builder.append("]");
        return builder.toString();
    }
    
    
}
