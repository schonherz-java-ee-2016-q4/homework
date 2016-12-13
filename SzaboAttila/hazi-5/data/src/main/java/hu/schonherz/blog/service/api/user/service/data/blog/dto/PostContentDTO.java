package hu.schonherz.blog.service.api.user.service.data.blog.dto;

public class PostContentDTO {
    private int post_id;
    private String text;
    
    public PostContentDTO() {
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PostContentDTO [post_id=");
        builder.append(post_id);
        builder.append(", text=");
        builder.append(text);
        builder.append("]");
        return builder.toString();
    }
    
}
