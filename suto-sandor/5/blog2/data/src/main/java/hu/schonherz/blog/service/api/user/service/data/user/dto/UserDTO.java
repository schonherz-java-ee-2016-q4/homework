package hu.schonherz.blog.service.api.user.service.data.user.dto;

import java.sql.Date;

public class UserDTO {
	private int id;
	private String title;
	private String first;
	private String last;
	private Date dob;
	private Date registered;
	private String gender;
	
	public UserDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDTO [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", first=");
		builder.append(first);
		builder.append(", last=");
		builder.append(last);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", registered=");
		builder.append(registered);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}
}
