package hu.schonherz.blog.data.user.dto;

public class NameDTO {
    private int user_id;
    private String title;
    private String first;
    private String last;
    
    public NameDTO() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NameDTO [user_id=");
        builder.append(user_id);
        builder.append(", title=");
        builder.append(title);
        builder.append(", first=");
        builder.append(first);
        builder.append(", last=");
        builder.append(last);
        builder.append("]");
        return builder.toString();
    }
    
    
}
