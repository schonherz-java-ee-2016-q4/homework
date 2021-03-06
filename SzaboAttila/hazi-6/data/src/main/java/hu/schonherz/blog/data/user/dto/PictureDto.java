package hu.schonherz.blog.data.user.dto;

public class PictureDto {
    private int user_id;
    private String large;
    private String medium;
    private String thumbnail;
    
    public PictureDto() {
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
