package memebershipManagement;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("#############################");
		System.out.println("##### ȸ�� ���� ���α׷� START #####");
		System.out.println("#############################");

		MemberManager memberManager = new MemberManager();
		memberManager.readMenu();
		
		System.out.println("#############################");
		System.out.println("##### GOOD-BYE ���α׷� ���� #####");
		System.out.println("#############################");
	}

}
