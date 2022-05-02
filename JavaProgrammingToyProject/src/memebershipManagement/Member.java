package memebershipManagement;

public class Member {

	private String member_id;
	private String name;
	private String phone_number;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", name=" + name + ", phone_number=" + phone_number + "]";
	}
	
	
}
