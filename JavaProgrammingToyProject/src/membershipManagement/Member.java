package membershipManagement;

public class Member {

	private String memberId;
	private String name;
	private String phoneNumber;
	
	public String getMember_id() {
		return memberId;
	}
	public void setMember_id(String member_id) {
		this.memberId = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phoneNumber;
	}
	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}
