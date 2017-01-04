package hu.schonherz.blog.service.api.user.service.data.blog.dto;

import java.sql.Date;

public class PostBlogDTO {
	private int id;
	private String username;
    private String header;
    private String content;
    private Date created;
    private String tags;
    
	public PostBlogDTO() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}



	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostBlogDTO [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", header=");
		builder.append(header);
		builder.append(", content=");
		builder.append(content);
		builder.append(", created=");
		builder.append(created);
		builder.append(", tags=");
		builder.append(tags);
		builder.append("]");
		return builder.toString();
	}



    
}
