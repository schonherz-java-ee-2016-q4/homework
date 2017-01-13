package blog_data.dto;

import org.springframework.stereotype.Repository;

@Repository
public class UserDTO {
	private String username;
	private String password;
	private String email;
	private String picture;
	private String registration_date;
	private String birth_date;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", email=" + email + ", picture=" + picture
				+ ", registration_date=" + registration_date + ", birth_date=" + birth_date + "]";
	}

	
	
	
}
