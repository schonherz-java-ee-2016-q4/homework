package hu.schonherz.blog.service.api.user.service.data.user.dto;

public class ContactDTO {
    private int user_id;
    private String email;
    private String phone;
    private String cell;
    
    public ContactDTO() {
    }

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactDTO [user_id=");
		builder.append(user_id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", cell=");
		builder.append(cell);
		builder.append("]");
		return builder.toString();
	}
}
