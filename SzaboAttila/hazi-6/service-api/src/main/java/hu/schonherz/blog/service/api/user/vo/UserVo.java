package hu.schonherz.blog.service.api.user.vo;

public class UserVo {
	private String gender;
	private NameVo name;
	private LocationVo location;
	private String email;
	private LoginVo login;
	private String dob;
	private String registered;
	private String phone;
	private String cell;
	private IdVo id;
	private PictureVo picture;
	private String nat;
	private String role;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public NameVo getName() {
		return name;
	}
	public void setName(NameVo name) {
		this.name = name;
	}
	public LocationVo getLocation() {
		return location;
	}
	public void setLocation(LocationVo location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginVo getLogin() {
		return login;
	}
	public void setLogin(LoginVo login) {
		this.login = login;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRegistered() {
		return registered;
	}
	public void setRegistered(String registered) {
		this.registered = registered;
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
	public IdVo getId() {
		return id;
	}
	public void setId(IdVo id) {
		this.id = id;
	}
	public PictureVo getPicture() {
		return picture;
	}
	public void setPicture(PictureVo picture) {
		this.picture = picture;
	}
	public String getNat() {
		return nat;
	}
	public void setNat(String nat) {
		this.nat = nat;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}