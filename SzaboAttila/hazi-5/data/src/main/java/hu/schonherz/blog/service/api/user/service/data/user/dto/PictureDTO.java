package hu.schonherz.blog.service.api.user.service.data.user.dto;

public class PictureDTO {
    private int user_id;
    private String large;
    private String medium;
    private String thumbnail;
    
    public PictureDTO() {
        // TODO Auto-generated constructor stub
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PictureDTO [user_id=");
        builder.append(user_id);
        builder.append(", large=");
        builder.append(large);
        builder.append(", medium=");
        builder.append(medium);
        builder.append(", thumbnail=");
        builder.append(thumbnail);
        builder.append("]");
        return builder.toString();
    }
    
}
